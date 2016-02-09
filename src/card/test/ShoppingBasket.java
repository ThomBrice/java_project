package card.test;

import java.util.ArrayList;

/**
 * La classe ShoppingBasket représente le panier de produit du client
 */
public class ShoppingBasket {
    /**
     * Liste de produits dans le paniers
     */
    private ArrayList<InterfaceProduct> products;

    /**
     * Nombre d'article dans le panier
     */
    private int nbArticle;

    /**
     * Prix du panier
     */
    private float price=0;

    /**
     * Constructeur de la classe ShoppingBasket
     * initialisation de la liste products
     */
    public ShoppingBasket() {
        products = new ArrayList<>();
    }

    /**
     * Méthode permettant l'ajout d'un objet product au panier.
     * @param nb : nombre de produits ajoutés
     * @param product : produit ajouté
     */
    public void addProduct(int nb, InterfaceProduct product){
        setNbArticle(getNbArticle() + nb);
        this.products.add(product);
        setPrice(getPrice() + (nb*product.getPrice()));
    }

    /**
     * Affiche le contenu du panier
     */
    public void print(){
        System.out.println("");
         for (InterfaceProduct aTempo1 : products) {
            System.out.print(aTempo1.getNb() + " ");
            aTempo1.print();
        }
        System.out.println("Montant Total : " + String.format("%.2f", getPrice())+"€"); // arrondie le prix à 2 chiffres aprés la virgule
        System.out.println("");
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNbArticle() {
        return nbArticle;
    }

    public void setNbArticle(int nbArticle) {
        this.nbArticle = nbArticle;
    }
}
