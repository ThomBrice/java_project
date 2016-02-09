package card.test;

/**
 * La classe WeightProduct représente un produit qui est vendu au kilogramme.
 * Elle implémente l'interface InterfaceProduct.
 */
public class WeightProduct  implements InterfaceProduct {
    /**
     * Nom du produit
     */
    private String name;

    /**
     * Prix du produit
     */
    private Float price;

    /**
     * Nombre de kilo choisi du produit.
     */
    private int nb;

    /**
     * Affiche le prix du produit au kilo
     * Override la méthode print() de l'InterfaceProduct
     */
    @Override
    public void print(){
        System.out.println(getName()+ " " + getPrice() +"€ le kilo");
    }

    /**
     * Demande du nombre de kilo choisi
     * Override la méthode quantityChoice() de l'InterfaceProduct
     */
    @Override
    public void quantityChoice(){
        System.out.println("Combien de kilogrammes voulez vous ?");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public int getNb() {
        return nb;
    }

    @Override
    public void setNb(int nb) {
        this.nb = nb;
    }
}
