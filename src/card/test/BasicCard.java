package card.test;

public class BasicCard extends Card {
	private double balance;

	public BasicCard() {
		setBalance(0);
		setAdvantage(0.05);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
