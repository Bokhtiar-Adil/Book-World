import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class edit_profile_page extends JFrame implements ActionListener {

    String[] data = new String[11];
    String[] labels = { "Username", "Password", "Name", "Email", "Occupation", "Country",
            "Gender", "Date of Birth", "ALma Mater", "I am a", "Field of Study", "Reviews Added", "Books Written",
            "Books Published" };

    int i, id, revadd, bkwrt, bkpub, editchecker = 0;

    ResultSet rs;
    int pos, k;
    JFrame frame;
    JPanel back;
    JLabel bg, l1, l2, l3;
    JButton e1, e2, mw, ma, edit;
    ImageIcon frameIcon = new ImageIcon("images\\book2.png");
    ImageIcon hi = new ImageIcon("images\\p 40.png");
    ImageIcon bye = new ImageIcon("images\\p2 40.png");

    void editing(String pr_name) throws SQLException {

        final String url = "jdbc:mysql:///BookWorld";
        final String user = "root";
        final String password = "supersqlsmash";

        Connection con = DriverManager.getConnection(url, user, password);

        // if(con!=null) System.out.println("Successfully connected to mysql");
        // System.out.println(pr_name);

        final String op = "SELECT * FROM client_info WHERE Username = ?";
        PreparedStatement ps = con.prepareStatement(op);
        try {
            ps.setString(1, pr_name);
            rs = ps.executeQuery();
            data[0] = pr_name;
            if (rs.next()) {
                id = rs.getInt(1);
                for (int i = 1, j = 3; j <= 12; i++, j++) {
                    data[i] = rs.getString(j);
                }
                revadd = rs.getInt(14);
                System.out.println(revadd);
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
        frame = new JFrame();
        frame.setSize(800, 900);
        // frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("BookWorld");
        frame.setIconImage(frameIcon.getImage());

        bg = new JLabel(new ImageIcon("images\\pro2.jpg"));
        // bg.setBounds(0, 0, 500, 750);
        frame.setContentPane(bg);

        l1 = new JLabel();
        l1.setBounds(10, 20, 200, 50);
        l1.setIcon(hi);
        l1.setText("PROFILE");
        l1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        l1.setForeground(Color.blue);
        l1.setHorizontalAlignment(JLabel.CENTER);
        frame.add(l1);

        e2 = new JButton();
        e2.setBounds(700, 20, 80, 70);
        e2.setIcon(bye);
        e2.setRolloverEnabled(true);
        e2.setRolloverIcon(bye);
        e2.setFocusable(false);
        e2.setBackground(Color.red);
        e2.setBorder(null);
        e2.setBorderPainted(false);
        e2.setContentAreaFilled(false);
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

        pos = 100;
        k = 0;
        // int i;
        for (i = 0; k < 14; i++, k++, pos = pos + 50) {

            l2 = new JLabel();
            l2.setBounds(180, pos, 200, 25);
            l2.setText(labels[k] + ":");
            l2.setFont(new Font("Lucida Sans", Font.BOLD, 20));
            l2.setForeground(Color.red);
            l2.setHorizontalAlignment(JLabel.LEFT);
            frame.add(l2);

        }

        System.out.println(revadd + " " + bkwrt + " " + bkpub);
        k = 0;
        pos = 100;
        for (i = 0; k < 14; i++, k++, pos = pos + 50) {
            l3 = new JLabel();
            l3.setBounds(400, pos, 300, 25);
            if (k < 11)
                l3.setText(data[k]);
            else if (k == 11)
                l3.setText("" + revadd);
            else if (k == 12)
                l3.setText("" + bkwrt);
            else if (k == 13)
                l3.setText("" + bkpub);
            l3.setFont(new Font("Copperplate Gothic", Font.PLAIN, 20));
            l3.setForeground(Color.blue);
            l3.setHorizontalAlignment(JLabel.LEFT);
            frame.add(l3);
            // if()
        }

        edit = new JButton();
        edit.setBounds(500, pos, 180, 30);
        edit.setText("Submit");
        edit.setFont(new Font("MV Boli", Font.PLAIN, 25));
        edit.setBackground(Color.black);
        // ma.setOpaque(false);
        edit.setBorder(null);
        edit.setBorderPainted(false);
        edit.setFocusable(false);
        edit.setForeground(Color.white);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == edit) {
                    int chkb = JOptionPane.YES_NO_OPTION;
                    int chkr = JOptionPane.showConfirmDialog(null,
                            "After editing your profile, you will have to login again. Continue to edit?", "BookWorld",
                            chkb);
                    if (chkr == 0) {

                    }
                }
            }

        });
        frame.add(edit);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}