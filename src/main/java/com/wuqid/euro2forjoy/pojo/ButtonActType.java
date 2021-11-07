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
    def("def", "默认"),
    always("always", "连续点击"),
    twice("twice", "拨动开关"),
    move("move", "移动");

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

    public static String[] getCHNames() {
        String[] result = new String[ButtonActType.values().length];
        for (ButtonActType tem : ButtonActType.values()) {
            result[tem.ordinal()] = tem.getChName();
        }
        return result;
    }

    public static ButtonActType getByCHName(String chName) {
        for (ButtonActType tem : ButtonActType.values()) {
            if (tem.getChName().equals(chName)) {
                return tem;
            }
        }
        return ButtonActType.def;
    }

    public static ButtonActType getByTag(String tag) {
        for (ButtonActType tem : ButtonActType.values()) {
            if (tem.getTag().equals(tag)) {
                return tem;
            }
        }
        return ButtonActType.def;
    }
}
