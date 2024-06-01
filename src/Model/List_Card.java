package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "list_card")
public class List_Card {
	@Id
	@GeneratedValue
	private int ID;
	@Column(name = "cardcol")
	private String cardcol;
	@Column(name = "usercol")
	private String usercol;
	@Column(name = "List_Name")
	private String Name_List;

	public List_Card(String cardcol, String usercol, String name_List) {
		super();
		this.cardcol = cardcol;
		this.usercol = usercol;
		Name_List = name_List;
	}

	public List_Card() {
		super();
	}

	public String getCardcol() {
		return cardcol;
	}

	public void setCardcol(String cardcol) {
		this.cardcol = cardcol;
	}

	public String getUsercol() {
		return usercol;
	}

	public void setUsercol(String usercol) {
		this.usercol = usercol;
	}

	public String getName_List() {
		return Name_List;
	}

	public void setName_List(String name_List) {
		Name_List = name_List;
	}

	@Override
	public String toString() {
		return "List_Card [cardcol=" + cardcol + ", usercol=" + usercol + ", Name_List=" + Name_List + "]";
	}

}
