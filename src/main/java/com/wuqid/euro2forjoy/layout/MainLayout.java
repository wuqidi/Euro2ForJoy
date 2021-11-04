package com.wuqid.euro2forjoy.layout;

import com.wuqid.euro2forjoy.common.Logcommon;
import com.wuqid.euro2forjoy.pojo.ControllerBO;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import net.java.games.input.Controller;
import net.java.games.input.JInputJoyServer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

import static com.wuqid.euro2forjoy.config.SystemConfig.IMG_FILE_URI;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>主窗体 https://www.cnblogs.com/mrdz/p/7716643.html </dd>
 * https://blog.csdn.net/qq_32006373/article/details/49659129
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/3 22:32
 */
@Log4j
@Data
public class MainLayout {
    private static final String imgPath = new File(IMG_FILE_URI).getAbsolutePath() + File.separator;
    private static final int w = 1000;
    private static final int h = 800;
    private static JPanel innerPanel = new JPanel();

    public static JFrame getMainPage() {
        JFrame mainPage = new JFrame("Euro2Joy");
        mainPage.setSize(w, h);
        setIcon(mainPage);
        //setWelcomePage(mainPage);
        setCenter(mainPage);
        mainPage.setBackground(Color.LIGHT_GRAY);
        mainPage.setLayout(new BorderLayout(0, 0));
        setMenuBar(mainPage);
        //中间操作面板区域
        //innerPanel.setBackground(Color.GRAY);
        innerPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        innerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        mainPage.add(innerPanel);
        //./中间操作面板区域
        setWriter(mainPage);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭界面 结束程序
        mainPage.setVisible(true);
        return mainPage;
    }

    public static void setInternalContentForMainPage(JFrame mainPage, List<Controller> controllers) {
        try {
            for (Controller controller : controllers) {
                JPanel panel = new JPanel();
                panel.setBounds(0,0,mainPage.getWidth(),50);
                panel.setFont(new Font("宋体", Font.ITALIC, 16));
                panel.setLayout(new BorderLayout(0, 0));
                panel.add(BorderLayout.WEST, new JLabel(controller.getName()));

                JPanel panelRight = new JPanel();
                panelRight.setBorder(BorderFactory.createLineBorder(Color.red));
                ControllerBO controllerBO = JInputJoyServer.getControllerBO(controller.getComponents());
                String button = controllerBO.getButton_1().getGUID();
                String analog = controllerBO.getAnalog().getGUID();
                panelRight.add(BorderLayout.WEST, getJTextArea("按键guid："+button));
                panelRight.add(BorderLayout.EAST, getJTextArea("摇杆guid："+analog));

                panel.add(BorderLayout.EAST, panelRight);
                panel.setBorder(BorderFactory.createLineBorder(Color.red));

                innerPanel.add(panel);
            }
            mainPage.revalidate();
        } catch (Exception e) {
            Logcommon.error(log, "Layout-中间操作面板区域", e);
        }
    }

    private static JTextArea getJTextArea(String content){
        JTextArea textArea = new JTextArea(content,1,35);
        textArea.setLineWrap(true);    //设置文本域中的文本为自动换行
        textArea.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        textArea.setBackground(Color.CYAN);    //设置背景色
        return textArea;
    }

    private static void setMenuBar(JFrame frame) {
        JMenuBar mb = new JMenuBar();
        JMenu mfile = new JMenu("文件");
        JMenuItem minew = new JMenuItem("新建");
        JMenuItem miopen = new JMenuItem("打开");
        mfile.add(minew);
        mfile.add(miopen);
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
            ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgPath + "eurologo.jpg"));
            a.setSize(image.getIconWidth() + 16, image.getIconHeight() + 60);
            a.setLayout(new BorderLayout(0, 0));//水平间距 垂直间距

            JLabel content = new JLabel();
            content.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
            content.setIcon(image);
            content.setVisible(true);
            a.add(BorderLayout.NORTH, content);

            setWriter(a);
            setCenter(a);
            a.setVisible(true);
        } catch (Exception e) {
            Logcommon.error(log, "Layout-欢迎页", e);
        }
    }

    private static void setWriter(Window w) {
        JLabel writer = new JLabel("writer:泥猴桃  V0.0.1 ", JLabel.RIGHT);//每个字像素宽度20
        //writer.setBorder(BorderFactory.createLineBorder(Color.red));
        //writer.setBounds(400, 230, 80, 20);
        writer.setFont(new Font("宋体", Font.ITALIC, 16));
        w.add(BorderLayout.SOUTH, writer);
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
            Image image = toolkit.createImage(imgPath + "icon.jpg");
            w.setIconImage(image);
        } catch (Exception e) {
            Logcommon.error(log, "Layout-设置Icon", e);
        }
    }
}