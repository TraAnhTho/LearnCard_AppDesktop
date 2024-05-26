package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.User_DAO;
import Model.User;
import View.Login;

public class User_Listener implements ActionListener{
	private User_DAO userdao;
	private Login login;
	
	
	
	public User_Listener(Login login) {
		super();
		this.login = login;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút: "+src);
		
		if(src.equals(login.btn_dangki.getText())){
			System.out.println("Dang ki click");
			this.login.InsertsUser();
		}else if(src.equals(login.btn_dangnhap.getText())){
			System.out.println("Dang nhap click");
			this.login.SelectById();
		}
	}
	
}
