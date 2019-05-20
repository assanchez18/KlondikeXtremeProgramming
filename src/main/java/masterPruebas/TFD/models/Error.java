package masterPruebas.TFD.models;

public enum Error {

	EMPTY_STOCK("empty stock"), EMPTY_WASTE("empty waste"), EMPTY_FOUNDATION("empty foundation"),
	EMPTY_PILE("empty pile"), NO_EMPTY_STOCK("no empty stock"), NO_FIT_FOUNDATION("no fit foundation"),
	NO_FIT_PILE("no fit pile"), SAME_PILE("same pile"), NO_ENOUGH_CARDS_PILE("no enough cards pile");

	private String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}