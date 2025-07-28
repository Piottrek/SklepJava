package pl.zajecia.skleplopata.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zajecia.skleplopata.Cart;
import pl.zajecia.skleplopata.dto.OrderDto;
import pl.zajecia.skleplopata.dto.order.Order;
import pl.zajecia.skleplopata.mapper.OrderMapper;
import pl.zajecia.skleplopata.repository.order.OrderItemRepository;
import pl.zajecia.skleplopata.repository.order.OrderRepository;

@Service
public class OrderService {

    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart, order));
        cart.cleanCart();
    }
}
