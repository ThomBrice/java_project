package card.test;

/**
 * Created by isen on 27/01/2016.
 */
public class PieceProduct  implements InterfaceProduct {

    private String name;
    private Float price;
    private int nb;

    public void print(){
        System.out.println(getName()+ " " + getPrice() +"€ l'unité");
    }

    public void quantityChoice(){
        System.out.println("Combien en voulez vous ?");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
}
