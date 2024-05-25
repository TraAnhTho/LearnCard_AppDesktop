package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import JDBC_KetNoi.JDBC_KetNoi;

public class demo {
//	btn_dangnhap.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		try {
//			String url = "jdbc:mySQL://localhost:3306/hethongminimart";
//			String username = "root";
//			String password = "081105";
//			// Tạo kết nối
//			Connection con = DriverManager.getConnection(url, username, password);
//			PreparedStatement ps = con.prepareStatement("SELECT * FROM flash_card.`user` WHERE `idUser` = '" +textField_user.getText()+"';");
//			System.out.println(ps);
//			ResultSet Rs = ps.executeQuery();
//			System.out.println(Rs);
//			System.out.println(Rs.next());
//
//			if(Rs.next()==true) {
//				JOptionPane.showMessageDialog(new Login(), "Tài khoản đã tồn tại!!!");
//				System.out.println("success");
//
//			}else if(Rs.next()==false) {
//				System.out.println("fail");
//
//				JOptionPane.showMessageDialog(new Login(), "Tài khoản chưa tồn tại!!!");
//				// Bước 1: Tạo kết nối
//				Connection c = JDBC_KetNoi.getConnection();
//				
//				// Bước 2: Tạo ra đối tượng statement
//				Statement st = c.createStatement();
//				
//				// Bước 3: Thực thi một câu lệnh SQL
//				String sql = "INSERT INTO flash_card.`user` (`STT`,`usercol`, `idUser`,`pass`)"
//						+ "VALUES ("+null
//						+", '"+ textField_user.getText()
//						+"', '"+ textField_user.getText()
//						+"', '"+ textField_pass.getText()
//						+"') ON DUPLICATE KEY UPDATE `pass` = VALUES(`pass`), `usercol` = VALUES(`usercol`);";
//				int check = st.executeUpdate(sql);
//		
//				c.close();
////				Clear();				
////				dispose();
//				JOptionPane.showMessageDialog(new Home_Login(), "Đã Lưu");	
//			}	
//			} catch (Exception e2) {
//				dispose();
//				System.err.println("An error occurred: " + e2.getMessage());
//	            e2.printStackTrace();
//		}
//	}
//});
	
	
	
//	btn_dangki.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {		
//			try {
//				String url = "jdbc:mySQL://localhost:3306/flash_card";
//				String username = "root";
//				String password = "081105";
//				// Bước 1: Tạo kết nối
//				Connection c = JDBC_KetNoi.getConnection();
//				
//				// Bước 2: Tạo ra đối tượng statement
//				Statement st = c.createStatement();
//				
//				// Bước 3: Thực thi một câu lệnh SQL
//				String sql = "SELECT * FROM flash_card.`user` WHERE `idUser` = '"
//				+ textField_user.getText()
//				+"' AND `pass` = '"
//						+ textField_pass.getText()+"';";
//				System.out.println("sql: "+sql);
//				ResultSet check = st.executeQuery(sql);
//				System.out.println("check: "+check);
//		
//				c.close();
////				dispose();
//				//can sua
//				JOptionPane.showMessageDialog(new Home_Login(), "Đã Đăng Nhập");
//				
//				
//			} catch (Exception e2) {
//				System.err.println("An error occurred: " + e2.getMessage());
//	            e2.printStackTrace();
//			}
//		}
//	});

}
