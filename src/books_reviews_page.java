import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class books_reviews_page {

    JFrame frame;
    JLabel bg, l1, l2, l3, l4;
    JButton e2, cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11, cat12, mb, mp, mab, rev, mr;
    ImageIcon frameIcon = new ImageIcon("images\\book2.png");
    ImageIcon hi = new ImageIcon("images\\br 40.png");
    String left[] = { "Categories", "My Works", "Reviews" };
    ImageIcon bye = new ImageIcon("images\\p2 40.png");

    void books_rev(String pr_name, int typecode) {

        frame = new JFrame();
        frame = new JFrame();
        frame.setSize(1200, 750);
        frame.setResizable(false);
        // frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("BookWorld");
        frame.setIconImage(frameIcon.getImage());

        bg = new JLabel(new ImageIcon("images\\br5.jpg"));
        bg.setBounds(0, 0, 500, 750);
        frame.setContentPane(bg);

        l1 = new JLabel();
        l1.setBounds(0, 30, 350, 50);
        l1.setIcon(hi);
        l1.setText("BOOKS and REVIEWS");
        l1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
        l1.setForeground(Color.green);
        l1.setBackground(Color.black);
        l1.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l1);

        e2 = new JButton();
        e2.setBounds(1100, 20, 80, 70);
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

        int pos = 100;
        for (int i = 0; i < 3; i++) {
            l2 = new JLabel();
            l2.setText(left[i] + "  ==>");
            if (i == 0)
                l2.setBounds(0, pos, 350, 250);
            else
                l2.setBounds(0, pos, 350, 150);
            l2.setHorizontalAlignment(JLabel.CENTER);
            l2.setVerticalAlignment(JLabel.CENTER);
            l2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
            l2.setForeground(Color.red);
            frame.add(l2);
            if (i == 0)
                pos = pos + 250;
            else
                pos = pos + 150;
        }

        String topics[] = { "Science", "Engineering", "Medical", "Religion", "Finance", "History", "Business",
                "Philosophy", "Arts", "Literature", "Army/Warfare", "Miscelleneous" };

        int i = 0, hor_pos = 400, ver_pos = 150;

        cat1 = new JButton();
        cat1.setText("Science");
        cat1.setBounds(hor_pos, ver_pos, 180, 30);
        cat1.setBackground(Color.blue);
        cat1.setBorder(null);
        cat1.setBorderPainted(false);
        // cat1.setContentAreaFilled(true);
        cat1.setOpaque(false);
        cat1.setFocusable(false);
        cat1.setForeground(Color.white);
        cat1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat1.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat1)
                    cat1.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat1)
                    cat1.setOpaque(false);

            }

        });
        cat1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat1) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Science");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat1);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat2 = new JButton();
        cat2.setText("Engineering");
        cat2.setBounds(hor_pos, ver_pos, 180, 30);
        cat2.setBackground(Color.blue);
        cat2.setBorder(null);
        cat2.setBorderPainted(false);
        cat2.setContentAreaFilled(true);
        cat2.setOpaque(false);
        cat2.setFocusable(false);
        cat2.setForeground(Color.white);
        cat2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat2.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat2)
                    cat2.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat2)
                    cat2.setOpaque(false);

            }

        });
        cat2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat2) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Engineering");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat2);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat3 = new JButton();
        cat3.setText("Medical");
        cat3.setBounds(hor_pos, ver_pos, 180, 30);
        cat3.setBackground(Color.blue);
        cat3.setBorder(null);
        cat3.setBorderPainted(false);
        cat3.setContentAreaFilled(true);
        cat3.setOpaque(false);
        cat3.setFocusable(false);
        cat3.setForeground(Color.white);
        cat3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat3.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat3)
                    cat3.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat3)
                    cat3.setOpaque(false);

            }

        });
        cat3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat3) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Medical");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat3);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat4 = new JButton();
        cat4.setText("Religion");
        cat4.setBounds(hor_pos, ver_pos, 180, 30);
        cat4.setBackground(Color.blue);
        cat4.setBorder(null);
        cat4.setBorderPainted(false);
        cat4.setContentAreaFilled(true);
        cat4.setOpaque(false);
        cat4.setFocusable(false);
        cat4.setForeground(Color.white);
        cat4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat4.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat4)
                    cat4.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat4)
                    cat4.setOpaque(false);

            }

        });
        cat4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat4) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Religion");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat4);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat5 = new JButton();
        cat5.setText("Finance");
        cat5.setBounds(hor_pos, ver_pos, 180, 30);
        cat5.setBackground(Color.blue);
        cat5.setBorder(null);
        cat5.setBorderPainted(false);
        cat5.setContentAreaFilled(true);
        cat5.setOpaque(false);
        cat5.setFocusable(false);
        cat5.setForeground(Color.white);
        cat5.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat5.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat5)
                    cat5.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat5)
                    cat5.setOpaque(false);

            }

        });
        cat5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat5) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Finance");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat5);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat6 = new JButton();
        cat6.setText("History");
        cat6.setBounds(hor_pos, ver_pos, 180, 30);
        cat6.setBackground(Color.blue);
        cat6.setBorder(null);
        cat6.setBorderPainted(false);
        cat6.setContentAreaFilled(true);
        cat6.setOpaque(false);
        cat6.setFocusable(false);
        cat6.setForeground(Color.white);
        cat6.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat6.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat6)
                    cat6.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat6)
                    cat6.setOpaque(false);

            }

        });
        cat6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat6) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "History");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat6);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat7 = new JButton();
        cat7.setText("Business");
        cat7.setBounds(hor_pos, ver_pos, 180, 30);
        cat7.setBackground(Color.blue);
        cat7.setBorder(null);
        cat7.setBorderPainted(false);
        cat7.setContentAreaFilled(true);
        cat7.setOpaque(false);
        cat7.setFocusable(false);
        cat7.setForeground(Color.white);
        cat7.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat7.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat7)
                    cat7.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat7)
                    cat7.setOpaque(false);

            }

        });
        cat7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat7) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Business");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat7);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat8 = new JButton();
        cat8.setText("Philosophy");
        cat8.setBounds(hor_pos, ver_pos, 180, 30);
        cat8.setBackground(Color.blue);
        cat8.setBorder(null);
        cat8.setBorderPainted(false);
        cat8.setContentAreaFilled(true);
        cat8.setOpaque(false);
        cat8.setFocusable(false);
        cat8.setForeground(Color.white);
        cat8.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat8.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat8)
                    cat8.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat8)
                    cat8.setOpaque(false);

            }

        });
        cat8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat8) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Philosophy");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat8);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat9 = new JButton();
        cat9.setText("Arts");
        cat9.setBounds(hor_pos, ver_pos, 180, 30);
        cat9.setBackground(Color.blue);
        cat9.setBorder(null);
        cat9.setBorderPainted(false);
        cat9.setContentAreaFilled(true);
        cat9.setOpaque(false);
        cat9.setFocusable(false);
        cat9.setForeground(Color.white);
        cat9.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat9.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat9)
                    cat9.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat9)
                    cat9.setOpaque(false);

            }

        });
        cat9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat9) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Arts");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat9);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat10 = new JButton();
        cat10.setText("Literature");
        cat10.setBounds(hor_pos, ver_pos, 180, 30);
        cat10.setBackground(Color.blue);
        cat10.setBorder(null);
        cat10.setBorderPainted(false);
        cat10.setContentAreaFilled(true);
        cat10.setOpaque(false);
        cat10.setFocusable(false);
        cat10.setForeground(Color.white);
        cat10.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat10.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat10)
                    cat10.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat10)
                    cat10.setOpaque(false);

            }

        });
        cat10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat10) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Literature");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat10);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat11 = new JButton();
        cat11.setText("Army/Warfare");
        cat11.setBounds(hor_pos, ver_pos, 180, 30);
        cat11.setBackground(Color.blue);
        cat11.setBorder(null);
        cat11.setBorderPainted(false);
        cat11.setContentAreaFilled(true);
        cat11.setOpaque(false);
        cat11.setFocusable(false);
        cat11.setForeground(Color.white);
        cat11.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat11.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat11)
                    cat11.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat11)
                    cat11.setOpaque(false);

            }

        });
        cat11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat11) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Army/Warfare");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat11);

        if (i % 4 != 0 || i == 0)
            hor_pos = hor_pos + 200;
        else {
            hor_pos = 400;
            ver_pos = ver_pos + 60;
        }
        i++;

        cat12 = new JButton();
        cat12.setText("Miscelleneous");
        cat12.setBounds(hor_pos, ver_pos, 180, 30);
        cat12.setBackground(Color.blue);
        cat12.setBorder(null);
        cat12.setBorderPainted(false);
        cat12.setContentAreaFilled(true);
        cat12.setOpaque(false);
        cat12.setFocusable(false);
        cat12.setForeground(Color.white);
        cat12.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        cat12.addMouseListener(new MouseListener() {
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
                if (e.getSource() == cat12)
                    cat12.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == cat12)
                    cat12.setOpaque(false);

            }

        });
        cat12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cat12) {
                    category_page cat = new category_page();
                    try {
                        cat.category(pr_name, "Miscelleneous");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(cat12);

        hor_pos = 400;
        ver_pos = 405;

        mb = new JButton();
        mb.setText("My Books");
        mb.setBounds(hor_pos, ver_pos, 180, 30);
        mb.setBackground(Color.blue);
        mb.setBorder(null);
        mb.setBorderPainted(false);
        mb.setContentAreaFilled(true);
        mb.setOpaque(false);
        mb.setFocusable(false);
        mb.setForeground(Color.white);
        mb.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        mb.addMouseListener(new MouseListener() {
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
                if (e.getSource() == mb)
                    mb.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == mb)
                    mb.setOpaque(false);

            }

        });
        mb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mb) {
                    if (typecode != 1) {
                        JOptionPane.showMessageDialog(frame,
                                "Only 'Writer' accounts can access this section",
                                "BookWorld",
                                JOptionPane.OK_OPTION);
                    }
                }

            }

        });
        frame.add(mb);

        hor_pos += 200;
        mp = new JButton();
        mp.setText("My Publication");
        mp.setBounds(hor_pos, ver_pos, 180, 30);
        mp.setBackground(Color.blue);
        mp.setBorder(null);
        mp.setBorderPainted(false);
        mp.setContentAreaFilled(true);
        mp.setOpaque(false);
        mp.setFocusable(false);
        mp.setForeground(Color.white);
        mp.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        mp.addMouseListener(new MouseListener() {
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
                if (e.getSource() == mp)
                    mp.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == mp)
                    mp.setOpaque(false);

            }

        });
        mp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mp) {
                    if (typecode != 2) {
                        JOptionPane.showMessageDialog(frame,
                                "Only 'Publisher' accounts can access this section",
                                "BookWorld",
                                JOptionPane.OK_OPTION);
                    }
                }

            }

        });
        frame.add(mp);

        hor_pos += 200;

        hor_pos = 400;
        ver_pos = 555;
        rev = new JButton();
        rev.setText("Reviews");
        rev.setBounds(hor_pos, ver_pos, 180, 30);
        rev.setBackground(Color.blue);
        rev.setBorder(null);
        rev.setBorderPainted(false);
        rev.setContentAreaFilled(true);
        rev.setOpaque(false);
        rev.setFocusable(false);
        rev.setForeground(Color.white);
        rev.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        rev.addMouseListener(new MouseListener() {
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
                if (e.getSource() == rev)
                    rev.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == rev)
                    rev.setOpaque(false);

            }

        });
        rev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }

        });
        frame.add(rev);

        hor_pos += 200;
        mr = new JButton();
        mr.setText("My Reviews");
        mr.setBounds(hor_pos, ver_pos, 180, 30);
        mr.setBackground(Color.blue);
        mr.setBorder(null);
        mr.setBorderPainted(false);
        mr.setContentAreaFilled(true);
        mr.setOpaque(false);
        mr.setFocusable(false);
        mr.setForeground(Color.white);
        mr.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
        mr.addMouseListener(new MouseListener() {
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
                if (e.getSource() == mr)
                    mr.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == mr)
                    mr.setOpaque(false);

            }

        });
        mr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }

        });
        frame.add(mr);

        frame.setVisible(true);

    }

}