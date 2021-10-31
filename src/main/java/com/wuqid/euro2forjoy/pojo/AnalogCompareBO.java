package com.wuqid.euro2forjoy.pojo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>摇杆比较</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 12:54
 */
@Data
public class AnalogCompareBO {
    private String gUID;

    private AnalogBO.Direction direction_new;
    private AnalogBO.Direction direction_old;

    public static AnalogCompareBO getInstance(ControllerBO newCon, ControllerBO oldCon){
        AnalogCompareBO result = new AnalogCompareBO();
        result.setGUID(newCon.getAnalog().getGUID());
        result.setDirection_new(newCon.getAnalog().getDirection());
        result.setDirection_old(oldCon.getAnalog().getDirection());
        return result;
    }

    public boolean isEmpty(){
        return StringUtils.isEmpty(getGUID());
    }
}
