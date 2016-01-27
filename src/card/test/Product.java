package card.test;

/**
 * Created by isen on 27/01/2016.
 */
public class Product {
    private String name;
    private Float price;
    private int id;
    private char type;

    public Product(){};

    public Product(String name, Float price, int id, char type){
        setId(id);
        setPrice(price);
        setName(name);
        setType(type);
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

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
