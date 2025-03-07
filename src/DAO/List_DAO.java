package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC_KetNoi.JDBC_KetNoi;
import Model.List_Card;
import Model.User;

public class List_DAO implements DAOinterface<List_Card> {
	// static: tái sử dụng hàm ko cần phải khởi tạo đối tượng
	public static List_DAO getInstance() {
		return new List_DAO();

	}

	@Override
	public int Insert(List_Card t) {
		// Them 1 LIST vào db
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "INSERT INTO flash_card.`list_card` (STT,`List_Name`,`cardcol`,`usercol`)" + "VALUES (" + null
					+ ", '" + t.getName_List() + "', '" + t.getName_List()
					// can sua
					// them thread vào để dispose cua so van chạy
					+ "', '" + t.getUsercol() + "') ON DUPLICATE KEY "
					+ "UPDATE `List_Name` = VALUES(`List_Name`), `cardcol` = VALUES(`cardcol`);";
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
	public int Update(List_Card t) {
		// sửa 1 list
		int check = 0, check1=0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "UPDATE flash_card.`List_Card` SET `List_Name`='" + t.getName_List() + "', `cardcol`='"
					+ t.getName_List() + "'WHERE `usercol`='" + t.getUsercol() + "' AND `cardcol` = '"
							+ t.getCardcol() + "';";
			
			String sql1 = "UPDATE flash_card.`card` SET " + "`cardcol`='" + t.getName_List() + "'WHERE `Name`='"
					+ t.getCardcol() + "';";
			

			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);
			System.out.println("Có: " + check + " dòng bị thay đổi");
			System.out.println("Bạn đã thực thi câu lệnh: " + sql1);
			System.out.println("Có: " + check1 + " dòng bị thay đổi");

			
			check = st.executeUpdate(sql);
			check1 = st.executeUpdate(sql1);
			// Bước 5: Ngắt kết nối
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
		int check = 0;
		int check1 = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "DELETE FROM flash_card.`card`" + " WHERE `cardcol`='" + t.getName_List() + "';";
			String sql1 = "DELETE FROM flash_card.`List_Card`" + " WHERE `cardcol`='" + t.getName_List() + "';";
			check = st.executeUpdate(sql);
			check1 = st.executeUpdate(sql1);

			// Bước 4: In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);
			System.out.println("Bạn đã thực thi câu lệnh: " + sql1);

			System.out.println("Có: " + check + " dòng bị thay đổi");
			System.out.println("Có: " + check1 + " dòng bị thay đổi");

			// Bước 5: Ngắt kết nối
			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<List_Card> selectAll() {
		// lấy all list
		ArrayList<List_Card> Ketqua = new ArrayList<List_Card>();

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`list_card`;";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				String listname = rs.getString("List_Name");
				String cardcol = rs.getString("cardcol");
				String usercol = rs.getString("usercol"); // ten cot hoặc thứ tự cột

//			            Object []row={STT++,listname, cardcol, usercol};
//			            dtm.addRow(row);
				List_Card listcard = new List_Card(cardcol, usercol, listname);
			}

			// In câu lệnh
			System.out.println("Bạn đã thực thi câu lệnh: " + sql);
//					System.out.println("listcarrd: "+listcard);

			// Bước 5: Ngắt kết nối
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Ketqua;
	}

	@Override
	public List_Card selectById(List_Card t) {
		// lấy 1 list
		List_Card Ketqua = null;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`list_card` WHERE cardcol='" + t.getCardcol() + "';";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				int STT = rs.getInt("STT");
				String listname = rs.getString("List_Name");
				String cardcol = rs.getString("cardcol");
				String usercol = rs.getString("usercol"); // ten cot hoặc thứ tự cột

				List_Card listcard = new List_Card(cardcol, usercol, listname);
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
	public ArrayList<List_Card> selectByCondition(String condition) {
		// lấy 1 list
		ArrayList<List_Card> Ketqua = new ArrayList<List_Card>();

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`list_card` WHERE" + condition + ";";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				int STT = rs.getInt("STT");
				String listname = rs.getString("List_Name");
				String cardcol = rs.getString("cardcol");
				String usercol = rs.getString("usercol"); // ten cot hoặc thứ tự cột

				List_Card listcard = new List_Card(cardcol, usercol, listname);
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

	public int CreateButtonList(List_Card t) {
		// Them 1 LIST vào db
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "INSERT INTO flash_card.`list_card` (STT,`List_Name`,`cardcol`,`usercol`)" + "VALUES (" + null
					+ ", '" + t.getName_List() + "', '" + t.getName_List()
					// can sua
					// them thread vào để dispose cua so van chạy
					+ "', '" + t.getUsercol() + "') ON DUPLICATE KEY "
					+ "UPDATE `List_Name` = VALUES(`List_Name`), `cardcol` = VALUES(`cardcol`);";
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

}
