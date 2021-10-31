package com.wuqid.euro2forjoy.pojo;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.ObjectUtils;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *           -1
 *      -1        1
 *           1
 *
 * @author: 泥猴桃
 * @date 2021/10/30 22:35
 */
@Log4j
@Data
public class ControllerBO {
    private AnalogBO analog = new AnalogBO();

    private ComponenBO button_1;
    private ComponenBO button_2;
    private ComponenBO button_3;
    private ComponenBO button_4;
    private ComponenBO button_5;
    private ComponenBO button_6;
    private ComponenBO button_7;
    private ComponenBO button_8;
    private ComponenBO button_9;
    private ComponenBO button_10;
    private ComponenBO button_11;
    private ComponenBO button_12;

    public boolean isEmpty() {
        return ObjectUtils.isEmpty(getAnalog());
    }
}
