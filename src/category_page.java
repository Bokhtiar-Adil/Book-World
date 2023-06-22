import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class category_page {

    JFrame frame;
    JLabel bg, l1, l2, l3, l4, l5, l6, l7, l8;
    JButton e2, seerev, addrev, submit, star1, star2, star3, star4, star5;
    JTextField bn, an, pub, yp;
    JTextArea revbox;
    ImageIcon frameIcon = new ImageIcon("F:\\Image\\book2.png");
    ImageIcon hi = new ImageIcon("F:\\Image\\cat 40.png");
    ImageIcon bye = new ImageIcon("F:\\Image\\p2 40.png");
    String[] search;
    String review, bookname, wr, publisher, year, fstars;
    int hor_pos = 30, var_pos, chkr = 0, star;
    ResultSet rs;
    int rs2;

    void category(String pr_name, String type) throws SQLException {

        final String url = "jdbc:mysql:///BookWorld";
        final String user = "root";
        final String password = "supersqlsmash";

        Connection con = DriverManager.getConnection(url, user, password);
        final String find = "SELECT Si_no, Book_name, Writer, Publication, Year_pub, Five_stars FROM Books WHERE Topic = ? ORDER BY Five_stars DESC";
        PreparedStatement ps = con.prepareStatement(find, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ps.setString(1, type);

        final String find2 = "INSERT INTO Reviews(Username, Book_name, Topic, Stars, Review, Time_added) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps2 = con.prepareStatement(find2);

        frame = new JFrame();
        frame.setSize(1600, 850);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("BookWorld");
        frame.setIconImage(frameIcon.getImage());

        bg = new JLabel(new ImageIcon("F:\\Image\\cat1.jpg"));
        bg.setBounds(0, 0, 500, 750);
        frame.setContentPane(bg);

        l1 = new JLabel();
        l1.setBounds(0, 30, 425, 40);
        l1.setIcon(hi);
        l1.setText("CATEGORY - " + type);
        l1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
        l1.setForeground(Color.green);
        l1.setBackground(Color.black);
        l1.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l1);

        e2 = new JButton();
        e2.setBounds(1500, 20, 80, 70);
        e2.setIcon(bye);
        e2.setRolloverEnabled(true);
        e2.setRolloverIcon(bye);
        e2.setFocusable(false);
        e2.setBackground(Color.white);
        e2.setBorder(null);
        e2.setBorderPainted(false);
        e2.setContentAreaFilled(true);
        e2.setOpaque(false);
        e2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == e2) {
                    frame.dispose();
                }

            }

        });
        frame.add(e2);

        l2 = new JLabel();
        l2.setText("Most popular books of " + type + " category:");
        l2.setBounds(30, 120, 500, 30);
        l2.setForeground(Color.blue);
        l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setVerticalAlignment(JLabel.CENTER);
        frame.add(l2);

        String column_name[] = { "Sr.", "BOOK NAME", "AUTHOR", "PUBLICATION", "YEAR PUBLISHED", "NO OF 5-STARS" };
        for (int i = 0; i < 6; i++) {
            System.out.println(hor_pos);
            l3 = new JLabel();
            l3.setText(column_name[i]);
            if (i == 0) {
                l3.setBounds(hor_pos, 180, 20, 20);
                hor_pos += 20;
            } else if (i == 1) {
                l3.setBounds(hor_pos, 180, 300, 20);
                hor_pos += 300;
            } else if (i == 3 || i == 2) {
                l3.setBounds(hor_pos, 180, 200, 20);
                hor_pos += 200;
            } else {
                l3.setBounds(hor_pos, 180, 150, 20);
                hor_pos += 150;
            }
            l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            l3.setForeground(Color.red);
            l3.setBackground(Color.cyan);
            l3.setHorizontalAlignment(JLabel.CENTER);

            frame.add(l3);

        }
        var_pos = 205;
        rs = ps.executeQuery();
        for (int i = 0; i < 5; i++) {
            hor_pos = 30;
            rs.absolute(i);
            for (int j = 0; j < 6; j++) {
                l4 = new JLabel();
                if (j == 0) {
                    l4.setBounds(hor_pos, var_pos, 20, 20);
                    l4.setText("" + (i + 1));
                    hor_pos += 20;
                } else if (j == 1) {
                    l4.setBounds(hor_pos, var_pos, 300, 20);
                    if (rs.next())
                        l4.setText(rs.getString("Book_name"));
                    hor_pos += 300;
                } else if (j == 2) {
                    l4.setBounds(hor_pos, var_pos, 200, 20);
                    l4.setText(rs.getString("Writer"));
                    hor_pos += 200;
                } else if (j == 3) {
                    l4.setBounds(hor_pos, var_pos, 200, 20);
                    l4.setText(rs.getString("Publication"));
                    hor_pos += 200;
                } else if (j == 4) {
                    l4.setBounds(hor_pos, var_pos, 150, 20);
                    l4.setText(rs.getString("Year_pub"));
                    hor_pos += 150;
                } else {
                    l4.setBounds(hor_pos, var_pos, 150, 20);
                    l4.setText("" + rs.getInt("Five_stars"));
                    hor_pos += 150;
                }
                l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
                l4.setForeground(Color.white);
                l4.setBackground(Color.cyan);
                l4.setHorizontalAlignment(JLabel.CENTER);

                frame.add(l4);
            }
            var_pos += 25;
            rs.next();
        }

        l5 = new JLabel();
        l5.setText("Search and Reviews");
        l5.setBounds(1075, 120, 500, 30);
        l5.setForeground(Color.blue);
        l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        l5.setHorizontalAlignment(JLabel.CENTER);
        l5.setVerticalAlignment(JLabel.CENTER);
        frame.add(l5);

        var_pos = 180;
        for (int i = 1; i <= 4; i++) {
            l6 = new JLabel();
            l6.setText(column_name[i]);
            l6.setBounds(1075, var_pos, 150, 40);
            l6.setForeground(Color.orange);
            l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            l6.setHorizontalAlignment(JLabel.CENTER);
            l6.setVerticalAlignment(JLabel.CENTER);
            frame.add(l6);
            var_pos += 45;
        }

        bn = new JTextField();
        bn.setBounds(1235, 190, 300, 20);
        bn.setEditable(true);
        bn.setFont(new Font("Cambria", Font.PLAIN, 16));
        bn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!bn.getText().isEmpty()) {
                    bookname = bn.getText();
                }
            }
        });
        frame.add(bn);

        an = new JTextField();
        an.setBounds(1235, 235, 200, 20);
        an.setEditable(true);
        an.setFont(new Font("Cambria", Font.PLAIN, 16));
        an.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!an.getText().isEmpty()) {
                    wr = an.getText();
                }
            }
        });
        frame.add(an);

        l8 = new JLabel();
        l8.setText("(Optional)");
        l8.setBounds(1440, 235, 100, 15);
        l8.setForeground(Color.white);
        l8.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l8);

        pub = new JTextField();
        pub.setBounds(1235, 280, 200, 20);
        pub.setEditable(true);
        pub.setFont(new Font("Cambria", Font.PLAIN, 16));
        pub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!pub.getText().isEmpty()) {
                    publisher = pub.getText();
                }
            }
        });
        frame.add(pub);

        l8 = new JLabel();
        l8.setText("(Optional)");
        l8.setBounds(1440, 280, 100, 15);
        l8.setForeground(Color.white);
        l8.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l8);

        yp = new JTextField();
        yp.setBounds(1235, 325, 50, 20);
        yp.setEditable(true);
        yp.setFont(new Font("Cambria", Font.PLAIN, 16));
        yp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!yp.getText().isEmpty()) {
                    year = yp.getText();
                }
            }
        });
        frame.add(yp);

        l8 = new JLabel();
        l8.setText("(Optional)");
        l8.setBounds(1290, 325, 100, 15);
        l8.setForeground(Color.white);
        l8.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l8);

        l6 = new JLabel("*Please press 'Enter' after inserting each option*");
        l6.setBounds(1095, 360, 350, 15);
        l6.setForeground(Color.red);
        l6.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l6);

        l7 = new JLabel("*Review must be within 600 characters*");
        l7.setBounds(1120, 460, 350, 15);
        l7.setForeground(Color.red);
        l7.setHorizontalAlignment(JLabel.CENTER);
        l7.setVisible(false);
        frame.add(l7);

        revbox = new JTextArea();
        revbox.setBounds(1100, 480, 450, 250);
        revbox.setEditable(true);
        revbox.setLineWrap(true);
        revbox.setWrapStyleWord(true);
        revbox.setFont(new Font("Cambria", Font.PLAIN, 16));
        revbox.setRows(5);
        revbox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!revbox.getText().equals("")) {
                    review = revbox.getText();
                    System.out.println(review.length());
                }
            }

        });
        revbox.setVisible(false);
        frame.add(revbox);

        star = 0;
        star1 = new JButton("*");
        star2 = new JButton("*");
        star3 = new JButton("*");
        star4 = new JButton("*");
        star5 = new JButton("*");

        star1.setFont(new Font("Wide Latin", Font.BOLD, 28));
        star1.setBounds(1100, 750, 30, 20);
        star1.setBackground(Color.blue);
        star1.setContentAreaFilled(true);
        star1.setBorder(null);
        star1.setBorderPainted(false);
        star1.setFocusable(false);
        star1.setOpaque(false);
        star1.setForeground(Color.yellow);
        star1.setVerticalAlignment(JButton.CENTER);
        star1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                star1.setForeground(Color.red);
                star2.setForeground(Color.yellow);
                star3.setForeground(Color.yellow);
                star4.setForeground(Color.yellow);
                star5.setForeground(Color.yellow);
                star = 1;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                star1.setForeground(Color.orange);
                star2.setForeground(Color.yellow);
                star3.setForeground(Color.yellow);
                star4.setForeground(Color.yellow);
                star5.setForeground(Color.yellow);

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        star1.setVisible(false);
        frame.add(star1);

        star2.setFont(new Font("Wide Latin", Font.BOLD, 28));
        star2.setBounds(1130, 750, 30, 20);
        star2.setBackground(Color.blue);
        star2.setContentAreaFilled(true);
        star2.setBorder(null);
        star2.setBorderPainted(false);
        star2.setFocusable(false);
        star2.setOpaque(false);
        star2.setForeground(Color.yellow);
        star2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                star1.setForeground(Color.red);
                star2.setForeground(Color.red);
                star3.setForeground(Color.yellow);
                star4.setForeground(Color.yellow);
                star5.setForeground(Color.yellow);
                star = 2;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                star1.setForeground(Color.orange);
                star2.setForeground(Color.orange);
                star3.setForeground(Color.yellow);
                star4.setForeground(Color.yellow);
                star5.setForeground(Color.yellow);

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        star2.setVisible(false);
        frame.add(star2);

        star3.setFont(new Font("Wide Latin", Font.BOLD, 28));
        star3.setBounds(1160, 750, 30, 20);
        star3.setBackground(Color.blue);
        star3.setContentAreaFilled(true);
        star3.setBorder(null);
        star3.setBorderPainted(false);
        star3.setFocusable(false);
        star3.setOpaque(false);
        star3.setForeground(Color.yellow);
        star3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                star1.setForeground(Color.red);
                star2.setForeground(Color.red);
                star3.setForeground(Color.red);
                star4.setForeground(Color.yellow);
                star5.setForeground(Color.yellow);
                star = 3;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                star1.setForeground(Color.orange);
                star2.setForeground(Color.orange);
                star3.setForeground(Color.orange);
                star4.setForeground(Color.yellow);
                star5.setForeground(Color.yellow);

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        star3.setVisible(false);
        frame.add(star3);

        star4.setFont(new Font("Wide Latin", Font.BOLD, 28));
        star4.setBounds(1190, 750, 30, 20);
        star4.setBackground(Color.blue);
        star4.setContentAreaFilled(true);
        star4.setBorder(null);
        star4.setBorderPainted(false);
        star4.setFocusable(false);
        star4.setOpaque(false);
        star4.setForeground(Color.yellow);
        star4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                star1.setForeground(Color.red);
                star2.setForeground(Color.red);
                star3.setForeground(Color.red);
                star4.setForeground(Color.red);
                star5.setForeground(Color.yellow);
                star = 4;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                star1.setForeground(Color.orange);
                star2.setForeground(Color.orange);
                star3.setForeground(Color.orange);
                star4.setForeground(Color.orange);
                star5.setForeground(Color.yellow);

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        star4.setVisible(false);
        frame.add(star4);

        star5.setFont(new Font("Wide Latin", Font.BOLD, 28));
        star5.setBounds(1220, 750, 30, 20);
        star5.setBackground(Color.blue);
        star5.setContentAreaFilled(true);
        star5.setBorder(null);
        star5.setBorderPainted(false);
        star5.setFocusable(false);
        star5.setOpaque(false);
        star5.setForeground(Color.yellow);
        star5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                star1.setForeground(Color.red);
                star2.setForeground(Color.red);
                star3.setForeground(Color.red);
                star4.setForeground(Color.red);
                star5.setForeground(Color.red);
                star = 5;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                star1.setForeground(Color.orange);
                star2.setForeground(Color.orange);
                star3.setForeground(Color.orange);
                star4.setForeground(Color.orange);
                star5.setForeground(Color.orange);

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        star5.setVisible(false);
        frame.add(star5);

        System.out.println(pr_name + " " + bookname + " " + type + " " + star + " " + review + " ");

        submit = new JButton();
        submit.setBounds(1450, 750, 100, 45);
        submit.setText("Submit");
        submit.setBackground(Color.blue);
        submit.setContentAreaFilled(true);
        submit.setFocusable(false);
        submit.setOpaque(false);
        submit.setFont(new Font("Cambria", Font.BOLD, 20));
        submit.setForeground(Color.green);
        submit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == submit)
                    submit.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == submit)
                    submit.setOpaque(false);

            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {
                    if (star != 0) {
                        System.out.println(pr_name + " " + bookname + " " + type + " " + star + " " + review + " ");
                        try {
                            ps2.setString(1, pr_name);
                            ps2.setString(2, bookname);
                            ps2.setString(3, type);
                            ps2.setInt(4, star);
                            ps2.setString(5, review);
                            ps2.setString(6, "Today");
                            rs2 = ps2.executeUpdate();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        l7.setVisible(false);
                        revbox.setVisible(false);
                        submit.setVisible(false);
                        star1.setVisible(false);
                        star2.setVisible(false);
                        star3.setVisible(false);
                        star4.setVisible(false);
                        star5.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(frame,
                                "Please rate stars before submit",
                                "BookWorld",
                                JOptionPane.WARNING_MESSAGE);
                    }

                }

            }

        });
        submit.setVisible(false);
        frame.add(submit);

        seerev = new JButton();
        seerev.setText("Read Reviews");
        seerev.setBounds(1150, 385, 175, 45);
        seerev.setFocusable(false);
        seerev.setBackground(Color.blue);
        // seerev.setBorder(null);
        // seerev.setBorderPainted(false);
        seerev.setContentAreaFilled(true);
        seerev.setOpaque(false);
        seerev.setFont(new Font("Cambria", Font.BOLD, 20));
        seerev.setForeground(Color.green);
        seerev.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == seerev)
                    seerev.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == seerev)
                    seerev.setOpaque(false);

            }

        });
        seerev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == seerev) {
                    if (bookname == null) {
                        JOptionPane.showMessageDialog(frame,
                                "PLease insert 'Book name' and press 'Enter' after each option",
                                "BookWorld",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }

            }

        });
        frame.add(seerev);

        addrev = new JButton();
        addrev.setText("Add Reviews");
        addrev.setBounds(1335, 385, 175, 45);
        addrev.setFocusable(false);
        addrev.setBackground(Color.blue);
        addrev.setContentAreaFilled(true);
        addrev.setOpaque(false);
        addrev.setFont(new Font("Cambria", Font.BOLD, 20));
        addrev.setForeground(Color.green);
        addrev.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == addrev)
                    addrev.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == addrev)
                    addrev.setOpaque(false);

            }

        });
        addrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addrev) {
                    if (bookname == null) {
                        JOptionPane.showMessageDialog(frame,
                                "PLease insert 'Book name' and press 'Enter' after each option",
                                "BookWorld",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        l7.setVisible(true);
                        revbox.setVisible(true);
                        star1.setVisible(true);
                        star2.setVisible(true);
                        star3.setVisible(true);
                        star4.setVisible(true);
                        star5.setVisible(true);
                        submit.setVisible(true);
                    }

                }

            }

        });
        frame.add(addrev);

        frame.setVisible(true);
    }
}