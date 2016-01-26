package card.test;

import java.util.*;
import java.io.*;

public class Authentification {

	public static void main(String[] args) throws IOException {
		Store auchan = new Store();
		auchan.transferUsers("ClientsList.txt");
		auchan.createAccount();
		auchan.writing("ClientsList.txt");

		/*
		//Test de Commit!
		//
		*/

		/*Scanner sc = new Scanner(System.in); // exception avec le system in ?
		String str = new String();
		do {
			starts();
			str = sc.nextLine();
			//je ne sais pas pq ya un pb ? ?
			switch (str) { // insérer exception ici
			case "1": {
				auchan.login();
				break;
			}
			case "2": {
				auchan.createAccount();
				break;
			}
			default: {
				System.out.println("Erreur, veuillez choisir '1' ou '2' \n");
			}
			}
		} while (!str.equals("1") && !str.equals("2"));
		do{
			menu();
			str = sc.nextLine();
			switch (str) { // insérer exception ici
			case "1": {
				
				break;
			}
			case "2": {
				
				break;
			}
			case "3": {

				break;
			}
			default : {
				
			}
			}
		} while (!str.equals("1") && !str.equals("2") && !str.equals("3"));
		
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

	public static void menu() {
		System.out.println("==========================================");
		System.out.println("=================  MENU  =================");
		System.out.println("==========================================");
		System.out.println("============== Voulez vous : =============");
		System.out.println("========= 1 : voir les rayons ? ==========");
		System.out.println("=2 : voir les détails de votre compte ?  =");
		System.out.println("========= 3 : vous déconnecter ? =========");
		System.out.println("==========================================");
		System.out.print(" 1..3 ? ");
	*/}

}
