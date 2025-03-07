package Controller;

import DAO.User_DAO;
import Model.User;

public class User_Server {
	public void InsertUser(User u) {
		User_DAO.getInstance().Insert(u);
	}

	public void UpdateUser(User u) {
		User_DAO.getInstance().Update(u);
	}

	public void DeleteUser(User u) {
		User_DAO.getInstance().Delete(u);
	}
//	public void InsertUser(User u) {
//		 User_DAO.getInstance().Insert(u);
//		}
//	
}
