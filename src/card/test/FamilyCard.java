package card.test;

public class FamilyCard extends Card {
	private int numberOfChild;

	public FamilyCard(int num) {
		setNumberOfChild(num);
		double advantage = num * 0.02;
		setAdvantage(advantage);
	}

	public int getNumberOfChild() {
		return numberOfChild;
	}

	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}
}
