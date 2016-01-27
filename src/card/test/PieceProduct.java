package card.test;

/**
 * Created by isen on 27/01/2016.
 */
public class PieceProduct  implements InterfaceProduct {

    private String name;
    private Float price;
    private int id;

    public void PieceProduct(String name, Float price, int id){
        setName(name);
        setPrice(price);
        setId(id);
    }

    public void print(){
        System.out.println(getName()+ getPrice() +"€ l'unité");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
