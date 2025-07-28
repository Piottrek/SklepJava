package pl.zajecia.skleplopata.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="item")
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="UMGURL")
    private String imgURL;
    private String name;
    private String description;
    private BigDecimal price;

    public Item(String name, String description, BigDecimal price, String imgURL) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
    }
}
