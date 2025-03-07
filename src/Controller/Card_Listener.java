package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;
import View.Home_Login;

public class Card_Listener implements ActionListener {
	private Card_DAO carddao;
	private List_DAO listdao;
	private Home_Login homelogin;

	public Card_Listener(Home_Login home_Login) {
		this.homelogin = home_Login;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút: " + src);

		if (src.equals(homelogin.btn_create_list.getText())) {
			this.homelogin.InsertsList();
		} else if (src.equals(homelogin.btn_Next.getText())) {
			this.homelogin.InsertsCard();
		} else if (src.equals(homelogin.btnSave.getText())) {
			this.homelogin.InsertsCardEnd();
		} else if (src.equals(homelogin.btn_delete.getText())) {
			System.out.println("1234567890");
			this.homelogin.DeleteCard();
		} else if (src.equals(homelogin.btn_update.getText())) {
			System.out.println("1234567890");
			this.homelogin.UpdateCard();
		} else if (src.equals(homelogin.btn_delete_list.getText())) {
			System.out.println("1234567890");
			this.homelogin.DeleteList();
		}

	}

}