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

import javax.swing.*;

public class add_books_page {
	
	JFrame frame;
	JLabel bg,l1,l2,l3,l4;
	JComboBox top;
	JButton submit;
	JTextField txt[] = new JTextField[4];
	ImageIcon frameIcon = new ImageIcon("images\\book2.png");
	ImageIcon hi = new ImageIcon("images\\br 40.png");
	String left[] = {"Categories", "My Works", "Reviews"};
	ImageIcon bye = new ImageIcon("images\\p2 40.png");
	
	int hor_pos, var_pos;
	String pub,topic,book,wr,year,publisher,lang,country;
	String[] inputs = new String[5];
	char[] cnt = new char[4];
	ResultSet rs1,rs2;
	int rs3,rs4;
	void add_books(String pr_name, int typecode) throws SQLException {
		
		final String url = "jdbc:mysql:///BookWorld";
	    final String user = "root";
	    final String password = "supersqlsmash";

	    Connection con = DriverManager.getConnection(url, user, password);
	    //if(con!=null) System.out.println("Successfully connected to mysql");
	    
	    final String insert = "INSERT INTO Books(Book_name, Topic, Writer, Publication, Year_pub) VALUES (?,?,?,?,?)";
		PreparedStatement ps1 = con.prepareStatement(insert);		
		
		final String find1 = "SELECT Username FROM Writers WHERE Full_name = ?";
		PreparedStatement ps2 = con.prepareStatement(find1);
		
		final String find3 = "UPDATE Publishers SET No_of_books = No_of_books + 1 WHERE Username = ?";
		PreparedStatement ps3 = con.prepareStatement(find3);
		
		final String find4 = "UPDATE Writers SET No_of_books = No_of_books + 1 WHERE Username = ?";
		PreparedStatement ps4 = con.prepareStatement(find4);
		
		final String find5 = "SELECT Publication FROM Publishers WHERE Publication = ?";
		PreparedStatement ps7 = con.prepareStatement(find5);
		
		final String find6 = "SELECT Publication FROM Publishers WHERE Pub_name = ?";
		PreparedStatement ps8 = con.prepareStatement(find6);
		
		final String find7 = "SELECT Cl_name FROM client_info WHERE Username = ?";
		PreparedStatement ps9 = con.prepareStatement(find7);
		
		final String insert2 = "INSERT INTO Writers(Username, Full_name, Preferred Language, No_of_books) VALUES (?,?,?,?)";
		PreparedStatement ps5 = con.prepareStatement(insert2);
		
		final String insert3 = "INSERT INTO Publishers(Username, Pub_name, Publication, No_of_books, Country) VALUES (?,?,?,?,?)";
		PreparedStatement ps6 = con.prepareStatement(insert3);
		
		for(int i=0; i<4; i++) cnt[i] = 'N';
		
		frame = new JFrame();
		frame = new JFrame();		
		frame.setSize(600,600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setTitle("BookWorld");
		frame.setIconImage(frameIcon.getImage());
		
		bg = new JLabel(new ImageIcon("images\\ab1.jpg"));
		frame.setContentPane(bg);		
		
		l1 = new JLabel();
		l1.setBounds(0, 0, 600, 40);
		l1.setText("add your own books");
		l1.setForeground(Color.green);
		l1.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,30));
		l1.setHorizontalAlignment(JLabel.CENTER);
		frame.add(l1);
		
		l2 = new JLabel();
		l2.setBounds(0, 50, 600, 30);
		l2.setText("You can only add your own written/published books");
		l2.setForeground(Color.yellow);
		l2.setFont(new Font("Comis Sans MS",Font.BOLD,15));
		l2.setHorizontalAlignment(JLabel.CENTER);
		frame.add(l2);
		
		String label[] = {"Book Name","Topic","Writer (Full name)","Publication","Published in (Year)"};
		
		hor_pos = 30;
		var_pos = 120;
		
		for(int i=0; i<5; i++,var_pos+=30) {			
			l3 = new JLabel();
			l3.setBounds(hor_pos, var_pos, 200, 20);
			l3.setForeground(Color.white);
			l3.setText(label[i]);
			l3.setFont(new Font("MV Boli",Font.PLAIN,18));
			l3.setHorizontalAlignment(JLabel.CENTER);
			frame.add(l3);			
		}
		
		hor_pos = 250;
		var_pos = 120;
		
		for(int i=0; i<4; i++,var_pos+=30) {
			if(typecode==1 && i==2) var_pos+=30;
			else if(typecode==2 && i==3) var_pos+=30;
			else if(i==1) continue;
			txt[i] = new JTextField();
			txt[i].setBounds(hor_pos, var_pos, 300, 20);
			txt[i].setFont(new Font("Cambria",Font.PLAIN,15));
			frame.add(txt[i]);
		}
		
		String topics[] = {"Science","Engineering","Medical","Religion","Finance","History","Business",
				"Philosophy","Arts","Literature","Army/Warfare","Biography","Miscelleneous"};
		top = new JComboBox(topics);
		top.setBounds(250, 150, 300, 20);
		top.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<12; i++) {
					if(((String)top.getSelectedItem()).equals(topics[i])) {
						topic = topics[i];
						inputs[1] = topic;
						cnt[1] = 'Y';
						break;
					}
				}				
			}
		});
		frame.add(top);
		if(typecode==1) {
			ps9.setString(1, pr_name);
			rs1 = ps9.executeQuery();
			if(rs1.next()) wr = rs1.getString(1);
		}
		else if(typecode==2) {
			ps9.setString(1, pr_name);
			rs1 = ps9.executeQuery();
			if(rs1.next()) ps8.setString(1, rs1.getString(1));
			rs1 = ps8.executeQuery();
			if(rs1.next()) pub = rs1.getString(1);
		}
		l4 = new JLabel();
		if(typecode==1) {
			l4.setBounds(250, 180, 300, 20);
			l4.setText(pr_name);
		} 
		else if(typecode==2) {
			l4.setBounds(250, 210, 300, 20);
			l4.setText(pub);
		} 
		l4.setForeground(Color.black);
		l4.setFont(new Font("Cambria",Font.PLAIN,15));
		l4.setHorizontalAlignment(JLabel.LEFT);
		l4.setBackground(Color.white);
		l4.setOpaque(true);
		frame.add(l4);
		
		txt[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==txt[0]) {
					book = txt[0].getText();
					inputs[0] = book;
					cnt[0]='Y';
				}				
			}
			
		});
		
		txt[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==txt[2]) {
					if(typecode==1) {
						pub = txt[2].getText();
						inputs[3] = pub;
						inputs[2] = pr_name;
					} 
					else if(typecode==2) {
						wr = txt[2].getText();
						inputs[2] = wr;
						inputs[3] = pub;
					} 
					cnt[2] = 'Y';
				}				
			}
			
		});
		
		txt[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==txt[3]) {
					year = txt[3].getText();
					inputs[4] = year;
					cnt[3] = 'Y';
				}				
			}
			
		});
		//System.out.println(book+" "+" "+topic+" "+wr+" "+pub+" "+year);
		
		submit = new JButton();
		submit.setText("Submit");
		submit.setBounds(260, 300, 100, 40);
		submit.setFocusable(false);
		submit.setFont(new Font("MV Boli",Font.PLAIN,18));
		submit.setForeground(Color.red);
		submit.setBackground(Color.green);
		submit.setBorderPainted(false);
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
				if(e.getSource()==submit) {
					submit.setBackground(Color.blue);
					submit.setForeground(Color.yellow);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getSource()==submit) {
					submit.setBackground(Color.green);
					submit.setForeground(Color.red);
				}
				
			}
			
		});
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i;
				if(e.getSource()==submit) {
					for(i=0; i<4; i++) {
						if(cnt[i]=='N') {
							JOptionPane.showMessageDialog(frame, 
									"Please insert all the option and press enter after each of them", 
									"BookWorld", 
									JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					if(i==4) {					
							try {
								for(int j=0; j<5; j++) ps1.setString(j+1, inputs[j]);
								rs3 = ps1.executeUpdate();
								if(typecode==1) {
									ps4.setString(1, pr_name);
									rs3 = ps4.executeUpdate();
									ps7.setString(1, pub);
									rs1 = ps7.executeQuery();
									if(rs1.next()) {
										ps3.setString(1, pub);
										rs3 = ps3.executeUpdate();
									}
									else {
										ps6.setString(1, pub);
										ps6.setString(2, pub);
										ps6.setString(3, pub);
										ps6.setInt(4, 1);
										country = (String) JOptionPane.showInputDialog(						
												frame,
												"Country of the publication:",
												JOptionPane.QUESTION_MESSAGE
											);										
										ps6.setString(5, country);
										rs3 = ps6.executeUpdate();
										
									}
								}
								else if(typecode==2) {
									ps3.setString(1, pr_name);
									rs4 = ps3.executeUpdate();
									ps2.setString(1, wr);
									rs2 = ps2.executeQuery();
									if(rs2.next()) {
										ps4.setString(1, rs2.getString(1));
										rs4 = ps4.executeUpdate();
									}
									else {
										ps5.setString(1, wr);
										ps5.setString(2, wr);
										lang = (String) JOptionPane.showInputDialog(						
												frame,
												"Preferred language of the writer:",
												JOptionPane.QUESTION_MESSAGE
											);	
										ps5.setString(3, lang);
										ps5.setInt(4, 1);
										rs4 = ps5.executeUpdate();
									}
								}
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							frame.dispose();
					}					
				}
				
			}
			
		});
		frame.add(submit);
		
		frame.setVisible(true);
	}
}