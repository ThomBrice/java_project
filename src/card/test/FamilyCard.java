package card.test;

public class FamilyCard extends Card {
	private int numberOfChild;

	public FamilyCard(int cardNum, int num) {
		setNumberOfChild(num);
		double advantage = num * 0.02; // gain de 2% par enfant
		setAdvantage(advantage);
		setCardNumber(cardNum);
	}

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
