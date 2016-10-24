package exercise.interview;

import java.util.List;

public class Receipt {

    private final List<ReceiptProduct> products;
    private final Integer total;

    public Receipt(List<ReceiptProduct> products, Integer total) {
        this.products = products;
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        String lineSeparator = System.lineSeparator();
        products.stream().forEach(receiptProduct -> {
            buffer.append(receiptProduct.toString()).append(lineSeparator);
        });
        buffer.append(String.format("%-14s %4dp", "Total", total));

        return buffer.toString();
    }
}
