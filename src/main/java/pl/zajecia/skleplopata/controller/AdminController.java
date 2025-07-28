package pl.zajecia.skleplopata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.skleplopata.dto.order.Order;
import pl.zajecia.skleplopata.model.Item;
import pl.zajecia.skleplopata.repository.ItemRepository;
import pl.zajecia.skleplopata.repository.order.OrderRepository;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ItemRepository itemRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public AdminController(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String addItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "adminview/additem";
    }

    @PostMapping
    public String addItemSubmit(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "redirect:/";
    }

    @GetMapping("/showorders")
    @ResponseBody
    public List<Order> showOrders() {
        return orderRepository.findAll();
    }
}
