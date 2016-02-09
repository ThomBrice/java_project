package card.test;

/**
 * La classe Card représente la carte de fidélité d'un client.
 * Classe abstraite
 */
public abstract class Card {
	/**
	 * Numéro de carte
	 */
	protected int cardNumber;

	/**
	 * Avantage amené grâce à la carte
	 */
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

	/**
	 * Méthode abstraite d'affichage des détails de la carte.
	 */
	abstract void printCardDetails();
}
