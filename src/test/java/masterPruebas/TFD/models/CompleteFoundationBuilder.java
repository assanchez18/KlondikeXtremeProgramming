package masterPruebas.TFD.models;

public class CompleteFoundationBuilder {
	
FoundationBuilder foundationBuilder;
	
	CompleteFoundationBuilder(){
		this.foundationBuilder = new FoundationBuilder();
		this.foundationBuilder
		.card(new CardBuilder().number(Number.AS).build()) 
		.card(new CardBuilder().number(Number.TWO).build())
		.card(new CardBuilder().number(Number.THREE).build())
		.card(new CardBuilder().number(Number.FOUR).build())
		.card(new CardBuilder().number(Number.FIVE).build())
		.card(new CardBuilder().number(Number.SIX).build())
		.card(new CardBuilder().number(Number.SEVEN).build())
		.card(new CardBuilder().number(Number.EIGHT).build())
		.card(new CardBuilder().number(Number.NINE).build())
		.card(new CardBuilder().number(Number.TEN).build())
		.card(new CardBuilder().number(Number.JACK).build())
		.card(new CardBuilder().number(Number.QUEEN).build())
		.card(new CardBuilder().number(Number.KING).build());
		}
	
	public Foundation build() {
		return foundationBuilder.build();
	}
	
	public CompleteFoundationBuilder suit(Suit suit) {
		this.foundationBuilder.suit(suit);
		return this;
	}

}