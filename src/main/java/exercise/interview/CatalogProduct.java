package exercise.interview;

public class CatalogProduct extends Product {
    protected final int priceInPennies;

    public CatalogProduct(String name, int priceInPennies) {
        super(name);
        this.priceInPennies = priceInPennies;
    }

    public int price() {
        return priceInPennies;
    }
}