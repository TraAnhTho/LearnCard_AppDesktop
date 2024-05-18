package View;
import Model.Card;

import java.awt.Button;
import java.awt.Color;
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

import JDBC_KetNoi.JDBC_KetNoi;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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
	private Login login;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lbl_Edit;
	private javax.swing.JPanel panel_tools;
	private javax.swing.JPanel panel_topic;
	private JTextField textField_1;
	private JTextField textField_card;
	private JTextField textField_2;
	private JTextField textField_des;
	protected JComponent panel_Create;
	private JTable table;
	private DefaultTableModel dtm;
	protected JComponent panel_Edit_List;
	protected JComponent panel_Edit_Card;
	protected JComponent panel_Edit;
	protected JComponent panel_Delete;
	private JComponent panel_Create_List;
	private Label lbl_create;
	private Button btn_Next;

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
	 */
	public Home_Login() throws Exception  {
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
		Search.setBounds(638, 0, 368, 60);
		Nav_Bar.add(Search);
		Search.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 11, 239, 38);
		Search.add(textField);
		textField.setColumns(10);
		
		JLabel icon_search = new JLabel("");
		icon_search.setHorizontalAlignment(SwingConstants.CENTER);
		icon_search.setIcon(new ImageIcon(Home_Login.class.getResource("/IMG/icons8-search-26.png")));
		icon_search.setBounds(272, 11, 61, 38);
		Search.add(icon_search);
		
		
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
		
		JTextField textField_List_Card = new JTextField();
		textField_List_Card.setBounds(110, 169, 484, 69);
		panel_Create_List.add(textField_List_Card);
		textField_List_Card.setColumns(10);
		
		JButton btn_create_list = new JButton("Create");
		
		
		btn_create_list.setBounds(657, 169, 211, 69);
		panel_Create_List.add(btn_create_list);
		panel_Create_List.setVisible(false);

		
		JPanel panel_Create = new JPanel();
		panel_Create.setBackground(new Color(40, 46, 62));
		panel_Create.setBounds(0, 57, 1006, 416);
		Interface.add(panel_Create);
		panel_Create.setLayout(null);
		panel_Create.setVisible(false);
//		panel_Edit_List.setVisible(false);
//		panel_Edit_Card.setVisible(false);
//		panel_Edit.setVisible(false);
//		panel_Delete.setVisible(false);
		
		JLabel lblNewLabel0 = new JLabel("TERMINOLOGY:");
		lblNewLabel0.setForeground(new Color(255, 255, 255));
		lblNewLabel0.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel0.setBounds(125, 44, 208, 97);
		panel_Create.add(lblNewLabel0);
		
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
		panel_Edit_List.setBounds(0, 57, 0, 416);
		Interface.add(panel_Edit_List);
		panel_Edit_List.setLayout(null);
		panel_Edit_List.setVisible(false);

		
		//them bảng
		String[]header={"STT", "Tên danh sách"};

        dtm=new DefaultTableModel(header, 0){
        	
       };
//        getContentPane()
        panel_Edit_List.add(new JScrollPane(table=new JTable(dtm)));
        table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
        table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(new Color(118, 203, 33));
//        table.setEditingColumn(null);
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
		
		JButton btn_Chon = new JButton("Chọn");
		
		btn_Chon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Chon.setBounds(746, 330, 112, 41);
		panel_Edit_List.add(btn_Chon);
		
		JPanel panel_Edit_Card = new JPanel();
		panel_Edit_Card.setBackground(new Color(40, 46, 62));
		panel_Edit_Card.setLayout(null);
		panel_Edit_Card.setBounds(0, 57, 0, 416);
		Interface.add(panel_Edit_Card);
		panel_Edit_Card.setVisible(false);

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(137, 110, 721, 209);
		panel_Edit_Card.add(scrollPane_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Chọn danh sách \r\ncần chỉnh sửa");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(137, 54, 239, 45);
		panel_Edit_Card.add(lblNewLabel_2_1);
		
		JButton btn_chinh = new JButton("Chỉnh sửa");
		
		btn_chinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_chinh.setBounds(746, 330, 112, 41);
		panel_Edit_Card.add(btn_chinh);
		
		JButton btn_xoa = new JButton("Xóa");
		
		btn_xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_xoa.setBounds(868, 330, 112, 41);
		panel_Edit_Card.add(btn_xoa);
		
		JPanel panel_Edit = new JPanel();
		panel_Edit.setBackground(new Color(40, 46, 62));
		panel_Edit.setBounds(0, 57, 0, 416);
		Interface.add(panel_Edit);
		panel_Edit.setLayout(null);
		panel_Edit.setVisible(false);
		
		JLabel lblNewLabel1 = new JLabel("TERMINOLOGY:");
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel1.setBounds(125, 44, 208, 97);
		panel_Edit.add(lblNewLabel1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(376, 44, 587, 97);
		panel_Edit.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDefinition1 = new JLabel("DEFINITION:");
		lblDefinition1.setForeground(new Color(255, 255, 255));
		lblDefinition1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDefinition1.setBounds(125, 152, 208, 97);
		panel_Edit.add(lblDefinition1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(376, 152, 587, 97);
		panel_Edit.add(textField_2);
		
		JButton btnNewButton1 = new JButton("Save");
		btnNewButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			
			}
		});
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton1.setBackground(new Color(66, 85, 255));
		btnNewButton1.setBounds(809, 271, 153, 45);
		panel_Edit.add(btnNewButton1);
		
		JPanel panel_Delete = new JPanel();
		panel_Delete.setBackground(new Color(40, 46, 62));
		panel_Delete.setBounds(0, 57, 0, 416);
		Interface.add(panel_Delete);
		panel_Delete.setLayout(null);
		panel_Delete.setVisible(false);

		
		//them bảng
		String[]header3={"STT", "Tên danh sách",};

        dtm=new DefaultTableModel(header3, 0){
        	
       };
       	panel_Delete.add(new JScrollPane(table=new JTable(dtm)));
        table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
        table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(new Color(118, 203, 33));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        JScrollPane scrollPane2 = new JScrollPane(table);
		scrollPane2.setBounds(137, 110, 721, 209);
		panel_Delete.add(scrollPane2);

		//	chèn dữ liệu vào
       LoadDBData2JTable();
		
		JLabel lblNewLabel_2_2 = new JLabel("Chọn danh sách \r\ncần xóa:");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(137, 54, 332, 45);
		panel_Delete.add(lblNewLabel_2_2);
		
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(746, 330, 112, 41);
		panel_Delete.add(btnNewButton_1_2);

		
//		JLabel Background_Main = new JLabel("");
//		Background_Main.setBackground(new Color(40, 46, 62));
//		Background_Main.setBounds(0, 0, 1006, 473);
//		Interface.add(Background_Main);
		
		// chuột
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tools.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Create.setVisible(false);
				panel_Delete.setVisible(false);
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
				panel_Delete.setVisible(false);
				panel_Create_List.setVisible(true);
				
//				try {
//				switchForm(e);
//				System.out.println("ok");
//			} catch (Exception e1) {
//				System.err.println("An error occurred: " + e1.getMessage());
//	            					e1.printStackTrace();
//			}
			}
		});

		lbl_Edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tools.setVisible(false);
				panel_Create.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(true);
				panel_Edit.setVisible(false);
				panel_Delete.setVisible(false);
			}
		});
		lbl_Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tools.setVisible(false);
				panel_Create.setVisible(false);
				panel_Edit_List.setVisible(true);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Delete.setVisible(false);
			}
		});
		btn_Chon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tools.setVisible(false);
				panel_Create.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(true);
				panel_Edit.setVisible(false);
				panel_Delete.setVisible(false);
			}
		});
		btn_chinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_tools.setVisible(false);
				panel_Create.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(true);
				panel_Delete.setVisible(false);
			}
		});
		btn_xoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tools.setVisible(false);
				panel_Create.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Delete.setVisible(true);
			}
		});
		btn_create_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Create.setVisible(true);
				panel_tools.setVisible(false);
				panel_Create_List.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Delete.setVisible(false);
				
				//
				try {
					// Bước 1: Tạo kết nối
					Connection c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "INSERT INTO flash_card.`list_card` (STT,`List_Name`,`cardcol`,`usercol`)"
							+ "VALUES ("+null
							+", '"+ textField_List_Card.getText()
							+"', '"+ textField_List_Card.getText()
							
							//can sua 
							// them thread vào để dispose cua so van chạy
							+"', '"+ "admin"
//							+"', '"+ login.getTextField_user().getText()
							+"') ON DUPLICATE KEY UPDATE `List_Name` = VALUES(`List_Name`), `cardcol` = VALUES(`cardcol`);";
					int check = st.executeUpdate(sql);
			
					c.close();
//					Clear();				
//					dispose();
//					JOptionPane.showMessageDialog((), "Đã Lưu");
				
				//can sua						
				} catch (Exception e2) {
					dispose();
					System.err.println("An error occurred: " + e2.getMessage());
		            e2.printStackTrace();
//					try {
//						JOptionPane.showMessageDialog( panel_Create_List, "Lỗi!");
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
			}
			}
		});
		btn_Next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				switchForm(e);
				panel_tools.setVisible(false);
				panel_Create_List.setVisible(false);
				panel_Edit_List.setVisible(false);
				panel_Edit_Card.setVisible(false);
				panel_Edit.setVisible(false);
				panel_Delete.setVisible(false);
				panel_Create.setVisible(true);
				try {
					// Bước 1: Tạo kết nối
					Connection c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "INSERT INTO flash_card.`card` (STT,`cardcol`,`Name`,`Dinh_Nghia`)"
							+ "VALUES ("+null
							+", '"+ textField_List_Card.getText()
							+"', '"+ textField_card.getText()
							+"', '"+ textField_des.getText()
							+"');";
					int check = st.executeUpdate(sql);
					c.close();
//					dispose();
//					String temp =textField_List_Card.getText();
//					new Home_Login();
//					panel_Create_List.setVisible(true);
//					textField_List_Card.setText(temp);
//					panel_Create.setVisible(true);
//					panel_tools.setVisible(false);
//					panel_Create_List.setVisible(false);
//					panel_Edit_List.setVisible(false);
//					panel_Edit_Card.setVisible(false);
//					panel_Edit.setVisible(false);
//					panel_Delete.setVisible(false);
					
					
					
					
					//can sua					
					
				} catch (Exception e2) {
					try {
						JOptionPane.showMessageDialog( panel_Create_List, "Lỗi!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
//				panel_Create.setVisible(flase);

			}
		});
		
		
		
		
		
		

	}
	
	
//	public void switchForm(EventObject event) {
//        Object source = event.getSource();
//		if(source==lbl_create) {
//			panel_Create.setVisible(false);
//			panel_tools.setVisible(false);
//			panel_Create_List.setVisible(true);
//			panel_Edit_List.setVisible(false);
//			panel_Edit_Card.setVisible(false);
//			panel_Edit.setVisible(false);
//			panel_Delete.setVisible(false);
//		}
//		else if(source==btn_Next) {
//			panel_Create_List.setVisible(true);
//			panel_tools.setVisible(false);
//			panel_Create.setVisible(false);
//			panel_Edit_List.setVisible(false);
//			panel_Edit_Card.setVisible(false);
//			panel_Edit.setVisible(false);
//			panel_Delete.setVisible(false);
//		}
//	}
	
	
	
	public void LoadDBData2JTable() throws Exception{
        Connection conn=getConnection();
        String sql="select *from list_card";
        ResultSet rs=conn.createStatement().executeQuery(sql);
    	int q1=1;
        while(rs.next()){
//            int name = rs.getInt(1);
            String q2 = rs.getString(2);
            Object []row={q1++,q2};
            dtm.addRow(row);
        }
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
