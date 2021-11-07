package com.wuqid.euro2forjoy.layout;

import com.wuqid.euro2forjoy.pojo.ButtonActType;
import com.wuqid.euro2forjoy.pojo.ControllerBO;
import com.wuqid.euro2forjoy.pojo.KeyMappingBO;
import com.wuqid.euro2forjoy.service.MappingServer;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.awt.*;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>映射配置页面</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/7 16:39
 */
@Log4j
public class KeyMappingConfigPage {

    public static void setKeyMapping(JPanel panel, KeyMappingBO keyMappingBO) {
        KeyMappingBO.Button button = keyMappingBO.getButton();
        KeyMappingBO.Analog analog = keyMappingBO.getAnalog();
        setAnalog(panel, analog);
        setButton(panel, button);
    }

    private static void setAnalog(JPanel panel, KeyMappingBO.Analog analog) {
        JPanel analog1 = getLine(panel, "上[↑]摇杆", 0);
        JComboBox selectButtonType0 = getSelectButtonType(MappingServer.getButtonType(analog.getUp()));
        selectButtonType0.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType0.getSelectedItem());
            if (!analog.getUp().contains(buttonActType.getTag())) {
                // Logcommon.info(log,"old", Logcommon.TAG.INPUT,analog);
                analog.setUp(MappingServer.updateConfigValue(buttonActType, null, analog.getUp()));
                //Logcommon.info(log,"new", Logcommon.TAG.INPUT,analog);
            }
        });
        analog1.add(selectButtonType0);
        analog1.add(getConfigValue(MappingServer.getWord(analog.getUp())));

        JPanel analog2 = getLine(panel, "下[↓]摇杆", 1);
        JComboBox selectButtonType1 = getSelectButtonType(MappingServer.getButtonType(analog.getDown()));
        selectButtonType1.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType1.getSelectedItem());
            if (!analog.getDown().contains(buttonActType.getTag())) {
                analog.setDown(MappingServer.updateConfigValue(buttonActType, null, analog.getDown()));
            }
        });
        analog2.add(selectButtonType1);
        analog2.add(getConfigValue(MappingServer.getWord(analog.getDown())));

        JPanel analog3 = getLine(panel, "左[←]摇杆", 2);
        JComboBox selectButtonType2 = getSelectButtonType(MappingServer.getButtonType(analog.getLeft()));
        selectButtonType2.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType2.getSelectedItem());
            if (!analog.getLeft().contains(buttonActType.getTag())) {
                analog.setLeft(MappingServer.updateConfigValue(buttonActType, null, analog.getLeft()));
            }
        });
        analog3.add(selectButtonType2);
        analog3.add(getConfigValue(MappingServer.getWord(analog.getLeft())));

        JPanel analog4 = getLine(panel, "右[→]摇杆", 3);
        JComboBox selectButtonType3 = getSelectButtonType(MappingServer.getButtonType(analog.getRight()));
        selectButtonType3.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType3.getSelectedItem());
            if (!analog.getRight().contains(buttonActType.getTag())) {
                analog.setRight(MappingServer.updateConfigValue(buttonActType, null, analog.getRight()));
            }
        });
        analog4.add(selectButtonType3);
        analog4.add(getConfigValue(MappingServer.getWord(analog.getRight())));

        panel.add(analog1);
        panel.add(analog2);
        panel.add(analog3);
        panel.add(analog4);
    }

    private static void setButton(JPanel panel, KeyMappingBO.Button button) {
        JPanel button0 = getLine(panel, "[1]号按钮", 4);
        JComboBox selectButtonType0 = getSelectButtonType(MappingServer.getButtonType(button.getButton_1()));
        selectButtonType0.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType0.getSelectedItem());
            if (!button.getButton_1().contains(buttonActType.getTag())) {
                button.setButton_1(MappingServer.updateConfigValue(buttonActType, null, button.getButton_1()));
            }
        });
        button0.add(selectButtonType0);
        button0.add(getConfigValue(MappingServer.getWord(button.getButton_1())));
        JPanel button1 = getLine(panel, "[2]号按钮", 5);
        JComboBox selectButtonType1 = getSelectButtonType(MappingServer.getButtonType(button.getButton_2()));
        selectButtonType1.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType1.getSelectedItem());
            if (!button.getButton_2().contains(buttonActType.getTag())) {
                button.setButton_2(MappingServer.updateConfigValue(buttonActType, null, button.getButton_2()));
            }
        });
        button1.add(selectButtonType1);
        button1.add(getConfigValue(MappingServer.getWord(button.getButton_2())));
        JPanel button2 = getLine(panel, "[3]号按钮", 6);
        JComboBox selectButtonType2 = getSelectButtonType(MappingServer.getButtonType(button.getButton_3()));
        selectButtonType2.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType2.getSelectedItem());
            if (!button.getButton_3().contains(buttonActType.getTag())) {
                button.setButton_3(MappingServer.updateConfigValue(buttonActType, null, button.getButton_3()));
            }
        });
        button2.add(selectButtonType2);
        button2.add(getConfigValue(MappingServer.getWord(button.getButton_3())));
        JPanel button3 = getLine(panel, "[4]号按钮", 7);
        JComboBox selectButtonType3 = getSelectButtonType(MappingServer.getButtonType(button.getButton_4()));
        selectButtonType3.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType3.getSelectedItem());
            if (!button.getButton_4().contains(buttonActType.getTag())) {
                button.setButton_4(MappingServer.updateConfigValue(buttonActType, null, button.getButton_4()));
            }
        });
        button3.add(selectButtonType3);
        button3.add(getConfigValue(MappingServer.getWord(button.getButton_4())));
        JPanel button4 = getLine(panel, "[5]号按钮", 8);
        JComboBox selectButtonType4 = getSelectButtonType(MappingServer.getButtonType(button.getButton_5()));
        selectButtonType4.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType4.getSelectedItem());
            if (!button.getButton_5().contains(buttonActType.getTag())) {
                button.setButton_5(MappingServer.updateConfigValue(buttonActType, null, button.getButton_5()));
            }
        });
        button4.add(selectButtonType4);
        button4.add(getConfigValue(MappingServer.getWord(button.getButton_5())));
        JPanel button5 = getLine(panel, "[6]号按钮", 9);
        JComboBox selectButtonType5 = getSelectButtonType(MappingServer.getButtonType(button.getButton_6()));
        selectButtonType5.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType5.getSelectedItem());
            if (!button.getButton_6().contains(buttonActType.getTag())) {
                button.setButton_6(MappingServer.updateConfigValue(buttonActType, null, button.getButton_6()));
            }
        });
        button5.add(selectButtonType5);
        button5.add(getConfigValue(MappingServer.getWord(button.getButton_6())));
        JPanel button6 = getLine(panel, "[7]号按钮", 10);
        JComboBox selectButtonType6 = getSelectButtonType(MappingServer.getButtonType(button.getButton_7()));
        selectButtonType6.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType6.getSelectedItem());
            if (!button.getButton_7().contains(buttonActType.getTag())) {
                button.setButton_7(MappingServer.updateConfigValue(buttonActType, null, button.getButton_7()));
            }
        });
        button6.add(selectButtonType6);
        button6.add(getConfigValue(MappingServer.getWord(button.getButton_7())));
        JPanel button7 = getLine(panel, "[8]号按钮", 11);
        JComboBox selectButtonType7 = getSelectButtonType(MappingServer.getButtonType(button.getButton_8()));
        selectButtonType7.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType7.getSelectedItem());
            if (!button.getButton_8().contains(buttonActType.getTag())) {
                button.setButton_8(MappingServer.updateConfigValue(buttonActType, null, button.getButton_8()));
            }
        });
        button7.add(selectButtonType7);
        button7.add(getConfigValue(MappingServer.getWord(button.getButton_8())));
        JPanel button8 = getLine(panel, "[9]号按钮", 12);
        JComboBox selectButtonType8 = getSelectButtonType(MappingServer.getButtonType(button.getButton_9()));
        selectButtonType8.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType8.getSelectedItem());
            if (!button.getButton_9().contains(buttonActType.getTag())) {
                button.setButton_9(MappingServer.updateConfigValue(buttonActType, null, button.getButton_9()));
            }
        });
        button8.add(selectButtonType8);
        button8.add(getConfigValue(MappingServer.getWord(button.getButton_9())));
        JPanel button9 = getLine(panel, "[10]号按钮", 13);
        JComboBox selectButtonType9 = getSelectButtonType(MappingServer.getButtonType(button.getButton_10()));
        selectButtonType9.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType9.getSelectedItem());
            if (!button.getButton_10().contains(buttonActType.getTag())) {
                button.setButton_10(MappingServer.updateConfigValue(buttonActType, null, button.getButton_10()));
            }
        });
        button9.add(selectButtonType9);
        button9.add(getConfigValue(MappingServer.getWord(button.getButton_10())));
        JPanel button10 = getLine(panel, "[11]号按钮", 14);
        JComboBox selectButtonType10 = getSelectButtonType(MappingServer.getButtonType(button.getButton_11()));
        selectButtonType10.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType10.getSelectedItem());
            if (!button.getButton_11().contains(buttonActType.getTag())) {
                button.setButton_11(MappingServer.updateConfigValue(buttonActType, null, button.getButton_11()));
            }
        });
        button10.add(selectButtonType10);
        button10.add(getConfigValue(MappingServer.getWord(button.getButton_11())));
        JPanel button11 = getLine(panel, "[12]号按钮", 15);
        JComboBox selectButtonType11 = getSelectButtonType(MappingServer.getButtonType(button.getButton_12()));
        selectButtonType11.addActionListener((e) -> {
            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType11.getSelectedItem());
            if (!button.getButton_12().contains(buttonActType.getTag())) {
                button.setButton_12(MappingServer.updateConfigValue(buttonActType, null, button.getButton_12()));
            }
        });
        button11.add(selectButtonType11);
        button11.add(getConfigValue(MappingServer.getWord(button.getButton_12())));


        panel.add(button0);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button10);
        panel.add(button11);
    }

    private static final int selectWidth = 120;

    private static JComboBox getSelectButtonType(ButtonActType buttonActType) {
        JComboBox select = new JComboBox(ButtonActType.getCHNames());
        select.setSelectedIndex(buttonActType.ordinal());
        select.setBounds(lineNameWidth + 30, 0, selectWidth, lineNameHeight);
        return select;
    }

    private static JTextField getConfigValue(String configValueStr) {
        JTextField configValue = new JTextField(configValueStr);
        configValue.setPreferredSize(new Dimension(80, lineNameHeight));
        configValue.setBounds(lineNameWidth * 2 + selectWidth + 30, 0, 120, lineNameHeight);
        return configValue;
    }

    private static final int lineNameWidth = 80;

    private static final int lineNameHeight = 32;

    private static JPanel getLine(JPanel panel, String lineName, int num) {
        int heightX = 10;
        int widthX = 20;
        int width = panel.getWidth() - widthX;
        JPanel line = new JPanel();
        line.setLayout(null);
        line.setFont(new Font("仿宋", Font.ITALIC, 18));
        line.setBorder(BorderFactory.createLineBorder(Color.red));
        line.setBounds(widthX / 2, num * (lineNameHeight + heightX), width, lineNameHeight);
        JLabel label = new JLabel("     " + lineName);
        label.setBounds(0, 0, lineNameWidth, lineNameHeight);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        line.add(label);
        return line;
    }

    private static void setButton2(JPanel panel, ControllerBO controllerBO) {
        int height = panel.getHeight() - 35;
        int width = 110;
        int widthX = 30;
        JPanel buttonName = new JPanel();
        buttonName.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 23));
        buttonName.setFont(new Font("仿宋", Font.ITALIC, 18));
        buttonName.setBorder(BorderFactory.createLineBorder(Color.red));
        buttonName.setBounds(0, 0, width, height);
        buttonName.add(new JLabel("上[↑]摇杆"));
        buttonName.add(new JLabel("下[↓]摇杆"));
        buttonName.add(new JLabel("左[←]摇杆"));
        buttonName.add(new JLabel("右[→]摇杆"));
        for (int i = 1; i <= 12; i++) {
            buttonName.add(new JLabel(String.format("  [%d]号按钮", i)));
        }
        panel.add(buttonName);

        JPanel buttonType = new JPanel();
        buttonType.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 14));
        buttonType.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        buttonType.setBounds(width + widthX, 0, width, height);
        for (int i = 1; i <= 16; i++) {
            buttonType.add(getButtonType());
        }
        panel.add(buttonType);//按键映射模式 https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html#uneditable

        JPanel buttonValue = new JPanel();
        buttonValue.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        buttonValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonValue.setBounds(2 * (width + widthX), 0, width, height);
        panel.add(buttonValue);//todo 按键映射值
    }

    private static JComboBox getButtonType() {
        JComboBox cb = new JComboBox(ButtonActType.values());
        cb.setSelectedIndex(0);
        return cb;
    }

    private static JTextArea getJTextArea(String content) {
        JTextArea textArea = new JTextArea(content, 1, 35);
        textArea.setLineWrap(true);    //设置文本域中的文本为自动换行
        textArea.setFont(new Font("楷体", Font.BOLD, 16));    //修改字体样式
        textArea.setBackground(Color.CYAN);    //设置背景色
        return textArea;
    }
}
