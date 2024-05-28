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
import JDBC_KetNoi.JDBC_KetNoi;
import Model.Card;
import design.FTextField;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;

public class admin_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String iduser;
	private FTextField textField;
	private FTextField textField_1;
	private FTextField textField_2;
	private FTextField textField_3;
	private FTextField textField_4;
	private FTextField textField_5;
	private FTextField textField_6;
	private FTextField textField_7;
	private DefaultTableModel dtm;
	private JTable table;
	private DefaultTableModel dtm1;
	private JTable table1;
	private DefaultTableModel dtm2;
	private JTable table2;
	
	private JPanel panel_user;
	private JPanel panel_list;
	private JPanel panel_card;
	private JPanel panel_edit_user;
	private JPanel panel_edit_list;
	private JPanel panel_edit_card;
	private JPanel panel_adduser;

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
	public admin_view(String iduser)throws Exception   {
		this.iduser= iduser;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 510);
		
		//gọi
		//thís là cái view mình đang làm việc
		ActionListener ac =new Admin_Listener(this);
		
		
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
		
		JLabel logout = new JLabel("LOGOUT");
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setForeground(Color.WHITE);
		logout.setBounds(867, 0, 139, 60);
		Nav_Bar.add(logout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(26, 29, 40));
		panel.setBounds(44, 71, 137, 157);
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
			}
		});
		Card.setHorizontalAlignment(SwingConstants.CENTER);
		Card.setForeground(Color.WHITE);
		Card.setBounds(0, 103, 139, 54);
		panel.add(Card);
		
		JButton adduser = new JButton("ADD USER");
		adduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(true);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(false);
			}
		});
		adduser.setFont(new Font("Tahoma", Font.BOLD, 15));
		adduser.setBounds(44, 242, 137, 52);
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
		
		textField = new FTextField();
		textField.setBounds(312, 82, 260, 45);
		panel_adduser.add(textField);
		textField.setColumns(10);
		
		textField_1 = new FTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(312, 138, 260, 45);
		panel_adduser.add(textField_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(412, 194, 160, 50);
		panel_adduser.add(btnNewButton_3);
		
		//
		 panel_user = new JPanel();
		panel_user.setBackground(new Color(40, 46, 62));
		panel_user.setBounds(342, 110, 598, 303);
		Interface.add(panel_user);
		panel_user.setLayout(null);
		panel_user.setVisible(false);
		
		
		
		//Table User
				String[]header={"STT", "Tên danh sách","Other","Other"};
		        dtm=new DefaultTableModel(header, 0){
		       };
		        panel_user.add(new JScrollPane(table=new JTable(dtm)));
		        table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		        table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		        table.setBackground(new Color(255, 255, 255));
		        table.setForeground(new Color(118, 203, 33));
		        table.setRowHeight(30);
		        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		        JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 11, 578, 233);
				panel_user.add(scrollPane);
				//	chèn dữ liệu vào
		       LoadDBDataUser();
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(427, 260, 130, 43);
		panel_user.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("New button");
		btnNewButton_4_1.setBounds(275, 260, 130, 43);
		panel_user.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("New button");
		btnNewButton_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(true);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(false);
			}
		});
		btnNewButton_4_2.setBounds(123, 260, 130, 43);
		panel_user.add(btnNewButton_4_2);
		
		//
		 panel_list = new JPanel();
		panel_list.setBackground(new Color(40, 46, 62));
		panel_list.setBounds(342, 110, 598, 303);
		Interface.add(panel_list);
		panel_list.setLayout(null);
		panel_list.setVisible(false);
		
		
		
		//Table Card
				String[]header1={"STT", "Tên danh sách","Other","Other"};
		        dtm1=new DefaultTableModel(header1, 0){
		       };
		        panel_list.add(new JScrollPane(table1=new JTable(dtm1)));
		        table1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		        table1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		        table1.setBackground(new Color(255, 255, 255));
		        table1.setForeground(new Color(118, 203, 33));
		        table1.setRowHeight(30);
		        table1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		        JScrollPane scrollPane1 = new JScrollPane(table1);
				scrollPane1.setBounds(10, 11, 578, 233);
				panel_list.add(scrollPane1);
				//	chèn dữ liệu vào
		       LoadDBDataList();
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(427, 260, 130, 43);
		panel_list.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("New button");
		btnNewButton_5_1.setBounds(275, 260, 130, 43);
		panel_list.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("New button");
		btnNewButton_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(true);
				panel_edit_card.setVisible(false);
			}
		});
		btnNewButton_5_2.setBounds(123, 260, 130, 43);
		panel_list.add(btnNewButton_5_2);

		
		//
		 panel_card = new JPanel();
		panel_card.setBounds(342, 110, 598, 303);
		Interface.add(panel_card);
		panel_card.setLayout(null);
		panel_card.setVisible(false);
		
		
		//Table Card
		String[]header2={"STT", "Tên danh sách","Other","Other"};
        dtm2=new DefaultTableModel(header2, 0){
       };
        panel_card.add(new JScrollPane(table2=new JTable(dtm2)));
        table2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
        table2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        table2.setBackground(new Color(255, 255, 255));
        table2.setForeground(new Color(118, 203, 33));
        table2.setRowHeight(30);
        table2.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(10, 11, 578, 233);
		panel_card.add(scrollPane2);
		//	chèn dữ liệu vào
       LoadDBDataCard();
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(427, 260, 130, 43);
		panel_card.add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("New button");
		btnNewButton_6_1.setBounds(275, 260, 130, 43);
		panel_card.add(btnNewButton_6_1);
		
		JButton btnNewButton_6_2 = new JButton("New button");
		btnNewButton_6_2.setBounds(123, 260, 130, 43);
		panel_card.add(btnNewButton_6_2);
		
		//
		 panel_edit_user = new JPanel();
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
		
		textField_2 = new FTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(274, 74, 281, 45);
		panel_edit_user.add(textField_2);
		
		textField_3 = new FTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(274, 142, 281, 45);
		panel_edit_user.add(textField_3);
		
		JButton btnNewButton_3_1 = new JButton("New button");
		btnNewButton_3_1.setBounds(423, 198, 137, 45);
		panel_edit_user.add(btnNewButton_3_1);
		
		//
		 panel_edit_list = new JPanel();
		panel_edit_list.setLayout(null);
		panel_edit_list.setBounds(342, 110, 598, 303);
		Interface.add(panel_edit_list);
		panel_edit_list.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID User: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(64, 72, 200, 45);
		panel_edit_list.add(lblNewLabel_1_1);
		
		JLabel lblPassword_1_1 = new JLabel("Password: ");
		lblPassword_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1_1.setForeground(Color.WHITE);
		lblPassword_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword_1_1.setBounds(63, 140, 200, 45);
		panel_edit_list.add(lblPassword_1_1);
		
		textField_4 = new FTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(274, 74, 281, 45);
		panel_edit_list.add(textField_4);
		
		textField_5 = new FTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(274, 142, 281, 45);
		panel_edit_list.add(textField_5);
		
		JButton btnNewButton_3_1_1 = new JButton("New button");
		btnNewButton_3_1_1.setBounds(423, 198, 137, 45);
		panel_edit_list.add(btnNewButton_3_1_1);
		
		//
		 panel_edit_card = new JPanel();
		panel_edit_card.setLayout(null);
		panel_edit_card.setBounds(342, 110, 598, 303);
		Interface.add(panel_edit_card);
		panel_edit_card.setVisible(false);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID User: ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(64, 72, 200, 45);
		panel_edit_card.add(lblNewLabel_1_2);
		
		JLabel lblPassword_1_2 = new JLabel("Password: ");
		lblPassword_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1_2.setForeground(Color.WHITE);
		lblPassword_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword_1_2.setBounds(63, 140, 200, 45);
		panel_edit_card.add(lblPassword_1_2);
		
		textField_6 = new FTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(274, 74, 281, 45);
		panel_edit_card.add(textField_6);
		
		textField_7 = new FTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(274, 142, 281, 45);
		panel_edit_card.add(textField_7);
		
		JButton btnNewButton_3_1_2 = new JButton("New button");
		btnNewButton_3_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_user.setVisible(false);
				panel_list.setVisible(false);
				panel_card.setVisible(false);
				panel_edit_user.setVisible(false);
				panel_edit_list.setVisible(false);
				panel_edit_card.setVisible(true);
			}
		});
		btnNewButton_3_1_2.setBounds(423, 198, 137, 45);
		panel_edit_card.add(btnNewButton_3_1_2);


}
//	public void InsertsUser() {
//		 if(textField_card.getText().trim().isEmpty()||textField_des.getText().trim().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thẻ danh sách!!", "Đây là cửa số thông báo", 
//		                JOptionPane.ERROR_MESSAGE);
//		 }else {
//			Card cardnote = new Card(txt_list_card.getText(),textField_card.getText(),textField_des.getText());
//			 this.cardDAO.getInstance().Insert(cardnote);
//		 }
//	}
	 
	
	
	public void LoadDBDataList() throws Exception{
		Connection conn=JDBC_KetNoi.getConnection();
       String sql="select *from list_card;";
       ResultSet rs=conn.createStatement().executeQuery(sql);
   	int STT=1;
       while(rs.next()){
			String listname = rs.getString("List_Name");
			String cardcol = rs.getString("cardcol");
			String usercol = rs.getString("usercol"); //ten cot hoặc thứ tự cột
			Object []row={STT++,listname, cardcol, usercol};
//           dtm_list.addRow(row);
       }
       conn.close();
   }
	public void LoadDBDataCard() throws Exception{
			try {
				Connection conn=JDBC_KetNoi.getConnection();
				String sql="select *from card;";
				System.err.println(sql);
				ResultSet rs=conn.createStatement().executeQuery(sql);
				System.out.println(rs.next());
				int STT=1;
				while(rs.next()){
					String cardcol = rs.getString("cardcol");
					String name = rs.getString("Name");
					String des = rs.getString("Dinh_Nghia"); //ten cot hoặc thứ tự cột
				    Object []row={STT++,cardcol,name,des};
				    dtm2.addRow(row);
				}
				conn.close();
			} catch (Exception e2) {
				System.err.println("An error occurred: " + e2.getMessage());
				e2.printStackTrace();
			}

       
   }
	public void LoadDBDataUser() throws Exception{
		try {
			Connection conn=JDBC_KetNoi.getConnection();
			String sql="select *from user;";
			System.err.println(sql);
			ResultSet rs=conn.createStatement().executeQuery(sql);
			System.out.println(rs.next());
			int STT=1;
			while(rs.next()){
				String usercol = rs.getString("usercol");
				String id = rs.getString("idUser");
				String pass = rs.getString("pass"); //ten cot hoặc thứ tự cột
			    Object []row={STT++,usercol,id,pass};
//			    dtm_user.addRow(row);
			}
			conn.close();
		} catch (Exception e2) {
			System.err.println("An error occurred: " + e2.getMessage());
			e2.printStackTrace();
		}

   
}
	
//	 public void UpdateUser() {
//		 DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//			int i_row = table.getSelectedRow();
//			String namelist = model_table.getValueAt(i_row, 1) +"";
//			String tes = model_table.getValueAt(i_row, 2) +"";
//			String des = model_table.getValueAt(i_row, 3) +"";
//			
//			textField_nameedit.setText(tes);
//			textField_desedit.setText(des);
//		Card cardnote = new Card(namelist,tes,textField_desedit.getText());
//		 this.cardDAO.getInstance().Update(cardnote);
//			JOptionPane.showMessageDialog(null, "Đã cập nhật !", "Đây là cửa số thông báo", 
//	                JOptionPane.PLAIN_MESSAGE);
//	 }
//	 
//	 public void UpdateList() {
//		 DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
//			int i_row = table1.getSelectedRow();
//			String namelist = model_table.getValueAt(i_row, 1) +"";
//			String tes = model_table.getValueAt(i_row, 2) +"";
//			String des = model_table.getValueAt(i_row, 3) +"";
//			
//			textField_nameedit.setText(tes);
//			textField_desedit.setText(des);
//		Card cardnote = new Card(namelist,tes,textField_desedit.getText());
//		 this.cardDAO.getInstance().Update(cardnote);
//			JOptionPane.showMessageDialog(null, "Đã cập nhật !", "Đây là cửa số thông báo", 
//	                JOptionPane.PLAIN_MESSAGE);
//	 }
//	 
//	 public void UpdateCard() {
//		 DefaultTableModel model_table = (DefaultTableModel) table2.getModel();
//			int i_row = table2.getSelectedRow();
//			String namelist = model_table.getValueAt(i_row, 1) +"";
//			String tes = model_table.getValueAt(i_row, 2) +"";
//			String des = model_table.getValueAt(i_row, 3) +"";
//			
//			textField_nameedit.setText(tes);
//			textField_desedit.setText(des);
//		Card cardnote = new Card(namelist,tes,textField_desedit.getText());
//		 this.cardDAO.getInstance().Update(cardnote);
//			JOptionPane.showMessageDialog(null, "Đã cập nhật !", "Đây là cửa số thông báo", 
//	                JOptionPane.PLAIN_MESSAGE);
//	 }
	
}
