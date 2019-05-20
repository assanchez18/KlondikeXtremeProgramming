package masterPruebas.TFD.models;

public enum Suit {
	HEARTS(Color.RED, 'H'), DIAMONDS(Color.RED, 'D'), CLOVERS(Color.BLACK,'C'), PIKES(Color.BLACK,'P');

	private Color color;
    private char initial;
	Suit(Color color, char initial) {
		this.color = color;
		this.initial = initial;
		
	}
	public static Suit find(char initial) {
		switch (initial) {
		case 'H':
		case 'h':
			return Suit.HEARTS;
		case 'D':
		case 'd':
			return Suit.DIAMONDS;
		case 'C':
		case 'c':
			return Suit.CLOVERS;
		case 'P':
		case 'p':
			return Suit.PIKES;
		default:
			return null;
		}
	}

	public static char[] initials() {
		return new char[] {Suit.HEARTS.initial, Suit.DIAMONDS.initial,Suit.CLOVERS.initial,Suit.PIKES.initial};
	}
	
	public Color getColor() {
		return this.color;
	}
}
