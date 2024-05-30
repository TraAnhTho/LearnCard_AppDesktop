package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import design.FButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
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
		LOGO.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		LOGO.setHorizontalAlignment(SwingConstants.CENTER);
		LOGO.setForeground(new Color(255, 255, 255));
		LOGO.setBounds(1, 0, 167, 60);
		Nav_Bar.add(LOGO);

		JLabel Home = new JLabel("HOME");
		Home.setHorizontalAlignment(SwingConstants.CENTER);
		Home.setForeground(new Color(255, 255, 255));
		Home.setBounds(187, 0, 139, 60);
		Nav_Bar.add(Home);

		JPanel panel_tools = new JPanel();
		panel_tools.setBackground(new Color(26, 29, 40));
		panel_tools.setForeground(new Color(26, 29, 40));
		panel_tools.setBounds(325, 57, 135, 148);
		Interface.add(panel_tools);
		panel_tools.setLayout(new GridLayout(0, 1, 0, 0));
		panel_tools.setVisible(false);

		JLabel Tools = new JLabel("Tools");
		Tools.addMouseListener(new MouseAdapter() {
			int count = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
				if (count % 2 != 0) {
					// Xử lý khi nhấn lần đầu
					panel_tools.setVisible(true);
					System.out.println("Đã nhấn lần Tool");
				} else if (count % 2 == 0) {
					// Xử lý khi nhấn lần thứ hai
					System.out.println("Đã nhấn lần Tool");
					panel_tools.setVisible(false);

				}
			}
		});
		Tools.setHorizontalAlignment(SwingConstants.CENTER);
		Tools.setForeground(new Color(255, 255, 255));
		Tools.setBounds(313, 0, 145, 60);
		Nav_Bar.add(Tools);

		JPanel panel_topic = new JPanel();
		panel_topic.setBackground(new Color(26, 29, 40));
		panel_topic.setBounds(497, 57, 135, 148);
		Interface.add(panel_topic);
		panel_topic.setLayout(new GridLayout(0, 1, 0, 0));
		panel_topic.setVisible(false);

		JLabel Topic = new JLabel("Topic");
		Topic.addMouseListener(new MouseAdapter() {
			int count = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
				if (count % 2 != 0) {
					// Xử lý khi nhấn lần đầu
					panel_topic.setVisible(true);
					System.out.println("Đã nhấn lần Topic");
				} else if (count % 2 == 0) {
					// Xử lý khi nhấn lần thứ hai
					System.out.println("Đã nhấn lần Topic");
					panel_topic.setVisible(false);

				}
			}
		});
		Topic.setHorizontalAlignment(SwingConstants.CENTER);
		Topic.setForeground(new Color(255, 255, 255));
		Topic.setBounds(461, 0, 167, 60);
		Nav_Bar.add(Topic);

		JLabel lbl_create = new JLabel("Create List Card");
		lbl_create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Bạn chưa đăng nhập", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		lbl_create.setForeground(new Color(255, 255, 255));
		lbl_create.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_create.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tools.add(lbl_create);

		JLabel lbl_Edit = new JLabel("Edit List Card");
		lbl_Edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Bạn chưa đăng nhập", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		lbl_Edit.setForeground(new Color(255, 255, 255));
		lbl_Edit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Edit.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tools.add(lbl_Edit);

		JLabel lbl_Delete = new JLabel("Delete List Card");
		lbl_Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Bạn chưa đăng nhập", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});

		lbl_Delete.setForeground(new Color(255, 255, 255));
		lbl_Delete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Delete.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tools.add(lbl_Delete);

		JLabel lbl_Learn = new JLabel("Learn");
		lbl_Learn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Bạn chưa đăng nhập", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		lbl_Learn.setForeground(new Color(255, 255, 255));
		lbl_Learn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Learn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_topic.add(lbl_Learn);

		JLabel lbl_Test = new JLabel("Test");
		lbl_Test.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Bạn chưa đăng nhập", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		lbl_Test.setForeground(new Color(255, 255, 255));
		lbl_Test.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Test.setHorizontalAlignment(SwingConstants.CENTER);
		panel_topic.add(lbl_Test);

		JLabel lbl_Data = new JLabel("Data");
		lbl_Data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Bạn chưa đăng nhập", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		lbl_Data.setForeground(new Color(255, 255, 255));
		lbl_Data.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Data.setHorizontalAlignment(SwingConstants.CENTER);
		panel_topic.add(lbl_Data);
		JPanel Login = new JPanel();
		Login.setBackground(new Color(26, 29, 40));
		Login.setBounds(673, 0, 333, 60);
		Nav_Bar.add(Login);
		Login.setLayout(null);

		JLabel button_login = new JLabel("Login");
		button_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Mời bạn đăng nhập!!!", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		button_login.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_login.setHorizontalAlignment(SwingConstants.CENTER);
		button_login.setBounds(0, 0, 155, 60);
		button_login.setForeground(new Color(255, 255, 255));
		Login.add(button_login);

		FButton button_register = new FButton();
		button_register.setText("Register");
		button_register.setBackground(new Color(175, 215, 130));
		button_register.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_register.setBounds(165, 11, 144, 38);
		button_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Mời bạn đăng kí!!!", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		Login.add(button_register);

		FButton Start = new FButton();
		Start.setText("Start");
		Start.setBackground(new Color(0, 128, 64));
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JOptionPane.showMessageDialog(new Login(), "Đăng nhập để tiếp tục!!!", "Đây là cửa số thông báo",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		Start.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		Start.setBounds(695, 313, 257, 83);
		Interface.add(Start);

		JLabel Background_Main = new JLabel("");
		Background_Main.setVerticalAlignment(SwingConstants.CENTER);
		Background_Main.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img1 = new ImageIcon(Home.class
				.getResource("/IMG/21 Heart-Wrenching GIFs To Sam Smith's _Stay With Me_ That Will Make You Stay.gif"));
		Image img2 = img1.getImage().getScaledInstance(1006, 475, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		Background_Main.setIcon(img3);
		Background_Main.setBounds(0, 0, 1006, 473);
		Interface.add(Background_Main);

	}
}
