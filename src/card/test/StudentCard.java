package card.test;

/**
 * La classe StudentCard représente une carte de fidélité pour étudiant
 * Elle hérite de la classe abstraite Card
 *
 * Une carte de fidélité étudiante donne un avantage de 5% par enfant.
 * Cet avantage est immédiatement déduit sur la facture.
 */
public class StudentCard extends Card {
	/**
	 * Nom de l'école
	 */
	private String schoolName;

	/**
	 * Constructeur de la classe StudentCard
	 * @param cardNum : numérode la carte
	 * @param school : nom de l'école
     */
	public StudentCard(int cardNum, String school) {
		setSchoolName(school);
		setAdvantage(0.1);
		setCardNumber(cardNum);
	}

	/**
	 * Affiche le détail de la carte étudiante.
	 */
	@Override
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
