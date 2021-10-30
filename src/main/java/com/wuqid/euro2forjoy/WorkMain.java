package com.wuqid.euro2forjoy;

import com.wuqid.euro2forjoy.operationPanel.PopPanel;
import com.wuqid.euro2forjoy.pojo.ControllerBO;
import com.wuqid.euro2forjoy.util.Logcommon;
import com.wuqid.euro2forjoy.util.SystemProperty;
import lombok.extern.log4j.Log4j;
import net.java.games.input.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private static List<Controller> getJoyStickControllers(ControllerEnvironment controllerEnvironment) {
        String methodName = "获取控制器";
        Controller[] controllers = controllerEnvironment.getControllers();
        if (controllers.length == 0) {
            Logcommon.info(log, methodName, Logcommon.TAG.INPUT, controllers);
            PopPanel.showError("不存在任何控制器", "错误");
            exit();//如果为0则退出 一个都无法获取
        }
        return Arrays.stream(controllers).filter(v -> (
                StringUtils.isNotEmpty(v.getName())
                        && v.getName().contains(Joystick_name))).collect(Collectors.toList());
    }

    private static void exit() {
        System.exit(0);
    }

/*    private static String getJoystickInfo(Controller controller) {
        return controller.getName() + "-" +
                controller.getType().toString() + "-" +
                controller.getPortType().toString() + "-";
    }*/

    private static void setInitProperty() throws Exception {
        SystemProperty.set("net.java.games.input.librarypath", new File(ClassLoader.getSystemResource("dll").toURI()).getAbsolutePath());//这里只能设置绝对路径
        SystemProperty.set("jinput.loglevel", "FINEST");//java.util.logging.Level

        try {
            // 读取配置文件
            ClassLoader cl = WorkMain.class.getClassLoader();
            InputStream inputStream;
            if (cl != null) {
                inputStream = cl.getResourceAsStream("logging.properties");
            } else {
                inputStream = ClassLoader.getSystemResourceAsStream("loggging.properties");
            }
            java.util.logging.LogManager logManager = java.util.logging.LogManager.getLogManager();
            logManager.readConfiguration(inputStream);
        } catch (Exception e) {
            Logcommon.error(log, "加载Java日志配置", e);
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            Logcommon.error(log, "线程休眠", e);
        }
    }

    public static void main(String[] args) {
        String methodName = "Euro2ForJoy 主程序 ";
        try {
            //***********设置运行参数***************
            setInitProperty();
            ControllerEnvironment defaultEnvironment = ControllerEnvironment.getDefaultEnvironment();
            //*************************************
            boolean joystickInfoPop = true;
            while (true) {
                List<Controller> controllers = getJoyStickControllers(defaultEnvironment);
                if (CollectionUtils.isEmpty(controllers)) {
                    PopPanel.showWarning("没有发现JoyStick，插了么？", "警告");
                    if (!PopPanel.showConfirm("等待JoyStick插入", "确认一下~")) {
                        exit();//选择了 否
                    } else {
                        sleep(5000);//等待5s 继续获取
                        joystickInfoPop = true;
                        continue;
                    }
                }

                if (joystickInfoPop) {
                    Logcommon.info(log, methodName + "获取joystick", Logcommon.TAG.INPUT, controllers);
                    PopPanel.showInfo("扫描：" + controllers.size() + "台", "joystick信息");
                    joystickInfoPop = false;
                    /* Arrays.stream(controllers).forEach(v -> { PopPanel.showInfo(getJoystickInfo(v), "joystick信息");});*/
                }

                for (Controller controller : controllers) {
                    controller.poll();
                    ControllerBO controllerBO = JInputJoyServer.getControllerBO(controller.getComponents());
                    Logcommon.info(log, methodName + "监听按键", Logcommon.TAG.INPUT,controllerBO);
                }
                sleep(3000);//20
            }
        } catch (Exception e) {
            PopPanel.showError(e.toString(), "报错");
            Logcommon.error(log, methodName, e);
        }
    }


}
