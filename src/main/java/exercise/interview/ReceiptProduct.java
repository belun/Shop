package exercise.interview;

public class ReceiptProduct extends Product {

    private final int priceInPennies;
    private final int quantity;

    public ReceiptProduct(Product product, int priceInPennies, int quantity) {
        super(product.name);
        this.priceInPennies = priceInPennies;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-10s %3d %4dp", name, quantity, priceInPennies);
    }
}