package com.wuqid.euro2forjoy.util;

import lombok.extern.log4j.Log4j;

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
public class SystemProperty {
    public static void set(String key,String value){
        System.setProperty(key, value);
        Logcommon.info(log,"设置系统属性", Logcommon.TAG.INPUT,key,value);
    }
}
