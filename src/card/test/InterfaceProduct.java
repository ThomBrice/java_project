package card.test;

/**
 * Interface qui représente un produit.
 *
 */
public interface InterfaceProduct {
    /**
     * méthode d'affichage du produit
     */
    void print();
    float getPrice();

    /**
     * Demande la quantité d'un produit
     */
    void quantityChoice();
    int getNb();
    void setNb(int nb);
}
