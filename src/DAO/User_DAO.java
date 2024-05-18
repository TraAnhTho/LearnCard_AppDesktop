package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC_KetNoi.JDBC_KetNoi;
import Model.User;

public class User_DAO implements DAOinterface<User>{
	//static: tái sử dụng hàm ko cần phải khởi tạo đối tượng
	public static User_DAO getInstance() {
		return new User_DAO();
	}
	@Override
	public int Insert(User t) {
		// Them 1 user vào db
		int check=0;
		
		try {
			//Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();
			
			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "INSERT INTO flash_card.`user` (`STT`,`usercol`, `idUser`,`pass`)"
					+ "VALUES ("+null
					+", '"+ t.getIdUser()
					+"', '"+ t.getIdUser()
					+"', '"+ t.getPassWord()
					+"') ON DUPLICATE KEY UPDATE `pass` = VALUES(`pass`), `usercol` = VALUES(`usercol`);";
			check = st.executeUpdate(sql);
			
			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: "+sql);
			System.out.println("Có: "+ check +" dòng bị thay đổi");
			
			//Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int Update(User t) {
		// sửa 1 user
		int check=0;
		
		try {
			//Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();
			
			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "UPDATE flash_card.`user` SET "
					+ "`pass`='"+ t.getPassWord()
					+"'WHERE `idUser`='"+ t.getIdUser()+"';";
			check = st.executeUpdate(sql);
			
			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: "+sql);
			System.out.println("Có: "+ check +" dòng bị thay đổi");
			
			//Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int Delete(User t) {
		// Xóa 1 user
				int check=0;
				
				try {
					//Bước 1: Tạo kết nối
					Connection c;
					c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "DELETE FROM flash_card.`user`"
							+"WHERE `idUser`='"+ t.getIdUser()+"';";
					check = st.executeUpdate(sql);
					
					// Bước 4: In câu lệnh
					System.out.println("Bạn đã thực thi câu lệnh: "+sql);
					System.out.println("Có: "+ check +" dòng bị thay đổi");
					
					//Bước 5: Ngắt kết nối
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return check;
	}

	@Override
	public ArrayList<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
