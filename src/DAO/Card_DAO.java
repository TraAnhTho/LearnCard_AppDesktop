package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC_KetNoi.JDBC_KetNoi;
import Model.Card;
import Model.List_Card;
import Model.User;

public class Card_DAO implements DAOinterface<Card> {
	// static: tái sử dụng hàm ko cần phải khởi tạo đối tượng
	public static Card_DAO getInstance() {
		return new Card_DAO();
	}

	@Override
	public int Insert(Card t) {
		// Them 1 card vào db
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "INSERT INTO flash_card.`card` (STT,`cardcol`,`Name`,`Dinh_Nghia`,`usercol`)" + "VALUES ("
					+ null + ", '" + t.getCardcol() + "', '" + t.getName_Card() + "', '" + t.getDefinition() + "', '"
					+ t.getUsercol() + "');";
			check = st.executeUpdate(sql);

			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);
			System.out.println("Có: " + check + " dòng bị thay đổi");

			// Bước 5: Ngắt kết nối
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
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "UPDATE flash_card.`card` SET " + "`Dinh_Nghia`='" + t.getDefinition() + "'WHERE `Name`='"
					+ t.getName_Card() + "';";
			check = st.executeUpdate(sql);

			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);
			System.out.println("Có: " + check + " dòng bị thay đổi");

			// Bước 5: Ngắt kết nối
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
		int check = 0;
		System.out.println(t.getName_Card());
		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "DELETE FROM flash_card.`card`" + "WHERE `Name`='" + t.getName_Card() + "';";
			check = st.executeUpdate(sql);

			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);
			System.out.println("Có: " + check + " dòng bị thay đổi");

			// Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<Card> selectAll() {
		// lấy all card
		ArrayList<Card> Ketqua = new ArrayList<Card>();

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`card`;";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				int STT = rs.getInt("STT");
				String cardcol = rs.getString("cardcol"); // ten cot hoặc thứ tự cột
				String name = rs.getString("Name");
				String des = rs.getString("Dinh_Nghia");
				String us = rs.getString("usercol");

				Card cardd = new Card(cardcol, des, name);
			}

			// In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);

			// Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Ketqua;
	}

	@Override
	public Card selectById(Card t) {
		// lấy 1 card
		Card Ketqua = null;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`card` WHERE card='" + t.getCardcol() + "' AND usercol ='"
					+ t.getUsercol() + "';";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				int STT = rs.getInt("STT");
				String cardcol = rs.getString("cardcol"); // ten cot hoặc thứ tự cột
				String name = rs.getString("Name");
				String des = rs.getString("Dinh_Nghia");

				Card cardd = new Card(cardcol, des, name);
			}

			// In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);

			// Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Ketqua;
	}

	@Override
	public ArrayList<Card> selectByCondition(String condition) {
		// lấy 1 card
		ArrayList<Card> Ketqua = new ArrayList<Card>();

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`card` WHERE" + condition + ";";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				int STT = rs.getInt("STT");
				String cardcol = rs.getString("cardcol"); // ten cot hoặc thứ tự cột
				String name = rs.getString("Name");
				String des = rs.getString("Dinh_Nghia");

				Card cardd = new Card(cardcol, des, name);
			}

			// In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);

			// Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Ketqua;
	}

	public int CreateButtonCard(Card t) {
		// Them 1 card vào db
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "INSERT INTO flash_card.`card` (STT,`cardcol`,`Name`,`Dinh_Nghia`)" + "VALUES (" + null + ", '"
					+ t.getCardcol() + "', '" + t.getName_Card()
					// can sua
					// them thread vào để dispose cua so van chạy
					+ "', '" + t.getDefinition() + "');";
			check = st.executeUpdate(sql);

			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);
			System.out.println("Có: " + check + " dòng bị thay đổi");

			// Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	
	public int UpdateOtherCard(Card t,String temp) {
		// sửa 1 card
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "UPDATE flash_card.`card` SET `Name`='"
					+ t.getName_Card() + "' , " + "`Dinh_Nghia`='" + t.getDefinition() + "'WHERE `cardcol`='"+ t.getCardcol()+"' AND `Name`='"
					+ temp + "';";
			

			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);
			System.out.println("Có: " + check + " dòng bị thay đổi");

			check = st.executeUpdate(sql);
			
			// Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
}
