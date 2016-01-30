package card.test;

/**
 * Created by isen on 30/01/2016.
 */
public class WeightProduct  implements InterfaceProduct {

    private String name;
    private Float price;
    private int nb;

    public void print(){
        System.out.println(getName()+ " " + getPrice() +"€ le kilo");
    }

    public void quantityChoice(){
        System.out.println("How many Kilogrammes do you want ?");
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
