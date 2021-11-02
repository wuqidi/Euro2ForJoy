package com.wuqid.euro2forjoy.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>日志工具</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 14:16
 */
@Log4j
public class Logcommon {
    public enum TAG {
        INPUT("输入"),
        OUTPUT("输出");
        private String desc;

        public String getDesc() {
            return desc;
        }

        TAG(String desc) {
            this.desc = desc;
        }
    }

    private static String getStr(Object object) {
        try {
            if (ObjectUtils.isNotEmpty(object)) {
                return JSON.toJSONString(object);
            }
        } catch (Exception e) {
            error(log, "对象转字符串", e);
        }
        return "空";
    }

    private static String getStr(Object... object) {
        try {
            if (object != null && object.length > 0) {
                return JSON.toJSONString(object);
            }
        } catch (Exception e) {
            error(log, "数组转字符串", e);
        }
        return "空";
    }
    public static void info(Logger log, String methodName, TAG tag, Object objects) {
        log.info("[" + methodName + "]-" + tag.desc + ">>" + getStr(objects) + "");
    }

    public static void info(Logger log, String methodName, TAG tag, Object... objects) {
        log.info("[" + methodName + "]-" + tag.desc + ">>" + getStr(objects) + "");
    }

    public static void error(Logger log, String methodName, Exception e) {
        log.error("[" + methodName + "]-报错:", e);
    }
}