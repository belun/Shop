package exercise.interview;

public class FreeItemEach implements Discount {
    private final int pieces;

    public FreeItemEach(int pieces) {
        this.pieces = pieces;
    }

    @Override
    public int when(int totalQuantity) {
        return totalQuantity / pieces;
    }
}
