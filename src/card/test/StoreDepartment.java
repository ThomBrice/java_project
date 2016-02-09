package card.test;

/**
 * La classe StoreDepartment représente un rayon du magasin
 *
 */
public class StoreDepartment {
    /**
     * Nom du rayon
     */
    private String name;

    /**
     * Constructeur de la classe StoreDepartment
     * @param dep : nom du rayon
     */
    public StoreDepartment(String dep) {
        setName(dep);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

