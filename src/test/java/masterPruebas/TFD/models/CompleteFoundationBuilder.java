package masterPruebas.TFD.models;

public class CompleteFoundationBuilder {
	
FoundationBuilder foundationBuilder;
	
	CompleteFoundationBuilder(){
		this.foundationBuilder = new FoundationBuilder();
		for(Number n : Number.values()) {
			this.foundationBuilder.card(new CardBuilder().number(n).build());
		}
		}
	
	public Foundation build() {
		return foundationBuilder.build();
	}
	
	public CompleteFoundationBuilder suit(Suit suit) {
		this.foundationBuilder.suit(suit);
		return this;
	}

}