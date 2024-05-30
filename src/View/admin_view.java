package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Admin_Listener;
import Controller.User_Listener;
import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;
import JDBC_KetNoi.JDBC_KetNoi;
import Model.Card;
import Model.List_Card;
import Model.User;
import design.FButton;
import design.FTextField;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;

public class admin_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private Card card;
	private List_Card listcard;
	private User user;
	private Card_DAO cardDAO;
	private List_DAO listDAO;
	private User_DAO userDAO;

	private JPanel contentPane;
	private String iduser;

	private FTextField txt_id;
	private FTextField txt_pass;
	private FTextField txt_edit_iduser;
	private FTextField txt_edit_passuser;
	private FTextField txt_edit_list_iduser;
	private FTextField txt_edit_list_namecard;
	private FTextField txt_edit_namecard;
	private FTextField txt_edit_des;

	private DefaultTableModel dtm_user;
	private JTable table;
	private DefaultTableModel dtm_list;
	private JTable table1;
	private DefaultTableModel dtm_card;
	private JTable table2;

	private JPanel panel_user;
	private JPanel panel_list;
	private JPanel panel_card;
	private JPanel panel_edit_user;
	private JPanel panel_edit_list;
	private JPanel panel_edit_card;
	private JPanel panel_adduser;

	public FButton btn_addUsser;
	public FButton btn_editUser;
	public FButton btn_edit_list;
	public FButton btn_editCard;
	public FButton btn_detele_user;
	public FButton btn_delete_list;
	public FButton btn_detele_card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_view frame = new admin_view("admin");
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
	public admin_view(String iduser) throws Exception {
		this.iduser = iduser;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 510);

		// gọi
		// thís là cái view mình đang làm việc
		ActionListener ac = new Admin_Listener(this);

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
				try {
					new admin_view(iduser);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Home.setHorizontalAlignment(SwingConstants.CENTER);
		Home.setForeground(new Color(255, 255, 255));
		Home.setBounds(164, 0, 139, 60);
		Nav_Bar.add(Home);

		JLabel logout = new JLabel("Exit");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát chế độ quản lí ???",
						"Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					try {
						new Home_Login(iduser);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (result == JOptionPane.NO_OPTION) {
				} else {
				}
			}
		});
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setForeground(Color.WHITE);
		logout.setBounds(867, 0, 139, 60);
		Nav_Bar.add(logout);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(26, 29, 40));
		panel.setBounds(100, 120, 137, 157);
		Interface.add(panel);
		panel.setLayout(null);

		JLabel User = new JLabel("USER");
		User.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_user.setVisible(true);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(false);
				panel_adduser.setVisible(false);

			}
		});
		User.setHorizontalAlignment(SwingConstants.CENTER);
		User.setForeground(Color.WHITE);
		User.setBounds(0, 0, 139, 54);
		panel.add(User);

		JLabel list = new JLabel("LIST");
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_user.setVisible(false);
				panel_list.setVisible(true);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(false);
				panel_adduser.setVisible(false);

			}
		});
		list.setHorizontalAlignment(SwingConstants.CENTER);
		list.setForeground(Color.WHITE);
		list.setBounds(0, 56, 139, 54);
		panel.add(list);

		JLabel Card = new JLabel("CARD");
		Card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(true);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(false);
				panel_adduser.setVisible(false);

			}
		});
		Card.setHorizontalAlignment(SwingConstants.CENTER);
		Card.setForeground(Color.WHITE);
		Card.setBounds(0, 103, 139, 54);
		panel.add(Card);

		FButton adduser = new FButton();
		adduser.setText("ADD USER");
		adduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(false);
				panel_adduser.setVisible(true);

			}
		});
		adduser.setFont(new Font("Tahoma", Font.BOLD, 15));
		adduser.setBounds(100, 299, 137, 52);
		Interface.add(adduser);

		panel_adduser = new JPanel();
		panel_adduser.setBackground(new Color(40, 46, 62));
		panel_adduser.setBounds(342, 110, 598, 303);
		Interface.add(panel_adduser);
		panel_adduser.setLayout(null);
		panel_adduser.setVisible(true);

		JLabel lblNewLabel = new JLabel("ID User: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(67, 80, 200, 45);
		panel_adduser.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(77, 136, 200, 45);
		panel_adduser.add(lblPassword);

		txt_id = new FTextField();
		txt_id.setBounds(312, 82, 260, 45);
		panel_adduser.add(txt_id);
		txt_id.setColumns(10);

		txt_pass = new FTextField();
		txt_pass.setColumns(10);
		txt_pass.setBounds(312, 138, 260, 45);
		panel_adduser.add(txt_pass);

		btn_addUsser = new FButton();
		btn_addUsser.addActionListener(ac);
		btn_addUsser.setText("ADD");
		btn_addUsser.setBounds(412, 194, 160, 50);
		panel_adduser.add(btn_addUsser);

		//
		panel_user = new JPanel();
		panel_user.setBackground(new Color(40, 46, 62));
		panel_user.setBounds(342, 110, 598, 303);
		Interface.add(panel_user);
		panel_user.setLayout(null);
		panel_user.setVisible(false);

		// Table User
		String[] header = { "STT", "Tên danh sách", "Other", "Other" };
		dtm_user = new DefaultTableModel(header, 0) {
		};
		panel_user.add(new JScrollPane(table = new JTable(dtm_user)));
		table.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(118, 203, 33));
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 578, 233);
		panel_user.add(scrollPane);
		// chèn dữ liệu vào
		LoadDBDataUser();

		btn_detele_user = new FButton();
		btn_detele_user.addActionListener(ac);
		btn_detele_user.setText("Delete User");
		btn_detele_user.setBounds(275, 260, 130, 43);
		panel_user.add(btn_detele_user);

		FButton btn_edit_user = new FButton();
		btn_edit_user.setText("Edit User");
		btn_edit_user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				int i_row = table.getSelectedRow();
				String usercol = model_table.getValueAt(i_row, 1) + "";
				String iduser = model_table.getValueAt(i_row, 2) + "";
				String passuser = model_table.getValueAt(i_row, 3) + "";

				txt_edit_iduser.setText(iduser);
				txt_edit_passuser.setText(passuser);

				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(true);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(false);
				panel_adduser.setVisible(false);

			}
		});
		btn_edit_user.setBounds(123, 260, 130, 43);
		panel_user.add(btn_edit_user);

		//
		panel_list = new JPanel();
		panel_list.setBackground(new Color(40, 46, 62));
		panel_list.setBounds(342, 110, 598, 303);
		Interface.add(panel_list);
		panel_list.setLayout(null);
		panel_list.setVisible(false);

		// Table Card
		String[] header1 = { "STT", "Tên danh sách", "Other", "Other" };
		dtm_list = new DefaultTableModel(header1, 0) {
		};
		panel_list.add(new JScrollPane(table1 = new JTable(dtm_list)));
		table1.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		table1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		table1.setBackground(new Color(255, 255, 255));
		table1.setForeground(new Color(118, 203, 33));
		table1.setRowHeight(30);
		table1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBounds(10, 11, 578, 233);
		panel_list.add(scrollPane1);
		// chèn dữ liệu vào
		LoadDBDataList();

		btn_delete_list = new FButton();
		btn_delete_list.addActionListener(ac);
		btn_delete_list.setText("Delete List");
		btn_delete_list.setBounds(275, 260, 130, 43);
		panel_list.add(btn_delete_list);

		btn_edit_list = new FButton();
		btn_edit_list.addActionListener(ac);
		btn_edit_list.setText("Edit List");
		btn_edit_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
				int i_row = table1.getSelectedRow();
				String listname = model_table.getValueAt(i_row, 1) + "";
				String cardcol = model_table.getValueAt(i_row, 2) + "";
				String usercol = model_table.getValueAt(i_row, 3) + "";

				txt_edit_list_iduser.setText(usercol);
				txt_edit_list_namecard.setText(listname);

				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(true);
				panel_edit_card.setVisible(false);
				panel_adduser.setVisible(false);

			}
		});
		btn_edit_list.setBounds(123, 260, 130, 43);
		panel_list.add(btn_edit_list);

		//
		panel_card = new JPanel();
		panel_card.setBackground(new Color(40, 46, 62));
		panel_card.setBounds(342, 110, 598, 303);
		Interface.add(panel_card);
		panel_card.setLayout(null);
		panel_card.setVisible(false);

		// Table Card
		String[] header2 = { "STT", "Tên danh sách", "Other", "Other" };
		dtm_card = new DefaultTableModel(header2, 0) {
		};
		panel_card.add(new JScrollPane(table2 = new JTable(dtm_card)));
		table2.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		table2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		table2.setBackground(new Color(255, 255, 255));
		table2.setForeground(new Color(118, 203, 33));
		table2.setRowHeight(30);
		table2.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(10, 11, 578, 233);
		panel_card.add(scrollPane2);
		// chèn dữ liệu vào
		LoadDBDataCard();

		btn_detele_card = new FButton();
		btn_detele_card.addActionListener(ac);
		btn_detele_card.setText("Delete Card");
		btn_detele_card.setBounds(275, 260, 130, 43);
		panel_card.add(btn_detele_card);

		FButton btn_edit_card = new FButton();
		btn_edit_card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model_table = (DefaultTableModel) table2.getModel();
				int i_row = table2.getSelectedRow();
				String namelist = model_table.getValueAt(i_row, 1) + "";
				String tes = model_table.getValueAt(i_row, 2) + "";
				String des = model_table.getValueAt(i_row, 3) + "";

				txt_edit_list_namecard.setText(namelist);
				txt_edit_namecard.setText(tes);
				txt_edit_des.setText(des);

				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(true);
				panel_adduser.setVisible(false);
			}
		});
		btn_edit_card.setText("Edit Card");
		btn_edit_card.setBounds(123, 260, 130, 43);
		panel_card.add(btn_edit_card);

		//
		panel_edit_user = new JPanel();
		panel_edit_user.setBackground(new Color(40, 46, 62));
		panel_edit_user.setBounds(342, 110, 598, 303);
		Interface.add(panel_edit_user);
		panel_edit_user.setLayout(null);
		panel_edit_user.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("ID User: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(64, 72, 200, 45);
		panel_edit_user.add(lblNewLabel_1);

		JLabel lblPassword_1 = new JLabel("Password: ");
		lblPassword_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1.setForeground(Color.WHITE);
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword_1.setBounds(63, 140, 200, 45);
		panel_edit_user.add(lblPassword_1);

		txt_edit_iduser = new FTextField();
		txt_edit_iduser.setColumns(10);
		txt_edit_iduser.setBounds(274, 74, 281, 45);
		panel_edit_user.add(txt_edit_iduser);

		txt_edit_passuser = new FTextField();
		txt_edit_passuser.setColumns(10);
		txt_edit_passuser.setBounds(274, 142, 281, 45);
		panel_edit_user.add(txt_edit_passuser);

		btn_editUser = new FButton();
		btn_editUser.addActionListener(ac);
		btn_editUser.setText("Edit user");
		btn_editUser.setBounds(423, 198, 137, 45);
		panel_edit_user.add(btn_editUser);

		//
		panel_edit_list = new JPanel();
		panel_edit_list.setBackground(new Color(40, 46, 62));
		panel_edit_list.setLayout(null);
		panel_edit_list.setBounds(342, 110, 598, 303);
		Interface.add(panel_edit_list);
		panel_edit_list.setVisible(false);

		JLabel lblNewLabel_1_1 = new JLabel("Tên user: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(64, 72, 200, 45);
		panel_edit_list.add(lblNewLabel_1_1);

		JLabel lblPassword_1_1 = new JLabel("Tên List Card: ");
		lblPassword_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1_1.setForeground(Color.WHITE);
		lblPassword_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword_1_1.setBounds(63, 140, 200, 45);
		panel_edit_list.add(lblPassword_1_1);

		txt_edit_list_iduser = new FTextField();
		txt_edit_list_iduser.setColumns(10);
		txt_edit_list_iduser.setBounds(274, 74, 281, 45);
		panel_edit_list.add(txt_edit_list_iduser);

		txt_edit_list_namecard = new FTextField();
		txt_edit_list_namecard.setColumns(10);
		txt_edit_list_namecard.setBounds(274, 142, 281, 45);
		panel_edit_list.add(txt_edit_list_namecard);

		FButton btn_editList = new FButton();
		btn_editList.setText("Edit List");
		btn_editList.setBounds(423, 198, 137, 45);
		panel_edit_list.add(btn_editList);

		//
		panel_edit_card = new JPanel();
		panel_edit_card.setBackground(new Color(40, 46, 62));
		panel_edit_card.setLayout(null);
		panel_edit_card.setBounds(342, 110, 598, 303);
		Interface.add(panel_edit_card);
		panel_edit_card.setVisible(false);

		JLabel lblNewLabel_1_2 = new JLabel("Khái niệm: ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(64, 72, 200, 45);
		panel_edit_card.add(lblNewLabel_1_2);

		JLabel lblPassword_1_2 = new JLabel("Định Nghĩa: ");
		lblPassword_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1_2.setForeground(Color.WHITE);
		lblPassword_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword_1_2.setBounds(63, 140, 200, 45);
		panel_edit_card.add(lblPassword_1_2);

		txt_edit_namecard = new FTextField();
		txt_edit_namecard.setColumns(10);
		txt_edit_namecard.setBounds(274, 74, 281, 45);
		panel_edit_card.add(txt_edit_namecard);

		txt_edit_des = new FTextField();
		txt_edit_des.setColumns(10);
		txt_edit_des.setBounds(274, 142, 281, 45);
		panel_edit_card.add(txt_edit_des);

		btn_editCard = new FButton();
		btn_editCard.addActionListener(ac);
		btn_editCard.setText("Edit Card");
		btn_editCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(true);
				panel_adduser.setVisible(true);

			}
		});
		btn_editCard.setBounds(423, 198, 137, 45);
		panel_edit_card.add(btn_editCard);

	}

	public void InsertsUser() {
		if (txt_id.getText().trim().isEmpty() || txt_pass.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!");
		} else {
			User usernote = new User(txt_id.getText(), txt_id.getText(), txt_pass.getText());
			this.userDAO.getInstance().Dang_Ki(usernote);
			dispose();
			try {
				JOptionPane.showMessageDialog(new admin_view(iduser), "Thêm " + txt_id.getText() + " thành công!!!");
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void LoadDBDataList() throws Exception {
		Connection conn = JDBC_KetNoi.getConnection();
		String sql = "select *from list_card;";
		ResultSet rs = conn.createStatement().executeQuery(sql);
		int STT = 1;
		while (rs.next()) {
			String listname = rs.getString("List_Name");
			String cardcol = rs.getString("cardcol");
			String usercol = rs.getString("usercol"); // ten cot hoặc thứ tự cột
			Object[] row = { STT++, listname, cardcol, usercol };
			dtm_list.addRow(row);
		}
		conn.close();
	}

	public void LoadDBDataCard() throws Exception {
		try {
			Connection conn = JDBC_KetNoi.getConnection();
			String sql = "select *from card;";
			System.err.println(sql);
			ResultSet rs = conn.createStatement().executeQuery(sql);
			System.out.println(rs.next());
			int STT = 1;
			while (rs.next()) {
				String cardcol = rs.getString("cardcol");
				String name = rs.getString("Name");
				String des = rs.getString("Dinh_Nghia"); // ten cot hoặc thứ tự cột
				Object[] row = { STT++, cardcol, name, des };
				dtm_card.addRow(row);
			}
			conn.close();
		} catch (Exception e2) {
			System.err.println("An error occurred: " + e2.getMessage());
			e2.printStackTrace();
		}

	}

	public void LoadDBDataUser() throws Exception {
		try {
			Connection conn = JDBC_KetNoi.getConnection();
			String sql = "select *from user;";
			System.err.println(sql);
			ResultSet rs = conn.createStatement().executeQuery(sql);
			System.out.println(rs.next());
			int STT = 1;
			while (rs.next()) {
				String usercol = rs.getString("usercol");
				String id = rs.getString("idUser");
				String pass = rs.getString("pass"); // ten cot hoặc thứ tự cột
				Object[] row = { STT++, usercol, id, pass };
				dtm_user.addRow(row);
			}
			conn.close();
		} catch (Exception e2) {
			System.err.println("An error occurred: " + e2.getMessage());
			e2.printStackTrace();
		}

	}

	public void UpdateUser() {
		User user = new User(txt_edit_iduser.getText(), txt_edit_iduser.getText(), txt_edit_passuser.getText());
		this.userDAO.getInstance().Update(user);
		try {
			JOptionPane.showMessageDialog(new admin_view(iduser), "Đã cập nhật !", "Đây là cửa số thông báo",
					JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateList() {
		List_Card list = new List_Card(txt_edit_list_namecard.getText(), txt_edit_list_iduser.getText(),
				txt_edit_list_namecard.getText());
		this.listDAO.getInstance().Update(list);
		try {
			JOptionPane.showMessageDialog(new admin_view(iduser), "Đã cập nhật !", "Đây là cửa số thông báo",
					JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateCard() {
		Card cardnote = new Card(txt_edit_list_namecard.getText(), txt_edit_namecard.getText(), txt_edit_des.getText());
		this.cardDAO.getInstance().Update(cardnote);
		try {
			JOptionPane.showMessageDialog(new admin_view(iduser), "Đã cập nhật !", "Đây là cửa số thông báo",
					JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DeleteCard() {
		DefaultTableModel model_table = (DefaultTableModel) table2.getModel();
		int i_row = table2.getSelectedRow();
		String namelist = model_table.getValueAt(i_row, 1) + "";
		String tes = model_table.getValueAt(i_row, 2) + "";
		String des = model_table.getValueAt(i_row, 3) + "";
		Card cardnote = new Card(namelist, tes, des);
		this.cardDAO.getInstance().Delete(cardnote);
		try {
			JOptionPane.showMessageDialog(new Home_Login(iduser), "Đã xóa card: " + tes, "Đây là cửa số thông báo",
					JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DeleteList() {
		DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
		int i_row = table1.getSelectedRow();
		String namelist = model_table.getValueAt(i_row, 1) + "";
		String cardcol = model_table.getValueAt(i_row, 2) + "";
		String usercol = model_table.getValueAt(i_row, 3) + "";
		List_Card listnote = new List_Card(cardcol, usercol, namelist);
		System.out.println(cardcol + " " + usercol + " " + namelist);
		this.listDAO.getInstance().Delete(listnote);
		try {
			JOptionPane.showMessageDialog(new Home_Login(iduser), "Đã xóa danh sách: " + namelist,
					"Đây là cửa số thông báo", JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DeleteUser() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String usercol = model_table.getValueAt(i_row, 1) + "";
		String iduser = model_table.getValueAt(i_row, 2) + "";
		String passuser = model_table.getValueAt(i_row, 3) + "";
		User user = new User(usercol, iduser, passuser);
		this.userDAO.getInstance().Delete(user);
		try {
			JOptionPane.showMessageDialog(new admin_view(iduser), "Đã xóa user: "+iduser, "Đây là cửa số thông báo",
					JOptionPane.PLAIN_MESSAGE);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
