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

public class writers_page {

	JFrame frame;
	JLabel bg, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	JLabel label[] = new JLabel[9];
	JButton e2, search;
	JTextField wr, wruser;
	ImageIcon frameIcon = new ImageIcon("images\\book2.png");
	ImageIcon hi = new ImageIcon("images\\wr 40.png");
	ImageIcon bye = new ImageIcon("images\\p2 40.png");
	int i, result;
	String wr_name, wr_username;
	String[] data = new String[3];
	int hor_pos = 30, var_pos, chkr = 0, star, size;
	ResultSet rs, rs2, rs3;

	void writers_list() throws SQLException {

		final String url = "jdbc:mysql:///BookWorld";
		final String user = "root";
		final String password = "supersqlsmash";

		Connection con = DriverManager.getConnection(url, user, password);
		// if(con!=null) System.out.println("Successfully connected to mysql");

		final String find = "SELECT * FROM Writers WHERE Full_name = ?";
		final String find2 = "SELECT Study_field, Country, Alma_mater, Email FROM client_info WHERE Username = ?";
		final String find3 = "SELECT * FROM Writers ORDER BY No_of_5_stars DESC LIMIT 20";
		final String find4 = "SELECT Study_field, Country, Alma_mater FROM client_info WHERE Username = ?";

		PreparedStatement ps = con.prepareStatement(find);
		PreparedStatement ps2 = con.prepareStatement(find2);
		PreparedStatement ps3 = con.prepareStatement(find3, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		PreparedStatement ps4 = con.prepareStatement(find4);
		frame = new JFrame();
		frame.setSize(1700, 800);
		frame.setResizable(false);
		// frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setTitle("BookWorld");
		frame.setIconImage(frameIcon.getImage());

		bg = new JLabel(new ImageIcon("images\\wr3.jpg"));
		// bg.setBounds(0, 0, 500, 750);
		frame.setContentPane(bg);

		l1 = new JLabel();
		l1.setBounds(30, 30, 425, 40);
		l1.setIcon(hi);
		l1.setText("WRITERS");
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
		l2.setText("Most popular writers:");
		l2.setBounds(30, 120, 500, 30);
		l2.setForeground(Color.red);
		l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		l2.setHorizontalAlignment(JLabel.LEFT);
		l2.setVerticalAlignment(JLabel.CENTER);
		frame.add(l2);

		String column_name[] = { "Sr", "Username", "Full name", "Field of Study", "Country",
				"Alma Mater", "No of Books", "Preferred Language", "E-mail", "No of 5-stars" };
		for (int i = 0; i < 7; i++) {
			l3 = new JLabel();
			l3.setText(column_name[i]);
			if (i == 0) {
				l3.setBounds(hor_pos, 180, 30, 20);
				hor_pos += 20;
			} else if (i == 2) {
				l3.setBounds(hor_pos, 180, 250, 20);
				hor_pos += 250;
			} else if (i != 6) {
				l3.setBounds(hor_pos, 180, 200, 20);
				hor_pos += 200;
			} else {
				l3.setBounds(hor_pos, 180, 100, 20);
				hor_pos += 100;
			}
			l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			l3.setForeground(Color.yellow);
			l3.setBackground(Color.cyan);
			l3.setHorizontalAlignment(JLabel.CENTER);

			frame.add(l3);
		}

		var_pos = 205;
		rs = ps3.executeQuery();
		rs.last();
		size = rs.getRow();
		rs.beforeFirst();
		for (int i = 0; i < size; i++) {
			hor_pos = 30;
			rs.next();

			ps4.setString(1, rs.getString(1));
			rs3 = ps4.executeQuery();
			if (rs3.next()) {
				data[0] = rs3.getString(1);
				data[1] = rs3.getString(2);
				data[2] = rs3.getString(3);
			} else {
				data[0] = "--";
				data[1] = "--";
				data[2] = "--";
			}

			for (int j = 0; j < 7; j++) {
				l4 = new JLabel();
				if (j == 0) {
					l4.setBounds(hor_pos, var_pos, 30, 20);
					l4.setText("" + (i + 1));
					hor_pos += 20;
				} else if (j == 1) {
					l4.setBounds(hor_pos, var_pos, 200, 20);
					l4.setText(rs.getString(1));
					hor_pos += 200;
				} else if (j == 2) {
					l4.setBounds(hor_pos, var_pos, 250, 20);
					l4.setText(rs.getString(2));
					hor_pos += 250;
				} else if (j == 3) {
					l4.setBounds(hor_pos, var_pos, 200, 20);
					l4.setText(data[0]);
					hor_pos += 200;
				} else if (j == 4) {
					l4.setBounds(hor_pos, var_pos, 200, 20);
					l4.setText(data[1]);
					hor_pos += 200;
				} else if (j == 5) {
					l4.setBounds(hor_pos, var_pos, 200, 20);
					l4.setText(data[2]);
					hor_pos += 200;
				} else {
					l4.setBounds(hor_pos, var_pos, 100, 20);
					l4.setText("" + rs.getInt(4));
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
		l5.setText("Search Writers");
		l5.setBounds(1200, 120, 500, 30);
		l5.setForeground(Color.red);
		l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		l5.setHorizontalAlignment(JLabel.CENTER);
		l5.setVerticalAlignment(JLabel.CENTER);
		frame.add(l5);

		l6 = new JLabel();
		l6.setText("Full Name");
		l6.setBounds(1250, 170, 150, 20);
		l6.setForeground(Color.orange);
		l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		l6.setHorizontalAlignment(JLabel.CENTER);
		l6.setVerticalAlignment(JLabel.CENTER);
		frame.add(l6);

		wr = new JTextField();
		wr.setBounds(1400, 170, 250, 20);
		wr.setEditable(true);
		wr.setFont(new Font("Cambria", Font.PLAIN, 16));
		wr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!wr.getText().isEmpty()) {
					wr_name = wr.getText();
				}
			}
		});
		frame.add(wr);

		l7 = new JLabel();
		l7.setText("Username");
		l7.setBounds(1250, 200, 150, 20);
		l7.setForeground(Color.orange);
		l7.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		l7.setHorizontalAlignment(JLabel.CENTER);
		l7.setVerticalAlignment(JLabel.CENTER);
		frame.add(l7);

		wruser = new JTextField();
		wruser.setBounds(1400, 200, 250, 20);
		wruser.setEditable(true);
		wruser.setFont(new Font("Cambria", Font.PLAIN, 16));
		wruser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!wruser.getText().isEmpty()) {
					wr_username = wruser.getText();
				}
			}
		});
		frame.add(wruser);

		l8 = new JLabel();
		l8.setText("Username is optional as the writer might not have account here.");
		l8.setBounds(1250, 230, 450, 15);
		l8.setForeground(Color.white);
		l8.setHorizontalAlignment(JLabel.CENTER);
		frame.add(l8);

		hor_pos = 1450;
		var_pos = 375;

		for (int i = 0; i < 9; i++) {
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
		search.setBounds(1400, 260, 100, 45);
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
					if (wr_name == null) {
						JOptionPane.showMessageDialog(frame,
								"Please insert writer's full name",
								"BookWorld",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							ps.setString(1, wr_name);
							rs = ps.executeQuery();
							if (rs.next()) {
								wr_username = rs.getString(1);
								label[0].setText(wr_username);
								label[1].setText(wr_name);
								label[5].setText("" + rs.getInt(4));
								label[6].setText(rs.getString(3));
								label[8].setText("" + rs.getInt(5));

								ps2.setString(1, wr_username);
								rs2 = ps2.executeQuery();

								if (rs2.next()) {
									label[2].setText(rs2.getString(1));
									label[3].setText(rs2.getString(2));
									label[4].setText(rs2.getString(3));
									label[7].setText(rs2.getString(4));
									for (int i = 0; i < 9; i++) {
										label[i].setVisible(true);
									}
								} else {
									label[2].setText("--");
									label[3].setText("--");
									label[4].setText("--");
									label[7].setText("--");
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
		l10.setBounds(1350, 325, 200, 30);
		l10.setForeground(Color.orange);
		l10.setHorizontalAlignment(JLabel.CENTER);
		l10.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		frame.add(l10);

		var_pos = 375;
		hor_pos = 1250;
		for (int i = 1; i < 10; i++) {

			l9 = new JLabel();
			l9.setText(column_name[i]);
			l9.setBounds(hor_pos, var_pos, 150, 20);
			l9.setForeground(Color.yellow);
			l9.setHorizontalAlignment(JLabel.CENTER);
			l9.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
			frame.add(l9);
			var_pos += 30;
		}

		frame.setVisible(true);
	}
}
