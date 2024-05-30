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
import java.awt.HeadlessException;
import java.awt.Image;
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
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import View.Login;
import design.FButton;
import design.FTextField;
public class Home_Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private Card card;
	private List_Card listcard;
	private User user;
	private Card_DAO cardDAO;
	private List_DAO listDAO;
	private User_DAO userDAO;
	
	private Login login;
	private JPanel contentPane;
	private FTextField textField;
	private JLabel lbl_Edit;
	private javax.swing.JPanel panel_tools;
	private javax.swing.JPanel panel_topic;
	private FTextField textField_nameedit;
	private FTextField textField_card;
	private FTextField textField_desedit;
	private FTextField textField_des;
	protected JComponent panel_Create;
	private JTable table;
	private JTable table1;
	private JTable table_update_list;
	private DefaultTableModel dtm_list;
	private DefaultTableModel dtm_card;
	private DefaultTableModel dtm_update_card;

	private JComponent panel_Edit_List;
	private JComponent panel_Edit_Card;
	private JComponent panel_Edit;
	private JComponent panel_Delete;
	private JComponent panel_Delete_List;
	private JComponent panel_Delete_Card;
	private JComponent panel_Create_List;
	private Label lbl_create;
	public FButton btn_Next;
	public FButton btn_create_list;
	public FButton btnSave;
	public FButton btn_select_edit;
	public FButton btn_delete;
	public FButton btn_select_delete;
	public FButton btn_update;
	public FButton btn_edit;
	public FButton btn_delete_list;
	private FTextField txt_list_card;
	private String namelist;
	private JLabel Background_Main;
	private JPanel panel_home;
	private JTable table_update_card;
	 static String iduser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Home_Login frame = new Home_Login(iduser);
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
	public Home_Login(String iduser) throws Exception  {
		this.iduser= iduser;
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
		Home.addMouseListener(new MouseAdapter() {
			int count=0;
			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
              if (count%2!= 0) {
                  // Xử lý khi nhấn lần đầu
              	panel_home.setVisible(true);
                  System.out.println("Đã nhấn lần Topic");
              } else if (count%2==0) {
                  // Xử lý khi nhấn lần thứ hai
                  System.out.println("Đã nhấn lần Topic");
                  panel_home.setVisible(false);

              }
			}
		});
		Home.setHorizontalAlignment(SwingConstants.CENTER);
		Home.setForeground(new Color(255, 255, 255));
		Home.setBounds(178, 0, 139, 60);
		Nav_Bar.add(Home);

		
		panel_home = new JPanel();
		panel_home.setBackground(new Color(26, 29, 40));
		panel_home.setBounds(185, 57, 135, 92);
		Interface.add(panel_home);
		panel_home.setLayout(new GridLayout(0, 1, 0, 0));
		panel_home.setVisible(false);

		
		JLabel lbl_logout = new JLabel("Logout");
		lbl_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int result = JOptionPane.showConfirmDialog(null,
	                        "Bạn có chắc muốn đăng xuất???",
	                        "Xác nhận",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
	                   new Home();
	                }else if (result == JOptionPane.NO_OPTION) {   
	                }else { 
	                }

			}
		});
		lbl_logout.setForeground(new Color(255, 255, 255));
		lbl_logout.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_logout.setHorizontalAlignment(SwingConstants.CENTER);
		panel_home.add(lbl_logout);
		
		JLabel lblNewLabel_3 = new JLabel("ADMIN");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(iduser);
				if(iduser.equals("admin")) {
					System.out.println(iduser);
					try {
						dispose();
						new admin_view(iduser);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"Bạn không phải admin", "Đây là cửa số thông báo", 
			                JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_home.add(lblNewLabel_3);
		
		
		
		panel_tools = new JPanel();
		panel_tools.setBackground(new Color(26, 29, 40));
		panel_tools.setForeground(new Color(26, 29, 40));
		panel_tools.setBounds(345, 57, 135, 148);
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
		
		panel_topic = new JPanel();
		panel_topic.setBackground(new Color(26, 29, 40));
		panel_topic.setBounds(497, 57, 135, 92);
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
		lbl_Test.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
	            new Rules(iduser);
			}
		});
		lbl_Test.setForeground(new Color(255, 255, 255));
		lbl_Test.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Test.setHorizontalAlignment(SwingConstants.CENTER);
		panel_topic.add(lbl_Test);
		
		JPanel Search = new JPanel();
		Search.setBackground(new Color(26, 29, 40));
		Search.setBounds(626, 0, 380, 60);
		Nav_Bar.add(Search);
		Search.setLayout(null);
		
		textField = new FTextField();
		textField.setBounds(23, 11, 166, 38);
		Search.add(textField);
		textField.setColumns(10);
		
		JLabel icon_search = new JLabel("");
		icon_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		icon_search.setHorizontalAlignment(SwingConstants.CENTER);
		icon_search.setIcon(new ImageIcon(Home_Login.class.getResource("/IMG/icons8-search-26.png")));
		icon_search.setBounds(199, 11, 43, 38);
		Search.add(icon_search);
		
		JLabel lblNewLabel_1 = new JLabel(iduser);
		lblNewLabel_1.setIcon(new ImageIcon(Home_Login.class.getResource("/IMG/account-50.png")));
		lblNewLabel_1.setForeground(new Color(175, 215, 130));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(252, 0, 128, 60);
		Search.add(lblNewLabel_1);
		
		Background_Main = new JLabel("");
		Background_Main.setVerticalAlignment(SwingConstants.CENTER);
		Background_Main.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img1 = new ImageIcon(Home.class.getResource("/IMG/tải xuống.gif"));
        Image img2 = img1.getImage().getScaledInstance(1006, 475, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
		Background_Main.setIcon(img3);
		Background_Main.setBounds(0, 0, 1006, 473);
		Interface.add(Background_Main);
		Background_Main.setVisible(true);
		
		
		panel_Create_List = new JPanel();
		panel_Create_List.setBackground(new Color(40, 46, 62));
		panel_Create_List.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Create_List);
		panel_Create_List.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập tên bộ thẻ: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(110, 87, 221, 58);
		panel_Create_List.add(lblNewLabel);
		
		txt_list_card = new FTextField();
		txt_list_card.setBounds(110, 169, 484, 69);
		panel_Create_List.add(txt_list_card);
		txt_list_card.setColumns(10);
		
		btn_create_list = new FButton();
		btn_create_list.setText("Create Name List");
		btn_create_list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_create_list.setBackground(new Color(175, 215, 130));
		btn_create_list.addActionListener(ac);
		btn_create_list.setBounds(657, 169, 211, 69);
		panel_Create_List.add(btn_create_list);
		panel_Create_List.setVisible(false);

		
		panel_Create = new JPanel();
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
		
		textField_card = new FTextField();
		textField_card.setBounds(376, 44, 587, 97);
		panel_Create.add(textField_card);
		textField_card.setColumns(10);
		
		JLabel lblDefinition = new JLabel("DEFINITION:");
		lblDefinition.setForeground(new Color(255, 255, 255));
		lblDefinition.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDefinition.setBounds(125, 152, 208, 97);
		panel_Create.add(lblDefinition);
		
		textField_des = new FTextField();
		textField_des.setColumns(10);
		textField_des.setBounds(376, 152, 587, 97);
		panel_Create.add(textField_des);
		
		btn_Next = new FButton();
		btn_Next.setText("NEXT");
		btn_Next.addActionListener(ac);
		btn_Next.setForeground(new Color(0, 0, 0));
		btn_Next.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Next.setBackground(new Color(175, 215, 130));
		btn_Next.setBounds(809, 271, 153, 45);
		panel_Create.add(btn_Next);
		
		btnSave = new FButton();
		btnSave.setText("SAVE");
		btnSave.addActionListener(ac);
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBackground(new Color(0, 128, 64));
		btnSave.setBounds(809, 340, 153, 45);
		panel_Create.add(btnSave);
		
		panel_Edit_List = new JPanel();
		panel_Edit_List.setBackground(new Color(40, 46, 62));
		panel_Edit_List.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Edit_List);
		panel_Edit_List.setLayout(null);
		panel_Edit_List.setVisible(false);

		
		
		
		//Table EditList
		String[]header={"STT", "Tên danh sách","Other","Other"};
		dtm_list = new DefaultTableModel(header, 0);
		System.out.println("dtm_list_edit: "+dtm_list);
        panel_Edit_List.add(new JScrollPane(table_update_list=new JTable(dtm_list)));
        table_update_list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
        table_update_list.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        table_update_list.setBackground(new Color(255, 255, 255));
        table_update_list.setForeground(new Color(118, 203, 33));
        table_update_list.setRowHeight(30);
        table_update_list.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(table_update_list);
		scrollPane.setBounds(137, 110, 721, 209);
		panel_Edit_List.add(scrollPane);
		//	chèn dữ liệu vào
       LoadDBData2JTable();
		
		JLabel lblNewLabel_2 = new JLabel("Chọn danh sách \r\ncần chỉnh sửa:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(137, 54, 332, 45);
		panel_Edit_List.add(lblNewLabel_2);
		
		btn_select_edit = new FButton();
		btn_select_edit.setText("Select_Edit");
		btn_select_edit.setBackground(new Color(175, 215, 130));
		
		btn_select_edit.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_select_edit.setBounds(746, 330, 112, 41);
		panel_Edit_List.add(btn_select_edit);
		
		panel_Edit_Card = new JPanel();
		
		panel_Edit_Card.setBackground(new Color(40, 46, 62));
		panel_Edit_Card.setLayout(null);
		panel_Edit_Card.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Edit_Card);
		panel_Edit_Card.setVisible(false);

		
		
		//Table card
				String[]header3={"STT", "Tên danh sách","Other", "Other"};

				dtm_update_card=new DefaultTableModel(header3,0);
				System.out.println("dtm_card_edit: "+dtm_update_card);
		       	panel_Edit_Card.add(new JScrollPane(table_update_card = new JTable(dtm_update_card)));
		       	table_update_card.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		       	table_update_card.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		       	table_update_card.setBackground(new Color(255, 255, 255));
		       	table_update_card.setForeground(new Color(118, 203, 33));
		       	table_update_card.setRowHeight(30);
		       	table_update_card.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		        JScrollPane scrollPane2 = new JScrollPane(table_update_card);
				scrollPane2.setBounds(137, 110, 721, 209);
				panel_Edit_Card.add(scrollPane2);

				//	chèn dữ liệu vào
//		       LoadDBData3JTable();
		
		JLabel lblNewLabel_2_1 = new JLabel("Chọn danh sách \r\ncần chỉnh sửa");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(137, 54, 239, 45);
		panel_Edit_Card.add(lblNewLabel_2_1);
		
		
		btn_edit = new FButton();
		btn_edit.setText("Chỉnh sửa");
		btn_edit.setBackground(new Color(175, 215, 130));
		
		btn_edit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_edit.setBounds(746, 330, 112, 41);
		panel_Edit_Card.add(btn_edit);
		
		panel_Edit = new JPanel();
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
		
		textField_nameedit = new FTextField();
		textField_nameedit.setBackground(new Color(192, 192, 192));
		textField_nameedit.setBounds(376, 44, 587, 97);
		panel_Edit.add(textField_nameedit);
		textField_nameedit.setColumns(10);
		
		JLabel lblDefinition1 = new JLabel("DEFINITION:");
		lblDefinition1.setForeground(new Color(255, 255, 255));
		lblDefinition1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDefinition1.setBounds(125, 152, 208, 97);
		panel_Edit.add(lblDefinition1);
		
		textField_desedit = new FTextField();
		textField_desedit.setColumns(10);
		textField_desedit.setBounds(376, 152, 587, 97);
		panel_Edit.add(textField_desedit);
		
		
		btn_update = new FButton();
		btn_update.setText("UPDATE");
		btn_update.addActionListener(ac);
		btn_update.setForeground(new Color(0, 0, 0));
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_update.setBackground(new Color(175, 215, 130));
		btn_update.setBounds(809, 271, 153, 45);
		panel_Edit.add(btn_update);
		
		panel_Delete_List = new JPanel();
		panel_Delete_List.setBackground(new Color(40, 46, 62));
		panel_Delete_List.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Delete_List);
		panel_Delete_List.setLayout(null);
		panel_Delete_List.setVisible(false);
		
		//Table DeleteList
		String[]header1={"STT", "Tên danh sách","Other","Other"};
		dtm_list = new DefaultTableModel(header1, 0);
		System.out.println("dtm_list_delete"+dtm_list);
        panel_Delete_List.add(new JScrollPane(table=new JTable(dtm_list)));
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
		
		btn_select_delete = new FButton();
		btn_select_delete.setText("SELECT_DELETE");
		btn_select_delete.setBackground(new Color(175, 215, 130));
//		btn_select_delete.addActionListener(ac);
		btn_select_delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_select_delete.setBounds(615, 330, 112, 41);
		panel_Delete_List.add(btn_select_delete);
		
		btn_delete_list = new FButton();
		btn_delete_list.setText("DELETE_LIST");
		btn_delete_list.setBackground(new Color(175, 215, 130));
		btn_delete_list.addActionListener(ac);
		btn_delete_list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_delete_list.setBounds(750, 330, 112, 41);
		panel_Delete_List.add(btn_delete_list);
		
		panel_Delete_Card = new JPanel();
		Interface.add(panel_Delete_Card);
		panel_Delete_Card.setBackground(new Color(40, 46, 62));
		panel_Delete_Card.setLayout(null);
		panel_Delete_Card.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Edit_Card);
		panel_Delete_Card.setVisible(false);

		
		btn_delete = new FButton();
		btn_delete.setText("DELETE");
		btn_delete.setBackground(new Color(175, 215, 130));
		btn_delete.addActionListener(ac);
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_delete.setBounds(746, 330, 112, 41);
		panel_Delete_Card.add(btn_delete);
		//Table card
				String[]header4={"STT", "Tên danh sách","Other", "Other"};

				dtm_card = new DefaultTableModel(header4, 0);
				System.out.println("dtm_delete_card: "+dtm_card);
		       panel_Delete_Card.add(new JScrollPane(table1=new JTable(dtm_card)));
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
//		       LoadDBData3JTable(txt_list_card.getText());
		
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
				DefaultTableModel model_table = (DefaultTableModel) table_update_card.getModel();
				int i_row = table_update_card.getSelectedRow();
				System.out.println("irow: " + i_row);
				System.out.println("model_edit: "+ model_table.getValueAt(i_row,1));
				String nameList = model_table.getValueAt(i_row,1) +"";
				String tes = model_table.getValueAt(i_row,2) +"";
				String des = model_table.getValueAt(i_row,3) +"";
				
				textField_nameedit.setText(tes);
				textField_desedit.setText(des);
				txt_list_card.setText(nameList);				
				
				
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
		
		//selectedit
		btn_select_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DefaultTableModel model_table = (DefaultTableModel) table_update_list.getModel();
					int i_row = table_update_list.getSelectedRow();
					System.out.println("irow: " + i_row);
					System.out.println("model_edit: "+ model_table.getValueAt(i_row,1));
					String tableedit = model_table.getValueAt(i_row,1) +"";
					System.out.println("name-edit: "+tableedit); 
					
					txt_list_card.setText(tableedit);
					System.out.println(txt_list_card.getText());
					
					panel_tools.setVisible(false);
					panel_Create.setVisible(false);
					panel_Create_List.setVisible(false);
					panel_Edit_List.setVisible(false);
					panel_Edit_Card.setVisible(true);
					panel_Edit.setVisible(false);
					panel_Delete_List.setVisible(false);
					panel_Delete_Card.setVisible(false);
					Background_Main.setVisible(false);
				    LoadDBData3JTable(tableedit);
	
				} catch (Exception e2) {
					System.err.println("An error occurred: " + e2.getMessage());
					e2.printStackTrace();
					try {
					dispose();
					JOptionPane.showMessageDialog(panel_Edit_List, "Chọn Sản Phẩm Cần Chỉnh");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				}
		});

		//selectDetele
		btn_select_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
					int i_row = table.getSelectedRow();
					System.out.println("irow_delete: " + i_row);
					System.out.println("model_delete "+model_table.getValueAt(i_row,1));
					String namelist = model_table.getValueAt(i_row, 1) +"";
					System.out.println("name_delete"+namelist); 
					
					txt_list_card.setText(namelist);
					System.out.println(txt_list_card.getText());
					
					panel_tools.setVisible(false);
					panel_Create.setVisible(false);
					panel_Create_List.setVisible(false);
					panel_Edit_List.setVisible(false);
					panel_Edit_Card.setVisible(false);
					panel_Edit.setVisible(false);
					panel_Delete_List.setVisible(false);
					panel_Delete_Card.setVisible(true);
					Background_Main.setVisible(false);
				    LoadDBData3JTable(namelist);
	
				} catch (Exception e2) {
					System.err.println("An error occurred: " + e2.getMessage());
					e2.printStackTrace();
					try {
//					dispose();
					JOptionPane.showMessageDialog(panel_Edit_List, "Chọn Sản Phẩm Cần Chỉnh");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			
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
        String sql="select * from list_card Where usercol='"+iduser+"';";
        ResultSet rs=conn.createStatement().executeQuery(sql);
    	int STT=1;
        while(rs.next()){
//			System.out.println("while: " +rs.next());
			String listname = rs.getString("List_Name");
			String cardcol = rs.getString("cardcol");
			String usercol = rs.getString("usercol"); //ten cot hoặc thứ tự cột
            Object []row={STT++,listname, cardcol, usercol};
            dtm_list.addRow(row);
        }
        conn.close();
    }
	public void LoadDBData3JTable(String listname) throws Exception{
			try {
				Connection conn=getConnection();
				System.out.println(listname);
				String sql="select * from card where cardcol='"+listname+"';";
				System.err.println(sql);
				ResultSet rs=conn.createStatement().executeQuery(sql);
//				System.out.println("ngoài while: " +rs.next());
				int STT=1;
				dtm_card.setRowCount(0);
			    dtm_update_card.setRowCount(0);
				while(rs.next()){
//					System.out.println("trong while: " +rs.next());
					String cardcol = rs.getString("cardcol");
					String name = rs.getString("Name");
					String des = rs.getString("Dinh_Nghia"); //ten cot hoặc thứ tự cột\
					System.out.println(cardcol);
				    Object []row={STT++,cardcol,name,des};
				    dtm_card.addRow(row);
				    dtm_update_card.addRow(row);
				}
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
			 //gắn id úsẻr cho "admin"
			List_Card listnote = new List_Card(txt_list_card.getText(),iduser,txt_list_card.getText());
			 this.listDAO.getInstance().Insert(listnote);
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
	 public void InsertsCard() {
		 if(textField_card.getText().trim().isEmpty()||textField_des.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thẻ danh sách!!", "Đây là cửa số thông báo", 
		                JOptionPane.ERROR_MESSAGE);
		 }else {
			Card cardnote = new Card(txt_list_card.getText(),textField_card.getText(),textField_des.getText());
			 this.cardDAO.getInstance().Insert(cardnote);
			 clearCard();
		 }
	}
	 
	 public void InsertsCardEnd() {
		 if(textField_card.getText().trim().isEmpty()||textField_des.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thẻ danh sách!!", "Đây là cửa số thông báo", 
		                JOptionPane.ERROR_MESSAGE);
		 }else {
			Card cardnote = new Card(txt_list_card.getText(),textField_card.getText(),textField_des.getText());
			 this.cardDAO.getInstance().Insert(cardnote);
			 try {
				dispose();
				JOptionPane.showMessageDialog(new Home_Login(iduser), "Đã lưu thành công bộ card: "+txt_list_card.getText(), "Đây là cửa số thông báo", 
		                JOptionPane.PLAIN_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 }
	}

	public void DeleteCard() {
		DefaultTableModel model_table = (DefaultTableModel) table1.getModel();
		int i_row = table1.getSelectedRow();
		String namelist = model_table.getValueAt(i_row, 1) + "";
		String tes = model_table.getValueAt(i_row, 2) + "";
		String des = model_table.getValueAt(i_row, 3) + "";
		Card cardnote = new Card(namelist, tes, des);
		this.cardDAO.getInstance().Delete(cardnote);
		try {
			JOptionPane.showMessageDialog(new Home_Login(iduser), "Đã xóa !", "Đây là cửa số thông báo",
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

		Card cardnote = new Card(txt_list_card.getText(),textField_nameedit.getText(),textField_desedit.getText());
		 this.cardDAO.getInstance().Update(cardnote);
			try {
				JOptionPane.showMessageDialog(new Home_Login(iduser), "Đã cập nhật !", "Đây là cửa số thông báo", 
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
		 DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int i_row = table.getSelectedRow();
			String namelist = model_table.getValueAt(i_row, 1) +"";
			String cardcol = model_table.getValueAt(i_row, 2) +"";
			String usercol = model_table.getValueAt(i_row, 3) +"";
		List_Card listnote = new List_Card(cardcol,usercol,namelist);
		System.out.println(cardcol+" "+usercol+" "+namelist);
		 this.listDAO.getInstance().Delete(listnote);
			try {
				JOptionPane.showMessageDialog(new Home_Login(iduser), "Đã xóa !", "Đây là cửa số thông báo", 
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
