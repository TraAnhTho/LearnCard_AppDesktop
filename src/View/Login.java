package View;
import Model.User;
import JDBC_KetNoi.JDBC_KetNoi;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_user;
	private JTextField textField_pass;
	
	

	public JTextField getTextField_user() {
		return textField_user;
	}

	public void setTextField_user(JTextField textField_user) {
		this.textField_user = textField_user;
	}

	public JTextField getTextField_pass() {
		return textField_pass;
	}

	public void setTextField_pass(JTextField textField_pass) {
		this.textField_pass = textField_pass;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Interface = new JPanel();
		Interface.setBackground(new Color(40, 46, 62));
		Interface.setBounds(0, 0, 1006, 473);
		contentPane.add(Interface);
		Interface.setLayout(null);
		
		
		
		JPanel Nav_Bar = new JPanel();
		Nav_Bar.setBackground(new Color(26, 29, 40));
		Nav_Bar.setBounds(0, 0, 1006, 60);
		Interface.add(Nav_Bar);
		Nav_Bar.setLayout(null);
		
		JLabel LOGO = new JLabel("LEARNCARD");
		LOGO.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		LOGO.setHorizontalAlignment(SwingConstants.CENTER);
		LOGO.setForeground(new Color(255, 255, 255));
		LOGO.setBounds(1, 0, 153, 60);
		Nav_Bar.add(LOGO);
		
		JLabel Home = new JLabel("HOME");
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Home();
			}
		});
		Home.setHorizontalAlignment(SwingConstants.CENTER);
		Home.setForeground(new Color(255, 255, 255));
		Home.setBounds(164, 0, 139, 60);
		Nav_Bar.add(Home);
		
		JLabel lblNewLabel = new JLabel("ID User: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(199, 167, 150, 52);
		Interface.add(lblNewLabel);
		
		JLabel lblPass = new JLabel("Password:");
		lblPass.setForeground(new Color(255, 255, 255));
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPass.setBounds(199, 258, 150, 52);
		Interface.add(lblPass);
		
		textField_user = new JTextField();
		textField_user.setBounds(393, 167, 294, 52);
		Interface.add(textField_user);
		textField_user.setColumns(10);
		
		textField_pass = new JTextField();
		textField_pass.setBounds(393, 258, 294, 52);
		Interface.add(textField_pass);
		textField_pass.setColumns(10);
		
		JButton btn_dangki = new JButton("Đăng nhập");
		btn_dangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					String url = "jdbc:mySQL://localhost:3306/flash_card";
					String username = "root";
					String password = "081105";
					// Bước 1: Tạo kết nối
					Connection c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "SELECT * FROM flash_card.`user` WHERE `idUser` = '"+ textField_user.getText()
					+"' AND `pass` = '"
							+ textField_pass.getText()+"';";
					System.out.println("sql: "+sql);
					ResultSet check = st.executeQuery(sql);
					System.out.println("check: "+check);
			
					c.close();
//					dispose();
					//can sua
					JOptionPane.showMessageDialog(new Home_Login(), "Đã Lưu");
					
					
				} catch (Exception e2) {
					System.err.println("An error occurred: " + e2.getMessage());
		            e2.printStackTrace();
		            //					dispose();
				}
			}
		});
		btn_dangki.setBounds(393, 345, 129, 41);
		Interface.add(btn_dangki);
		
		JButton btn_dangnhap = new JButton("Đăng kí");
		btn_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mySQL://localhost:3306/hethongminimart";
					String username = "root";
					String password = "081105";
					// Tạo kết nối
					Connection con = DriverManager.getConnection(url, username, password);
					PreparedStatement ps = con.prepareStatement("SELECT * FROM flash_card.`user` WHERE `idUser` = '" +textField_user.getText()+"';");
					System.out.println(ps);
					ResultSet Rs = ps.executeQuery();
					System.out.println(Rs);
					System.out.println(Rs.next());
		
					if(Rs.next()==true) {
						JOptionPane.showMessageDialog(new Login(), "Tài khoản đã tồn tại!!!");
						System.out.println("success");

					}else if(Rs.next()==false) {
						System.out.println("fail");

						JOptionPane.showMessageDialog(new Login(), "Tài khoản chưa tồn tại!!!");
						// Bước 1: Tạo kết nối
						Connection c = JDBC_KetNoi.getConnection();
						
						// Bước 2: Tạo ra đối tượng statement
						Statement st = c.createStatement();
						
						// Bước 3: Thực thi một câu lệnh SQL
						String sql = "INSERT INTO flash_card.`user` (`STT`,`usercol`, `idUser`,`pass`)"
								+ "VALUES ("+null
								+", '"+ textField_user.getText()
								+"', '"+ textField_user.getText()
								+"', '"+ textField_pass.getText()
								+"') ON DUPLICATE KEY UPDATE `pass` = VALUES(`pass`), `usercol` = VALUES(`usercol`);";
						int check = st.executeUpdate(sql);
				
						c.close();
//						Clear();				
//						dispose();
						JOptionPane.showMessageDialog(new Home_Login(), "Đã Lưu");	
					}	
					} catch (Exception e2) {
						dispose();
						System.err.println("An error occurred: " + e2.getMessage());
			            e2.printStackTrace();
				}
			}
		});
		btn_dangnhap.setBounds(558, 345, 129, 41);
		Interface.add(btn_dangnhap);
		
	}
public void LoadDBDataJTable() throws Exception{
	    
	    Connection conn=getConnection();
	    String sql="select *from user";
	    ResultSet rs=conn.createStatement().executeQuery(sql);
	    conn.close();
	}
	 private Connection getConnection()throws Exception{
	    	String url = "jdbc:mySQL://localhost:3306/flash_card";
			String username = "root";
			String password = "081105";
			// Tạo kết nối
			Connection con = DriverManager.getConnection(url, username, password);
	       return con;
	 }
	 
	 


}
