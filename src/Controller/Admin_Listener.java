package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;
import View.admin_view;

public class Admin_Listener implements ActionListener{
	private User_DAO userdao;
	private List_DAO listdao;
	private Card_DAO carddao;
	private admin_view adview;
	
	public Admin_Listener(admin_view adview) {
		super();
		this.adview = adview;
	}
	
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút: "+src);
		
//		if(src.equals(login.btn_dangki.getText())){
//			System.out.println("Dang ki click");
//			this.login.InsertsUser();
//		}else if(src.equals(login.btn_dangnhap.getText())){
//			System.out.println("Dang nhap click");
//			this.login.SelectById();
//		}
	}
	
	
	
}
