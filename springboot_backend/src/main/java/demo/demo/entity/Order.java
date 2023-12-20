package demo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "assortment_id")
    private Assortment assortment;

    @Column(name = "price")
    private int price;

    @Column(name = "delivery_type")
    private int deliveryType;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

}
