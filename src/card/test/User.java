package card.test;

import java.util.Scanner;

public class User {
	private String name;
	private String surname;
	private String login;
	private String password;
	private String typeOfCard;
	private int cardNumber;
	private int id = 0;
	private static int numberOfUsers = 0;

	public User() { // calculer cardnumebr
		scanName();
		scanSurname();
		scanLogin();
		scanPassword();
		System.out.println("\n");
		numberOfUsers++;
		setId(numberOfUsers - 1);
		scanTypeOfCard();
		int ascii=0;
        for(int i=0; i<login.length();i++){
        	ascii =ascii + login.charAt(i);
        }
		setCardNumber(ascii);
	}
	
	public User(String name, String surname, String login, String password){ // calculer cardnumber !!
		setName(name);
		setSurname(surname);
		setLogin(login);
		setPassword(password);
		int ascii=0;
        for(int i=0; i<login.length();i++){
        	ascii =ascii + login.charAt(i);
        }
		setCardNumber(ascii);
	}

	public void scanTypeOfCard() {
		System.out.println("Veuillez choisir votre carte de fidélité.  ");
		System.out.println("4 types de carte sont disponibles : ");
		System.out.println(" - la carte Basique : 5% du total de votre facture est crédité sur votre compte ");
		System.out.println(" - la carte Etudiant : vous bénéficiez de 10% de réduction lorsque que vous payez sur tous les produits ");
		System.out.println(" - la carte Professionnels : la TVA vous est offerte, soit 20% de réduction immédiate sur tous les produits ");
		System.out.println(" - la carte Famille : si vous êtes parents, chaque enfant vous donne 2% de réduction immédiate ");
		System.out.println("Quelle carte choississez vous ? Tapez b pour Basique, e pour Etudiant, p pour Professionnel, f pour Famille. ");
		Scanner scan = new Scanner(System.in);
		String str = new String();
		while(!str.equals("b") && !str.equals("e") && !str.equals("p") && !str.equals("f")){
			str = scan.nextLine();
		}
		this.typeOfCard=str;		
	}

	public void printUserDetails() {
		System.out.println("Here is the details of your account \n");
		System.out.print("Name : ");
		System.out.println(getName());
		System.out.print("Surname : ");
		System.out.println(getSurname());
		/*switch(getTypeOfCard()){
		case "b" : {
			System.out.println("Vous avez la carte Basique.");
			break;
		}
		case "e" : {
			System.out.println("Vous avez la carte Etudiant.");
			break;
		}
		case "p" : {
			System.out.println("Vous avez la carte Professionnels.");
			break;
		}
		case "f" : {
			System.out.println("Vous avez la carte Famille.");
			break;
		}
		}*/
		System.out.print("Id : ");
		System.out.println(getId());
		System.out.print("Login : ");
		System.out.println(getLogin());
		System.out.print("Password : ");
		System.out.println(getPassword());
		System.out.println("\n");
	}

	public void scanName() {
		System.out.print("name : ");
		Scanner scan = new Scanner(System.in);
		this.name = scan.nextLine();
	}

	public void scanSurname() {
		System.out.print("surname : ");
		Scanner scan = new Scanner(System.in);
		this.surname = scan.nextLine();
	}

	public void scanLogin() {
		System.out.print("login : ");
		Scanner scan = new Scanner(System.in);
		this.login = scan.nextLine();
	}

	public void scanPassword() {
		System.out.print("password : ");
		Scanner scan = new Scanner(System.in);
		this.password = scan.nextLine();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getNumberOfUsers() {
		return numberOfUsers;
	}

	public String getTypeOfCard() {
		return typeOfCard;
	}

	public void setTypeOfCard(String typeOfCard) {
		this.typeOfCard = typeOfCard;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

}
