package com.wuqid.euro2forjoy.operationPanel;

import javax.swing.*;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>弹窗 https://www.cnblogs.com/aipan/p/6295026.html </dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 16:39
 */
public class PopPanel {
    public static void showInfo(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void showWarning(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void showError(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static boolean showConfirm(String msg, String title){
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION);
        return showConfirmDialog<1;
    }
}