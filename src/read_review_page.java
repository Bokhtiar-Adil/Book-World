import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;

public class read_review_page {
	JFrame frame;
	JPanel panel;
	JLabel book_pro;
	Border border;
	ImageIcon frameIcon = new ImageIcon("images\\book2.png");
	ImageIcon hi = new ImageIcon("images\\cat 40.png");
	ImageIcon bye = new ImageIcon("images\\p2 40.png");
	String[] search;
	String star;
	JTextArea rev;
	int size;
	int hor_pos = 0, var_pos = 0, chkr = 0;

	void read_review(String pr_name, String book_name, int pagetype) throws SQLException {

		final String url = "jdbc:mysql:///BookWorld";
		final String user = "root";
		final String password = "supersqlsmash";

		Connection con = DriverManager.getConnection(url, user, password);

		final String find1 = "SELECT * FROM Reviews ORDER BY Serial_no DESC";
		final String find2 = "SELECT * FROM Reviews WHERE Username = ? ORDER BY Serial_no DESC";
		final String find3 = "SELECT * FROM Reviews WHERE Book_name = ? ORDER BY Serial_no DESC";
		final String find4 = "SELECT * FROM Books WHERE Book_name = ?";
		PreparedStatement ps, ps2;
		ResultSet rs = null, rs2 = null;

		frame = new JFrame();
		frame.setSize(800, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(frameIcon.getImage());

		panel = new JPanel();
		JScrollPane scroll = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		if (pagetype == 1) {
			ps = con.prepareStatement(find1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			rs.last();
			size = rs.getRow();
			rs.beforeFirst();
			frame.setTitle("BookWorld - All Reviews");
		} else if (pagetype == 2) {
			ps = con.prepareStatement(find2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, pr_name);
			rs = ps.executeQuery();
			rs.last();
			size = rs.getRow();
			rs.beforeFirst();
			frame.setTitle("BookWorld -" + pr_name + "'s Written Reviews");
		} else if (pagetype == 3) {
			ps = con.prepareStatement(find3, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, book_name);
			rs = ps.executeQuery();
			rs.last();
			size = rs.getRow();
			rs.beforeFirst();
			frame.setTitle("BookWorld -" + book_name + "'s Reviews");

			ps2 = con.prepareStatement(find4);
			ps2.setString(1, book_name);
			rs2 = ps2.executeQuery();
			rs2.next();
		}

		if (size != 0) {
			c.gridx = hor_pos;
			c.gridy = var_pos;

			if (pagetype == 3) {
				book_pro = new JLabel();
				book_pro.setPreferredSize(new Dimension(750, 300));
				book_pro.setForeground(Color.white);

				book_pro.setText("<html>Book Name: <span style=\"font-family:Cambria;font-size:15px;\">"
						+ rs2.getString(2)
						+ "</span> <br> Topic: <span style=\"font-family:Cambria;font-size:15px;\">" + rs2.getString(3)
						+ "</span> <br> Writer: <span style=\"font-family:Cambria;font-size:15px;\">" + rs2.getString(4)
						+ "</span> <br> Publication: <span style=\"font-family:Cambria;font-size:15px;\">"
						+ rs2.getString(5)
						+ "</span> <br> Published in: <span style=\"font-family:Cambria;font-size:15px;\">"
						+ rs2.getString(11)
						+ "</span> <br> Five Stars: <span style=\"font-family:Cambria;font-size:15px;\">"
						+ rs2.getInt(6)
						+ "</span> <br> Four stars: <span style=\"font-family:Cambria;font-size:15px;\">"
						+ rs2.getInt(7)
						+ "</span> <br> Three Stars: <span style=\"font-family:Cambria;font-size:15px;\">"
						+ rs2.getInt(8)
						+ "</span> <br> Two Stars: <span style=\"font-family:Cambria;font-size:15px;\">" + rs2.getInt(9)
						+ "</span> <br> One Stars: <span style=\"font-family:Cambria;font-size:15px;\">"
						+ rs2.getInt(10)
						+ "</span> </html>");

				book_pro.setBackground(Color.blue);
				book_pro.setOpaque(true);
				book_pro.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
				book_pro.setHorizontalAlignment(JLabel.CENTER);
				book_pro.setVerticalAlignment(JLabel.CENTER);
				// border = BorderFactory.createLineBorder(Color.green, 5);
				book_pro.setBorder(border);
				panel.add(book_pro, c);

				var_pos += 1;
			}

			JLabel label[] = new JLabel[size];
			for (int i = 0; i < size; i++, var_pos++) {
				c.gridx = hor_pos;
				c.gridy = var_pos;

				rs.next();

				if (rs.getInt(5) == 1)
					star = "*";
				else if (rs.getInt(5) == 2)
					star = "**";
				else if (rs.getInt(5) == 3)
					star = "***";
				else if (rs.getInt(5) == 4)
					star = "****";
				else if (rs.getInt(5) == 5)
					star = "*****";
				else
					star = "";

				label[i] = new JLabel();

				label[i].setText("<html><span style=\"font-family:Comic Sans MS;font-size:15px;\">" + rs.getString(2)
						+ "</span> reviewed " + "<span style=\"font-family:Comic Sans MS;font-size:15px;\">"
						+ rs.getString(3)
						+ "</span> on topic " + "<span style=\"font-family:Comic Sans MS;font-size:15px;\">"
						+ rs.getString(4)
						+ "</span> <br> Rated <span style=\"font-family:Comic Sans MS;font-size:15px;\">" + rs.getInt(5)
						+ "</span> stars <span style=\"font-family:Wide Latin;font-size:18px;\">" + star
						+ "</span> <br>"
						+ "Review : <span style=\"font-family:Cambria;font-size:15px;\">" + rs.getString(6)
						+ "</span> </html>");

				if (rs.getString(6) == null || rs.getString(6).length() < 300)
					label[i].setPreferredSize(new Dimension(750, 200));
				else
					label[i].setPreferredSize(new Dimension(750, 300));
				label[i].setForeground(Color.blue);
				label[i].setOpaque(true);
				label[i].setBackground(Color.green);
				label[i].setFont(new Font("Arial", Font.PLAIN, 14));
				label[i].setHorizontalAlignment(JLabel.LEFT);
				label[i].setVerticalAlignment(JLabel.TOP);
				border = BorderFactory.createLineBorder(Color.BLUE, 5);
				label[i].setBorder(border);
				panel.add(label[i], c);
			}

			frame.add(scroll);
			frame.setVisible(true);
		}

		else {
			JOptionPane.showMessageDialog(frame,
					"No record found",
					"BookWorld",
					JOptionPane.WARNING_MESSAGE);
			frame.dispose();

		}

	}
}