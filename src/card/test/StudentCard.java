package card.test;

public class StudentCard extends Card {
	private String schoolName;

	public StudentCard(String school) {
		setSchoolName(school);
		setAdvantage(0.1);
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
