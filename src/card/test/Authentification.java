package card.test;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

/**
 * Authentification est la classe d'éxécution, elle contient la méthode main.
 * L'interface utilisateur est gérée par la classe Authentification, 3 méthodes y sont d'ailleurs consacrées (starts(), mainMenu(), secondMenu()).
 *
 *@author Thomas BRICE & Nicolas BOCK
 */
public class Authentification {

	public static void main(String[] args) throws IOException {
		DecimalFormat df = new DecimalFormat("0.00"); // for decimal format
		Store store = new Store();
		int id = 0;
		InterfaceProduct prod; // on crée un produit
		ShoppingBasket basket = new ShoppingBasket(); // on crée un panier
	    Scanner sc = new Scanner(System.in);
        String entreeClavier;
		store.transferUsersFromFiles("ClientsList.txt");
		store.transferCardsFromFiles("CardsList.txt");
        do {
            starts();
            entreeClavier = sc.nextLine();
            switch (entreeClavier) {
                case "1": {
                    id = store.login();
                    break;
                }
                case "2": {
                    id = store.createAccount();
                    break;
                }
                default: {
                    System.out.println("Erreur, veuillez choisir '1' ou '2' \n");
                }
            }
        } while (!entreeClavier.equals("1") && !entreeClavier.equals("2"));
        do {
            mainMenu();
            entreeClavier = sc.nextLine();
            switch (entreeClavier) {
                case "1": {
					do {
						secondMenu();
						entreeClavier = sc.nextLine();
						switch (entreeClavier) {
							case "1": {
								StoreDepartment Dep;
								Dep = store.choiceDepartment("StoreDepartment.txt");
								prod = store.choiceProduct(Dep.getName() + ".txt");
								store.AddToBasket(prod, basket);
								break;
							}
							case "2": {
								basket.print();
								break;
							}
							case "3": {
								store.getListOfCards().get(store.findCard(store.getListUsers().get(id).getCardNumber())).printCardDetails();
								System.out.println("Voici votre facture : ");
								basket.print();
								if (store.getListOfCards().get(store.findCard(store.getListUsers().get(id).getCardNumber())) instanceof BasicCard){
									System.out.println("Voulez-vous utiliser votre cagnotte ? Tapez o pour oui, n pour non : o/n ? ");
									String s = sc.nextLine();
									switch (s){
										case "o" : {
											System.out.println("===============================");
											System.out.println("Montant après déduction de votre cagnotte : " + df.format(basket.getPrice() - store.getUserCardBalance(id)) + "€");
											store.setUserCardBalance(id, basket.getPrice()*store.getUserCardAdvantage(id));
											System.out.println("Nouvelle cagnotte : " +  df.format(store.getUserCardBalance(id)) + " €");
											System.out.println("\nMerci de vos achats, Au revoir !");
											break;
										}
										case "n" : {
											System.out.println("===============================");
											System.out.println("Montant total : " + basket.getPrice() + " €");
                                            store.setUserCardBalance(id, store.getUserCardBalance(id) + basket.getPrice()*store.getUserCardAdvantage(id));
											System.out.println("Nouvelle cagnotte : " + df.format(store.getUserCardBalance(id)) + "€");
											System.out.println("\nMerci de vos achats, Au revoir !");
											break;
										}
									}
								}
								else {
									System.out.println("===============================");
									System.out.println("Montant après réduction : " + df.format(basket.getPrice() - basket.getPrice() * store.getUserCardAdvantage(id)) + "€");
									System.out.println("\nMerci de vos achats, Au revoir !");
								}
								break;
							}
							default: {
								System.out.println("Erreur, veuillez réessayer \n");
							}
						}
					}while(!entreeClavier.equals("3"));
                    break;
                }
                case "2": {
                    store.getListUsers().get(id).printUserDetails();
					store.printCardDetails(id);
                    break;
                }
                case "3": {
                    System.out.println("Au revoir ! \n");
                    break;
                }
                default: {
                    System.out.println("Erreur, veuillez choisir un chiffre entre 1 et 3 \n");

                }
            }
        } while (!entreeClavier.equals("3"));
        store.writingUsersFiles("ClientsList.txt");
		store.writingCardsFile("CardsList.txt");
        sc.close();
    }

	/**
	 * Méthode qui affiche le premier menu, il propose à l'utilisateur de se connecter ou de créer un compte.
	 */
	public static void starts() {
		System.out.println("===============================");
		System.out.println("==== Bonjour cher client ! ====");
		System.out.println("===============================");
		System.out.println("======== Voulez vous : ========");
		System.out.println("==== 1 : vous connecter ?  ====");
		System.out.println("==== 2 : créer un compte ? ====");
		System.out.println("===============================");
		System.out.print(" 1/2 ? ");
	}

	/**
	 * Méthode qui affiche de deuxième menu, il propose à l'utilisateur de :
	 * - commencer ses achats
	 * - voir les détails de son compte (Nom, prénom, indentifiant, mot de passe, type de carte de fidélité, etc).
	 * - se déconnecter
	 */
	public static void mainMenu	() {
		System.out.println("==========================================");
		System.out.println("=================  MENU  =================");
		System.out.println("==========================================");
		System.out.println("============== Voulez vous : =============");
		System.out.println("======= 1 : commencer vos achats ? =======");
		System.out.println("=2 : voir les détails de votre compte ?  =");
		System.out.println("========= 3 : vous déconnecter ? =========");
		System.out.println("==========================================");
		System.out.print(" 1..3 ? ");
	}

	/**
	 * Méthode qui affiche le menu permettant de :
	 * - choisir le rayon
	 * - voir son panier
	 * - régler ses achats
	 * Ce menu est affiché une fois que l'utilisateur à choisi l'option, "commencer vos achats" de la méthode mainMenu().
	 *
	 */
	public static void secondMenu(){
		System.out.println("==========================================");
		System.out.println("============== Voulez vous : =============");
		System.out.println("========= 1 : choisir le rayon ? =========");
		System.out.println("========= 2 : voir votre panier ? ========");
		System.out.println("========= 3 : régler vos achats ? ========");
		System.out.println("==========================================");
		System.out.print(" 1..3 ? ");
	}
}
