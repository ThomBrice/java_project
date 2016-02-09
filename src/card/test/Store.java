package card.test;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * La classe Store représente le magasin.
 * Le magasin comporte deux attributs :
 * - une liste d'objet User, c'est-à-dire une liste d'utilisateur inscrit du magasin
 * - une liste d'objet Card, c'est-à-dire la liste des cartes de fidélité de tous les utilisateurs inscrits du magasin.
 *
 * Les méthodes de cette classe vont
 * - gérer la lecture et l'écriture dans les fichiers "CardsList.txt" et "ClientsList.txt"
 * - gérer la connexion d'un utilisateur ou la création d'un nouveau compte
 * - la navigation entre les rayons du magasin
 * - l'ajout d'un produit au panier
 */
public class Store {
	/**
	 * 	C'est la liste d'objet User, chaque utilisateur inscrit du magasin y est référencé.
	 *
	 */
	private ArrayList<User> listUsers;
	/**
	 * C'est la liste d'objet Card, chaque utilisateur a une carte de fidelité, toutes les cartes sont listées dans cette liste.
	 */
	private ArrayList<Card> listOfCards;

	/**
	 * Constructeur de la classe Store.
	 * Lorsque le constructeur est appele, les listes listUsers et listOfcards sont initialisées.
	 */
	public Store() {
		listUsers = new ArrayList<>();
		listOfCards = new ArrayList<>();
	}

	/**
	 * Méthode appelee lors de la creation d'un nouveau compte.
	 * Cette methode cree un utilisateur, en vérifiant si l'identifiant choisi n'existe pas déjà.
	 * Elle appelle aussi la methode createCard() qui crée une carte de fidelite associee.
	 * Une fois le compte cree, les détails sont affiches.
	 * Et les nouvels objets User et Card sont ajoutés respectivement dans les listes listUsers et listOfCards.
	 * @return L'id de l'utilisateur qui a ete ajoute.
     */
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
		createCard(e.getCardNumber());
		this.listUsers.add(e);
		e.printUserDetails();
        this.listOfCards.get(findCard(e.getCardNumber())).printCardDetails();
        return(e.getId());
	}

	/**
	 * Cette méthode prend en paramètre un numéro de carte de fidelité et renvoie la position de la carte correspondante dans la liste listOfCards.
	 *
	 * @param num : le numéro de carte de fidélité
	 * @return la position de la carte correspondante dans la liste listOfCards
     */
    public int findCard(int num){
        int index=0;
        for(int i = 0; i<getListOfCards().size(); i++){
            if (getListOfCards().get(i).getCardNumber()== num){
                index=i;
            }
        }
        return index;
    }

	/**
	 * Affiche le détail de la carte de fidélité de l'utilisateur ayant l'id passé en paramètre.
	 * @param id id de l'utilisateur dont on veut le détail de la carte de fidelité
     */
    public void printCardDetails(int id){
        getListOfCards().get(findCard(getListUsers().get(id).getCardNumber())).printCardDetails();
    }

	/**
	 * Renvoie l'avantage client qu'un utilisateur a grâce à sa carte de fidelité
	 * @param id : id de l'utilisateur
	 * @return l'avantage client de l'utilisateur.
     */
    public double getUserCardAdvantage(int id){
        return getListOfCards().get(findCard(getListUsers().get(id).getCardNumber())).getAdvantage();
    }

	/**
	 * Renvoie le montant de la cagnotte d'un utlisateur ayant une carte de fidélité basique.
	 * @param id : id de l'utilisateur
	 * @return la cagnotte de l'utilisateur.
	 */
    public double getUserCardBalance(int id){
        return ((BasicCard) getListOfCards().get(findCard(getListUsers().get(id).getCardNumber()))).getBalance();
    }

	/**
	 * Méthode qui modifie la valeur de la cagnotte d'un client
	 * @param id : l'id du client voulu
	 * @param balance : la nouvelle cagnotte du client
     */
    public void setUserCardBalance(int id, double balance){
        ((BasicCard) getListOfCards().get(findCard(getListUsers().get(id).getCardNumber()))).setBalance(balance);
    }

	/**
	 * getter de listUsers
	 * @return
     */
	public ArrayList<User> getListUsers() {
		return listUsers;
	}

	/**
	 * Méthode permettant de se connecter grâce un identifiant et un mot de passe.
	 * @return l'id du client connecté
     */
	public int login() {
		Scanner scan = new Scanner(System.in); // exception avec le system in ?
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

	/**
	 * Méthode de création d'un nouveau compte, appell de la méthode addUser();
	 * @return l'id du client créé
     */
	public int createAccount() {
		int id = addUser();
		System.out.println("Vous pouvez maintenant vous connecter ! \n");
		login();
        return id;
	}

	/**
	 * Méthode qui transfert les utilisateurs stockés dans un fichier txt dans la liste listUsers;
	 * Appel de la méthode readingFiles()
	 * @param namefile    : nom du fichier txt
     */
	public void transferUsersFromFiles(String namefile) {
		String containFile = readingFiles(namefile);
		String[] tempo1;
		String[] tempo2 = null;

		tempo1 = containFile.split(";");
		for (String tempo11 : tempo1) {
			tempo2 = tempo11.split("/");
			User temp = new User(tempo2[0], tempo2[1], tempo2[2], tempo2[3]);
			getListUsers().add(temp);
		}
	}

	/**
	 * Méthode qui renvoie un tableau de string dans lesquelles sont contenus les noms des rayons.
	 * @param nameStore nom du fichier où sont stockés les noms des rayons
	 * @return tableau de string, chaque string du tableau contient le nom d'un rayon
     */
    public String[] transferDepartmentFromFiles(String nameStore){
        String containFile = readingFiles(nameStore);
        String[] tempo1;
        tempo1 = containFile.split(";");
        return tempo1;
    }

	/**
	 * Méthode qui renvoie un tableau de string contenant les noms des produits d'un rayon particulier.
	 * @param nameStoreDepartment : nom du fichier où sont stockés les noms des produits et leur prix.
	 * @return tableau de string
     */
    public String[] transferProductsFromFiles(String nameStoreDepartment){
        String containFile = readingFiles(nameStoreDepartment);
        String[] tempo1;

        tempo1 = containFile.split(";");
        return tempo1;
    }

	/**
	 * Méthode qui permet à l'utilisateur de choisir dans quel rayon il veut aller.
	 * Une liste de rayons s'affiche, et l'utilisateur choisit.
	 * @param nameStore nom du fichier où sont stockés les noms des rayons
	 * @return un objet représentant le rayon choisi
     */
    public StoreDepartment choiceDepartment(String nameStore){
        String [] tempo= transferDepartmentFromFiles(nameStore);

        int i=0;

        System.out.println("Choisissez votre rayon : (Tapez le nombre puis Entrée)");
        for (String aTempo1 : tempo) {
            System.out.println(i + " : " + aTempo1);
            i++;
        }

        Scanner scan =new Scanner(System.in);
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

	/**
	 * Méthode qui permet à l'utilisateur de choisir un produit.
	 * Après avoir choisi le rayon, les produits du rayon s'affiche et l'utilisateur peut choisir.
	 * @param nameStoreDepartment nom du fichier contenant le noms des produits.
	 * @return le produit choisi
     */
    public InterfaceProduct choiceProduct(String nameStoreDepartment){
        String [] listProduits= transferProductsFromFiles(nameStoreDepartment);
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

	/**
	 * Méthode qui permet l'ajout d'un produit choisi par l'ulisateur à son panier.
	 * Choix du nombre de produit à ajouter au panier.
	 * @param product : produit choisi par l'utilisateur
	 * @param basket : panier de l'utilisateur
     */
	public void addToBasket(InterfaceProduct product, ShoppingBasket basket){
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

	/**
	 * Méthode qui permet la lecture d'un fichier .txt donné
	 * @param fileName : nom du fichier .txt
	 * @return une string contenant tout le fichier .txt
     */
    public String readingFiles(String fileName) { // read the file
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

	/**
	 * Méthode permettant l'écriture de la liste listUsers dans un fichier .txt
	 * Elle sert à sauvegarder la liste des comptes créés.
	 * @param fileName : nom du fichier .txt
	 * @throws IOException
     */
	public void writingUsersFiles(String fileName)
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

	/**
	 * Méthode permettant l'écriture de la liste listOfCards dans un fichier .txt
	 * Elle sert à sauvegarder la liste des cartes de fidélité créées.
	 * @param fileName : nom du fichier .txt
	 * @throws IOException
	 */
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

	/**
	 * getter de listOfCards
	 * @return
     */
	public ArrayList<Card> getListOfCards() {
		return listOfCards;
	}

	/**
	 * Méthode permettant la création d'une carte de fidélité.
	 * Elle est appelée lors de la création d'un nouveau compte.
	 * Elle affiche toutes les cartes de fidélité possibles et décrit les différents avantages.
	 * @param cardNum : numéro de carte
     */
	public void createCard(int cardNum) {
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

	/**
	 * Méthode qui transfert les cartes stockées dans un fichier txt dans la liste listOfCards;
	 * Appel de la méthode readingFiles()
	 * @param namefile
     */
	public void transferCardsFromFiles(String namefile) {
		String containFile = readingFiles(namefile);
		String[] tempo1;
		String[] tempo2 = null;

		tempo1 = containFile.split(";");
		for (String tempo11 : tempo1) {
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
