package com.wuqid.euro2forjoy.common;

import lombok.extern.log4j.Log4j;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 14:43
 */
@Log4j
public class PropertyUtil {
    public static void setSystem(String key, String value){
        System.setProperty(key, value);
        Logcommon.info(log,"设置系统属性", Logcommon.TAG.INPUT,key,value);
    }

    public static <T> Map<String,T> getYml(String file)throws Exception{
         return new Yaml().load(new FileInputStream(new File(ClassLoader.getSystemResource(file).toURI()).getAbsolutePath()));
    }
}
