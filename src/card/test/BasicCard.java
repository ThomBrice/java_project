package card.test;

/**
 * La classe BasicCard représente une carte de fidélité basique
 * Elle hérite de la classe abstraite Card
 *
 * Une carte de fidélité basique comporte une cagnotte qui peut être utilisée lors du réglement;
 * Lors de chaque achat 5% du montant de la facture vont sur la cagnotte.
 *
 */
public class BasicCard extends Card {
	/**
	 * Cagnotte de la carte basique.
	 */
	private double balance;

	/**
	 * Constructeur 1 de la classe BasicCard
	 * Ce constructeur est appelé lors de la création d'un nouveau compte.
	 * @see Store#createCard(int)
	 * @param cardNum : numéro de carte
     */
	public BasicCard(int cardNum) {
		setBalance(0);
		setAdvantage(0.05);
		setCardNumber(cardNum);
	}

	/**
	 * Constructeur 2 de la classe BasicCard
	 * Ce constructeur est utilisé pour créer les objets BasicCard déjà existants qui sont stockés dans le fichier .txt
	 * @param cardNum : numéro de carte
	 * @param bal : montant de la cagnotte
     */
	public BasicCard(int cardNum, double bal) {
		setCardNumber(cardNum);
		setBalance(bal);
		setAdvantage(0.05);
	}

	/**
	 * Affiche les détails la carte basique.
	 */
	@Override
	public void printCardDetails(){
		System.out.println("\nVous avez la carte de fidelité basique.");
		System.out.println("Lors de chaque achat, 5% du montant de la facture vont sur la cagnote de votre carte.");
		System.out.println("Vous avez : " + getBalance() + "euros sur votre carte. \n");
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
