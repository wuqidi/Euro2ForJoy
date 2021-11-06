package com.wuqid.euro2forjoy.service;

import com.wuqid.euro2forjoy.pojo.ButtonActType;
import com.wuqid.euro2forjoy.swing.PopPanel;
import com.wuqid.euro2forjoy.common.Logcommon;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Locale;

import static com.wuqid.euro2forjoy.config.SystemConfig.REFRESH_MS;
import static com.wuqid.euro2forjoy.config.SystemConfig.STEP_SIZE;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/1 21:05
 */
@Log4j
public class RobotServer {
    private static Robot ROBOT;

    static {
        String methodName = "RobotServer初始化";
        try {
            ROBOT = new Robot();
            ROBOT.setAutoDelay(REFRESH_MS - 10);
            ROBOT.setAutoWaitForIdle(true);
        } catch (Exception e) {
            PopPanel.showError(null,"鼠标、键盘存在配置问题！", "配置故障");
            Logcommon.error(log, methodName, e);
            System.exit(0);
        }
    }

    public static void moveAndPress(String key){
        if(StringUtils.isNotEmpty(key)){
            if(key.contains(ButtonActType.move.getTag())){
                mouseMove(key);
            }else{
                pressATUO(key);
            }
        }
    }

    public static void pressATUO(String key) {
        press(key);
        release(key);
    }

    /**
     * 按下按键
     *
     * @param key 映射配置
     */
    public static void press(String key) {
        if (ObjectUtils.isNotEmpty(ROBOT)) {
            Integer keyEvent = getKeyEvent(key);
            if (null != keyEvent) {
                ROBOT.keyPress(keyEvent);
            }
        }
    }

    /**
     * 释放按键
     *
     * @param key 映射配置
     */
    public static void release(String key) {
        if (ObjectUtils.isNotEmpty(ROBOT)) {
            Integer keyEvent = getKeyEvent(key);
            if (null != keyEvent) {
                ROBOT.keyRelease(keyEvent);
            }
        }
    }


    /**
     * (0,0)
     * ---------------------------->X
     * |
     * |
     * |
     * |
     * |
     * ∨
     * Y
     */

    /**
     *  操作鼠标
     * @param key 鼠标映射配置
     */
    public static void mouseMove(String key) {
        if (ObjectUtils.isNotEmpty(ROBOT)) {
            Integer keyEvent = getKeyEvent(key);
            Point point = MouseInfo.getPointerInfo().getLocation();
            if (null != keyEvent) {
                switch (keyEvent) {
                    case 0://up
                        ROBOT.mouseMove(point.x, point.y - STEP_SIZE);
                        break;
                    case 1://down
                        ROBOT.mouseMove(point.x, point.y + STEP_SIZE);
                        break;
                    case 2://left
                        ROBOT.mouseMove(point.x - STEP_SIZE, point.y);
                        break;
                    case 3://right
                        ROBOT.mouseMove(point.x + STEP_SIZE, point.y);
                        break;
                }
            }
        }
    }


    private static Integer getKeyEvent(String key) {
        String replace = key.replace("_", "");
        for(ButtonActType tem : ButtonActType.values()){
            String s = tem.name().toLowerCase(Locale.ROOT);
            replace = replace.replace(s, "");
        }
        switch (replace.toLowerCase(Locale.ROOT)) {
            case "a":
                return KeyEvent.VK_A;
            case "b":
                return KeyEvent.VK_B;
            case "c":
                return KeyEvent.VK_C;
            case "d":
                return KeyEvent.VK_D;
            case "e":
                return KeyEvent.VK_E;
            case "f":
                return KeyEvent.VK_F;
            case "g":
                return KeyEvent.VK_G;
            case "h":
                return KeyEvent.VK_H;
            case "i":
                return KeyEvent.VK_I;
            case "j":
                return KeyEvent.VK_J;
            case "k":
                return KeyEvent.VK_K;
            case "l":
                return KeyEvent.VK_L;
            case "m":
                return KeyEvent.VK_M;
            case "n":
                return KeyEvent.VK_N;
            case "o":
                return KeyEvent.VK_O;
            case "p":
                return KeyEvent.VK_P;
            case "q":
                return KeyEvent.VK_Q;
            case "r":
                return KeyEvent.VK_R;
            case "s":
                return KeyEvent.VK_S;
            case "t":
                return KeyEvent.VK_T;
            case "u":
                return KeyEvent.VK_U;
            case "v":
                return KeyEvent.VK_V;
            case "w":
                return KeyEvent.VK_W;
            case "x":
                return KeyEvent.VK_X;
            case "y":
                return KeyEvent.VK_Y;
            case "z":
                return KeyEvent.VK_Z;
            case "space":
                return KeyEvent.VK_SPACE;
            case "enter":
                return KeyEvent.VK_ENTER;
            case "up":
                return 0;
            case "down":
                return 1;
            case "left":
                return 2;
            case "right":
                return 3;
        }
        return null;
    }
}
