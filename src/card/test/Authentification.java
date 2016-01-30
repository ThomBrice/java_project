package card.test;

import java.util.*;
import java.io.*;

public class Authentification {

	public static void main(String[] args) throws IOException {
		Store store = new Store();
		int id = 0;
		InterfaceProduct prod;
		ShoppingBasket basket = new ShoppingBasket();
	    Scanner sc = new Scanner(System.in); // exception avec le system in ?
        String str;

		store.transferUsers("ClientsList.txt");
        do {
            starts();
            str = sc.nextLine();
            //je ne sais pas pq ya un pb ? ?
            switch (str) { // insérer exception ici
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
        } while (!str.equals("1") && !str.equals("2"));
        do {
            mainMenu();
            str = sc.nextLine();
            switch (str) { // insérer exception ici
                case "1": {
					do {
						StoreDepartment Dep;
						Dep = store.choiceDepartment("StoreDepartment.txt");
						prod = store.choiceProduct(Dep.getName() + ".txt");
						store.AddToBasket(prod, basket);
						secondMenu();
						str = sc.nextLine();
						if (str.equals("2")) {
							basket.print();
						}
					}while(str.equals("1"));
                    break;
                }
                case "2": {
                    store.getListUsers().get(id).printUserDetails();
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
        } while (!str.equals("3"));
        store.writing("ClientsList.txt");
        sc.close();
    }


	public static void starts() { // voir si on met en place une machine d'état
		// pour pouvoir se déco et reco avec autre
		// compte
		System.out.println("===============================");
		System.out.println("==== Bonjour cher client ! ====");
		System.out.println("===============================");
		System.out.println("======== Voulez vous : ========");
		System.out.println("==== 1 : vous connecter ?  ====");
		System.out.println("==== 2 : créer un compte ? ====");
		System.out.println("===============================");
		System.out.print(" 1/2 ? ");
	}

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

	public static void secondMenu(){
		System.out.println("==========================================");
		System.out.println("============== Voulez vous : =============");
		System.out.println("======= 1 : continuez vos achats ? =======");
		System.out.println("========= 2 : voir votre panier ? ========");
		System.out.println("==========================================");
		System.out.print(" 1..2 ? ");
	}
}
