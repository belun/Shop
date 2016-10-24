package exercise.interview;

import java.util.List;

public class Catalog {
    private final List<CatalogProduct> products;

    public Catalog(List<CatalogProduct> products) {
        this.products = products;
    }

    public Integer priceOf(final Product product) {
        if (!products.contains(product)) {
            throw new RuntimeException("Item not available for sale");
        }
        return products.stream()
                .filter(catalogProduct -> ((Product)catalogProduct).equals(product))
                .findFirst().get().price();
    }
}
