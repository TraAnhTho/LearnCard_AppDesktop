package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC_KetNoi.JDBC_KetNoi;
import Model.Card;

public class Card_DAO implements DAOinterface<Card>{
	//static: tái sử dụng hàm ko cần phải khởi tạo đối tượng
	public static Card_DAO getInstance() {
		return new Card_DAO();	
	}
	@Override
	public int Insert(Card t) {
		// Them 1 card vào db
				int check=0;
				
				try {
					//Bước 1: Tạo kết nối
					Connection c;
					c = JDBC_KetNoi.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					Statement st = c.createStatement();
					
					// Bước 3: Thực thi một câu lệnh SQL
					String sql = "INSERT INTO flash_card.`card` (STT,`cardcol`,`Name`,`Dinh_Nghia`)"
							+ "VALUES ("+null
							+", '"+ t.getCardcol()
							+"', '"+ t.getName_Card()
							+"', '"+ t.getDefinition()
							+"');";
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
	public int Update(Card t) {
		// sửa 1 card
		int check=0;
		
		try {
			//Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();
			
			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "UPDATE flash_card.`card` SET "
					+ "`Dinh_Nghia`='"+ t.getDefinition()
					+"'WHERE `Name`='"+ t.getName_Card()+"';";
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
	public int Delete(Card t) {
		// Xóa 1 card
		int check=0;
		
		try {
			//Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();
			
			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "DELETE FROM flash_card.`user`"
					+"WHERE `Name`='"+ t.getName_Card()+"';";
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
	public ArrayList<Card> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card selectById(Card t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Card> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
