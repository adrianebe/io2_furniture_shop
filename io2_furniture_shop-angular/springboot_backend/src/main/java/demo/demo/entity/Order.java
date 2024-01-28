package demo.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import demo.demo.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "order_assortment",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "assortment_id"))
    private List<Assortment> assortments;

    @Column(name = "price")
    private double price;

    @Column(name = "delivery_type")
    private int deliveryType;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "delivery_address")
    private String deliveryAddress;

}
