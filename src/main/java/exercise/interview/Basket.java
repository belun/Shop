package exercise.interview;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {
    private static final Discount NO_DISCOUNT = quantity -> 0;

    private final Catalog catalog;
    private final List<BasketProduct> basketProducts;
    private final Map<Product, Discount> discounts;

    public Basket(Catalog catalog) {
        this(catalog, Collections.emptyList(), Collections.emptyMap());
    }

    private Basket(Catalog catalog, List<BasketProduct> basketProducts, Map<Product, Discount> discounts) {
        this.catalog = catalog;
        this.basketProducts = basketProducts;
        this.discounts = discounts;
    }

    public Basket add(String name, int quantity) {
        return new Basket(
                catalog,
                new ImmutableList.Builder().addAll(basketProducts).add(new BasketProduct(name, quantity)).build(),
                discounts);
    }

    public Integer total() {
        return basketProducts.stream()
                .collect(Collectors.summingInt(
                    product -> product.totalWhenPriceIs(catalog.priceOf((Product)product))
                )
        );
    }

    public int numberOfItems() {
        return basketProducts.stream()
                .collect(Collectors.summingInt(
                    basketProducts -> basketProducts.quantityWhenThereAre(discounts)
                )
        );
    }

    public Receipt receipt() {
        List<ReceiptProduct> receiptProducts = basketProducts.stream()
                .map(basketProduct -> basketProduct.asReceiptProduct(catalog, discounts))
                .collect(Collectors.toList());
        return new Receipt(receiptProducts, total());
    }

    public Basket withDiscount(String productName, Discount discount) {
        return new Basket(
                catalog,
                basketProducts,
                new ImmutableMap.Builder().putAll(discounts).put(new Product(productName), discount).build()
        );
    }
}
