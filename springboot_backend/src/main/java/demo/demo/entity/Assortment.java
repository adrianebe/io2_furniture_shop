package demo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "assortment")
public class Assortment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private int availability;
}