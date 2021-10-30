package com.wuqid.euro2forjoy.pojo;

import lombok.Data;

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
}