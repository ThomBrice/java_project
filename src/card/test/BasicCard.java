package card.test;

public class BasicCard extends Card {
	private double balance;

	public BasicCard(int cardNum) {
		setBalance(0);
		setAdvantage(0.05);
		setCardNumber(cardNum);
	}

	public BasicCard(int cardNum, double bal) {
		setCardNumber(cardNum);
		setBalance(bal);
		setAdvantage(0.05);
	}

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
