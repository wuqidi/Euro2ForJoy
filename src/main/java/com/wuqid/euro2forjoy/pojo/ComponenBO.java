package com.wuqid.euro2forjoy.pojo;

import lombok.Data;

import java.util.Objects;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 19:59
 */
@Data
public class ComponenBO {
    private String name;
    private String gUID;
    private boolean button;
    private boolean switchOff = false;
    private float pollData;

    private int type;//硬件回调
    private int gUIDType;//硬件回调
    private int flags;//硬件回调

    public boolean equals(ComponenBO componenBO) {
        /*if (this == componenBO) {
            return true;
        }
        return isButton() == componenBO.isButton()
                && isSwitchOff() == componenBO.isSwitchOff()
                && getPollData() == componenBO.getPollData()
                && getType() == componenBO.getType()
                && getGUIDType() == componenBO.getGUIDType()
                && getFlags() == componenBO.getFlags()
                && getName().equals(componenBO.getName())
                && getGUID().equals(componenBO.getGUID());*/
        return isSwitchOff() == componenBO.isSwitchOff();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), gUID, isButton(), isSwitchOff(), getPollData(), getType(), gUIDType, getFlags());
    }
}