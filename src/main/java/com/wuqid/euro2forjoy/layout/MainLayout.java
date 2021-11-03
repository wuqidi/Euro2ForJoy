package com.wuqid.euro2forjoy.layout;

import com.wuqid.euro2forjoy.common.Logcommon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

/**
 * <dl>
 * <dt>Description：</dt>
 * <dd>主窗体</dd>
 * </dl>
 *
 * @author: 泥猴桃
 * @date 2021/11/3 22:32
 */
@Log4j
@Data
public class MainLayout {
    //private static final ImageIcon imageIcon = new ImageIcon("./img/icon/icon.jpg");
    public static void main(String[] args) {
        JFrame f = new JFrame("Euro2Joy");
        f.setSize(400, 300);
        setIcon(f);
        setCenter(f);

        f.setLayout(null);
        //f.setLocationRelativeTo(null);
        JButton b = new JButton("test");
        b.setBounds(50, 50, 280, 30);

        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭界面 结束程序

        setWelcomePage(f);

        f.setVisible(true);
    }

    private static final Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();

    private static void setCenter(Window w) {
        double x = scrSize.getWidth();
        double y = scrSize.getHeight();
        w.setLocation((int) (x - w.getWidth()) / 2, (int) (y - w.getHeight()) / 2);
    }

    private static final URL url = MainLayout.class.getResource("/img/icon.png");

    private static void setWelcomePage(JFrame f) {
        try {
            //欢迎页
            JDialog a = new JDialog(f);
            a.setModal(true);
            setIcon(a);
            a.setTitle("welcome~");
            a.setSize(500, 300);
            /*JLabel content = new JLabel();
            content.setBorder(BorderFactory.createLineBorder(Color.red));
            content.setBounds(0, 0, 74, 66);
            content.setIcon(imageIcon);
            content.setVisible(true);
            a.add(content);*/

            JLabel writer = new JLabel("writer:泥猴桃");//每个字像素宽度20
            writer.setBounds(400, 230, 80, 20);
            a.add(writer);

            a.setLayout(null);
            setCenter(a);
            a.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setIcon(Window w) {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.createImage(new File(url.toURI()).getAbsolutePath());
            w.setIconImage(image);
        } catch (Exception e) {
            Logcommon.error(log, "设置Icon", e);
        }
    }

    @Data
    @AllArgsConstructor
    static class Center {
        int x;
        int y;
    }

    //        JLabel label = new JLabel();
    //        label.setIcon(imageIcon);
    //        label.setText("123123121231");
    //        label.setVisible(true);
    //        label.setBackground(Color.BLUE);
    //        label.setBounds(10,10,imageIcon.getIconWidth(),imageIcon.getIconHeight());
    //        //label.setBounds(a.getWidth()/2,a.getHeight()/2,imageIcon.getIconWidth(),imageIcon.getIconHeight());
    //        f.add(label);

}
