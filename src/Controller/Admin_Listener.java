package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;
import View.admin_view;
import design.FButton;

public class Admin_Listener implements ActionListener {
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
		System.out.println("Bạn đã nhấn nút: " + src);

		if (src.equals(adview.btn_addUsser.getText())) {
			this.adview.InsertsUser();
		} else if (src.equals(adview.btn_editUser.getText())) {
			this.adview.UpdateUser();
		} else if (src.equals(adview.btn_editList.getText())) {
			this.adview.UpdateList();
		} else if (src.equals(adview.btn_editCard.getText())) {
			this.adview.UpdateCard();
		} else if (src.equals(adview.btn_detele_user.getText())) {
			this.adview.DeleteUser();
		} else if (src.equals(adview.btn_delete_list.getText())) {
			this.adview.DeleteList();
		} else if (src.equals(adview.btn_detele_card.getText())) {
			this.adview.DeleteCard();
		}
	}

}
