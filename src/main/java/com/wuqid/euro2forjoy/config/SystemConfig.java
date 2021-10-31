package com.wuqid.euro2forjoy.config;

import com.wuqid.euro2forjoy.util.PropertyUtil;
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
    public static void setInitProperty() throws Exception {
        PropertyUtil.setSystem("net.java.games.input.librarypath", new File(ClassLoader.getSystemResource("dll").toURI()).getAbsolutePath());//这里只能设置绝对路径
        PropertyUtil.setSystem("jinput.loglevel", "FINEST");//java.util.logging.Level
    }
}