package pl.zajecia.skleplopata.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zajecia.skleplopata.Cart;
import pl.zajecia.skleplopata.ItemOperation;
import pl.zajecia.skleplopata.dto.OrderDto;
import pl.zajecia.skleplopata.service.CartService;
import pl.zajecia.skleplopata.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderController {


    private final CartService cartService;
    private final OrderService orderService;


    public OrderController (CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService= orderService;
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cartView";
    }

    @GetMapping("/increase/{itemId}")
    public String increaseItem(@PathVariable("itemId") Long itemId) {
        cartService.updateCartItem(itemId, ItemOperation.INCREASE);
        return "redirect:/order/cart";
    }

    @GetMapping("/decrease/{itemId}")
    public String decreaseItem(@PathVariable("itemId") Long itemId) {
        cartService.updateCartItem(itemId, ItemOperation.DECREASE);
        return "redirect:/order/cart";
    }

    @GetMapping("/remove/{itemId}")
    public String removeItem(@PathVariable("itemId") Long itemId) {
        cartService.updateCartItem(itemId, ItemOperation.REMOVE);
        return "redirect:/order/cart";
    }

    @GetMapping("/summary")
    public String showSummary() {
        return "summary";
    }

    @PostMapping("/saveorder")
    public String saveOrder(OrderDto orderDto)
    {
        orderService.saveOrder(orderDto);
        return "redirect:/order/confirmation";
    }
    @GetMapping("/confirmation")
    public String showConfirmation() {
        return "confirmation";
    }

}

