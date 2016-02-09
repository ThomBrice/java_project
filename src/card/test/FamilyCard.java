package card.test;
/**
 * La classe FamiliyCard représente une carte de fidélité pour famille nombreuse
 * Elle hérite de la classe abstraite Card
 *
 * Une carte de fidélité Famille donne un avantage de 2% par enfant.
 * Cet avantage est immédiatement déduit sur la facture.
 *
 */
public class FamilyCard extends Card {
	/**
	 * Nombre d'enfant.
	 */
	private int numberOfChild;

	/**
	 * Constructeur de la classe FamilyCard
	 * @param cardNum : numéro de carte
	 * @param num : nombre d'enfants
     */
	public FamilyCard(int cardNum, int num) {
		setNumberOfChild(num);
		double advantage = num * 0.02; // gain de 2% par enfant
		setAdvantage(advantage);
		setCardNumber(cardNum);
	}

	/**
	 * Affiche les détails de la carte de fidélité pour famille
	 */
	@Override
	public void printCardDetails(){
		System.out.println("\nVous avez la carte de fidelité pour famille nombreuse.");
		System.out.println("Vous avez " + getNumberOfChild() + " enfants.");
		System.out.println("Le montant de votre réduction s'élève donc à " + getAdvantage()*100 + "%." + "\n");
	}

	public int getNumberOfChild() {
		return numberOfChild;
	}

	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}
}
