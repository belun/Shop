package exercise.interview;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReceiptTest {

    Basket emptyBasket = new Basket(new FakeCatalog());

    @Test
    public void shouldShowOneItemValuedAt25p() throws Exception {
        int QUANTITY = 1;
        Receipt receipt = this.emptyBasket.add("Apple", QUANTITY).receipt();
        assertThat(receipt.toString(), equalTo(
                "Apple        1   25p" + System.lineSeparator() +
                "Total            25p"));

    }

    @Test
    public void shouldShowMultipleItems() throws Exception {
        Receipt receipt = this.emptyBasket.add("Apple", 2).add("Orange", 4).receipt();
        assertThat(receipt.toString(), equalTo(
                "Apple        2   25p" + System.lineSeparator() +
                "Orange       4   30p" + System.lineSeparator() +
                "Total           170p"
        ));

    }
}