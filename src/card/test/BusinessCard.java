package card.test;

public class BusinessCard extends Card {

	private String companyName;

	public BusinessCard(int cardNum, String company) {
		setCompanyName(company);
		setAdvantage(0.2);
		setCardNumber(cardNum);
	}

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
