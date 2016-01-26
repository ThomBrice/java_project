package card.test;

public class BusinessCard extends Card {

	private String companyName;
	private String nSiret;

	public BusinessCard(String company, String num) {
		setCompanyName(company);
		setnSiret(num);
		setAdvantage(0.2);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getnSiret() {
		return nSiret;
	}

	public void setnSiret(String nSiret) {
		this.nSiret = nSiret;
	}
}
