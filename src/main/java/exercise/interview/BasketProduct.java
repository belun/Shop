package exercise.interview;

import java.util.Map;

public class BasketProduct extends Product {
    private final int quantity;

    public BasketProduct(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    public int totalWhenPriceIs(Integer price) {
        return price * quantity;
    }

    public int quantityWhenThereAre(Map<Product, Discount> discounts) {
        if(!discounts.containsKey(this)) {
            return quantity;
        }
        return quantity + discounts.get(this).when(quantity);
    }

    public ReceiptProduct asReceiptProduct(Catalog catalog, Map<Product, Discount> discounts) {
        return new ReceiptProduct(this, catalog.priceOf(this), quantity);
    }
}
