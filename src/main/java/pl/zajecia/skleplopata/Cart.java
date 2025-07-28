package pl.zajecia.skleplopata;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.zajecia.skleplopata.model.Item;
import pl.zajecia.skleplopata.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;
    private final ItemRepository itemRepository;



    public Cart(ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
        /*List<Item> items = new ArrayList<>(itemRepository.findAll());
        for (Item item : items) {
            this.addItem(item);
            this.addItem(item);
        }*/
    }

    public void addItem(Item item)
    {
        getCartItemByItem(item).ifPresentOrElse(CartItem::increaseCounter, () -> cartItems.add(new CartItem(item)));
        recalculatePriceAndCounter();
    }


    public void decreaseItem(Item item)
    {
        Optional<CartItem> oCartItem = getCartItemByItem(item);

        if (oCartItem.isPresent()) {
            CartItem cartItem = oCartItem.get();
            cartItem.decreaseCounter();
            if (cartItem.hasZeroItems())
            {
                removeAllItems(item);
            }
            recalculatePriceAndCounter();
        }
    }

    private Optional<CartItem> getCartItemByItem(Item item)
    {
        return cartItems.stream().filter(ci -> ci.getItem().getId() == item.getId()).findFirst();
    }

    public void removeAllItems(Item item)
    {
        cartItems.removeIf(i->i.isEquals(item));
        recalculatePriceAndCounter();
    }

    private void recalculatePriceAndCounter() {
        this.counter = cartItems.stream()
                .mapToInt(CartItem::getCounter)
                .sum();

        this.sum = cartItems.stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void cleanCart()
    {
        cartItems.clear();
        counter = 0;
        sum= BigDecimal.ZERO;
    }
}
