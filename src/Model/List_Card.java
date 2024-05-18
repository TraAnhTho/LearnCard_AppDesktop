package Model;

public class List_Card {
	private String cardcol;
	private String usercol;
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
	
	
}
