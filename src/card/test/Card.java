package card.test;

public abstract class Card {
	protected int cardNumber;
	protected double advantage;

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int id) {
		this.cardNumber = id;
	}

	public double getAdvantage() {
		return advantage;
	}

	public void setAdvantage(double advantage) {
		this.advantage = advantage;
	}

	abstract void printCardDetails();
}
