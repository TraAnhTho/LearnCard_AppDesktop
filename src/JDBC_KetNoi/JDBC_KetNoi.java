package JDBC_KetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//public class JDBC_KetNoi {
//	Statement stmt;
//	Connection con;
//	public JDBC_KetNoi() {
//		try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            try {
//                this.con = DriverManager.getConnection("jdbc"
//                        + ":mysql://localhost:3306/hethongminimart?useUnicode=yes&characterEncoding=UTF-8","root","081105");
//                this.stmt = con.createStatement();
//                //stmt.executeUpdate("insert into student values(\"183\", \"Nguyet\", \"20\", \"18T3\")");
//                //stmt.executeUpdatoe ("insert into lop values(\"183\", \"18T3\")");
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//	}
//}

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class JDBC_KetNoi{
	public static Connection getConnection() {
		Connection c = null;
//	public static void main(String[] args) throws SQLException {
		
	
		
		try {
			// Đăng ký MySQL Driver với DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			// Các thông số
				String url = "jdbc:mysql://localhost:3306/flash_card?useSSL=false";
				String username = "root";
				String password = "081105";
			
			// Tạo kết nối
				c = DriverManager.getConnection(url, username, password);
				
//				System.out.println("Thành công!!!");
			
		} catch (SQLException e) {
			System.out.println("Thất bại!!!");
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}