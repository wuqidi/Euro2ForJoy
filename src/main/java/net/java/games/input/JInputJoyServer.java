package net.java.games.input;

import com.alibaba.fastjson.JSON;
import com.wuqid.euro2forjoy.pojo.ComponenBO;
import com.wuqid.euro2forjoy.pojo.ControllerBO;
import com.wuqid.euro2forjoy.util.Logcommon;
import lombok.extern.log4j.Log4j;
import net.java.games.input.Component.Identifier.Axis;

import java.util.Locale;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 20:50
 */
@Log4j
public class JInputJoyServer {
    public static boolean isDIComponentClass(Component component) {
        return component instanceof DIComponent;
    }

    public static ComponenBO getComponenBO(Component component) throws Exception {
        if (component instanceof DIComponent) {
            DIComponent diComponent = (DIComponent) component;
            ComponenBO result = new ComponenBO();
            DIDeviceObject deviceObject = diComponent.getDeviceObject();
            result.setName(deviceObject.getIdentifier().getName().toLowerCase(Locale.ROOT));
            result.setGUID(JSON.toJSONString(deviceObject.getGUID()).replace("\"",""));
            result.setButton(deviceObject.isButton());
            result.setFlags(deviceObject.getFlags());
            result.setType(deviceObject.getType());
            result.setGUIDType(deviceObject.getGUIDType());
            result.setSwitchOff(diComponent.getPollData() == 1.0f);
            if (deviceObject.isButton()) {
                result.setPollData(diComponent.getPollData());
            } else {
                if (-0.007827878f == diComponent.getPollData()) {
                    result.setPollData(0.0f);
                } else if (-1.0f == diComponent.getPollData()) {
                    result.setPollData(-1.0f);
                } else if (1.0f == diComponent.getPollData()) {
                    result.setPollData(1.0f);
                }

            }

            return result;
        }
        return null;
    }

    public static ControllerBO getControllerBO(Component[] components) throws Exception {
        ControllerBO result = new ControllerBO();
        ComponenBO componenBOX = null;
        ComponenBO componenBOY = null;
        for (Component component : components) {
            if (JInputJoyServer.isDIComponentClass(component)) {
                ComponenBO componenBO = getComponenBO(component);
                if (componenBO.isButton()) {
                    switch (componenBO.getName()) {
                        case "0":
                            result.setButton_1(componenBO);
                            break;
                        case "1":
                            result.setButton_2(componenBO);
                            break;
                        case "2":
                            result.setButton_3(componenBO);
                            break;
                        case "3":
                            result.setButton_4(componenBO);
                            break;
                        case "4":
                            result.setButton_5(componenBO);
                            break;
                        case "5":
                            result.setButton_6(componenBO);
                            break;
                        case "6":
                            result.setButton_7(componenBO);
                            break;
                        case "7":
                            result.setButton_8(componenBO);
                            break;
                        case "8":
                            result.setButton_9(componenBO);
                            break;
                        case "9":
                            result.setButton_10(componenBO);
                            break;
                        case "10":
                            result.setButton_11(componenBO);
                            break;
                        case "11":
                            result.setButton_12(componenBO);
                            break;
                        default:
                            break;
                    }
                } else {
                    if (Axis.X.getName().equals(componenBO.getName())) {
                        componenBOX = (componenBO);
                    } else if (Axis.Y.getName().equals(componenBO.getName())) {
                        componenBOY = componenBO;
                    }
                }
            }
        }
        ControllerBO.Analog analog = result.getAnalog();
        analog.setDirection(ControllerBO.Analog.Direction.getDirection(componenBOX, componenBOY));
        return result;
    }

    public static void printValue(Component component) {
        DIComponent diComponent = (DIComponent) component;
        if (diComponent.isAnalog()) {
            Logcommon.info(log, "摇杆" + diComponent.getDeviceObject().getIdentifier().getName(), Logcommon.TAG.OUTPUT, diComponent.getPollData());
        }
    }
}