package com.wuqid.euro2forjoy.layout;

import com.wuqid.euro2forjoy.common.Logcommon;
import com.wuqid.euro2forjoy.config.SystemConfig;
import com.wuqid.euro2forjoy.pojo.ControllerBO;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import net.java.games.input.Controller;
import net.java.games.input.JInputJoyServer;
import org.apache.commons.collections.CollectionUtils;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>主窗体 https://www.cnblogs.com/mrdz/p/7716643.html </dd>
 * https://blog.csdn.net/qq_32006373/article/details/49659129
 * https://blog.csdn.net/SHU15121856/article/details/78310112
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/3 22:32
 */
@Log4j
@Data
public class MainLayout {
    private static final int w = 1000;
    private static final int h = 800;
    private static JPanel innerPanel = new JPanel();

    public static JFrame getMainPage() {
        JFrame mainPage = new JFrame("Euro2Joy");
        mainPage.setSize(w, h);
        setIcon(mainPage);
        setWelcomePage(mainPage);
        setCenter(mainPage);
        mainPage.setBackground(Color.LIGHT_GRAY);
        mainPage.setLayout(new BorderLayout(0, 0));
        setMenuBar(mainPage);
        //中间操作面板区域
        innerPanel.setOpaque(false);
        //innerPanel.setBackground(Color.GRAY);
        //innerPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        innerPanel.setLayout(null);
        mainPage.add(innerPanel);
        //./中间操作面板区域
        setWriter(mainPage);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭界面 结束程序
        mainPage.setVisible(true);
        return mainPage;
    }

    public static void setInternalContentForMainPage(JFrame mainPage, List<Controller> controllers) {
        try {
            if (CollectionUtils.isNotEmpty(controllers)) {
                int widthX = 300;
                int height = h - 92;
                int width = w - widthX;
                JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
                jTabbedPane.setBounds(widthX / 2, 0, width, height);
                jTabbedPane.setFont(new Font("宋体", Font.BOLD, 19));
                for (int i = 0; i < controllers.size(); i++) {
                    Controller controller = controllers.get(i);
                    JPanel panel = new JPanel();
                    panel.setBounds(0, 0, width, height);
                    panel.setFont(new Font("仿宋", Font.ITALIC, 18));
                    panel.setLayout(null);

                    ControllerBO controllerBO = JInputJoyServer.getControllerBO(controller.getComponents());
                    setButton(panel, controllerBO);

                   /* String button = controllerBO.getButton_1().getGUID();
                    String analog = controllerBO.getAnalog().getGUID();
                    panelRight.add(BorderLayout.WEST, getJTextArea("按键guid：" + button));
                    panelRight.add(BorderLayout.EAST, getJTextArea("摇杆guid：" + analog));*/


                    jTabbedPane.add(panel);
                    jTabbedPane.setTitleAt(i, controller.getName() + ":" + i + "号");
                }
                innerPanel.add(jTabbedPane);
                mainPage.revalidate();
            }
        } catch (
                Exception e) {
            Logcommon.error(log, "Layout-中间操作面板区域", e);
        }
    }

    private static void setButton(JPanel panel, ControllerBO controllerBO) {
        int height = panel.getHeight() - 35;
        int width = 110;
        int widthX = 30;
        JPanel buttonName = new JPanel();
        buttonName.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 23));
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
        buttonType.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        buttonType.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        buttonType.setBounds(width + widthX, 0, width, height);

        panel.add(buttonType);//todo 按键映射模式

        JPanel buttonValue = new JPanel();
        buttonValue.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        buttonValue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonValue.setBounds(2 * (width + widthX), 0, width, height);

        panel.add(buttonValue);//todo 按键映射值
    }


    private static JTextArea getJTextArea(String content) {
        JTextArea textArea = new JTextArea(content, 1, 35);
        textArea.setLineWrap(true);    //设置文本域中的文本为自动换行
        textArea.setFont(new Font("楷体", Font.BOLD, 16));    //修改字体样式
        textArea.setBackground(Color.CYAN);    //设置背景色
        return textArea;
    }

    private static void setMenuBar(JFrame frame) {
        JMenuBar mb = new JMenuBar();
        JMenu mfile = new JMenu("操作");
        JMenuItem loadConfig = new JMenuItem("加载配置");
        JMenuItem saveConfig = new JMenuItem("保存配置");
        mfile.add(loadConfig);
        mfile.add(saveConfig);
        mb.add(mfile);
        frame.setJMenuBar(mb);
    }

    private static void setLoading() {
        //600 * 600
    }

    private static void setWelcomePage(JFrame f) {
        try {
            //欢迎页
            JDialog a = new JDialog(f);
            a.setModal(true);
            setIcon(a);
            a.setTitle("welcome~");
            ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().createImage(SystemConfig.WORK_HOME + "img/eurologo.jpg"));
            a.setSize(image.getIconWidth() + 16, image.getIconHeight() + 10);
            a.setLayout(new BorderLayout(0, 0));//水平间距 垂直间距

            JPanel TOP = new JPanel();
            TOP.setLayout(null);//上部绝对坐标
            TOP.setOpaque(false);

            JLabel imageLabel = new JLabel(image);
            imageLabel.setOpaque(false);
            imageLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
            imageLabel.addMouseListener(new MouseListening(a));
            TOP.add(BorderLayout.NORTH, imageLabel);

            a.add(TOP);
            setWriter(a);
            setCenter(a);
            a.setVisible(true);
        } catch (Exception e) {
            Logcommon.error(log, "Layout-欢迎页", e);
        }
    }

    @Data
    private static class MouseListening implements MouseInputListener {
        JDialog jDialog;

        public MouseListening(JDialog jDialog) {
            this.jDialog = jDialog;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            jDialog.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }

    private static void setWriter(Window w) {
        JLabel writer = new JLabel("writer:泥猴桃  V0.0.1 ", JLabel.RIGHT);//每个字像素宽度20
        //writer.setBorder(BorderFactory.createLineBorder(Color.red));
        //writer.setBounds(400, 230, 80, 20);
        writer.setFont(new Font("宋体", Font.ITALIC, 16));
        JPanel jPanel = new JPanel();
        jPanel.add(writer);
        //jPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        w.add(BorderLayout.SOUTH, jPanel);
    }

    private static final Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();

    private static void setCenter(Window w) {
        double x = scrSize.getWidth();
        double y = scrSize.getHeight();
        w.setLocation((int) (x - w.getWidth()) / 2, (int) (y - w.getHeight()) / 2);
    }

    private static void setIcon(Window w) {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.createImage(SystemConfig.WORK_HOME + "img/icon.jpg");
            w.setIconImage(image);
        } catch (Exception e) {
            Logcommon.error(log, "Layout-设置Icon", e);
        }
    }
}