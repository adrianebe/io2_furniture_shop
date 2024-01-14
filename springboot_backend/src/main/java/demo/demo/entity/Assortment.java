package demo.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    @Column(name = "availability")
    private int availability;

    @JsonIgnore
    @ManyToMany(mappedBy = "assortments")
    private List<Order> orders;
}