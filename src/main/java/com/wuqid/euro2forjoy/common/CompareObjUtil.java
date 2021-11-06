package com.wuqid.euro2forjoy.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/6 16:06
 */
@Data
@Log4j
public class CompareObjUtil {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Comparison implements Serializable {
        //字段
        private String Field;
        //字段旧值
        private Object before;
        //字段新值
        private Object after;
    }

    public static List<Comparison> compareObj(Object beforeObj, Object afterObj) {
        List<Comparison> diffs = new ArrayList<>();

        try {
            //取出属性
            Field[] beforeFields = beforeObj.getClass().getDeclaredFields();
            Field[] afterFields = afterObj.getClass().getDeclaredFields();
            Field.setAccessible(beforeFields, true);
            Field.setAccessible(afterFields, true);

            //遍历取出差异值
            if (beforeFields.length > 0) {
                for (int i = 0; i < beforeFields.length; i++) {
                    Object beforeValue = beforeFields[i].get(beforeObj);
                    Object afterValue = afterFields[i].get(afterObj);
                    if (ObjectUtils.isNotEmpty(beforeValue) || ObjectUtils.isNotEmpty(afterValue)) {
                        compareObj(beforeFields[i].getName(), beforeValue, afterValue);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return diffs;
    }

    private static void compareObj(String fileName, Object beforeObj, Object afterObj) {
        List<Comparison> diffs = new ArrayList<>();
        if (isBaseType(beforeObj) || isBaseType(afterObj)) {
            if(!beforeObj.equals(afterObj)){
                Logcommon.info(log,"比较-基础类型"+fileName, Logcommon.TAG.OUTPUT,beforeObj,afterObj);
            }
        }else{
            try {
                Field[] beforeFields = beforeObj.getClass().getDeclaredFields();
                Field[] afterFields = afterObj.getClass().getDeclaredFields();
                Field.setAccessible(beforeFields, true);
                Field.setAccessible(afterFields, true);
                for (int i = 0; i < beforeFields.length; i++) {
                    Object beforeValue = beforeFields[i].get(beforeObj);
                    Object afterValue = afterFields[i].get(afterObj);
                    compareObj(beforeFields[i].getName(), beforeValue, afterValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isBaseType(Object o) {
        if (o instanceof String) {
            return true;
        } else if (o instanceof Character) {
            return true;
        } else if (o instanceof Short) {
            return true;
        } else if (o instanceof Integer) {
            return true;
        } else if (o instanceof Long) {
            return true;
        } else if (o instanceof Double) {
            return true;
        } else if (o instanceof Float) {
            return true;
        } else if (o instanceof Byte) {
            return true;
        } else if (o instanceof Boolean) {
            return true;
        }
        return false;
    }
}
