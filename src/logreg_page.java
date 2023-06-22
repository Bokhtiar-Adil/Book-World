import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logreg_page extends JFrame implements ActionListener {

    String un, pw;
    int typecode;
    ResultSet rs;
    JFrame frame;
    JLabel welcome, name, password, l1, l2, l3;
    JTextField namebox;
    JPasswordField passbox;
    JLabel back;
    JButton login, reg;

    ImageIcon frameIcon = new ImageIcon("images\\book2.png");

    final String url = "jdbc:mysql:///BookWorld";
    final String user = "root";
    final String pass = "supersqlsmash";

    char[] cnt = new char[2];

    void logreg() throws SQLException {

        for (int i = 0; i < 2; i++)
            cnt[i] = 'N';

        frame = new JFrame();
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("BookWorld");
        frame.setIconImage(frameIcon.getImage());

        back = new JLabel(new ImageIcon("images\\l4.jpg"));
        back.setBounds(0, 0, 500, 600);
        frame.setContentPane(back);

        welcome = new JLabel();
        welcome.setText("Welcome to BookWorld");
        welcome.setFocusable(false);
        welcome.setBounds(0, 20, 500, 25);
        welcome.setForeground(new Color(0, 255, 0));
        welcome.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        frame.add(welcome);

        l1 = new JLabel();
        l1.setText("Log in to continue");
        l1.setFocusable(false);
        l1.setBounds(170, 100, 200, 30);
        l1.setFont(new Font("Bahnschrift SemiBold Condensed", Font.BOLD, 20));
        l1.setForeground(Color.red);
        frame.add(l1);

        name = new JLabel();
        name.setText("Username:");
        name.setFocusable(false);
        name.setFont(new Font("Cambria", Font.PLAIN, 20));
        name.setForeground(Color.white);
        name.setBounds(50, 150, 100, 20);
        name.setHorizontalAlignment(JLabel.CENTER);
        frame.add(name);

        namebox = new JTextField();
        namebox.setBounds(170, 150, 270, 20);
        namebox.setEditable(true);
        namebox.setFont(new Font("Cambria", Font.PLAIN, 16));
        namebox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!namebox.getText().isEmpty()) {
                    un = namebox.getText();
                    cnt[0] = 'Y';
                }

            }

        });
        frame.add(namebox);

        password = new JLabel();
        password.setText("Password:");
        password.setFocusable(false);
        password.setFont(new Font("Cambria", Font.PLAIN, 20));
        password.setForeground(Color.white);
        password.setBounds(50, 190, 100, 20);
        password.setHorizontalAlignment(JLabel.CENTER);
        frame.add(password);

        passbox = new JPasswordField();
        passbox.setBounds(170, 190, 270, 20);
        passbox.setEditable(true);
        passbox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (passbox.getPassword().length != 0) {
                    pw = new String(passbox.getPassword());
                    cnt[1] = 'Y';
                }

            }

        });
        frame.add(passbox);

        l3 = new JLabel("*Please press 'Enter' after inserting each option*");
        l3.setBounds(50, 220, 370, 15);
        l3.setForeground(Color.red);
        l3.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l3);

        login = new JButton();
        login.setText("Log In");
        login.setFont(new Font("Bahnschrift SemiBold Condensed", Font.BOLD, 20));
        login.setBackground(Color.green);
        login.setBorder(null);
        login.setForeground(Color.red);
        login.setFocusable(false);
        login.setBounds(200, 270, 100, 50);
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
                login.setBackground(Color.blue);

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
                    int i;
                    for (i = 0; i < 2; i++) {
                        if (cnt[i] == 'N') {
                            JOptionPane.showMessageDialog(frame,
                                    "PLease insert all the information and press 'Enter' after each option",
                                    "BookWorld",
                                    JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }
                    if (i == 2) {
                        perform_login();
                    }
                }
            }
        });
        frame.add(login);

        l2 = new JLabel();
        l2.setText("Don't have any account?");
        l2.setFont(new Font("Bahnschrift SemiBold Condensed", Font.BOLD, 20));
        l2.setForeground(Color.white);
        l2.setBounds(30, 360, 250, 40);
        l2.setHorizontalAlignment(JLabel.LEFT);
        frame.add(l2);

        reg = new JButton();
        reg.setText("Register");
        reg.setFont(new Font("Bahnschrift SemiBold Condensed", Font.BOLD, 20));
        reg.setBorder(null);
        reg.setBackground(Color.green);
        reg.setForeground(Color.red);
        reg.setFocusable(false);
        reg.setBounds(300, 360, 150, 40);
        reg.addMouseListener(new MouseListener() {

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
                reg.setBackground(Color.blue);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                reg.setBackground(Color.green);

            }

        });
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == reg) {
                    frame.dispose();
                    reg_page register = new reg_page();
                    try {
                        register.register_page();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        frame.add(reg);

        frame.setVisible(true);
    }

    void perform_login() {

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            final String find1 = "SELECT Username FROM client_info WHERE Username = ?";
            final String find2 = "SELECT Pass FROM client_info WHERE Pass = ?";
            final String find3 = "SELECT Type_code FROM client_info WHERE Username = ?";
            PreparedStatement ps = con.prepareStatement(find1);
            PreparedStatement ps2 = con.prepareStatement(find2);
            PreparedStatement ps3 = con.prepareStatement(find3);

            int chckr = 0;
            try {
                ps.setString(1, un);
                rs = ps.executeQuery();
                if (rs.next()) {
                    chckr = 1;
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Username does not match",
                            "BookWorld",
                            JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    logreg();
                }
                if (chckr == 1) {
                    ps2.setString(1, pw);
                    rs = ps2.executeQuery();
                    if (rs.next()) {
                        ps3.setString(1, un);
                        rs = ps3.executeQuery();
                        if (rs.next()) {
                            typecode = rs.getInt(1);
                            frame.dispose();
                            home_page hm = new home_page();
                            hm.home(un, typecode);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame,
                                "Password does not match",
                                "BookWorld",
                                JOptionPane.ERROR_MESSAGE);
                        frame.dispose();
                        logreg();
                    }
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
                    if (rs != null)
                        rs.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                try {
                    if (con != null)
                        con.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        } catch (HeadlessException | SQLException e) {
            // e.printStackTrace();
            frame.dispose();
            home_page hm = new home_page();
            hm.home(un, typecode);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}