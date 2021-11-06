package com.wuqid.euro2forjoy.layout;

import lombok.Data;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.EventQueue;
import net.java.games.input.Rumbler;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd></dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/6 22:16
 */
class MainLayoutTest {

    @Test
    void getMainPage() {
        JFrame mainLayout =MainLayout.getMainPage();
        List<Controller> controllers = new ArrayList<>();
        //ainLayout.setInternalContentForMainPage(mainLayout,controllers);
    }

    private static Controller getController(){
        Controller result = new DIAbstractController();
        return result;
    }

    @Data
    private static class DIAbstractController implements Controller {
        @Override
        public Controller[] getControllers() {
            return new Controller[0];
        }

        @Override
        public Type getType() {
            return null;
        }

        @Override
        public Component[] getComponents() {
            return new Component[0];
        }

        @Override
        public Component getComponent(Component.Identifier identifier) {
            return null;
        }

        @Override
        public Rumbler[] getRumblers() {
            return new Rumbler[0];
        }

        @Override
        public boolean poll() {
            return false;
        }

        @Override
        public void setEventQueueSize(int i) {

        }

        @Override
        public EventQueue getEventQueue() {
            return null;
        }

        @Override
        public PortType getPortType() {
            return null;
        }

        @Override
        public int getPortNumber() {
            return 0;
        }

        @Override
        public String getName() {
            return null;
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);

        f.setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(50, 50, 300, 60);

        p1.setBackground(Color.RED);

        p1.setLayout(new FlowLayout());

        JButton b1 = new JButton("英雄1");
        JButton b2 = new JButton("英雄2");
        JButton b3 = new JButton("英雄3");

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);

        JPanel p2 = new JPanel();
        JButton b4 = new JButton("英雄4");
        JButton b5 = new JButton("英雄5");
        JButton b6 = new JButton("英雄6");

        p2.add(b4);
        p2.add(b5);
        p2.add(b6);

        p2.setBackground(Color.BLUE);
        p2.setBounds(10, 150, 300, 60);

        JTabbedPane tp = new JTabbedPane();
        tp.add(p1);
        tp.add(p2);

        // 设置tab的标题
        tp.setTitleAt(0, "红色tab");
        tp.setTitleAt(1, "蓝色tab");

        ImageIcon i = new ImageIcon("e:/project/j2se/j.png");
        tp.setIconAt(0,i );
        tp.setIconAt(1,i );

        f.setContentPane(tp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}