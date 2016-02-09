package card.test;

import java.util.ArrayList;

/**
 * Created by isen on 30/01/2016.
 */
public class ShoppingBasket {
    private ArrayList<InterfaceProduct> products;
    private int nbArticle;
    private float price=0;

    public ShoppingBasket() {
        products = new ArrayList<>();
    }

    public void addProduct(int nb, InterfaceProduct product){
        setNbArticle(getNbArticle() + nb);
        this.products.add(product);
        setPrice(getPrice() + (nb*product.getPrice()));
    }

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
