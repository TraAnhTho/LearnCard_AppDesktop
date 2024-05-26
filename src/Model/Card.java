package Model;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
    @Column(name = "cardcol")
	private String cardcol;
    @Column(name = "Dinh_Nghia")
	private String Definition;
	@Id
	private String Name_Card;
//	private ArrayList<FlashCard> CardList;

	public Card() {
		//rong
	}
	public Card( String name_Card,String definition) {
		super();
		Definition = definition;
		Name_Card = name_Card;
	}
	public Card(String cardcol, String name_Card, String definition) {
		super();
		this.cardcol = cardcol;
		Definition = definition;
		Name_Card = name_Card;
	}
	
	public String getDefinition() {
		return Definition;
	}

	public void setDefinition(String definition) {
		Definition = definition;
	}

	public String getName_Card() {
		return Name_Card;
	}

	public void setName_Card(String name_Card) {
		Name_Card = name_Card;
	}
	public String getCardcol() {
		return cardcol;
	}
	public void setCardcol(String cardcol) {
		this.cardcol = cardcol;
	}
	@Override
	public String toString() {
		return "Card [cardcol=" + cardcol + ", Definition=" + Definition + ", Name_Card=" + Name_Card + "]";
	}
	
	
	
}

