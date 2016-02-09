package card.test;

/**
 * La classe BusinessCard représente une carte de fidélité pour professionel
 * Elle hérite de la classe abstraite Card
 *
 * Chaque carte de fidelité pour professionel donne un avantage de 20% immédiatement déduit sur la facture.
 */
public class BusinessCard extends Card {
	/**
	 * Nom de la société
	 */
	private String companyName;

	/**
	 * Constructeur de la classe BusinessCard
	 * Il modifie le numéro de carte, le nom de la société et l'avantage de la carte;
	 * @param cardNum : numéro de carte
	 * @param company : nom de la société
     */
	public BusinessCard(int cardNum, String company) {
		setCompanyName(company);
		setAdvantage(0.2);
		setCardNumber(cardNum);
	}

	/**
	 * Affiche les détails de la carte de fidélité pour professionels
	 */
	@Override
	public void printCardDetails(){
		System.out.println("\nVous avez la carte de fidelité pour professionels.");
		System.out.println("Lors de chaque achat, la TVA vous est déduite de la facture, soit 20%.\n");
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
