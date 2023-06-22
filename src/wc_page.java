import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class wc_page {
    JFrame frame;
    JLabel label, label2;

    ImageIcon img = new ImageIcon("images\\b9 con 2.png");
    ImageIcon frameIcon = new ImageIcon("images\\book2.png");

    void wc() {
        frame = new JFrame();
        frame.setSize(460, 800);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("BookWorld");
        frame.setIconImage(frameIcon.getImage());

        label = new JLabel("", img, JLabel.LEFT);
        label.setBounds(0, 0, 460, 800);
        frame.add(label);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                frame.dispose();
                // home_page homepg = new home_page();
                // homepg.home("abc", 1);

                logreg_page lgrg = new logreg_page();
                try {
                    lgrg.logreg();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        frame.setVisible(true);
    }
}
