package com.wuqid.euro2forjoy.config;

import com.wuqid.euro2forjoy.common.PropertyUtil;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

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
    public static URI IMG_FILE_URI;
    public static URI DLL_FILE_URI;

    static {
        try {
            DLL_FILE_URI = ClassLoader.getSystemResource("dll").toURI();
            IMG_FILE_URI = ClassLoader.getSystemResource("img").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void setInitProperty() throws Exception {
        PropertyUtil.setSystem("net.java.games.input.librarypath", new File(DLL_FILE_URI).getAbsolutePath());//这里只能设置绝对路径
        PropertyUtil.setSystem("jinput.loglevel", "FINEST");//java.util.logging.Level
    }
}