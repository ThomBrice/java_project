package card.test;

import java.util.Scanner;

/**
 * La classe User représente les utilisateurs du système d'achat.
 * Il est caractérisé par un nom, un prénom, un identifiant, un mot de passe, un numéro de client, un numéro de carte.
 */
public class User {
	/**
	 * Nom du client
	 */
	private String name;

	/**
	 * Prénom du client
	 */
	private String surname;

	/**
	 * Identifiant du client, servant à se connecter
	 */
	private String login;

	/**
	 * Mot de passe du client
	 */
	private String password;

	/**
	 * Numéro de carte du client
	 */
	private int cardNumber;

	/**
	 * Numéro de client.
	 */
	private int id;

	/**
	 * Nombre de clients
	 * Nombre d'instances de la classe User
	 */
	private static int numberOfUsers = 0;

	/**
	 * Constructeur 1 de la classe User
	 * Ce constructeur est utilisé lorsque le client crée son compte pour la première fois
	 * Toutes les informations sont demandées à l'utilisateur.
	 * @see Store#addUser()
	 *
	 */
	public User() {
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

	/**
	 * Constructeur 2 de la classe User
	 * Ce constructeur est utilisé pour créer les objets User correspondant aux utilisateurs déjà inscrits qui sont stockés dans le fichier .txt
	 * @see Store#transferUsersFromFiles(String)
	 * @param name : nom
	 * @param surname : prenom
 	 * @param login : identifiant
	 * @param password : mot de passe
     */
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

	/**
	 * Méthode qui affiche le détail d'un client.
	 */
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
	/**
	 * Méthode qui demande le nom du client.
	 */
	public void scanName() {
		System.out.print("Prénom : ");
		Scanner scan = new Scanner(System.in);
		this.name = scan.nextLine();
	}

	/**
	 * Méthode qui demande le prénom du client.
	 */
	public void scanSurname() {
		System.out.print("Nom : ");
		Scanner scan = new Scanner(System.in);
		this.surname = scan.nextLine();
	}

	/**
	 * Méthode qui demande l'identifiant du client.
	 */
	public void scanLogin() {
		System.out.print("Identifiant : ");
		Scanner scan = new Scanner(System.in);
		this.login = scan.nextLine();
	}

	/**
	 * Méthode qui demande le mot de passe du client.
	 */
	public void scanPassword() {
		System.out.print("Mot de passe : ");
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

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
}
