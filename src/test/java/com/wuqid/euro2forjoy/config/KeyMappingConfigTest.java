package com.wuqid.euro2forjoy.config;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 15:47
 */
class KeyMappingConfigTest {

    @Test
    void getKeyMapping() {
        System.out.println(JSON.toJSONString(KeyMappingConfig.getKeyMapping()));
    }
}