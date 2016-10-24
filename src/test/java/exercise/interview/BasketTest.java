package exercise.interview;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BasketTest {
    interface ExpectedPrices {
        int Apple = 25;
        int Orange = 30;
        int Garlic = 15;
        int Papaya = 50;
    }

    Basket emptyBasket = new Basket(new FakeCatalog());

    @Test
    public void shouldHaveOneItemValuedAt25p() throws Exception {
        int QUANTITY = 1;
        Basket basket = this.emptyBasket.add("Apple", QUANTITY);
        assertThat(basket.total(), equalTo(ExpectedPrices.Apple));
        assertThat(basket.numberOfItems(), equalTo(QUANTITY));
    }

    @Test
    public void shouldHaveOneItemSeveralTimesValuedAt75p() throws Exception {
        int QUANTITY = 3;
        Basket basket = this.emptyBasket.add("Apple", QUANTITY);
        assertThat(basket.total(), equalTo(ExpectedPrices.Apple * QUANTITY));
        assertThat(basket.numberOfItems(), equalTo(QUANTITY));
    }

    @Test
    public void shouldCumulateTotalOfSeveralItem() throws Exception {
        Basket basket = this.emptyBasket.add("Apple", 2).add("Orange", 1).add("Garlic", 3).add("Papaya", 1);
        assertThat(basket.total(), equalTo(
                ExpectedPrices.Apple * 2
                + ExpectedPrices.Orange
                + ExpectedPrices.Garlic * 3
                + ExpectedPrices.Papaya
        ));
        assertThat(basket.numberOfItems(), equalTo(7));
    }

    @Test
    public void shouldProvideDiscountForPapayas() throws Exception {
        int QUANTITY = 2;
        Basket basket = this.emptyBasket.add("Papaya", QUANTITY).withDiscount("Papaya", new FreeItemEach(2));
        assertThat(basket.total(), equalTo(ExpectedPrices.Papaya * QUANTITY));
        assertThat(basket.numberOfItems(), equalTo(3));
    }
}
