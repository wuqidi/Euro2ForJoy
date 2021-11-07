package com.wuqid.euro2forjoy.layout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/7 19:00
 */
class KeyMappingConfigPageTest {

    @Test
    public void autoWriteCode(){
        String code = "        JPanel button%d = getLine(panel, \"[%d]号按钮\", %d);\n" +
                "        JComboBox selectButtonType%d = getSelectButtonType(MappingServer.getButtonType(button.getButton_%d()));\n" +
                "        selectButtonType%d.addActionListener((e) -> {\n" +
                "            ButtonActType buttonActType = ButtonActType.getByCHName((String) selectButtonType%d.getSelectedItem());\n" +
                "            if (!button.getButton_%d().contains(buttonActType.getTag())) {\n" +
                "                button.setButton_%d(MappingServer.updateConfigValue(buttonActType, null, button.getButton_%d()));\n" +
                "            }\n" +
                "        });\n" +
                "        button%d.add(selectButtonType%d);\n" +
                "        button%d.add(getConfigValue(MappingServer.getWord(button.getButton_%d())));";

        for(int i=0;i<12;i++){
            System.out.println(String.format(code,i,i+1,i+4,i,i+1,i,i,i+1,i+1,i+1,i,i,i,i+1));
        }
    }

}