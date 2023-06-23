import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class publishers_page {

	JFrame frame;
	JLabel bg, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JLabel label[] = new JLabel[8];
	JButton e2, search;
	JTextField pub;
	ImageIcon frameIcon = new ImageIcon("images\\book2.png");
	ImageIcon hi = new ImageIcon("images\\pub 40.png");
	ImageIcon bye = new ImageIcon("images\\p2 40.png");

	String pub_name, wr_username;
	int hor_pos = 30, var_pos, chkr = 0, star, size;
	ResultSet rs, rs2;

	void publisher_list() throws SQLException {

		final String url = "jdbc:mysql:///BookWorld";
		final String user = "root";
		final String password = "supersqlsmash";

		Connection con = DriverManager.getConnection(url, user, password);
		// if(con!=null) System.out.println("Successfully connected to mysql");

		final String find = "SELECT * FROM Publishers WHERE Publication = ?";
		final String find2 = "SELECT * FROM Publishers ORDER BY No_of_5_stars DESC";

		PreparedStatement ps = con.prepareStatement(find);
		PreparedStatement ps2 = con.prepareStatement(find2, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

		frame = new JFrame();
		frame.setSize(1700, 800);
		frame.setResizable(false);
		// frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setTitle("BookWorld");
		frame.setIconImage(frameIcon.getImage());

		bg = new JLabel(new ImageIcon("images\\wr3.jpg"));
		frame.setContentPane(bg);

		l1 = new JLabel();
		l1.setBounds(30, 30, 425, 40);
		l1.setIcon(hi);
		l1.setText("PUBLISHERS");
		l1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
		l1.setForeground(Color.green);
		l1.setBackground(Color.black);
		l1.setHorizontalAlignment(JLabel.LEFT);
		frame.add(l1);

		e2 = new JButton();
		e2.setBounds(1600, 20, 80, 70);
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
		l2.setText("Most popular publishers:");
		l2.setBounds(30, 120, 500, 30);
		l2.setForeground(Color.red);
		l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		l2.setHorizontalAlignment(JLabel.LEFT);
		l2.setVerticalAlignment(JLabel.CENTER);
		frame.add(l2);

		String column_name[] = { "Sr", "Publication", "Owner", "Username", "Country", "No of Books", "Five stars" };
		for (int i = 0; i < 7; i++) {
			l3 = new JLabel();
			l3.setText(column_name[i]);
			if (i == 0) {
				l3.setBounds(hor_pos, 180, 30, 20);
				hor_pos += 20;
			} else if (i == 1 || i == 2) {
				l3.setBounds(hor_pos, 180, 250, 20);
				hor_pos += 250;
			} else if (i == 3 || i == 4) {
				l3.setBounds(hor_pos, 180, 200, 20);
				hor_pos += 200;
			} else {
				l3.setBounds(hor_pos, 180, 100, 20);
				hor_pos += 100;
			}
			l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			l3.setForeground(Color.yellow);
			l3.setBackground(Color.cyan);
			l3.setHorizontalAlignment(JLabel.CENTER);

			frame.add(l3);

		}
		var_pos = 205;
		rs2 = ps2.executeQuery();
		rs2.last();
		size = rs2.getRow();
		rs2.beforeFirst();
		for (int i = 0; i < size; i++) {
			hor_pos = 30;
			rs2.next();
			for (int j = 0; j < 7; j++) {
				l4 = new JLabel();
				if (j == 0) {
					l4.setBounds(hor_pos, var_pos, 30, 20);
					l4.setText("" + (i + 1));
					hor_pos += 30;
				} else if (j == 1) {
					l4.setBounds(hor_pos, var_pos, 250, 20);
					l4.setText(rs2.getString(3));
					hor_pos += 250;
				} else if (j == 2) {
					l4.setBounds(hor_pos, var_pos, 250, 20);
					l4.setText(rs2.getString(2));
					hor_pos += 250;
				} else if (j == 3) {
					l4.setBounds(hor_pos, var_pos, 200, 20);
					l4.setText(rs2.getString(1));
					hor_pos += 200;
				} else if (j == 4) {
					l4.setBounds(hor_pos, var_pos, 200, 20);
					l4.setText(rs2.getString(6));
					hor_pos += 200;
				} else if (j == 5) {
					l4.setBounds(hor_pos, var_pos, 100, 20);
					l4.setText("" + rs2.getInt(4));
					hor_pos += 100;
				} else {
					l4.setBounds(hor_pos, var_pos, 100, 20);
					l4.setText("" + rs2.getInt(5));
					hor_pos += 100;
				}
				l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
				l4.setForeground(Color.white);
				l4.setBackground(Color.cyan);
				l4.setHorizontalAlignment(JLabel.CENTER);

				frame.add(l4);
			}
			var_pos += 25;
		}
		l5 = new JLabel();
		l5.setText("Search Publishers");
		l5.setBounds(1200, 120, 500, 30);
		l5.setForeground(Color.red);
		l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		l5.setHorizontalAlignment(JLabel.CENTER);
		l5.setVerticalAlignment(JLabel.CENTER);
		frame.add(l5);

		l6 = new JLabel();
		l6.setText("Publication Name:");
		l6.setBounds(1250, 170, 150, 20);
		l6.setForeground(Color.orange);
		l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		l6.setHorizontalAlignment(JLabel.CENTER);
		l6.setVerticalAlignment(JLabel.CENTER);
		frame.add(l6);

		pub = new JTextField();
		pub.setBounds(1250, 200, 350, 20);
		pub.setEditable(true);
		pub.setFont(new Font("Cambria", Font.PLAIN, 16));
		pub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pub.getText().isEmpty()) {
					pub_name = pub.getText();
				}
			}
		});
		frame.add(pub);

		var_pos = 375;
		hor_pos = 1400;

		for (int i = 0; i < 8; i++) {
			label[i] = new JLabel();
			label[i].setBounds(hor_pos, var_pos, 200, 20);
			label[i].setForeground(Color.white);
			label[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			label[i].setHorizontalAlignment(JLabel.LEFT);
			label[i].setVisible(false);
			frame.add(label[i]);
			var_pos += 30;
		}

		search = new JButton();
		search.setBounds(1375, 240, 100, 45);
		search.setText("Search");
		search.setBackground(Color.blue);
		search.setContentAreaFilled(true);
		search.setFocusable(false);
		search.setOpaque(false);
		search.setFont(new Font("Cambria", Font.BOLD, 20));
		search.setForeground(Color.green);
		search.addMouseListener(new MouseListener() {
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
					if (pub_name == null) {
						JOptionPane.showMessageDialog(frame,
								"Please insert publication name",
								"BookWorld",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							ps.setString(1, pub_name);
							rs = ps.executeQuery();
							if (rs.next()) {
								label[0].setText(pub_name);
								label[1].setText(rs.getString(2));
								label[2].setText(rs.getString(1));
								label[3].setText(rs.getString(6));
								label[4].setText("" + rs.getInt(4));
								label[5].setText("" + rs.getInt(5));
								for (int i = 0; i < 6; i++) {
									label[i].setVisible(true);
								}

							} else {
								JOptionPane.showMessageDialog(frame,
										"No record found",
										"BookWorld",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}

		});
		frame.add(search);

		l10 = new JLabel();
		l10.setText("Search Result");
		l10.setBounds(1325, 315, 200, 30);
		l10.setForeground(Color.orange);
		l10.setHorizontalAlignment(JLabel.CENTER);
		l10.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		frame.add(l10);

		var_pos = 375;
		hor_pos = 1250;
		for (int i = 1; i < 7; i++) {

			l9 = new JLabel();
			l9.setText(column_name[i]);
			l9.setBounds(hor_pos, var_pos, 100, 20);
			l9.setForeground(Color.yellow);
			l9.setHorizontalAlignment(JLabel.CENTER);
			l9.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			frame.add(l9);
			var_pos += 30;
		}

		frame.setVisible(true);
	}
}
