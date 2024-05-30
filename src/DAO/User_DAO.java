package DAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import JDBC_KetNoi.JDBC_KetNoi;
import Model.User;
import View.Home_Login;
import View.Login;

public class User_DAO implements DAOinterface<User> {
	// static: tái sử dụng hàm ko cần phải khởi tạo đối tượng
	public static User_DAO getInstance() {
		return new User_DAO();
	}

	@Override
	public int Insert(User t) {
		// Them 1 user vào db
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "INSERT INTO flash_card.`user` (`STT`,`usercol`, `idUser`,`pass`)" + "VALUES (" + null + ", '"
					+ t.getIdUser() + "', '" + t.getIdUser() + "', '" + t.getPassWord()
					+ "') ON DUPLICATE KEY UPDATE `pass` = VALUES(`pass`), `usercol` = VALUES(`usercol`);";
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
	public int Update(User t) {
		// sửa 1 user
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "UPDATE flash_card.`user` SET " + "`pass`='" + t.getPassWord() + "'WHERE `idUser`='"
					+ t.getIdUser() + "';";
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
	public int Delete(User t) {
		// Xóa 1 user
		int check = 0;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "DELETE FROM flash_card.`user`" + "WHERE `idUser`='" + t.getIdUser() + "';";
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
	public ArrayList<User> selectAll() {
		// lấy all user
		ArrayList<User> Ketqua = new ArrayList<User>();

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`user`;";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				int STT = rs.getInt("STT");
				String usercol = rs.getString("usercol"); // ten cot hoặc thứ tự cột
				String iduser = rs.getString("iduser");
				String pass = rs.getString("pass");

				User user = new User(usercol, iduser, pass);
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
	public User selectById(User t) {
		// lấy 1 user
		User Ketqua = null;

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`user` WHERE usercol='" + t.getUsercol() + "';";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				int STT = rs.getInt("STT");
				String usercol = rs.getString("usercol"); // ten cot hoặc thứ tự cột
				String iduser = rs.getString("iduser");
				String pass = rs.getString("pass");

				User user = new User(usercol, iduser, pass);
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
	public ArrayList<User> selectByCondition(String condition) {
		// lấy all user
		ArrayList<User> Ketqua = new ArrayList<User>();

		try {
			// Bước 1: Tạo kết nối
			Connection c;
			c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`user` WHERE" + condition + ";";

			// resultset giống như 1 cái bảng mình có thể lấy từng giống bên trong
			ResultSet rs = st.executeQuery(sql);

			// Bước 4:
			while (rs.next()) {
				int STT = rs.getInt("STT");
				String usercol = rs.getString("usercol"); // ten cot hoặc thứ tự cột
				String iduser = rs.getString("iduser");
				String pass = rs.getString("pass");

				User user = new User(usercol, iduser, pass);
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

	public int Dang_Ki(User t) {
		int check = 0;
		try {
			String url = "jdbc:mySQL://localhost:3306/flash_card";
			String username = "root";
			String password = "081105";
			// Tạo kết nối
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM flash_card.`user` WHERE `idUser` = '" + t.getIdUser() + "';");
			System.out.println(ps);
			ResultSet Rs = ps.executeQuery();
			System.out.println(Rs);
			if (Rs.next() == true) {
				JOptionPane.showMessageDialog(new Login(), "Tài khoản đã tồn tại!!!");
				System.out.println("success");

			} else if (Rs.next() == false) {
				// Bước 1: Tạo kết nối
				Connection c = JDBC_KetNoi.getConnection();

				// Bước 2: Tạo ra đối tượng statement
				Statement st = c.createStatement();

				// Bước 3: Thực thi một câu lệnh SQL
				String sql = "INSERT INTO flash_card.`user` (`STT`,`usercol`,`idUser`,`pass`)" + "VALUES (" + null
						+ ", '" + t.getIdUser() + "', '" + t.getIdUser() + "', '" + t.getPassWord()
						+ "') ON DUPLICATE KEY UPDATE `pass` = VALUES(`pass`), `usercol` = VALUES(`usercol`);";
				check = st.executeUpdate(sql);
//				JOptionPane.showMessageDialog(new Home_Login(t.getIdUser()), "Đăng kí thành công!!!");
				c.close();

			}
		} catch (Exception e2) {
//				dispose();
			System.err.println("An error occurred: " + e2.getMessage());
			e2.printStackTrace();
		}
		return check;
	}

	public ArrayList<User> DangNhap(String id, String mk) {
		// lấy all user
		ArrayList<User> Ketqua = new ArrayList<User>();
		try {
			String url = "jdbc:mySQL://localhost:3306/flash_card";
			String username = "root";
			String password = "081105";
			// Bước 1: Tạo kết nối
			Connection c = JDBC_KetNoi.getConnection();

			// Bước 2: Tạo ra đối tượng statement
			Statement st = c.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sql = "SELECT * FROM flash_card.`user` WHERE `idUser` = '" + id + "' AND `pass` = '" + mk + "';";
			System.out.println("sql: " + sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs);

			if (rs.next()) {
				JOptionPane.showMessageDialog(new Home_Login(id), "Đăng nhập thành công!!!");
				System.out.println("success");
				c.close();

			} else {
				JOptionPane.showMessageDialog(new Login(), "Tài khoản KHÔNG tồn tại!!!");
				System.out.println("Tài khoản chưa tồn tại!!!");
				c.close();
			}
		} catch (Exception e2) {
			System.err.println("An error occurred: " + e2.getMessage());
			e2.printStackTrace();
		}
		return Ketqua;
	}

}
