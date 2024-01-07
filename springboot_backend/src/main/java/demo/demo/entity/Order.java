package demo.demo.entity;

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

}
