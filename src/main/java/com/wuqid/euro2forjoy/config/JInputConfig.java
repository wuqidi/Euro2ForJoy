package com.wuqid.euro2forjoy.config;

import com.wuqid.euro2forjoy.common.Logcommon;
import lombok.extern.log4j.Log4j;

import java.io.InputStream;

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
public class JInputConfig {
    public static void setConfig() {
        try {
            // 读取配置文件
            ClassLoader cl = JInputConfig.class.getClassLoader();
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
}
