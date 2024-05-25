package View;
import Model.Card;
import Model.List_Card;
import Model.User;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Card_Listener;
import Controller.User_Listener;
import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;
import JDBC_KetNoi.JDBC_KetNoi;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.ref.Cleaner.Cleanable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventObject;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import View.Login;
public class Home_Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private Card card;
	private List_Card listcard;
	private User user;
	private Card_DAO cardDAO;
	private List_DAO listDAO;
	private User_DAO userDAO;
	
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lbl_Edit;
	private javax.swing.JPanel panel_tools;
	private javax.swing.JPanel panel_topic;
	private JTextField textField_nameedit;
	private JTextField textField_card;
	private JTextField textField_desedit;
	private JTextField textField_des;
	protected JComponent panel_Create;
	private JTable table;
	private JTable table1;
	private DefaultTableModel dtm;
	protected JComponent panel_Edit_List;
	protected JComponent panel_Edit_Card;
	protected JComponent panel_Edit;
	protected JComponent panel_Delete;
	private JComponent panel_Create_List;
	private Label lbl_create;
	private Button btn_Next;
	private JTextField txt_list_card;
	private DefaultTableModel dtm1;
	private String namelist;
	private Component panel_Delete_List;
	private Component panel_Delete_Card;
	private Label Background_Main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Login frame = new Home_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @author TraAnhTho
	 */
	public Home_Login() throws Exception  {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 510);
		
		//gọi
		//thís là cái view mình đang làm việc
		ActionListener ac =new Card_Listener(this);
		
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
			int count=0;
			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
                if (count%2!= 0) {
                    // Xử lý khi nhấn lần đầu
    				panel_tools.setVisible(true);
                    System.out.println("Đã nhấn lần Tool");
                } else if (count%2==0) {
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
			int count =0;
			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
                if (count%2!= 0) {
                    // Xử lý khi nhấn lần đầu
                	panel_topic.setVisible(true);
                    System.out.println("Đã nhấn lần Topic");
                } else if (count%2==0) {
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
		lbl_create.setForeground(new Color(255, 255, 255));
		lbl_create.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_create.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tools.add(lbl_create);
		
		JLabel lbl_Edit = new JLabel("Edit List Card");
		lbl_Edit.setForeground(new Color(255, 255, 255));
		lbl_Edit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Edit.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tools.add(lbl_Edit);
		
		JLabel lbl_Delete = new JLabel("Delete List Card");
		
		lbl_Delete.setForeground(new Color(255, 255, 255));
		lbl_Delete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Delete.setHorizontalAlignment(SwingConstants.CENTER);
		panel_tools.add(lbl_Delete);
		
		
		
		JLabel lbl_Learn = new JLabel("Learn");
		lbl_Learn.setForeground(new Color(255, 255, 255));
		lbl_Learn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Learn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_topic.add(lbl_Learn);
		
		JLabel lbl_Test = new JLabel("Test");
		lbl_Test.setForeground(new Color(255, 255, 255));
		lbl_Test.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Test.setHorizontalAlignment(SwingConstants.CENTER);
		panel_topic.add(lbl_Test);
		
		JLabel lbl_Data = new JLabel("Data");
		lbl_Data.setForeground(new Color(255, 255, 255));
		lbl_Data.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Data.setHorizontalAlignment(SwingConstants.CENTER);
		panel_topic.add(lbl_Data);
		
		JPanel Search = new JPanel();
		Search.setBackground(new Color(26, 29, 40));
		Search.setBounds(626, 0, 380, 60);
		Nav_Bar.add(Search);
		Search.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 11, 166, 38);
		Search.add(textField);
		textField.setColumns(10);
		
		JLabel icon_search = new JLabel("");
		icon_search.setHorizontalAlignment(SwingConstants.CENTER);
		icon_search.setIcon(new ImageIcon(Home_Login.class.getResource("/IMG/icons8-search-26.png")));
		icon_search.setBounds(199, 11, 43, 38);
		Search.add(icon_search);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home_Login.class.getResource("/IMG/icons8-people-40.png")));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(252, 0, 128, 60);
		Search.add(lblNewLabel_1);
		
		JLabel Background_Main = new JLabel("");
		Background_Main.setVerticalAlignment(SwingConstants.TOP);
		Background_Main.setIcon(new ImageIcon(Home_Login.class.getResource("/IMG/bookx2.png")));
		Background_Main.setBackground(new Color(40, 46, 62));
		Background_Main.setBounds(0, 0, 1006, 473);
		Interface.add(Background_Main);
		Background_Main.setVisible(true);
		
		
		JPanel panel_Create_List = new JPanel();
		panel_Create_List.setBackground(new Color(40, 46, 62));
		panel_Create_List.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Create_List);
		panel_Create_List.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập tên bộ thẻ: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(110, 87, 221, 58);
		panel_Create_List.add(lblNewLabel);
		
		JTextField txt_list_card = new JTextField();
		txt_list_card.setBounds(110, 169, 484, 69);
		panel_Create_List.add(txt_list_card);
		txt_list_card.setColumns(10);
		
		JButton btn_create_list = new JButton("Create Name List");
		btn_create_list.addActionListener(ac);
		btn_create_list.setBounds(657, 169, 211, 69);
		panel_Create_List.add(btn_create_list);
		panel_Create_List.setVisible(false);

		
		JPanel panel_Create = new JPanel();
		panel_Create.setBackground(new Color(40, 46, 62));
		panel_Create.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Create);
		panel_Create.setLayout(null);
		panel_Create.setVisible(false);
		
		JLabel lblTeminolofy = new JLabel("TERMINOLOGY:");
		lblTeminolofy.setForeground(new Color(255, 255, 255));
		lblTeminolofy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTeminolofy.setBounds(125, 44, 208, 97);
		panel_Create.add(lblTeminolofy);
		
		textField_card = new JTextField();
		textField_card.setBounds(376, 44, 587, 97);
		panel_Create.add(textField_card);
		textField_card.setColumns(10);
		
		JLabel lblDefinition = new JLabel("DEFINITION:");
		lblDefinition.setForeground(new Color(255, 255, 255));
		lblDefinition.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDefinition.setBounds(125, 152, 208, 97);
		panel_Create.add(lblDefinition);
		
		textField_des = new JTextField();
		textField_des.setColumns(10);
		textField_des.setBounds(376, 152, 587, 97);
		panel_Create.add(textField_des);
		
		JButton btn_Next = new JButton("NEXT");
		
		btn_Next.setForeground(new Color(255, 255, 255));
		btn_Next.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btn_Next.setBackground(new Color(66, 85, 255));
		btn_Next.setBounds(809, 271, 153, 45);
		panel_Create.add(btn_Next);
		
		JButton btnSave = new JButton("SAVE");
		
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSave.setBackground(new Color(66, 85, 255));
		btnSave.setBounds(809, 340, 153, 45);
		panel_Create.add(btnSave);
		
		JPanel panel_Edit_List = new JPanel();
		panel_Edit_List.setBackground(new Color(40, 46, 62));
		panel_Edit_List.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Edit_List);
		panel_Edit_List.setLayout(null);
		panel_Edit_List.setVisible(false);

		
		//Table EditList
		String[]header={"STT", "Tên danh sách","Other","Other"};
        dtm=new DefaultTableModel(header, 0){
       };
//        getContentPane()
        panel_Edit_List.add(new JScrollPane(table=new JTable(dtm)));
        table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
        table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(new Color(118, 203, 33));
//      table.setEditingColumn(null);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(137, 110, 721, 209);
		panel_Edit_List.add(scrollPane);
		//	chèn dữ liệu vào
       LoadDBData2JTable();
		
		JLabel lblNewLabel_2 = new JLabel("Chọn danh sách \r\ncần chỉnh sửa:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(137, 54, 332, 45);
		panel_Edit_List.add(lblNewLabel_2);
		
		JButton btn_select_edit = new JButton("Chọn");
		
		btn_select_edit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_select_edit.setBounds(746, 330, 112, 41);
		panel_Edit_List.add(btn_select_edit);
		
		JPanel panel_Edit_Card = new JPanel();
		
		panel_Edit_Card.setBackground(new Color(40, 46, 62));
		panel_Edit_Card.setLayout(null);
		panel_Edit_Card.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Edit_Card);
		panel_Edit_Card.setVisible(false);

		
		
		//Table card
				String[]header3={"STT", "Tên danh sách","Other", "Other"};

		        dtm1=new DefaultTableModel(header3, 0){
		        	
		       };
		       	panel_Edit_Card.add(new JScrollPane(table1=new JTable(dtm1)));
		        table1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		        table1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		        table1.setBackground(new Color(255, 255, 255));
		        table1.setForeground(new Color(118, 203, 33));
		        table1.setRowHeight(30);
		        table1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		        JScrollPane scrollPane2 = new JScrollPane(table1);
				scrollPane2.setBounds(137, 110, 721, 209);
				panel_Edit_Card.add(scrollPane2);

				//	chèn dữ liệu vào
//		       LoadDBData3JTable();
		
		JLabel lblNewLabel_2_1 = new JLabel("Chọn danh sách \r\ncần chỉnh sửa");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(137, 54, 239, 45);
		panel_Edit_Card.add(lblNewLabel_2_1);
		
		JButton btn_edit = new JButton("Chỉnh sửa");
		
		btn_edit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_edit.setBounds(746, 330, 112, 41);
		panel_Edit_Card.add(btn_edit);
		
		JPanel panel_Edit = new JPanel();
		panel_Edit.setBackground(new Color(40, 46, 62));
		panel_Edit.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Edit);
		panel_Edit.setLayout(null);
		panel_Edit.setVisible(false);
		
		JLabel lblNewLabel1 = new JLabel("TERMINOLOGY:");
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel1.setBounds(125, 44, 208, 97);
		panel_Edit.add(lblNewLabel1);
		
		textField_nameedit = new JTextField();
		textField_nameedit.setBounds(376, 44, 587, 97);
		panel_Edit.add(textField_nameedit);
		textField_nameedit.setColumns(10);
		
		JLabel lblDefinition1 = new JLabel("DEFINITION:");
		lblDefinition1.setForeground(new Color(255, 255, 255));
		lblDefinition1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDefinition1.setBounds(125, 152, 208, 97);
		panel_Edit.add(lblDefinition1);
		
		textField_desedit = new JTextField();
		textField_desedit.setColumns(10);
		textField_desedit.setBounds(376, 152, 587, 97);
		panel_Edit.add(textField_desedit);
		
		JButton btn_save = new JButton("Save");
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			
			}
		});
		btn_save.setForeground(new Color(255, 255, 255));
		btn_save.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btn_save.setBackground(new Color(66, 85, 255));
		btn_save.setBounds(809, 271, 153, 45);
		panel_Edit.add(btn_save);
		
		JPanel panel_Delete_List = new JPanel();
		panel_Delete_List.setBackground(new Color(40, 46, 62));
		panel_Delete_List.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Delete_List);
		panel_Delete_List.setLayout(null);
		panel_Delete_List.setVisible(false);
		
		//Table DeleteList
		String[]header1={"STT", "Tên danh sách","Other","Other"};
        dtm=new DefaultTableModel(header1, 0){
       };
//        getContentPane()
        panel_Delete_List.add(new JScrollPane(table=new JTable(dtm)));
        table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
        table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(new Color(118, 203, 33));
//      table.setEditingColumn(null);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(137, 110, 721, 209);
		panel_Delete_List.add(scrollPane1);
		//	chèn dữ liệu vào
       LoadDBData2JTable();
		
		JLabel lblNewLabel_2_2 = new JLabel("Chọn danh sách \r\ncần xóa:");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(137, 54, 332, 45);
		panel_Delete_List.add(lblNewLabel_2_2);
		
		JButton btn_select_delete = new JButton("Chọn");
		
		btn_select_delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_select_delete.setBounds(746, 330, 112, 41);
		panel_Delete_List.add(btn_select_delete);
		
		JPanel panel_Delete_Card = new JPanel();
		Interface.add(panel_Delete_Card);
		panel_Delete_Card.setBackground(new Color(40, 46, 62));
		panel_Delete_Card.setLayout(null);
		panel_Delete_Card.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Edit_Card);
		panel_Delete_Card.setVisible(false);

		
		JButton btn_delete = new JButton("Xóa");
		
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_delete.setBounds(746, 330, 112, 41);
		panel_Delete_Card.add(btn_delete);
		//Table card
				String[]header4={"STT", "Tên danh sách","Other", "Other"};

		        dtm1=new DefaultTableModel(header4, 0){
		        	
		       };
		       panel_Delete_Card.add(new JScrollPane(table1=new JTable(dtm1)));
		        table1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		        table1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		        table1.setBackground(new Color(255, 255, 255));
		        table1.setForeground(new Color(118, 203, 33));
		        table1.setRowHeight(30);
		        table1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		        JScrollPane scrollPane4 = new JScrollPane(table1);
				scrollPane4.setBounds(137, 110, 721, 209);
				panel_Delete_Card.add(scrollPane4);

				//	chèn dữ liệu vào
		       LoadDBData3JTable(txt_list_card.getText());
		
		
		// chuột
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tools.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Create.setVisible(false);
				panel_Create_List.setVisible(false);
				panel_Delete_List.setVisible(false);
				panel_Delete_Card.setVisible(false);
				Background_Main.setVisible(true);

			}
		});
		lbl_create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panel_tools.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Create.setVisible(false);
				panel_Delete_List.setVisible(false);
				panel_Create_List.setVisible(true);
				panel_Delete_Card.setVisible(false);
				Background_Main.setVisible(false);
				try {
				System.out.println("create click");
			} catch (Exception e1) {
				System.err.println("An error occurred: " + e1.getMessage());
	            					e1.printStackTrace();
			}
			}
		});
		// EditLabel
		lbl_Edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tools.setVisible(false);
				panel_Create.setVisible(false);
				panel_Create_List.setVisible(false);
				panel_Edit_List.setVisible(true);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Delete_List.setVisible(false);
				panel_Delete_Card.setVisible(false);
				Background_Main.setVisible(false);


			}
		});
		// DeleteLabel
		lbl_Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tools.setVisible(false);
				panel_Create.setVisible(false);
				panel_Create_List.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Delete_List.setVisible(true);
				panel_Delete_Card.setVisible(false);
				Background_Main.setVisible(false);
			}
		});
	
		// EditButton
		btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_tools.setVisible(false);
				panel_Create.setVisible(false);
				panel_Create_List.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(true);
				panel_Delete_List.setVisible(false);
				panel_Delete_Card.setVisible(false);
				Background_Main.setVisible(false);
			}
		});
//		
		// EditLabel
		panel_Edit_Card.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
	}
	
	public void clearCard() {
		textField_card.setText("");
		textField_des.setText("");
		textField_card.requestFocus();
	}
	
	public void LoadDBData2JTable() throws Exception{
        Connection conn=getConnection();
        String sql="select *from list_card";
        ResultSet rs=conn.createStatement().executeQuery(sql);
    	int STT=1;
        while(rs.next()){
//        	int STT = rs.getInt("STT");
			String listname = rs.getString("List_Name");
			String cardcol = rs.getString("cardcol");
			String usercol = rs.getString("usercol"); //ten cot hoặc thứ tự cột
			
            
            Object []row={STT++,listname, cardcol, usercol};
            dtm.addRow(row);
        }
        conn.close();
    }
	
	public void LoadDBData3JTable(String listname) throws Exception{
			try {
				Connection conn=getConnection();
				System.out.println(listname);
				String sql="select *from card where cardcol='"+listname+"';";
				System.err.println(sql);
				ResultSet rs=conn.createStatement().executeQuery(sql);
				System.out.println(rs.next());
				int STT=1;
				while(rs.next()){
					String cardcol = rs.getString("cardcol");
					String name = rs.getString("Name");
					String des = rs.getString("Dinh_Nghia"); //ten cot hoặc thứ tự cột
				    Object []row={STT++,cardcol,name,des};
				    dtm1.addRow(row);
				}//https://github.com/TraAnhTho/Do_An/commit/3a72125d905597ddbdb3e38ef9bb28995bf09daa
				conn.close();
			} catch (Exception e2) {
				System.err.println("An error occurred: " + e2.getMessage());
				e2.printStackTrace();
			}

        
    }
	
	 private Connection getConnection()throws Exception{
	    	String url = "jdbc:mySQL://localhost:3306/flash_card";
			String username = "root";
			String password = "081105";
			// Tạo kết nối
			Connection con = DriverManager.getConnection(url, username, password);
	       return con;
	    }	
	 
	 public void InsertsList() {
		 if(txt_list_card.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thẻ danh sách!!");
		 }else {
			List_Card listnote = new List_Card(txt_list_card.getText(),"admin",txt_list_card.getText());
			 this.listDAO.getInstance().CreateButtonList(listnote);
			 	panel_Create.setVisible(true);
				panel_tools.setVisible(false);
				panel_Create_List.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Delete_List.setVisible(false);
				panel_Delete_Card.setVisible(false);
				Background_Main.setVisible(false);
		 }
	}
	 
}
