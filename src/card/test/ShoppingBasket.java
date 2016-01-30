package card.test;

import java.text.DecimalFormat;
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
        nbArticle+=nb;
        this.products.add(product);
        price+=(nb*product.getPrice());
    }

    public void print(){
        System.out.println("");
         for (InterfaceProduct aTempo1 : products) {
            System.out.print(aTempo1.getNb() + " ");
            aTempo1.print();
        }
        System.out.println("total amount : " + String.format("%.2f",price)+"€"); // arrondie le prix à 2 chiffres aprés la virgule
        System.out.println("");
    }

}
