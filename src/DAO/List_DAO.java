package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC_KetNoi.JDBC_KetNoi;
import Model.List_Card;

public class List_DAO implements DAOinterface<List_Card> {
	//static: tái sử dụng hàm ko cần phải khởi tạo đối tượng
	public static List_DAO getInstance() {
		return new List_DAO();
		
	}
	
	
	@Override
	public int Insert(List_Card t) {
		// Them 1 LIST vào db
				int check=0;
				
				try {
					//Bước 1: Tạo kết nối
					Connection c;
					c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "INSERT INTO flash_card.`list_card` (STT,`List_Name`,`cardcol`,`usercol`)"
							+ "VALUES ("+null
							+", '"+ t.getName_List()
							+"', '"+ t.getName_List()
							//can sua 
							// them thread vào để dispose cua so van chạy
							+"', '"+ t.getUsercol()
							+"') ON DUPLICATE KEY "
							+ "UPDATE `List_Name` = VALUES(`List_Name`), `cardcol` = VALUES(`cardcol`);";
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
	public int Update(List_Card t) {
		// sửa 1 list
				int check=0;
				
				try {
					//Bước 1: Tạo kết nối
					Connection c;
					c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "UPDATE flash_card.`List_Card` SET "
							+ "`List_Name`='"+ t.getName_List()
							+ "`cardcol`='"+ t.getCardcol()
							+"'WHERE `usercol`='"+ t.getUsercol()+"';";
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
	public int Delete(List_Card t) {
		// xóa 1 list
		int check=0;
		
		try {
			//Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();
			
			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "DELETE FROM flash_card.`List_Card`"
					+"'WHERE `cardcol`='"+ t.getName_List()+"';";
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
	public ArrayList<List_Card> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List_Card selectById(List_Card t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List_Card> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}


}
