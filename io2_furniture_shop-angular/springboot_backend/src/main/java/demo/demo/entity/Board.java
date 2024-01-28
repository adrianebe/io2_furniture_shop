package demo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private String size;

    @Column(name = "availability")
    private int availability;
}
