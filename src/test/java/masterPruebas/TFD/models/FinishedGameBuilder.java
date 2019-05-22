package masterPruebas.TFD.models;

public class FinishedGameBuilder {

	GameBuilder gameBuilder;
	
	public FinishedGameBuilder() {
		this.gameBuilder = new GameBuilder();
		for(Suit s : Suit.values()) {
			this.gameBuilder.foundation(new CompleteFoundationBuilder().suit(s).build());
		}
	}
	
	public Game build() {
		return this.gameBuilder.build();
	}
}
