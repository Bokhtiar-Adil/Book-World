import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class write_review_page {

	JFrame frame;
	JLabel bg, l1, l2, l3, l4;
	JTextArea rev, txt;
	JButton star1, star2, star3, star4, star5, submit;
	ImageIcon frameIcon = new ImageIcon("images\\book2.png");
	PreparedStatement ps1, ps2, ps3;
	ResultSet rs3;
	int rs1, rs2;
	int star = 0;
	String review = null, wr, pub;

	void write(String pr_name, String book_name, String category) throws SQLException {

		final String url = "jdbc:mysql:///BookWorld";
		final String user = "root";
		final String password = "supersqlsmash";

		Connection con = DriverManager.getConnection(url, user, password);
		// if(con!=null) System.out.println("Successfully connected to mysql");

		final String insert = "INSERT INTO Reviews(Username, Book_name, Topic, Stars, Review) VALUES (?,?,?,?,?)";
		ps1 = con.prepareStatement(insert);

		final String insertstar5 = "UPDATE Books SET Five_stars = Five_stars+1 WHERE Book_name = ?";
		final String insertstar4 = "UPDATE Books SET Four_stars = Four_stars+1 WHERE Book_name = ?";
		final String insertstar3 = "UPDATE Books SET Three_stars = Three_stars+1 WHERE Book_name = ?";
		final String insertstar2 = "UPDATE Books SET Two_stars = Two_stars+1 WHERE Book_name = ?";
		final String insertstar1 = "UPDATE Books SET One_stars = One_stars+1 WHERE Book_name = ?";

		final String find = "SELECT Writer, Publication FROM Books WHERE Book_name = ?";
		ps2 = con.prepareStatement(find);
		ps2.setString(1, book_name);
		rs3 = ps2.executeQuery();
		if (rs3.next()) {
			wr = rs3.getString(1);
			pub = rs3.getString(2);
		}

		final String insertwr = "UPDATE Writers SET No_of_5_stars = No_of_5_stars+1 WHERE Full_name = ?";
		final String insertpub = "UPDATE Publishers SET No_of_5_stars = No_of_5_stars+1 WHERE Publication = ?";

		frame = new JFrame();
		frame = new JFrame();
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setTitle("BookWorld");
		frame.setIconImage(frameIcon.getImage());

		bg = new JLabel(new ImageIcon("images\\wrev1.jpg"));
		frame.setContentPane(bg);

		l1 = new JLabel();
		l1.setBounds(15, 20, 600, 40);
		l1.setText("Write review on " + book_name);
		l1.setForeground(Color.green);
		l1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		l1.setHorizontalAlignment(JLabel.LEFT);
		frame.add(l1);

		l2 = new JLabel();
		l2.setBounds(15, 70, 150, 40);
		l2.setText("Rate your star: ");
		l2.setForeground(Color.white);
		l2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		l2.setHorizontalAlignment(JLabel.LEFT);
		frame.add(l2);

		star = 0;
		star1 = new JButton("*");
		star2 = new JButton("*");
		star3 = new JButton("*");
		star4 = new JButton("*");
		star5 = new JButton("*");

		star1.setFont(new Font("Wide Latin", Font.BOLD, 28));
		star1.setBounds(175, 85, 30, 20);
		star1.setBackground(Color.blue);
		star1.setContentAreaFilled(true);
		star1.setBorder(null);
		star1.setBorderPainted(false);
		star1.setFocusable(false);
		star1.setOpaque(false);
		star1.setForeground(Color.white);
		star1.setVerticalAlignment(JButton.CENTER);
		star1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				star1.setForeground(Color.red);
				star2.setForeground(Color.white);
				star3.setForeground(Color.white);
				star4.setForeground(Color.white);
				star5.setForeground(Color.white);
				star = 1;
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				star1.setForeground(Color.orange);
				star2.setForeground(Color.white);
				star3.setForeground(Color.white);
				star4.setForeground(Color.white);
				star5.setForeground(Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		frame.add(star1);

		star2.setFont(new Font("Wide Latin", Font.BOLD, 28));
		star2.setBounds(210, 85, 30, 20);
		star2.setBackground(Color.blue);
		star2.setContentAreaFilled(true);
		star2.setBorder(null);
		star2.setBorderPainted(false);
		star2.setFocusable(false);
		star2.setOpaque(false);
		star2.setForeground(Color.white);
		star2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				star1.setForeground(Color.red);
				star2.setForeground(Color.red);
				star3.setForeground(Color.white);
				star4.setForeground(Color.white);
				star5.setForeground(Color.white);
				star = 2;
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				star1.setForeground(Color.orange);
				star2.setForeground(Color.orange);
				star3.setForeground(Color.white);
				star4.setForeground(Color.white);
				star5.setForeground(Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		frame.add(star2);

		star3.setFont(new Font("Wide Latin", Font.BOLD, 28));
		star3.setBounds(240, 85, 30, 20);
		star3.setBackground(Color.blue);
		star3.setContentAreaFilled(true);
		star3.setBorder(null);
		star3.setBorderPainted(false);
		star3.setFocusable(false);
		star3.setOpaque(false);
		star3.setForeground(Color.white);
		star3.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				star1.setForeground(Color.red);
				star2.setForeground(Color.red);
				star3.setForeground(Color.red);
				star4.setForeground(Color.white);
				star5.setForeground(Color.white);
				star = 3;
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				star1.setForeground(Color.orange);
				star2.setForeground(Color.orange);
				star3.setForeground(Color.orange);
				star4.setForeground(Color.white);
				star5.setForeground(Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		frame.add(star3);

		star4.setFont(new Font("Wide Latin", Font.BOLD, 28));
		star4.setBounds(270, 85, 30, 20);
		star4.setBackground(Color.blue);
		star4.setContentAreaFilled(true);
		star4.setBorder(null);
		star4.setBorderPainted(false);
		star4.setFocusable(false);
		star4.setOpaque(false);
		star4.setForeground(Color.white);
		star4.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				star1.setForeground(Color.red);
				star2.setForeground(Color.red);
				star3.setForeground(Color.red);
				star4.setForeground(Color.red);
				star5.setForeground(Color.white);
				star = 4;
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				star1.setForeground(Color.orange);
				star2.setForeground(Color.orange);
				star3.setForeground(Color.orange);
				star4.setForeground(Color.orange);
				star5.setForeground(Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		frame.add(star4);

		star5.setFont(new Font("Wide Latin", Font.BOLD, 28));
		star5.setBounds(300, 85, 30, 20);
		star5.setBackground(Color.blue);
		star5.setContentAreaFilled(true);
		star5.setBorder(null);
		star5.setBorderPainted(false);
		star5.setFocusable(false);
		star5.setOpaque(false);
		star5.setForeground(Color.white);
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
			}

			@Override
			public void mouseReleased(MouseEvent e) {
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
		frame.add(star5);

		l3 = new JLabel();
		l3.setBounds(15, 115, 400, 30);
		l3.setText("Write your review: (within 1000 characters)");
		l3.setForeground(Color.white);
		l3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		l3.setHorizontalAlignment(JLabel.LEFT);
		frame.add(l3);

		rev = new JTextArea();
		rev.setBounds(15, 170, 550, 400);
		rev.setFont(new Font("Arial", Font.PLAIN, 15));
		rev.setBackground(Color.cyan);
		rev.setWrapStyleWord(true);
		rev.setLineWrap(true);
		rev.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!rev.getText().equals("")) {
					review = rev.getText();
				}

			}

		});
		frame.add(rev);

		l4 = new JLabel("After writing review click here");
		l4.setForeground(Color.white);
		l4.setBounds(15, 600, 170, 20);
		frame.add(l4);

		txt = new JTextArea();
		txt.setBounds(190, 600, 10, 20);
		frame.add(txt);

		submit = new JButton();
		submit.setText("Submit");
		submit.setBounds(350, 600, 150, 40);
		submit.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		submit.setBackground(Color.blue);
		submit.setForeground(Color.green);
		submit.setOpaque(false);
		submit.setFocusable(false);
		submit.addMouseListener(new MouseListener() {

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
				if (e.getSource() == submit)
					submit.setOpaque(true);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (e.getSource() == submit)
					submit.setOpaque(false);

			}

		});
		submit.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == submit) {
					if (star != 0 && review != null) {
						try {
							ps1.setString(1, pr_name);
							ps1.setString(2, book_name);
							ps1.setString(3, category);
							ps1.setInt(4, star);
							ps1.setString(5, review);

							rs1 = ps1.executeUpdate();
							if (star == 5) {
								ps3 = con.prepareStatement(insertstar5);
								ps3.setString(1, book_name);
								rs1 = ps3.executeUpdate();

								ps3 = con.prepareStatement(insertwr);
								ps3.setString(1, wr);
								rs1 = ps3.executeUpdate();

								ps3 = con.prepareStatement(insertpub);
								ps3.setString(1, pub);
								rs1 = ps3.executeUpdate();
							} else if (star == 4) {
								ps3 = con.prepareStatement(insertstar4);
								ps3.setString(1, book_name);
								rs1 = ps3.executeUpdate();
							} else if (star == 3) {
								ps3 = con.prepareStatement(insertstar3);
								ps3.setString(1, book_name);
								rs1 = ps3.executeUpdate();
							} else if (star == 2) {
								ps3 = con.prepareStatement(insertstar2);
								ps3.setString(1, book_name);
								rs1 = ps3.executeUpdate();
							} else if (star == 1) {
								ps3 = con.prepareStatement(insertstar1);
								ps3.setString(1, book_name);
								rs1 = ps3.executeUpdate();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

						frame.dispose();
					} else if (star == 0) {
						JOptionPane.showMessageDialog(frame,
								"Please rate stars before submit",
								"BookWorld",
								JOptionPane.WARNING_MESSAGE);
					} else if (review == null) {
						JOptionPane.showMessageDialog(frame,
								"Please write a review before submit",
								"BookWorld",
								JOptionPane.WARNING_MESSAGE);
					}

				}

			}

		});

		frame.add(submit);

		frame.setVisible(true);
	}
}