package card.test;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Store {

	private ArrayList<User> listUsers;
    private ArrayList<StoreDepartment> listDepartement;
    String name;


	public Store() {
		listUsers = new ArrayList<>();
	}

    public Store(String name){
        setName(name);
    }

    public void setName(String name){
        this.name=name;
    }

	public int addUser() {
		User e = new User();
        boolean test = false;
        do {
            for (int j = 0; j < getListUsers().size(); j++) {
                if (getListUsers().get(j).getLogin().equals(e.getLogin())) {
                    test = true;
                    System.out.println("Ce login existe déjà, veuillez en choisir un autre.");
                    e.scanLogin();
                }
                else{
                    test = false;
                }
            }
        }while(test);
		this.listUsers.add(e);
		e.printUserDetails();
        return(e.getId());
	}

	public void printListOfUsers() {
		int i = 0;
		while (this.listUsers.size() != i) {
			System.out.print("Name : ");
			System.out.println(getListUsers().get(i).getName());
			System.out.print("Surname : ");
			System.out.println(getListUsers().get(i).getSurname());
			System.out.print("Id : ");
			System.out.println(getListUsers().get(i).getId());
			System.out.println("\n");
			i++;
		}
	}

	public ArrayList<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(ArrayList<User> listUsers) {
		this.listUsers = listUsers;
	}

	public int login() {
		Scanner scan = new Scanner(System.in); // exception avec le system in ?
		// scan.close(); A VOIR AVEC LE PROF
		int i = 0;
        int id = 0;
		boolean test = false;
		while (!test) {
			if (i != 0) {
				System.out.println("Identifiant ou mot de passe erroné\n");
			}
			System.out.print("Identifiant :");
			String login = scan.nextLine();
			System.out.print("Mot de passe :");
			String password = scan.nextLine();
			for (int j = 0; j < getListUsers().size(); j++) {
				if (getListUsers().get(j).getLogin().equals(login)) { // on parcourt
																	// la liste
																	// d'users
																	// pour voir
																	// si le
																	// login
																	// entré
																	// correspond
																	// au login
																	// d'un user
					if (getListUsers().get(j).getPassword().equals(password)) {
						id = getListUsers().get(j).getId();
						test = true;
					}
				}
			}
////
			i++;
		}
		System.out.println("Vous êtes connecté !\n");
        return id;
	}

	public int createAccount() {
		int id = addUser();
		System.out.println("Vous pouvez maintenant vous connecter ! \n");
		login();
        return id;
	}

	public void transferUsers(String namefile) {
		String containFile = reading(namefile);
		String[] tempo1;
		String[] tempo2 = null;

		tempo1 = containFile.split(";");
		for (String tempo11 : tempo1) {
			System.out.println(tempo11);
			tempo2 = tempo11.split("/");
			User temp = new User(tempo2[0], tempo2[1], tempo2[2], tempo2[3]);
			getListUsers().add(temp);
		}
	}

    public String[] transferDepartment(String nameStore){
        String containFile = reading(nameStore);
        String[] tempo1;

        tempo1 = containFile.split(";");
        return tempo1;
    }

    public String[] transferProducts(String nameStoreDepartment){
        String containFile = reading(nameStoreDepartment);
        String[] tempo1;

        tempo1 = containFile.split(";");
        return tempo1;
    }

    public StoreDepartment choiceDepartment(String nameStore){
        String [] tempo=transferDepartment(nameStore);

        int i=0;

        System.out.println("Choisissez votre rayon : (Tapez le nombre puis Entrée)");
        for (String aTempo1 : tempo) {
            System.out.println(i + " : " + aTempo1);
            i++;
        }

        Scanner scan =new Scanner(System.in);
        int tempo1 = scan.nextInt();

        while(tempo1<0 || tempo1>tempo.length) {
            System.out.println("Mauvais choix, recommencez : ");
            tempo1 = scan.nextInt();
        }
        StoreDepartment Dep = new StoreDepartment(tempo[tempo1]);
		return (Dep);
    }

    public InterfaceProduct choiceProduct(String nameStoreDepartment){
        String [] listProduits=transferProducts(nameStoreDepartment);
		String [] detailProduit=null;
        int i=0,number=0;

        System.out.println("Choisissez votre produit : (Tapez le nombre puis Entrée)");
        for (String aTempo1 : listProduits) {
            detailProduit =aTempo1.split("/");
            System.out.print(i + " : " + detailProduit[0] + "  ");
			if(detailProduit[2].charAt(0) == 'p' ){
				System.out.println(detailProduit[1] + "€ la Piéce");
			}
			if(detailProduit[2].charAt(0) == 'w' ){
				System.out.println(detailProduit[1] + "€ le kilo");
			}
            i++;
        }

        Scanner scan =new Scanner(System.in);
        int choice = scan.nextInt();

        while(choice<0 || choice>listProduits.length) {
            System.out.println("Mauvais choix, recommencez : : ");
            choice = scan.nextInt();
        }

		detailProduit=listProduits[choice].split("/");

		InterfaceProduct defaultProduct = null;

        if(detailProduit[2].charAt(0) == 'p'){
			PieceProduct product = new PieceProduct();
			product.setName(detailProduit[0]);
			product.setPrice(Float.parseFloat(detailProduit[1]));
			return (product);
	    }
		if(detailProduit[2].charAt(0) == 'w'){
			WeightProduct product = new WeightProduct();
			product.setName(detailProduit[0]);
			product.setPrice(Float.parseFloat(detailProduit[1]));
			return (product);
		}

		return (defaultProduct);
	}

	public void AddToBasket (InterfaceProduct product, ShoppingBasket basket){
		Scanner scan = new Scanner(System.in);

		product.quantityChoice();
		int choice = scan.nextInt();
		product.setNb(choice);
		basket.addProduct(choice,product);

	}

    public String reading(String fileName) { // read the file
        BufferedReader details;
        String temp = new String();
        try {
            details = new BufferedReader(new FileReader(fileName));
            while (details.ready()) {
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
			for (User text1 : getListUsers()) { // for each
				details = null;
				details = text1.getName() + "/";
				details = details + text1.getSurname() + "/";
				details = details + text1.getLogin() + "/";
				details = details + text1.getPassword() + ";" + "\n";
				//int temp = text1.getCardNumber();   On en a plus besoin non ??
				//details = details + (temp + "") + ";" + "\n"; // int vers string

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
