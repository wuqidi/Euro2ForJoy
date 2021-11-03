package com.wuqid.euro2forjoy.swing;

import org.junit.jupiter.api.Test;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 16:44
 */
class PopPanelTest {
    @Test
    public void test1(){
        PopPanel.showInfo("你好","欢迎");
        PopPanel.showError("你好","报错");
        PopPanel.showWarning("你好","警告");
        boolean b = PopPanel.showConfirm("你好", "选择");
        System.out.println(b);

        PopPanel.showContent("你好","警告");
    }
}