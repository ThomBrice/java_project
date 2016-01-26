package card.test;

public abstract class Card {
	protected int id;
	protected double advantage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAdvantage() {
		return advantage;
	}

	public void setAdvantage(double advantage) {
		this.advantage = advantage;
	}
}
