package exercise.interview;


import com.google.common.collect.ImmutableList;

import java.util.List;

public class FakeCatalog extends Catalog {
    private static final List<CatalogProduct> PRODUCTS = ImmutableList.of(
            new CatalogProduct("Apple", 25),
            new CatalogProduct("Orange", 30),
            new CatalogProduct("Garlic", 15),
            new CatalogProduct("Papaya", 50)
            );

    public FakeCatalog() {
        super(PRODUCTS);
    }
}
