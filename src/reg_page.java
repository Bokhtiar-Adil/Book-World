import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class reg_page extends JFrame implements ActionListener {

    String name, occupation, country, gender, dob = "", wpr = "", alma, study, email, username, pass, publication;
    int result;
    ResultSet rs;
    int typecode;
    JFrame frame;
    JLabel back;
    JLabel welcome, hd, shd1, shd2, d, m, y, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JTextField td, tm, ty, t1, t2, t3, t4, t5;
    JTextArea a1;
    JPasswordField p1, p2;
    JCheckBox man, woman, wr, pub, re;
    JComboBox sf;
    JButton register, login;

    final String url = "jdbc:mysql:///BookWorld";
    final String user = "root";
    final String password = "supersqlsmash";

    ImageIcon frameIcon = new ImageIcon("images\\book2.png");

    char[] cnt = new char[12];

    Color blue_sapphire = new Color(15, 82, 186);
    Color blue_zaffre = new Color(8, 24, 168);
    Color blue_neon = new Color(31, 81, 255);
    Color blue_indigo = new Color(63, 0, 255);
    Color blue_navy = new Color(0, 0, 128);
    Color gray_charcoal = new Color(54, 69, 79);
    Color yellow_orange = new Color(255, 170, 51);

    void register_page() throws SQLException {

        for (int i = 0; i < 12; i++)
            cnt[i] = 'N';

        frame = new JFrame();
        frame.setSize(600, 850);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("BookWorld");
        frame.setIconImage(frameIcon.getImage());

        back = new JLabel(new ImageIcon("images\\r2.jpg"));
        back.setBounds(0, 0, 500, 750);
        frame.setContentPane(back);

        welcome = new JLabel();
        welcome.setText("Welcome to BookWorld");
        welcome.setFocusable(false);
        welcome.setBounds(0, 20, 600, 25);
        welcome.setForeground(blue_navy);
        welcome.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        frame.add(welcome);

        hd = new JLabel();
        hd.setText("Create Account");
        hd.setFocusable(false);
        hd.setBounds(0, 80, 600, 30);
        hd.setFont(new Font("Bahnschrift SemiBold Condensed", Font.BOLD, 20));
        hd.setForeground(blue_navy);
        hd.setHorizontalAlignment(JLabel.CENTER);
        frame.add(hd);

        shd1 = new JLabel();
        shd1.setText("Basic Information");
        shd1.setFocusable(false);
        shd1.setBounds(20, 120, 500, 30);
        shd1.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        shd1.setForeground(blue_navy);
        shd1.setHorizontalAlignment(JLabel.LEFT);
        frame.add(shd1);

        l1 = new JLabel();
        l1.setText("Name");
        l1.setFocusable(false);
        l1.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l1.setForeground(blue_navy);
        l1.setBounds(50, 160, 150, 20);
        l1.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l1);

        t1 = new JTextField();
        t1.setBounds(220, 160, 270, 20);
        t1.setEditable(true);
        t1.setFont(new Font("Cambria", Font.PLAIN, 16));
        t1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t1.getText().isEmpty()) {
                    name = t1.getText();
                    cnt[0] = 'Y';
                }
            }
        });
        frame.add(t1);

        l2 = new JLabel();
        l2.setText("Occupation");
        l2.setFocusable(false);
        l2.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l2.setForeground(blue_navy);
        l2.setBounds(50, 190, 150, 20);
        l2.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l2);

        t2 = new JTextField();
        t2.setBounds(220, 190, 270, 20);
        t2.setEditable(true);
        t2.setFont(new Font("Cambria", Font.PLAIN, 16));
        t2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t2.getText().isEmpty()) {
                    occupation = t2.getText();
                    cnt[1] = 'Y';
                }
            }
        });
        frame.add(t2);

        l3 = new JLabel();
        l3.setText("Country");
        l3.setFocusable(false);
        l3.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l3.setForeground(blue_navy);
        l3.setBounds(50, 220, 150, 20);
        l3.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l3);

        t3 = new JTextField();
        t3.setBounds(220, 220, 270, 20);
        t3.setEditable(true);
        t3.setFont(new Font("Cambria", Font.PLAIN, 16));
        t3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t3.getText().isEmpty()) {
                    country = t3.getText();
                    cnt[2] = 'Y';
                }
            }
        });
        frame.add(t3);

        l4 = new JLabel();
        l4.setText("Gender");
        l4.setFocusable(false);
        l4.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l4.setForeground(blue_navy);
        l4.setBounds(50, 250, 150, 20);
        l4.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l4);

        man = new JCheckBox();
        man.setText("Male");
        man.setBounds(220, 250, 75, 20);
        man.setBackground(Color.cyan);
        man.setFocusable(false);
        man.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == man) {
                    gender = "Male";
                    cnt[3] = 'Y';
                }
            }
        });
        frame.add(man);

        woman = new JCheckBox();
        woman.setText("Female");
        woman.setBounds(310, 250, 75, 20);
        woman.setBackground(Color.cyan);
        woman.setFocusable(false);
        woman.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == woman) {
                    gender = "Female";
                    cnt[3] = 'Y';
                }
            }
        });
        frame.add(woman);

        ButtonGroup gen = new ButtonGroup();
        gen.add(man);
        gen.add(woman);

        l5 = new JLabel();
        l5.setText("Date of Birth");
        l5.setFocusable(false);
        l5.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l5.setForeground(blue_navy);
        l5.setBounds(50, 280, 150, 20);
        l5.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l5);

        d = new JLabel();
        d.setText("DD");
        d.setBounds(220, 280, 30, 20);
        d.setOpaque(true);
        d.setBackground(Color.cyan);
        d.setHorizontalAlignment(JLabel.CENTER);
        frame.add(d);

        td = new JTextField();
        td.setBounds(260, 280, 25, 20);
        td.setEditable(true);
        td.setFont(new Font("Cambria", Font.PLAIN, 16));
        td.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!td.getText().isEmpty()) {
                    dob = dob + td.getText();
                    cnt[4] = 'Y';
                }
            }
        });
        frame.add(td);

        m = new JLabel();
        m.setText("MM");
        m.setBounds(300, 280, 30, 20);
        m.setOpaque(true);
        m.setBackground(Color.cyan);
        m.setHorizontalAlignment(JLabel.CENTER);
        frame.add(m);

        tm = new JTextField();
        tm.setBounds(340, 280, 25, 20);
        tm.setEditable(true);
        tm.setFont(new Font("Cambria", Font.PLAIN, 16));
        tm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tm.getText().isEmpty()) {
                    dob = dob + "-" + tm.getText();
                    cnt[5] = 'Y';
                }
            }
        });
        frame.add(tm);

        y = new JLabel();
        y.setText("YYYY");
        y.setBounds(380, 280, 40, 20);
        y.setOpaque(true);
        y.setBackground(Color.cyan);
        y.setHorizontalAlignment(JLabel.CENTER);
        frame.add(y);

        ty = new JTextField();
        ty.setBounds(430, 280, 45, 20);
        ty.setEditable(true);
        ty.setFont(new Font("Cambria", Font.PLAIN, 16));
        ty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!ty.getText().isEmpty()) {
                    dob = dob + "-" + ty.getText();
                    cnt[6] = 'Y';
                }
            }
        });
        frame.add(ty);

        l6 = new JLabel();
        l6.setText("Alma Mater");
        l6.setFocusable(false);
        l6.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l6.setForeground(blue_navy);
        l6.setBounds(50, 310, 150, 20);
        l6.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l6);

        a1 = new JTextArea();
        a1.setBounds(220, 310, 270, 40);
        a1.setEditable(true);
        a1.setFont(new Font("Cambria", Font.PLAIN, 16));
        a1.setRows(2);
        a1.setWrapStyleWord(true);
        a1.setLineWrap(true);
        a1.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!a1.getText().equals("")) {
                    alma = a1.getText();
                    cnt[7] = 'Y';
                } else {
                    cnt[7] = 'N';
                }

            }
        });
        frame.add(a1);

        l7 = new JLabel();
        l7.setText("You are a - ");
        l7.setFocusable(false);
        l7.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l7.setForeground(blue_navy);
        l7.setBounds(50, 360, 150, 20);
        l7.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l7);

        wr = new JCheckBox();
        wr.setText("Writer");
        wr.setBounds(220, 360, 75, 20);
        wr.setBackground(Color.cyan);
        wr.setFocusable(false);
        wr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (wr.isSelected()) {
                    wpr = "Writer";
                    typecode = 1;
                    cnt[8] = 'Y';
                }

            }
        });
        frame.add(wr);

        pub = new JCheckBox();
        pub.setText("Publisher");
        pub.setBounds(305, 360, 85, 20);
        pub.setBackground(Color.cyan);
        pub.setFocusable(false);
        pub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (pub.isSelected()) {
                    wpr = "Publisher";
                    typecode = 2;
                    cnt[8] = 'Y';
                    publication = (String) JOptionPane.showInputDialog(
                            frame,
                            "Name of your publication:",
                            JOptionPane.QUESTION_MESSAGE);
                    System.out.println(publication);
                }

            }
        });
        frame.add(pub);

        re = new JCheckBox();
        re.setText("Reader");
        re.setBounds(400, 360, 85, 20);
        re.setBackground(Color.cyan);
        re.setFocusable(false);
        re.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (re.isSelected()) {
                    wpr = "Reader";
                    typecode = 3;
                    cnt[8] = 'Y';
                }

            }
        });
        frame.add(re);

        ButtonGroup type = new ButtonGroup();
        type.add(wr);
        type.add(pub);
        type.add(re);

        l8 = new JLabel();
        l8.setText("Field of Study");
        l8.setFocusable(false);
        l8.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l8.setForeground(blue_navy);
        l8.setBounds(50, 390, 150, 20);
        l8.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l8);

        String studyfield[] = { "Still a child", "Science", "Engineering", "Medical", "Business", "Finance", "History",
                "Religion", "Philosophy", "Arts", "Literature", "Millitary" };
        sf = new JComboBox(studyfield);
        sf.setBounds(220, 390, 270, 20);
        sf.setForeground(Color.black);
        sf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 12; i++) {
                    if (((String) sf.getSelectedItem()).equals(studyfield[i])) {
                        study = studyfield[i];
                        break;
                    }
                }
            }

        });
        frame.add(sf);

        shd2 = new JLabel();
        shd2.setText("Account Information");
        shd2.setFocusable(false);
        shd2.setBounds(20, 430, 250, 30);
        shd2.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        shd2.setForeground(blue_navy);
        shd2.setHorizontalAlignment(JLabel.LEFT);
        frame.add(shd2);

        l14 = new JLabel("(Caution: You can't change username after registration)");
        l14.setBounds(250, 440, 320, 15);
        l14.setForeground(Color.black);
        l14.setHorizontalAlignment(JLabel.LEFT);
        l14.setVerticalAlignment(JLabel.CENTER);
        frame.add(l14);

        l9 = new JLabel();
        l9.setText("Email");
        l9.setFocusable(false);
        l9.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l9.setForeground(blue_navy);
        l9.setBounds(50, 470, 150, 20);
        l9.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l9);

        t4 = new JTextField();
        t4.setBounds(220, 470, 270, 20);
        t4.setEditable(true);
        t4.setFont(new Font("Cambria", Font.PLAIN, 16));
        t4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t4.getText().isEmpty()) {
                    email = t4.getText();
                    cnt[9] = 'Y';
                }
            }
        });
        frame.add(t4);

        l10 = new JLabel();
        l10.setText("Username");
        l10.setFocusable(false);
        l10.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l10.setForeground(blue_navy);
        l10.setBounds(50, 500, 150, 20);
        l10.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l10);

        t5 = new JTextField();
        t5.setBounds(220, 500, 270, 20);
        t5.setEditable(true);
        t5.setFont(new Font("Cambria", Font.PLAIN, 16));
        t5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t5.getText().isEmpty()) {
                    username = t5.getText();
                    try {
                        check_username_uniqueness();
                    } catch (Exception err) {
                    }
                }
            }
        });
        frame.add(t5);

        l11 = new JLabel();
        l11.setText("Password");
        l11.setFocusable(false);
        l11.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        l11.setForeground(blue_navy);
        l11.setBounds(50, 530, 150, 20);
        l11.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l11);

        p1 = new JPasswordField();
        p1.setBounds(220, 530, 270, 20);
        p1.setEditable(true);
        p1.setFont(new Font("Cambria", Font.PLAIN, 16));
        p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p1.getPassword().length != 0) {
                    pass = new String(p1.getPassword());
                    cnt[11] = 'Y';
                }

            }

        });
        frame.add(p1);

        l13 = new JLabel("*Please press 'Enter' after inserting each option*");
        l13.setBounds(50, 570, 420, 15);
        l13.setForeground(Color.black);
        l13.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l13);

        register = new JButton();
        register.setText("Register");
        register.setFont(new Font("Bahnschrift SemiBold Condensed", Font.BOLD, 20));
        register.setBorder(null);
        register.setBackground(Color.green);
        register.setForeground(Color.red);
        register.setFocusable(false);
        register.setBounds(220, 595, 150, 50);
        register.addMouseListener(new MouseListener() {

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
                register.setBackground(blue_navy);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                register.setBackground(Color.green);

            }

        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == register) {
                    int i;
                    for (i = 0; i < 12; i++) {
                        if (cnt[i] == 'N') {
                            JOptionPane.showMessageDialog(frame,
                                    "PLease insert all the information and press 'Enter' after each option",
                                    "BookWorld",
                                    JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }

                    if (i == 12) {
                        try {
                            register_into_database();
                        } catch (Exception err) {

                        }

                        frame.dispose();
                        home_page hm = new home_page();
                        hm.home(username, typecode);
                    }
                }
            }
        });

        frame.add(register);

        l12 = new JLabel();
        l12.setText("Already have an account?");
        l12.setFocusable(false);
        l12.setBounds(0, 675, 300, 30);
        l12.setFont(new Font("Bahnschrift SemiBold Condensed", Font.PLAIN, 20));
        l12.setForeground(Color.black);
        l12.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l12);

        login = new JButton();
        login.setText("Log in");
        login.setFont(new Font("Bahnschrift SemiBold Condensed", Font.BOLD, 20));
        login.setBorder(null);
        login.setBackground(Color.green);
        login.setForeground(Color.red);
        login.setFocusable(false);
        login.setBounds(350, 675, 150, 50);
        login.addMouseListener(new MouseListener() {

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
                login.setBackground(blue_navy);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.setBackground(Color.green);

            }

        });
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == login) {
                    frame.dispose();
                    logreg_page log = new logreg_page();
                    try {
                        log.logreg();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }

            }

        });
        frame.add(login);

        frame.setVisible(true);
    }

    void check_username_uniqueness() {

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            final String Insert4 = "SELECT Username FROM client_info WHERE Username = ?";
            PreparedStatement ps4 = con.prepareStatement(Insert4);

            try {
                ps4.setString(1, username);
                rs = ps4.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(frame,
                            "Your Username must be unique",
                            "BookWorld",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    cnt[10] = 'Y';
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
    }

    void register_into_database() {

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            final String Insert = "INSERT INTO client_info(Username,"
                    + "Pass, Cl_name, Email,"
                    + "Occupation, Country, Gender,"
                    + "Birthdate, Alma_mater, WPR,"
                    + "Study_field, Type_code) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

            final String Insert2 = "INSERT INTO Registered_writer(Username) VALUES (?)";
            final String Insert3 = "INSERT INTO Publisher(Username, Pub_name, Publication, Country) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(Insert);
            PreparedStatement ps2 = con.prepareStatement(Insert2);
            PreparedStatement ps3 = con.prepareStatement(Insert3);

            try {
                ps.setString(1, username);
                ps.setString(2, pass);
                ps.setString(3, name);
                ps.setString(4, email);
                ps.setString(5, occupation);
                ps.setString(6, country);
                ps.setString(7, gender);
                ps.setString(8, dob);
                ps.setString(9, alma);
                ps.setString(10, wpr);
                ps.setString(11, study);
                ps.setInt(12, typecode);

                result = ps.executeUpdate();

                if (typecode == 1) {
                    ps2.setString(1, username);
                    result = ps2.executeUpdate();
                } else if (typecode == 2) {
                    ps3.setString(1, username);
                    ps3.setString(2, name);
                    ps3.setString(3, publication);
                    ps3.setString(4, country);

                    result = ps3.executeUpdate();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                // close JDBC objects
                try {
                    if (ps != null)
                        ps.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                try {
                    if (ps2 != null)
                        ps2.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                try {
                    if (ps3 != null)
                        ps3.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                try {
                    if (con != null)
                        con.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }

                frame.dispose();
                home_page hm = new home_page();
                hm.home(username, typecode);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            frame.dispose();
            home_page hm = new home_page();
            hm.home(username, typecode);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}