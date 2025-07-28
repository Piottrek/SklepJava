package pl.zajecia.skleplopata;

import lombok.Getter;
import pl.zajecia.skleplopata.model.Item;

import java.math.BigDecimal;

@Getter
public class CartItem {
    private Item item;
    private int counter;
    private BigDecimal price;

    public CartItem(Item item) {
        this.item = item;
        this.counter = 1;
        this.price = item.getPrice();
    }

    public void increaseCounter() {
        counter++;
        recalculate();
    }

    public void decreaseCounter() {
        counter--;
        recalculate();
    }

    public void recalculate() {
        this.price = item.getPrice().multiply(BigDecimal.valueOf(counter));
    }

    public boolean hasZeroItems() {
        return counter == 0;
    }

    public boolean isEquals(Item otherItem) {
        return item.getId().equals(otherItem.getId());
    }
}
