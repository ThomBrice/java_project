package card.test;

public class StudentCard extends Card {
	private String schoolName;

	public StudentCard(int cardNum, String school) {
		setSchoolName(school);
		setAdvantage(0.1);
		setCardNumber(cardNum);
	}

	public void printCardDetails(){
		System.out.println("\nVous avez la carte de fidelité pour étudiant.");
		System.out.println("Vous êtes étudiant à " + getSchoolName());
		System.out.println("Lors de chaque achat, 10% du montant total vous est déduit de la facture.\n");
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
