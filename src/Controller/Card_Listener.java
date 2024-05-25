package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;
import View.Home_Login;

public class Card_Listener implements ActionListener{
	private Card_DAO carddao;
	private List_DAO listdao;
	private Home_Login homelogin;
	
	public Card_Listener(Home_Login home_Login) {
		this.homelogin = homelogin;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút: "+src);
		
		
		if(src.equals("Create Name List")){
			System.out.println("1234567890");
			this.homelogin.InsertsList();
//		}else if(src.equals("Đăng Nhập")){
//			this.login.SelectById();
		}
	}
	
}