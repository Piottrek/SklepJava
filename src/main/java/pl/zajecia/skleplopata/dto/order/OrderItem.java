package pl.zajecia.skleplopata.dto.order;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Data
@Table(name="orderitem")
public class OrderItem implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="orderItemId")
    private Long orderItemId;
    @Column (name="orderId")
    private Long orderId;
    @Column (name="itemId")
    private Long itemId;
    @Column (name="amount")
    private int amount;

    public OrderItem(Long orderId, Long itemId, int amount) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.amount = amount;
    }

}
