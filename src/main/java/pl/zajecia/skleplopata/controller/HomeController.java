package pl.zajecia.skleplopata.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.zajecia.skleplopata.Cart;
import pl.zajecia.skleplopata.ItemOperation;
import pl.zajecia.skleplopata.model.Item;
import pl.zajecia.skleplopata.repository.ItemRepository;
import pl.zajecia.skleplopata.service.CartService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {
    private final CartService cartService;

    public HomeController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", cartService.getAllItems());
        return "home";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, Model model) {
        model.addAttribute("items",cartService.getAllItems());
        cartService.updateCartItem(itemId, ItemOperation.INCREASE);
        return "redirect:/";
    }


}

