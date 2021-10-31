package com.wuqid.euro2forjoy.config;

import com.wuqid.euro2forjoy.pojo.KeyMappingBO;
import com.wuqid.euro2forjoy.util.Logcommon;
import com.wuqid.euro2forjoy.util.PropertyUtil;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 15:04
 */
@Log4j
public class KeyMappingConfig {
    public static Map<String,KeyMappingBO> getKeyMapping() {
        String methodName = "获取键盘映射关系";
        Map<String,KeyMappingBO> result = new HashMap<>();
        try {
            Map<String, Map<String, Map<String,String>>> yml = PropertyUtil.getYml("keymapping.yml");
            yml.forEach((k, v) -> result.putAll(KeyMappingBO.getInstance(v)));
        } catch (Exception e) {
            Logcommon.error(log, methodName, e);
        }
        Logcommon.info(log, methodName, Logcommon.TAG.OUTPUT, result);
        return result;
    }
}