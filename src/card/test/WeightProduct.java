package card.test;

/**
 * Created by isen on 30/01/2016.
 */
public class WeightProduct  implements InterfaceProduct {

    private String name;
    private Float price;
    private int nb;

    @Override
    public void print(){
        System.out.println(getName()+ " " + getPrice() +"€ le kilo");
    }

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
    public Float getPrice() {
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
