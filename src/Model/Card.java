package Model;

public class Card {
	private String Definition;
	private String Name_Card;
	
	public Card(String definition, String name_Card) {
		super();
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
	
	
}

