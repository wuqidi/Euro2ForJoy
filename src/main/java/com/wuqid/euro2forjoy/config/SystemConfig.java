package com.wuqid.euro2forjoy.config;

import com.wuqid.euro2forjoy.common.PropertyUtil;
import lombok.extern.log4j.Log4j;

import java.io.File;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 12:26
 */
@Log4j
public class SystemConfig {
    public static final int REFRESH_MS = 50;//最小20
    public static final int STEP_SIZE = 100;//像素，影响鼠标移动速度
    public static final int ALWAYS_TIME = 30;//模拟一直按着键 线程执行间隔时间
    public static final int CONTROLLER_NUMS = 2;//控制器数量
    public static final int LOOP_GET_CONTROLLER_SLEEP = 5000;//循环获取控制器间隔

    public static final String WORK_HOME = System.getProperty("user.dir") + File.separator;

    public static void setInitProperty() {
        PropertyUtil.setSystem("net.java.games.input.librarypath", WORK_HOME+"dll");//这里只能设置绝对路径
        PropertyUtil.setSystem("jinput.loglevel", "FINEST");//java.util.logging.Level
    }
}