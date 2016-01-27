package card.test;

import java.util.*;
import java.io.*;

public class Authentification {

    public static void main(String[] args) throws IOException {
        Store auchan = new Store();
        int id = 0;
        auchan.transferUsers("ClientsList.txt");
        //auchan.choiceDepartment("StoreDepartment.txt");
        //auchan.choiceProduct("Produits Frais.txt");

        Scanner sc = new Scanner(System.in); // exception avec le system in ?
        String str;
        do {
            starts();
            str = sc.nextLine();
            //je ne sais pas pq ya un pb ? ?
            switch (str) { // insérer exception ici
                case "1": {
                    id = auchan.login();
                    break;
                }
                case "2": {
                    id = auchan.createAccount();
                    break;
                }
                default: {
                    System.out.println("Erreur, veuillez choisir '1' ou '2' \n");
                }
            }
        } while (!str.equals("1") && !str.equals("2"));
        do {
            menu();
            str = sc.nextLine();
            switch (str) { // insérer exception ici
                case "1": {
                    System.out.print("lol");
                    break;
                }
                case "2": {
                    auchan.getListUsers().get(id).printUserDetails();
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
        auchan.writing("ClientsList.txt");
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
        }

}
