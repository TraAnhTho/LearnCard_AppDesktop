package Model;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id // khóa chính
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name = "usercol")
	private String usercol;
	@Column(name = "idUser")
	private String idUser;
	@Column(name = "pass")
	private String passWord;

	public User(String usercol, String idUser, String passWord) {
		this.usercol = usercol;
		this.idUser = idUser;
		this.passWord = passWord;
	}

	public User() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	@Override
	public String toString() {
		return "User [usercol=" + usercol + ", idUser=" + idUser + ", passWord=" + passWord + "]";
	}

}
