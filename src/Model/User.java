package Model;

public class User {
	private String usercol;
	private String idUser;
	private String passWord;
	public User(String usercol, String idUser, String passWord) {
		super();
		this.usercol = usercol;
		this.idUser = idUser;
		this.passWord = passWord;
	}
	public User() {
		super();
	}
	public String getUsercol() {
		return usercol;
	}
	public void setUsercol(String usercol) {
		this.usercol = usercol;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
