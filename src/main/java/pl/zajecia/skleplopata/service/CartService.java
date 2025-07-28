package pl.zajecia.skleplopata.service;


import org.springframework.stereotype.Service;
import pl.zajecia.skleplopata.Cart;
import pl.zajecia.skleplopata.ItemOperation;
import pl.zajecia.skleplopata.model.Item;
import pl.zajecia.skleplopata.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final ItemRepository itemRepository;

    private final Cart cart;

    public CartService(ItemRepository itemRepository, Cart cart) {
        this.itemRepository = itemRepository;
        this.cart = cart;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public void updateCartItem(long itemId, ItemOperation operation) {
        Optional<Item> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent())
        {
            Item item = oItem.get();
            switch (operation)
            {
                case INCREASE : cart.addItem(item);
                break;
                case DECREASE : cart.decreaseItem(item);
                break;
                case REMOVE : cart.removeAllItems(item);
            }
        }
    }
}
