package card.test;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Store {
	private ArrayList<User> list;

	public Store() {
		list = new ArrayList<User>();
	}

	public int addUser() {
		User e = new User();
		this.list.add(e);
		return e.getId();
	}

	public void printListOfUsers() {
		int i = 0;
		while (this.list.size() != i) {
			System.out.print("Name : ");
			System.out.println(getList().get(i).getName());
			System.out.print("Surname : ");
			System.out.println(getList().get(i).getSurname());
			System.out.print("Id : ");
			System.out.println(getList().get(i).getId());
			System.out.println("\n");
			i++;
		}
	}

	public ArrayList<User> getList() {
		return list;
	}

	public void setList(ArrayList<User> list) {
		this.list = list;
	}

	public void login() {
		Scanner scan = new Scanner(System.in); // exception avec le system in ?
		// scan.close(); A VOIR AVEC LE PROF
		int i = 0;
		boolean test = false;
		while (test != true) {
			if (i != 0) {
				System.out.println("Identifiant ou mot de passe erroné\n");
			}
			System.out.print("Identifiant :");
			String login = scan.nextLine();
			System.out.print("Mot de passe :");
			String password = scan.nextLine();
			for (int j = 0; j < getList().size(); j++) {
				if (getList().get(j).getLogin().equals(login)) { // on parcourt
																	// la liste
																	// d'users
																	// pour voir
																	// si le
																	// login
																	// entré
																	// correspond
																	// au login
																	// d'un user
					if (getList().get(j).getPassword().equals(password)) {
						test = true;
					}
				}
			}

			i++;
		}
		System.out.println("Vous êtes connecté !\n");

	}

	public void createAccount() { // A CHANGER !!! addUser instancie a 1 et quand on import un fichier ça instancie pas
		int num = addUser();
		getList().get(num).printUserDetails();
		System.out.println("Vous pouvez maintenant vous connecter ! \n");
		login();
	}

	public void transferUsers(String namefile) {
		String containFile = reading(namefile);
		String[] tempo1;
		String[] tempo2;
		tempo1 = containFile.split(";");
		for (String tempo11 : tempo1) {
			System.out.println(tempo11);
			tempo2 = null;
			tempo2 = tempo11.split("/");
			User temp = new User(tempo2[0], tempo2[1], tempo2[2], tempo2[3]);
			getList().add(temp);
		}
		System.out.println(getList().get(1).getLogin());
	}

	public String reading(String fileName) { // read the file
		BufferedReader details;
		String temp = new String();
		try {
			details = new BufferedReader(new FileReader(fileName));
			while (details.ready() == true) {
				temp += details.readLine();
			}// end while
		}// end try

		catch (NullPointerException a) {
			System.out.println("Erreur : pointeur null");
		}// end catch

		catch (IOException a) {
			System.out.println("Problème d'IO");
		}// end catch

		return temp;
	}

	public void writing(String fileName)
			throws IOException {
		String details = null;
		try (
		// write at the end of the file
		FileWriter writer = new FileWriter(fileName, false)
		// end try
		) {
			for (User text1 : getList()) { // for each
				details = null;
				details = text1.getName() + "/";
				details = details + text1.getSurname() + "/";
				details = details + text1.getLogin() + "/";
				details = details + text1.getPassword() + "/";
				int temp = text1.getCardNumber();
				details = details + (temp + "") + ";" + "\n"; // int vers string

				writer.write(details, 0, details.length()); // write in the file
			}

		}// end try
		catch (NullPointerException a) {
			System.out.println("Erreur : pointeur null");
		}// end catch
		catch (IOException a) {
			System.out.println("Problème d'IO");
		}
	}

}
