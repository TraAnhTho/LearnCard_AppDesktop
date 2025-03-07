package TestMain;

import java.util.ArrayList;

import DAO.User_DAO;
import Model.User;

public class User_Test {
	public static void main(String[] args) {
		// TEST INSRRT
//		// nhập dữ liệu cho user
//		User user1= new User("user1", "user1", "user1");
//		User user2= new User("user2", "user2", "user2");
//		// getinstance để khởi tạo hàm
//		// insert là hàm thêm của user_dao
//		User_DAO.getInstance().Insert(user2);
//		
//		
//		//tạo nhieu user
//		for(int i =1; i<5; i++) {
//			User user= new User("user"+i, "user"+i, "user"+i);
//			User_DAO.getInstance().Insert(user);
//		}

		// TEST UPDATE
//		//sua user1 
//		User user= new User("user1", "user1", "user1");
//		User_DAO.getInstance().Update(user);

		// TEST DELETE
//		for(int i =1; i<5; i++) {
//			User user= new User("user"+i, "user"+i, "user"+i);
//			User_DAO.getInstance().Delete(user);
//		}

		ArrayList<User> listuser = User_DAO.getInstance().selectAll();
		for (User user : listuser) {
			System.out.println(user.toString());
		}

		User find = new User();
		find.setUsercol("user");
		User us = User_DAO.getInstance().selectById(find);
		System.out.println(us);
	}
}
