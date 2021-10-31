package com.wuqid.euro2forjoy.util;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 15:20
 */
class PropertyUtilTest {

    @Test
    void setSystem() {
    }

    @Test
    void getYml() throws Exception{
        System.out.println(JSON.toJSONString(PropertyUtil.getYml("keymapping.yml")));
        //{
        //    "button1":{
        //        "gUID":"8AJto/PJzxG/x0RFU1QAAA==",
        //        "button_1":"w",
        //        "button_2":"w",
        //        "button_3":"w",
        //        "button_4":"w",
        //        "button_5":"w",
        //        "button_6":"w",
        //        "button_7":"w",
        //        "button_8":"w",
        //        "button_9":"w",
        //        "button_10":"w",
        //        "button_11":"w",
        //        "button_12":"w"
        //    },
        //    "analoy1":{
        //        "gUID":"4AJto/PJzxG/x0RFU1QAAA==",
        //        "up":"space",
        //        "down":"space",
        //        "left":"space",
        //        "right":"space"
        //    }
        //}
    }
}