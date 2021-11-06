package com.wuqid.euro2forjoy;

import com.wuqid.euro2forjoy.common.Logcommon;
import com.wuqid.euro2forjoy.common.ThreadPoolServer;
import com.wuqid.euro2forjoy.config.JInputConfig;
import com.wuqid.euro2forjoy.config.KeyMappingConfig;
import com.wuqid.euro2forjoy.config.SystemConfig;
import com.wuqid.euro2forjoy.layout.MainLayout;
import com.wuqid.euro2forjoy.pojo.AnalogCompareBO;
import com.wuqid.euro2forjoy.pojo.ButtonCompareBO;
import com.wuqid.euro2forjoy.pojo.ControllerBO;
import com.wuqid.euro2forjoy.pojo.KeyMappingBO;
import com.wuqid.euro2forjoy.service.MappingServer;
import com.wuqid.euro2forjoy.swing.PopPanel;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.JInputJoyServer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.wuqid.euro2forjoy.config.SystemConfig.*;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>主程序</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 14:57
 */
@Log4j
public class WorkMain {
    private static final String Joystick_name = "Joystick";



    private static void exit() {
        System.exit(0);
    }

    private static final Map<String, ControllerBO> RECORD_LAST_STATUS = new ConcurrentHashMap<>(CONTROLLER_NUMS);//记录控制器上一次状态

    public static void main(String[] args) {
        String methodName = "Euro2ForJoy 主程序 ";
        try {
            //***********设置运行参数***************
            SystemConfig.setInitProperty();
            JInputConfig.setConfig();

            //***********设置配置参数***************
            final Map<String, KeyMappingBO> keyMapping = KeyMappingConfig.getInstance().getKeyMapping();// key:4AJto/PJzxG/x0RFU1QAAA==

            //***********业务逻辑执行***************
            ThreadPoolExecutor controllerExe = ThreadPoolServer.getControllerExe();//controllerExe.shutDown() 结束进程直接推出
            ControllerEnvironment defaultEnvironment = ControllerEnvironment.getDefaultEnvironment();
            boolean joystickInfoPop = true;
            //目前jinput提供的方法 无法实时获取硬件设备插入状态。例如：软件启动后，插入无法识别。导致下面实时弹窗无效，留着以备不时之需。
            JFrame mainPage = MainLayout.getMainPage();
            while (true) {
                List<Controller> controllers = JInputJoyServer.getJoyStickControllers(defaultEnvironment,Joystick_name);
                if (CollectionUtils.isEmpty(controllers)) {
                    PopPanel.showWarning(mainPage, "没有发现"+Joystick_name+"，插了么？", "警告");
                    if (!PopPanel.showConfirm(mainPage, "等待"+Joystick_name+"插入", "确认一下~")) {
                        exit();//选择了 否
                    } else {
                        ThreadPoolServer.sleep(LOOP_GET_CONTROLLER_SLEEP);//等待5s 继续获取
                        joystickInfoPop = true;
                        continue;
                    }
                }

                if (joystickInfoPop) {
                    Logcommon.info(log, methodName + "获取"+Joystick_name, Logcommon.TAG.INPUT, controllers);
                    PopPanel.showInfo(mainPage, "扫描：" + controllers.size() + "台", Joystick_name+"信息");
                    //增加设备信息弹窗复制
                    MainLayout.setInternalContentForMainPage(mainPage, controllers);
                    joystickInfoPop = false;
                    /* Arrays.stream(controllers).forEach(v -> { PopPanel.showInfo(getJoystickInfo(v), "joystick信息");});*/
                }

                CountDownLatch countDownLatch = new CountDownLatch(controllers.size());
                countDownLatch.await(REFRESH_MS - 5, TimeUnit.MILLISECONDS);
                for (Controller controller : controllers) {
                    controllerExe.execute(new MappingExecute(controller, keyMapping, countDownLatch));
                }
                ThreadPoolServer.sleep(REFRESH_MS);//控制刷新频率
            }
        } catch (Exception e) {
            PopPanel.showError(null, e.toString(), "报错");
            Logcommon.error(log, methodName, e);
        }
    }

    @Data
    @Log4j
    private static class MappingExecute implements Runnable {
        private Controller controller;
        private Map<String, KeyMappingBO> keyMapping;
        private CountDownLatch countDownLatch;

        public MappingExecute(Controller controller, final Map<String, KeyMappingBO> keyMapping, CountDownLatch countDownLatch) {
            this.controller = controller;
            this.keyMapping = keyMapping;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                getController().poll();
                final ControllerBO controllerBO = JInputJoyServer.getControllerBO(getController().getComponents());
                //Logcommon.info(log, methodName + "监听按键", Logcommon.TAG.INPUT,controllerBO);
                ControllerBO controllerOld = RECORD_LAST_STATUS.get(controllerBO.getButton_1().getGUID());
                if (ObjectUtils.isNotEmpty(controllerOld)) {
                    AnalogCompareBO analogCompareBO = MappingServer.queryDifferentOfAnalog(controllerBO, controllerOld);
                    if (!analogCompareBO.isEmpty()) {//摇杆有变动
                        MappingServer.exeMapping(analogCompareBO, keyMapping);
                    }
                    List<ButtonCompareBO> buttonCompareBOS = MappingServer.queryDifferentOfButton(controllerBO, controllerOld);
                    if (CollectionUtils.isNotEmpty(buttonCompareBOS)) {//按钮有变动
                        MappingServer.exeMapping(buttonCompareBOS, keyMapping);
                    }
                }
                RECORD_LAST_STATUS.put(controllerBO.getButton_1().getGUID(), controllerBO);

                countDownLatch.countDown();
            } catch (Exception e) {
                Logcommon.error(log, "多线程执行控制映射", e);
            }
        }
    }
}