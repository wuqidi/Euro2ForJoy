package com.wuqid.euro2forjoy.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/31 15:29
 */
@Data
public class KeyMappingBO {
    private Integer controllerNum;
    private Button button = new Button();
    private Analog analog = new Analog();

    private static final String KEY = "controller%d";

    public static String getKey(int controllerNum){
        return String.format(KEY,controllerNum);
    }

    public static Map<String,KeyMappingBO> getInstance(String controllerNum,Map<String,Map<String,String>> config){
        Map<String,KeyMappingBO> result = new HashMap<>(1);
        KeyMappingBO keyMappingBO = new KeyMappingBO();

        Map<String, String> analogConfig = config.get("analog");
        Analog analog = keyMappingBO.getAnalog();
        analog.setGUID(analogConfig.get("gUID"));
        analog.setCenter(analogConfig.get("center"));
        analog.setUp(analogConfig.get("up"));
        analog.setDown(analogConfig.get("down"));
        analog.setLeft(analogConfig.get("left"));
        analog.setRight(analogConfig.get("right"));

        Map<String, String> buttonConfig = config.get("button");
        Button button = keyMappingBO.getButton();
        button.setName(buttonConfig.get("name"));
        button.setGUID(buttonConfig.get("gUID"));
        button.setButton_1(buttonConfig.get("button_1"));
        button.setButton_2(buttonConfig.get("button_2"));
        button.setButton_3(buttonConfig.get("button_3"));
        button.setButton_4(buttonConfig.get("button_4"));
        button.setButton_5(buttonConfig.get("button_5"));
        button.setButton_6(buttonConfig.get("button_6"));
        button.setButton_7(buttonConfig.get("button_7"));
        button.setButton_8(buttonConfig.get("button_8"));
        button.setButton_9(buttonConfig.get("button_9"));
        button.setButton_10(buttonConfig.get("button_10"));
        button.setButton_11(buttonConfig.get("button_11"));
        button.setButton_12(buttonConfig.get("button_12"));
        result.put(controllerNum,keyMappingBO);
        return result;
    }

    @Data
    public static class Button{
        private String name;
        private String gUID;
        private String button_1;
        private String button_2;
        private String button_3;
        private String button_4;
        private String button_5;
        private String button_6;
        private String button_7;
        private String button_8;
        private String button_9;
        private String button_10;
        private String button_11;
        private String button_12;

        public String getKey(String name){
            switch (name){
                case "0":
                    return getButton_1();
                case "1":
                    return getButton_2();
                case "2":
                    return getButton_3();
                case "3":
                    return getButton_4();
                case "4":
                    return getButton_5();
                case "5":
                    return getButton_6();
                case "6":
                    return getButton_7();
                case "7":
                    return getButton_8();
                case "8":
                    return getButton_9();
                case "9":
                    return getButton_10();
                case "10":
                    return getButton_11();
                case "11":
                    return getButton_12();
                default:
                    break;
            }
            return "";
        }
    }
    @Data
    public static class Analog {
        private String gUID;
        private String center;
        private String up;
        private String down;
        private String left;
        private String right;

        public String getKey(AnalogBO.Direction direction){
            switch (direction){
                case CENTER:
                    return getCenter();
                case UP:
                    return getUp();
                case DOWN:
                    return getDown();
                case LEFT:
                    return getLeft();
                case RIGHT:
                    return getRight();
            }
            return "";
        }
    }
}