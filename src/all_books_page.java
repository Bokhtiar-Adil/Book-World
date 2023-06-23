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
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class all_books_page {

    JFrame frame;
    JLabel bg, l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JButton search, addbkwr, addbkpub, allrev, e2, b1, b2, b3, b4, seerev, addrev;
    JLabel books[] = new JLabel[40];
    JLabel left[] = new JLabel[5];
    JLabel right[] = new JLabel[5];
    JTextField input;
    JTextArea revbox;
    ImageIcon frameIcon = new ImageIcon("images\\book2.png");
    ImageIcon hi = new ImageIcon("images\\cat 40.png");
    ImageIcon bye = new ImageIcon("images\\p2 40.png");
    // String[] search;
    String review, bookname = null, author = null, publi = null, category;
    int hor_pos = 30, var_pos, chkr = 0, star, size, i;
    String[] data = new String[10];
    ResultSet rs1, rs2;
    int rs3;

    final String url = "jdbc:mysql:///BookWorld";
    final String user = "root";
    final String password = "supersqlsmash";
    final String find2 = "SELECT Book_name, Writer, Publication, Topic, Year_pub FROM Books WHERE Book_name = ?";

    void all_books(String pr_name, int typecode) {

        Connection con = DriverManager.getConnection(url, user, password);
        // if(con!=null) System.out.println("Successfully connected to mysql");
        PreparedStatement ps2 = con.prepareStatement(find2);

        frame = new JFrame();
        frame.setSize(1800, 1000);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setTitle("BookWorld");
        frame.setIconImage(frameIcon.getImage());
        // frame.setBackground(Color.black);

        bg = new JLabel(new ImageIcon("images\\all1.jpg"));
        frame.setContentPane(bg);

        l1 = new JLabel();
        l1.setBounds(30, 30, 425, 40);
        l1.setIcon(hi);
        l1.setText("BOOKS and REVIEWS");
        l1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
        l1.setForeground(Color.green);
        l1.setBackground(Color.black);
        l1.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l1);

        e2 = new JButton();
        e2.setBounds(1700, 20, 80, 70);
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
        l2.setText("Most popular books:");
        l2.setBounds(30, 100, 500, 30);
        l2.setForeground(Color.red);
        l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setVerticalAlignment(JLabel.CENTER);
        frame.add(l2);

        show_all_books();

        allrev = new JButton();
        allrev.setText("Read All Reviews");
        allrev.setBounds(1400, 700, 300, 40);
        allrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        allrev.setForeground(Color.green);
        allrev.setBackground(Color.red);
        allrev.setOpaque(false);
        allrev.setFocusable(false);
        allrev.addMouseListener(new MouseListener() {
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
                if (e.getSource() == allrev)
                    allrev.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == allrev)
                    allrev.setOpaque(false);

            }

        });
        allrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == allrev) {
                    read_review_page rr = new read_review_page();
                    try {
                        rr.read_review(null, bookname, 1);
                    } catch (SQLException e1) {

                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(allrev);

        addbkwr = new JButton();
        addbkwr.setText("Add Your Written Books");
        addbkwr.setBounds(1400, 750, 300, 40);
        addbkwr.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        addbkwr.setForeground(Color.green);
        addbkwr.setBackground(Color.red);
        addbkwr.setOpaque(false);
        addbkwr.setFocusable(false);
        addbkwr.addMouseListener(new MouseListener() {
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
                if (e.getSource() == addbkwr)
                    addbkwr.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == addbkwr)
                    addbkwr.setOpaque(false);

            }

        });
        addbkwr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addbkwr) {
                    if (typecode == 1) {
                        add_books_page add = new add_books_page();
                        try {
                            add.add_books(pr_name, 1);
                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame,
                                "Only a 'Writer' account can access this section",
                                "BookWorld",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        frame.add(addbkwr);

        addbkpub = new JButton();
        addbkpub.setText("Add Your Published Books");
        addbkpub.setBounds(1400, 800, 300, 40);
        addbkpub.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        addbkpub.setForeground(Color.green);
        addbkpub.setBackground(Color.red);
        addbkpub.setOpaque(false);
        addbkpub.setFocusable(false);
        addbkpub.addMouseListener(new MouseListener() {
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
                if (e.getSource() == addbkpub)
                    addbkpub.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == addbkpub)
                    addbkpub.setOpaque(false);

            }

        });
        addbkpub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addbkpub) {
                    if (typecode == 2) {
                        add_books_page add = new add_books_page();
                        try {
                            add.add_books(pr_name, 2);
                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame,
                                "Only a 'Publisher' account can access this section",
                                "BookWorld",
                                JOptionPane.WARNING_MESSAGE);
                    }

                }
            }

        });
        frame.add(addbkpub);

        l5 = new JLabel();
        l5.setText("Search Books");
        l5.setBounds(1350, 100, 400, 30);
        l5.setForeground(Color.red);
        l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        l5.setHorizontalAlignment(JLabel.CENTER);
        l5.setVerticalAlignment(JLabel.CENTER);
        frame.add(l5);

        l6 = new JLabel();
        l6.setText("Press 'Enter' after inserting book name");
        l6.setBounds(1350, 140, 400, 20);
        l6.setForeground(Color.white);
        l6.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l6);

        hor_pos = 1350;
        var_pos = 180;
        l6 = new JLabel();
        l6.setText("Book Name");
        l6.setBounds(hor_pos, var_pos, 80, 30);
        l6.setForeground(Color.white);
        l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        l6.setHorizontalAlignment(JLabel.LEFT);
        l6.setVerticalAlignment(JLabel.CENTER);
        frame.add(l6);

        input = new JTextField();
        input.setBounds(hor_pos + 100, var_pos, 300, 30);
        input.setFont(new Font("Cambria", Font.PLAIN, 16));
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().isEmpty()) {
                    bookname = input.getText();
                }
            }
        });

        frame.add(input);

        l6 = new JLabel();
        l6.setText("Search Result");
        l6.setBounds(1360, 280, 400, 30);
        l6.setForeground(Color.red);
        l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        l6.setHorizontalAlignment(JLabel.CENTER);
        l6.setVerticalAlignment(JLabel.CENTER);
        frame.add(l6);

        String col[] = { "Book Name", "Author", "Publication", "Category", "Published in" };

        hor_pos = 1350;
        var_pos = 320;

        for (i = 0; i < 5; i++) {
            left[i] = new JLabel();
            left[i].setText(col[i]);
            left[i].setBounds(hor_pos, var_pos + i * 40, 90, 30);
            left[i].setForeground(Color.white);
            left[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            left[i].setHorizontalAlignment(JLabel.LEFT);
            left[i].setVerticalAlignment(JLabel.CENTER);
            frame.add(left[i]);

            right[i] = new JLabel();
            right[i].setText(".....");
            right[i].setBounds(hor_pos + 100, var_pos + i * 40, 300, 30);
            right[i].setForeground(Color.yellow);
            right[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            right[i].setHorizontalAlignment(JLabel.CENTER);
            right[i].setVerticalAlignment(JLabel.CENTER);
            frame.add(right[i]);
        }

        seerev = new JButton();
        seerev.setText("Read Reviews");
        seerev.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        seerev.setBounds(1350, 530, 180, 40);
        seerev.setForeground(Color.green);
        seerev.setBackground(Color.red);
        seerev.setOpaque(false);
        seerev.setFocusable(false);
        seerev.addMouseListener(new MouseListener() {
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
                    read_review_page rr = new read_review_page();
                    try {
                        rr.read_review(null, bookname, 3);
                    } catch (SQLException e1) {

                        e1.printStackTrace();
                    }
                }

            }

        });
        seerev.setEnabled(false);
        frame.add(seerev);

        addrev = new JButton();
        addrev.setText("Write Reviews");
        addrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        addrev.setBounds(1575, 530, 180, 40);
        addrev.setForeground(Color.green);
        addrev.setBackground(Color.red);
        addrev.setOpaque(false);
        addrev.setFocusable(false);
        addrev.addMouseListener(new MouseListener() {
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
                    add_review(pr_name, bookname);
                }

            }

        });
        addrev.setEnabled(false);
        frame.add(addrev);

        search = new JButton();
        search.setText("Search");
        search.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        search.setBounds(1500, 230, 120, 40);
        search.setForeground(Color.green);
        search.setBackground(Color.red);
        search.setOpaque(false);
        search.setFocusable(false);
        search.addMouseListener(new MouseListener() {
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
                if (e.getSource() == search)
                    search.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == search)
                    search.setOpaque(false);

            }

        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == search) {
                    show_searched_book(bookname);
                }
            }
        });
        frame.add(search);

        frame.setVisible(true);
    }

    void show_all_books() {

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            final String find1 = "SELECT Book_name, Writer, Topic FROM Books ORDER BY Five_stars DESC LIMIT 40";
            PreparedStatement ps1 = con.prepareStatement(find1, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs1 = ps1.executeQuery();

            hor_pos = 30;
            var_pos = 150;
            for (int i = 0, j = 0; i < 40; i++) {
                if (i % 10 == 0) {
                    hor_pos = 30 + j * 320;
                    var_pos = 150;
                    j++;
                } else {
                    var_pos = 150 + (i % 10) * 80;
                }
                books[i] = new JLabel();
                try {
                    if (rs1.next())
                        books[i].setText(
                                "<html> <span style=\"font-family:Cambria;font-size:15px;\">" + rs1.getString(1)
                                        + "</span><br> Writer: "
                                        + rs1.getString(2) + "<br> Category: " + rs1.getString(3) + "</html>");
                    else
                        books[i].setText(".....");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                books[i].setBounds(hor_pos, var_pos, 300, 70);
                books[i].setFont(new Font("Cambria", Font.PLAIN, 15));
                books[i].setHorizontalAlignment(JLabel.LEFT);
                books[i].setBackground(Color.blue);
                books[i].setForeground(Color.yellow);
                books[i].setFocusable(true);
                books[i].setOpaque(false);
                frame.add(books[i]);
            }

        } catch (SQLException e) {

            String[] random_books_names = { "Lorem ipsum", "Amar Bangladesh", "Mughol Empire", "Paradox",
                    "Machine Learning", "Wars and Battles", "A Journey to History" };
            String[] random_writers_names = { "Musa Al Hafiz", "Asif Adnan", "Shamsul Arefin", "Kazi Nazrul",
                    "Ismail Rehan", "Lorem Ipsum", "Mister Writer" };
            String topics[] = { "Science", "Engineering", "Medical", "Religion", "Finance", "History", "Business",
                    "Philosophy", "Arts", "Literature", "Army/Warfare", "Miscelleneous" };

            for (int i = 0; i < 40; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 7);
                int randomNum2 = ThreadLocalRandom.current().nextInt(0, 12);
                books[i].setText(
                        "<html> <span style=\"font-family:Cambria;font-size:15px;\">" + random_books_names[randomNum]
                                + "</span><br> Writer: " + random_writers_names[randomNum] +
                                "<br> Category: " + topics[randomNum2] + "</html>");
            }
        }

    }

    void show_searched_book(String bookname) {

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps2 = con.prepareStatement(find2);
            ps2.setString(1, bookname);
            rs2 = ps2.executeQuery();
            if (rs2.next()) {
                right[0].setText(rs2.getString(1));
                for (i = 1; i < 5; i++) {
                    right[i].setText(rs2.getString(i + 1));
                }
                seerev.setEnabled(true);
                addrev.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "No record found",
                        "BookWorld",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            String[] random_writers_names = { "Musa Al Hafiz", "Asif Adnan", "Shamsul Arefin", "Kazi Nazrul", "Ismail Rehan", 
                    "Lorem Ipsum", "Mister Writer", "Dr Writer", "MD Writer", "Prof. Writer", "Mr Writer", "Dr Author" };
            String topics[] = { "Science", "Engineering", "Medical", "Religion", "Finance", "History", "Business",
                    "Philosophy", "Arts", "Literature", "Army/Warfare", "Miscelleneous" };
            int randomNum = ThreadLocalRandom.current().nextInt(0, 12);
            category = topics[randomNum];
            right[0].setText(bookname);
            right[1].setText(random_writers_names[randomNum]);
            right[2].setText("Dummy Publication"); 
            right[3].setText(category);
            right[4].setText("2018");      
            seerev.setEnabled(true);
            addrev.setEnabled(true);
        }

    }

    void add_review(String pr_name, String bookname) {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // if(con!=null) System.out.println("Successfully connected to mysql");
            PreparedStatement ps2 = con.prepareStatement(find2);
            ps2.setString(1, bookname);
            rs2 = ps2.executeQuery();
            if (rs2.next())
                category = rs2.getString(4);
        } catch (SQLException e) {
            String topics[] = { "Science", "Engineering", "Medical", "Religion", "Finance", "History", "Business",
                    "Philosophy", "Arts", "Literature", "Army/Warfare", "Miscelleneous" };

            int randomNum = ThreadLocalRandom.current().nextInt(0, 12);
            category = topics[randomNum];
        }

        write_review_page wr = new write_review_page();
        // wr.write(pr_name, bookname, category);

    }
}