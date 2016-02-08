package card.test;

import java.util.Scanner;

public class User {
	private String name;
	private String surname;
	private String login;
	private String password;
	private int cardNumber;
	private int id;
	private static int numberOfUsers = 0;

	public User() { // calculer cardnumebr
		scanName();
		scanSurname();
		scanLogin();
		scanPassword();
		numberOfUsers++;
		setId(numberOfUsers - 1);
        System.out.print("\n");
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
        numberOfUsers++;
        setId(numberOfUsers - 1);
		int ascii=0;
        for(int i=0; i<login.length();i++){
        	ascii =ascii + login.charAt(i);
        }
		setCardNumber(ascii);
	}

	public void printUserDetails() {
		System.out.println("Here is the details of your account \n");
		System.out.print("Prénom : ");
		System.out.println(getName());
		System.out.print("Nom : ");
		System.out.println(getSurname());
		System.out.print("Numéro de client : ");
		System.out.println(getId());
		System.out.print("Identifiant : ");
		System.out.println(getLogin());
		System.out.print("Mot de passe : ");
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

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
}
