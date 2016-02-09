package card.test;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Store {

	private ArrayList<User> listUsers;
    private ArrayList<StoreDepartment> listDepartement;
	private ArrayList<Card> listOfCards;
    String name;


	public Store() {
		listUsers = new ArrayList<>();
		listOfCards = new ArrayList<>();
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
		scanTypeOfCard(e.getCardNumber());
		this.listUsers.add(e);
		e.printUserDetails();
        this.listOfCards.get(findCard(e.getCardNumber())).printCardDetails();
        return(e.getId());
	}

    public int findCard(int num){
        int index=0;
        for(int i = 0; i<getListOfCards().size(); i++){
            if (getListOfCards().get(i).getCardNumber()== num){
                index=i;
            }
        }
        return index;
    }

    public void printCardDetails(int id){
		System.out.println(getListUsers().get(id).getCardNumber());
        getListOfCards().get(findCard(getListUsers().get(id).getCardNumber())).printCardDetails();
    }

    public double getUserCardAdvantage(int id){
        return getListOfCards().get(findCard(getListUsers().get(id).getCardNumber())).getAdvantage();
    }

    public double getUserCardBalance(int id){
        return ((BasicCard) getListOfCards().get(findCard(getListUsers().get(id).getCardNumber()))).getBalance();
    }

    public void setUserCardBalance(int id, double balance){
        ((BasicCard) getListOfCards().get(findCard(getListUsers().get(id).getCardNumber()))).setBalance(balance);
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
        //int tempo1 = scan.nextInt();
		String tempo1 = scan.nextLine();

		boolean test = false;
		int num=-1;
        int j = 0;
		while(!test) {
			if (j>0){
				System.out.println("Mauvais choix, recommencez : ");
				tempo1 = scan.nextLine();
			}
			for (int k=0;k<tempo.length;k++){
				if(tempo1.equals(Integer.toString(k))){
					test=true;
					num = new Integer(tempo1);
				}
			}
			j++;
		}
		System.out.println(num);

        StoreDepartment Dep = new StoreDepartment(tempo[num]);
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
        String choice = scan.nextLine();
        boolean test = false;
        int num=-1;
        int j = 0;
        while(!test) {
            if (j>0){
                System.out.println("Mauvais choix, recommencez : ");
                choice = scan.nextLine();
            }
            for (int k=0;k<listProduits.length;k++){
                if(choice.equals(Integer.toString(k))){
                    test=true;
                    num = new Integer(choice);
                }
            }
            j++;
        }
		detailProduit=listProduits[num].split("/");

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
        String choice=scan.nextLine();
        boolean test=false;
        while(!test){
            char c[]=choice.toCharArray();
            if(c.length<4){
                if((int)c[0]<58 && (int) c[0]>46){
                    if(c.length>1){
                        if((int)c[1]<58 && (int) c[1]>46){
                            if(c.length>2) {
                                if ((int) c[2] < 58 && (int) c[2] > 46) {
                                    test = true;
                                }
                            }
                            else{
                                test=true;
                            }
                        }
                    }
                    else{
                        test=true;
                    }
                }

            }
            if(!test){
                System.out.println("Erreur, entrez un nombre");
                choice=scan.nextLine();
            }
        }
        int num = new Integer(choice);

        product.setNb(num);
        basket.addProduct(num,product);


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

    public void writingCardsFile(String fileName)
            throws IOException {
        String details = null;
        try (
                // write at the end of the file
                FileWriter writer = new FileWriter(fileName, false)
                // end try
        ) {
            for (Card text1 : getListOfCards()) { // for each
                details = null;
                if (text1 instanceof BasicCard){
                    details = "b/" + text1.getCardNumber() + "/" + ((BasicCard) text1).getBalance() + ";";
                }
                if (text1 instanceof StudentCard){
                    details = "e/" + text1.getCardNumber() + "/" + ((StudentCard) text1).getSchoolName() + ";";
                }
                if (text1 instanceof BusinessCard){
                    details = "p/" + text1.getCardNumber() + "/" + ((BusinessCard) text1).getCompanyName() + ";";
                }
                if (text1 instanceof FamilyCard){
                    details = "f/" + text1.getCardNumber() + "/" + ((FamilyCard) text1).getNumberOfChild() + ";";
                }
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

	public ArrayList<Card> getListOfCards() {
		return listOfCards;
	}

	public void scanTypeOfCard(int cardNum) {
		System.out.println("Veuillez choisir votre carte de fidélité.  ");
		System.out.println("4 types de carte sont disponibles : ");
		System.out.println(" - la carte Basique : 5% du total de votre facture est crédité sur votre compte ");
		System.out.println(" - la carte Etudiant : vous bénéficiez de 10% de réduction lorsque que vous payez sur tous les produits ");
		System.out.println(" - la carte Professionnels : la TVA vous est offerte, soit 20% de réduction immédiate sur tous les produits ");
		System.out.println(" - la carte Famille : si vous êtes parents, chaque enfant vous donne 2% de réduction immédiate ");
		System.out.println("Quelle carte choississez vous ? Tapez b pour Basique, e pour Etudiant, p pour Professionnel, f pour Famille. ");
		Scanner scan = new Scanner(System.in);
		String str = new String();
		int i = 0;
		while(!str.equals("b") && !str.equals("e") && !str.equals("p") && !str.equals("f")){
			if (i != 0){
				System.out.println("Veuillez taper 'b', 'e', 'p' ou 'f'");
			}
			str = scan.nextLine();
			i++;
		}
		switch(str) {
			case "b": {
				Card c = new BasicCard(cardNum);
				this.listOfCards.add(c);
				break;
			}
			case "e": {
				System.out.println("Ecrivez le nom de votre école");
				str = scan.nextLine();
				Card c = new StudentCard(cardNum, str);
				this.listOfCards.add(c);
				break;
			}
			case "p" : {
				System.out.println("Ecrivez le nom de votre entreprise");
				str = scan.nextLine();
				Card c = new BusinessCard(cardNum, str);
				this.listOfCards.add(c);
				break;
			}
			case "f" : {
				System.out.println("Combien d'enfants avez-vous ? (Max : 9)");
				str = scan.nextLine();
				boolean test=false;
				while(!test) {
					char chr[] = str.toCharArray();
					if (chr.length < 2) {
						if ((int) chr[0] < 58 && (int) chr[0] > 46) {
							test = true;
							if((int) chr[0] <= 50){
								System.out.println("La carte Famille n'est intéressante qu'à partir de 3 enfants.");
								System.out.println("Une carte de fidélité basique vous sera attribuée.");
								Card c = new BasicCard(cardNum);
								this.listOfCards.add(c);
							}
							else{
								Card c = new FamilyCard(cardNum,Integer.parseInt(str));
								this.listOfCards.add(c);
							}
						}
					}
					if (!test) {
						System.out.println("Erreur, entrez un nombre");
						str = scan.nextLine();
					}
				}
				break;
			}
		}

	}

	public void setListOfCards(ArrayList<Card> listOfCards) {
		this.listOfCards = listOfCards;
	}

	public void transferCards(String namefile) {
		String containFile = reading(namefile);
		String[] tempo1;
		String[] tempo2 = null;

		tempo1 = containFile.split(";");
		for (String tempo11 : tempo1) {
			System.out.println(tempo11);
			tempo2 = tempo11.split("/");
			switch(tempo2[0]){
				case "b": {
					Card c = new BasicCard(Integer.parseInt(tempo2[1]), Double.parseDouble(tempo2[2]));
					getListOfCards().add(c);
					break;
				}
				case "e": {
					Card c = new StudentCard(Integer.parseInt(tempo2[1]), tempo2[2]);
					getListOfCards().add(c);
					break;
				}
				case "p" : {
					Card c = new BusinessCard(Integer.parseInt(tempo2[1]), tempo2[2]);
					getListOfCards().add(c);
					break;
				}
				case "f" : {
					Card c = new FamilyCard(Integer.parseInt(tempo2[1]), Integer.parseInt(tempo2[2]));
					getListOfCards().add(c);
					break;
				}
				default : {
					System.out.print("Erreur lecture ficher");
				}
			}
		}
	}
}
