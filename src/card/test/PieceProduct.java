package card.test;

/**
 * La classe PieceProduct représente un produit qui est vendu à la pièce.
 * Elle implémente l'interface InterfaceProduct.
 */
public class PieceProduct  implements InterfaceProduct {
    /**
     * Nom du produit
     */
    private String name;

    /**
     * Prix du produit
     */
    private Float price;

    /**
     * Nombre de produit choisi
     */
    private int nb;

    /**
     * Affiche le prix du produit à l'unité
     * Override la méthode print() de l'InterfaceProduct
     */
    @Override
    public void print(){
        System.out.println(getName()+ " " + getPrice() +"€ l'unité");
    }

    /**
     * Demande le nombre de produit voulu
     * Override la méthode quantityChoice() de l'InterfaceProduct
     */
    @Override
    public void quantityChoice(){
        System.out.println("Combien en voulez vous ?");
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
