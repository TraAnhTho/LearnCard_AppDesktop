package Model;

import java.util.ArrayList;

public class Card {
	private String cardcol;
	private String Definition;
	private String Name_Card;
//	private ArrayList<FlashCard> CardList;

	public Card() {
		//rong
	}
	public Card(String definition, String name_Card) {
		super();
		Definition = definition;
		Name_Card = name_Card;
	}
	public Card(String cardcol, String definition, String name_Card) {
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
	
	
	
}

