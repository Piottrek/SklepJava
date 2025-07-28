package pl.zajecia.skleplopata.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="orders")

public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId")
    private Long orderId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="address")
    private String address;
    @Column(name="postCode")
    private String postCode;
    @Column(name="city")
    private String city;
    @Column(name="created")
    private LocalDateTime created;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="orderId")
    private List<OrderItem> orderItems;
}
