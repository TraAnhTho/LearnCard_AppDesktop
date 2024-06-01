package View;

import Model.Card;
import Model.List_Card;
import Model.User;
import design.FButton;
import design.FPasswordField;
import design.FTextField;
import JDBC_KetNoi.JDBC_KetNoi;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.User_Listener;
import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 * 
 */
public class Login extends JFrame {
	private Card card;
	private List_Card listcard;
	private User user;
	private Card_DAO cardDAO;
	private List_DAO listDAO;
	private User_DAO userDAO;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FTextField textField;
	private FTextField textField_user;
	private FPasswordField textField_pass;

	public FButton btn_dangnhap;
	public FButton btn_dangki;

	/**
	 * Launch the application.
	 * 
	 * @author TraAnhTho
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

		// gọi
		// thís là cái view mình đang làm việc
		ActionListener ac = new User_Listener(this);

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

		textField_user = new FTextField();
		textField_user.setBounds(393, 167, 294, 52);
		Interface.add(textField_user);
		textField_user.setColumns(10);

		textField_pass = new FPasswordField();
		textField_pass.setBounds(393, 258, 294, 52);
		Interface.add(textField_pass);
		textField_pass.setColumns(10);

		btn_dangnhap = new FButton();
		btn_dangnhap.setText("Đăng Nhập");
		btn_dangnhap.setFont(new Font("Verdana", Font.PLAIN, 20));
		btn_dangnhap.setForeground(new Color(0, 0, 0));
		btn_dangnhap.addActionListener(ac);
		btn_dangnhap.setBounds(398, 349, 137, 55);
		Interface.add(btn_dangnhap);
		
		btn_dangki = new FButton();
		btn_dangki.setText("Đăng Kí");
		btn_dangki.setForeground(new Color(255, 255, 255));
		btn_dangki.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_dangki.addActionListener(ac);
		btn_dangki.setBounds(550, 349, 137, 55);
		Interface.add(btn_dangki);

		JButton btn_showpass = new JButton();
		btn_showpass.setBackground(new Color(40, 46, 62));
		btn_showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setShowPasswordMouseClick(e);
			}
		});
		btn_showpass.setIcon(new ImageIcon(Login.class.getResource("/IMG/eye_48.png")));
		btn_showpass.setBounds(697, 273, 55, 37);
		Interface.add(btn_showpass);

	}

	public FButton getBtn_dangnhap() {
		return btn_dangnhap;
	}

	public void setBtn_dangnhap(FButton btn_dangnhap) {
		this.btn_dangnhap = btn_dangnhap;
	}

	public FButton getBtn_dangki() {
		return btn_dangki;
	}

	public void setBtn_dangki(FButton btn_dangki) {
		this.btn_dangki = btn_dangki;
	}

	public void SelectById() {
		System.out.println("Đăng Nhập click");
		if (textField_user.getText().trim().isEmpty() || textField_pass.getText().trim().isEmpty()) {
			dispose();
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!");
		} else {
			this.userDAO.getInstance().DangNhap(textField_user.getText(), textField_pass.getText());
			dispose();
		}
	}

	public FTextField getTextField_user() {
		return textField_user;
	}

	public void setTextField_user(FTextField textField_user) {
		this.textField_user = textField_user;
	}

	public FPasswordField getTextField_pass() {
		return textField_pass;
	}

	public void setTextField_pass(FPasswordField textField_pass) {
		this.textField_pass = textField_pass;
	}

	public void InsertsUser() {
		if (textField_user.getText().trim().isEmpty() || textField_pass.getPassword().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!");
		} else {
			User usernote = new User(textField_user.getText(), textField_user.getText(), textField_pass.getText());
			this.userDAO.getInstance().Dang_Ki(usernote);
			dispose();
		}
	}

	private void setShowPasswordMouseClick(ActionEvent event) {
		if (textField_pass.getEchoChar() == (char) 0) { // Password is hidden
			textField_pass.setEchoChar('\u25cf'); // Hide password
		} else { // Password is visible
			textField_pass.setEchoChar((char) 0); // Show password
		}
	}

//	public void addButtonClickListener(ActionListener ac) {
//		Login.addActionListener(ac);
//	}

}
