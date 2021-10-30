package com.wuqid.euro2forjoy.demo;

import com.wuqid.euro2forjoy.util.Logcommon;
import com.wuqid.euro2forjoy.util.SystemProperty;
import lombok.extern.log4j.Log4j;
import net.java.games.input.*;

import java.io.File;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>输入设备识别操作demo</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/10/30 11:43
 */
@Log4j
public class JoyInputDemo {



    public static void ReadAllEvents() {
        while (true) {
            /* Get the available controllers */
            Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
            if (controllers.length == 0) {
                System.out.println("Found no controllers.");
                System.exit(0);
            }

            for (int i = 0; i < controllers.length; i++) {
                /* Remember to poll each one */
                controllers[i].poll();

                /* Get the controllers event queue */
                EventQueue queue = controllers[i].getEventQueue();

                /* Create an event object for the underlying plugin to populate */
                Event event = new Event();

                /* For each object in the queue */
                while (queue.getNextEvent(event)) {

                    /*
                     * Create a string buffer and put in it, the controller name,
                     * the time stamp of the event, the name of the component
                     * that changed and the new value.
                     *
                     * Note that the timestamp is a relative thing, not
                     * absolute, we can tell what order events happened in
                     * across controllers this way. We can not use it to tell
                     * exactly *when* an event happened just the order.
                     */
                    StringBuffer buffer = new StringBuffer(controllers[i].getName());
                    buffer.append(" at ");
                    buffer.append(event.getNanos()).append(", ");
                    Component comp = event.getComponent();
                    buffer.append(comp.getName()).append(" changed to ");
                    float value = event.getValue();

                    /*
                     * Check the type of the component and display an
                     * appropriate value
                     */
                    if (comp.isAnalog()) {
                        buffer.append(value);
                    } else {
                        if (value == 1.0f) {
                            buffer.append("On");
                        } else {
                            buffer.append("Off");
                        }
                    }
                    System.out.println(buffer.toString());
                }
            }

            /*
             * Sleep for 20 milliseconds, in here only so the example doesn't
             * thrash the system.
             */
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String methodName = "Euro2ForJoy 主程序";
        try {

            SystemProperty.set("net.java.games.input.librarypath", new File(ClassLoader.getSystemResource("dll").toURI()).getAbsolutePath());//这里只能设置绝对路径
            //"classpath:*resources/dll"
            // System.getProperty("java.class.path")
            //new File("src/main/resources/dll").getAbsolutePath()
           ReadAllEvents();
        }catch (Exception e){
            Logcommon.error(log,methodName,e);
        }
    }
}
