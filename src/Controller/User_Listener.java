package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.mapping.List;

import DAO.List_DAO;
import DAO.User_DAO;
import DAO.u_Dao;
import Model.User;
import View.Login;

public class User_Listener implements ActionListener {
	private User_DAO userdao;
	private Login login;

	public User_Listener(Login login) {
		this.login = login;
	}
//		login.addButtonClickListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == login.getBtn_dangnhap()) {
//					User_DAO userdao = new User_DAO();
//					String usercol = login.getTextField_user().getText();
//					String pass = login.getTextField_pass().getText();
//					List<u_Dao> userList = u_Dao.getAllUser();
//					
//				}
//			}
//			
//		});
//		
//	}

	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút: " + src);

		if (src.equals(login.btn_dangki.getText())) {
			System.out.println("Dang ki click");
			this.login.InsertsUser();
		} else if (src.equals(login.btn_dangnhap.getText())) {
			System.out.println("Dang nhap click");
			this.login.SelectById();
		}
	}

}
