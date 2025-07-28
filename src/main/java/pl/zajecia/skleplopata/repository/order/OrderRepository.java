package pl.zajecia.skleplopata.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajecia.skleplopata.dto.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}