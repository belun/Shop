package exercise.interview;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Product {
    protected final String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object product) {
        return new EqualsBuilder().append(name, ((Product)product).name).build();
    }
}
