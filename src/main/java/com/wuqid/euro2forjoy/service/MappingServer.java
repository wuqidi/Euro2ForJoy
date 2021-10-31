package com.wuqid.euro2forjoy.service;

import com.wuqid.euro2forjoy.pojo.*;
import com.wuqid.euro2forjoy.util.Logcommon;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>映射服务</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 12:38
 */
@Log4j
public class MappingServer {
    public static void exeMapping(AnalogCompareBO analogCompareBO, Map<String, KeyMappingBO> keyMapping) {
        String methodName = "执行摇杆映射";
        String guid = analogCompareBO.getGUID();
        KeyMappingBO keyMappingBO = keyMapping.get(guid);
        AnalogBO.Direction direction_new = analogCompareBO.getDirection_new();
        AnalogBO.Direction direction_old = analogCompareBO.getDirection_old();
        KeyMappingBO.Analog analog = keyMappingBO.getAnalog();
        String key = analog.getKey(direction_new);//todo 键盘映射按键
        Logcommon.info(log, methodName, Logcommon.TAG.INPUT, direction_new, direction_old);
        Logcommon.info(log, methodName + " 键盘：", Logcommon.TAG.OUTPUT, key);
    }

    public static void exeMapping(List<ButtonCompareBO> buttonCompareBOs, Map<String, KeyMappingBO> keyMapping) {
        String methodName = "执行按键映射";
        KeyMappingBO keyMappingBO = keyMapping.get(buttonCompareBOs.get(0).getGUID());
        KeyMappingBO.Button button = keyMappingBO.getButton();
        buttonCompareBOs.forEach(v -> {
            String key = button.getKey(v.getName());//todo 键盘映射按键
            Logcommon.info(log, methodName, Logcommon.TAG.INPUT, v.isSwitchOff_new(), v.isSwitchOff_old());
            Logcommon.info(log, methodName + "键盘：", Logcommon.TAG.OUTPUT, key);
        });
    }


    public static AnalogCompareBO queryDifferentOfAnalog(ControllerBO newCon, ControllerBO oldCon) {
        String methodName = "查询不同摇杆";
        AnalogCompareBO result = new AnalogCompareBO();
        if (!newCon.getAnalog().equals(oldCon.getAnalog())) {
            result = AnalogCompareBO.getInstance(newCon, oldCon);
        }
        //Logcommon.info(log, methodName, Logcommon.TAG.OUTPUT, result);
        return result;
    }


    public static List<ButtonCompareBO> queryDifferentOfButton(ControllerBO newCon, ControllerBO oldCon) {
        String methodName = "查询不同按键列表";
        List<ButtonCompareBO> result = new ArrayList<>();
        if (!newCon.isEmpty() && !oldCon.isEmpty()) {
            if (!newCon.getButton_1().equals(oldCon.getButton_1())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_1(), oldCon.getButton_1()));
            }
            if (!newCon.getButton_2().equals(oldCon.getButton_2())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_2(), oldCon.getButton_2()));
            }
            if (!newCon.getButton_3().equals(oldCon.getButton_3())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_3(), oldCon.getButton_3()));
            }
            if (!newCon.getButton_4().equals(oldCon.getButton_4())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_4(), oldCon.getButton_4()));
            }
            if (!newCon.getButton_5().equals(oldCon.getButton_5())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_5(), oldCon.getButton_5()));
            }
            if (!newCon.getButton_6().equals(oldCon.getButton_6())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_6(), oldCon.getButton_6()));
            }
            if (!newCon.getButton_7().equals(oldCon.getButton_7())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_7(), oldCon.getButton_7()));
            }
            if (!newCon.getButton_8().equals(oldCon.getButton_8())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_8(), oldCon.getButton_8()));
            }
            if (!newCon.getButton_9().equals(oldCon.getButton_9())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_9(), oldCon.getButton_9()));
            }
            if (!newCon.getButton_10().equals(oldCon.getButton_10())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_10(), oldCon.getButton_10()));
            }
            if (!newCon.getButton_11().equals(oldCon.getButton_11())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_11(), oldCon.getButton_11()));
            }
            if (!newCon.getButton_12().equals(oldCon.getButton_12())) {
                result.add(ButtonCompareBO.getInstance(newCon.getButton_12(), oldCon.getButton_12()));
            }
        }
        //Logcommon.info(log, methodName, Logcommon.TAG.OUTPUT, result);
        return result;
    }
}