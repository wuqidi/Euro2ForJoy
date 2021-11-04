package com.wuqid.euro2forjoy.swing;

import javax.swing.*;
import java.awt.*;

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
    public static void showInfo(Window window,String msg, String title) {
        JOptionPane.showMessageDialog(window, msg, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void showWarning(Window window,String msg, String title) {
        JOptionPane.showMessageDialog(window, msg, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void showError(Window window,String msg, String title) {
        JOptionPane.showMessageDialog(window, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static boolean showConfirm(Window window,String msg, String title){
        int showConfirmDialog = JOptionPane.showConfirmDialog(window, msg, title, JOptionPane.YES_NO_OPTION);
        return showConfirmDialog<1;
    }

    public static boolean showContent(Window window,String content, String title){
        JOptionPane.showInputDialog(window,content,title, JOptionPane.INFORMATION_MESSAGE);
        int showConfirmDialog = JOptionPane.showConfirmDialog(window, content, title, JOptionPane.YES_NO_OPTION);
        return showConfirmDialog<1;
    }
}