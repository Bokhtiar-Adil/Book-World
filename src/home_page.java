import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class home_page {
    int editchecker;
    JFrame frame;
    JPanel panel1, panel2;
    JLabel l1, l2, l3, back, back1;
    JButton pr, books, wr, pub, logout, exit;
    ImageIcon frameIcon = new ImageIcon("images\\book2.png");
    ImageIcon hi = new ImageIcon("images\\h 40.png");
    ImageIcon img2 = new ImageIcon("images\\home5r3.jpg");
    ImageIcon img = new ImageIcon("images\\h1.jpg");

    void home(String pr_name, int typecode) {
        frame = new JFrame();
        frame.setSize(1200, 750);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("BookWorld");
        frame.setIconImage(frameIcon.getImage());

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 350, 750);
        panel1.setBackground(Color.black);
        // back1 = new JLabel(img);
        // panel1.add(back1);
        // frame.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(350, 0, 850, 750);
        panel2.setBackground(Color.black);
        back = new JLabel(img2);
        panel2.add(back);

        l1 = new JLabel();
        l1.setBounds(0, 30, 350, 50);
        l1.setIcon(hi);
        l1.setText("HOME");
        l1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        l1.setForeground(Color.green);
        l1.setBackground(Color.black);
        l1.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l1);

        l2 = new JLabel();
        l2.setBounds(0, 120, 350, 50);
        l2.setText("Hello " + pr_name + "!");
        l2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
        l2.setForeground(Color.white);
        l2.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l2);

        pr = new JButton();
        pr.setText("PROFILE");
        pr.setBounds(0, 200, 350, 50);
        pr.setBackground(Color.blue);
        pr.setBorder(null);
        pr.setBorderPainted(false);
        // pr.setContentAreaFilled(false);
        pr.setOpaque(false);
        pr.setFocusable(false);
        pr.setForeground(Color.red);
        pr.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        pr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == pr) {
                    profile_page prof = new profile_page();
                    prof.profile(pr_name, typecode);
                }

            }

        });
        pr.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == pr)
                    pr.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == pr)
                    pr.setOpaque(false);

            }

        });
        frame.add(pr);

        books = new JButton();
        books.setText("BOOKS and REVIEWS");
        books.setBounds(0, 275, 350, 50);
        books.setBackground(Color.blue);
        books.setBorder(null);
        books.setBorderPainted(false);
        // books.setContentAreaFilled(false);
        books.setOpaque(false);
        books.setFocusable(false);
        books.setForeground(Color.red);
        books.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        books.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == books)
                    books.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == books)
                    books.setOpaque(false);

            }

        });
        books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // books_reviews_page br = new books_reviews_page();
                // br.books_rev(pr_name, typecode);
                all_books_page br = new all_books_page();
                br.all_books("umar", 1);
            }

        });
        frame.add(books);

        wr = new JButton();
        wr.setText("WRITERS");
        wr.setBounds(0, 350, 350, 50);
        wr.setBackground(Color.blue);
        wr.setBorder(null);
        wr.setBorderPainted(false);
        // wr.setContentAreaFilled(false);
        wr.setOpaque(false);
        wr.setFocusable(false);
        wr.setForeground(Color.red);
        wr.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        wr.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == wr)
                    wr.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == wr)
                    wr.setOpaque(false);

            }

        });
        frame.add(wr);

        pub = new JButton();
        pub.setText("PUBLISHERS");
        pub.setBounds(0, 425, 350, 50);
        pub.setBackground(Color.blue);
        pub.setBorder(null);
        pub.setBorderPainted(false);
        // pub.setContentAreaFilled(false);
        pub.setOpaque(false);
        pub.setFocusable(false);
        pub.setForeground(Color.red);
        pub.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        pub.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == pub)
                    pub.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == pub)
                    pub.setOpaque(false);

            }

        });
        frame.add(pub);

        logout = new JButton();
        logout.setText("LOGOUT");
        logout.setBounds(0, 500, 350, 50);
        logout.setBackground(Color.blue);
        logout.setBorder(null);
        logout.setBorderPainted(false);
        // logout.setContentAreaFilled(false);
        logout.setOpaque(false);
        logout.setFocusable(false);
        logout.setForeground(Color.red);
        logout.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        logout.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == logout)
                    logout.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == logout)
                    logout.setOpaque(false);

            }

        });
        // logout.addActionListener(new ActionListener() {

        // @Override
        // public void actionPerformed(ActionEvent e) {
        // int chkb = JOptionPane.YES_NO_OPTION;
        // int chkr = JOptionPane.showConfirmDialog(null,
        // "Are you sure to logout?", "BookWorld", chkb);
        // if(chkr==0) {
        // frame.dispose();
        // logreg_page login_page = new logreg_page();
        // try {
        // login_page.logreg();
        // } catch (SQLException e1) {
        // e1.printStackTrace();
        // }
        // }
        // }

        // });
        frame.add(logout);

        exit = new JButton();
        exit.setText("EXIT");
        exit.setBounds(0, 575, 350, 50);
        exit.setBackground(Color.blue);
        exit.setBorder(null);
        exit.setBorderPainted(false);
        // exit.setContentAreaFilled(false);
        exit.setOpaque(false);
        exit.setFocusable(false);
        exit.setForeground(Color.red);
        exit.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int chkb = JOptionPane.YES_NO_OPTION;
                int chkr = JOptionPane.showConfirmDialog(null,
                        "Are you sure to exit?", "BookWorld", chkb);
                if (chkr == 0)
                    System.exit(0);

            }

        });
        exit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == exit)
                    exit.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == exit)
                    exit.setOpaque(false);

            }

        });
        frame.add(exit);

        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {}

}
