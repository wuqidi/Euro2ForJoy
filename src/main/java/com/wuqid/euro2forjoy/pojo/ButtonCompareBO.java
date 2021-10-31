package com.wuqid.euro2forjoy.pojo;

import lombok.Data;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>按钮比较</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 12:54
 */
@Data
public class ButtonCompareBO {
    private String name;
    private String gUID;

    private boolean switchOff_new = false;
    private boolean switchOff_old = false;

    public static ButtonCompareBO getInstance(ComponenBO buttonNew,ComponenBO buttonOld){
        ButtonCompareBO result = new ButtonCompareBO();
        result.setName(buttonNew.getName());
        result.setGUID(buttonNew.getGUID());
        result.setSwitchOff_new(buttonNew.isSwitchOff());
        result.setSwitchOff_old(buttonOld.isSwitchOff());
        return result;
    }
}
