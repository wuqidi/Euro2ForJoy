package com.wuqid.euro2forjoy.pojo;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>按键类型</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/2 0:54
 */
public enum ButtonActType {
    always("always","连续点击"),
    twice("twice","拨动开关"),
    move("move","移动");

    private final String tag;
    private final String chName;

    public String getTag() {
        return tag;
    }

    public String getChName() {
        return chName;
    }

    ButtonActType(String tag, String chName) {
        this.tag = tag;
        this.chName = chName;
    }
}
