package demo.demo.entity;

import demo.demo.entity.enums.ComplaintStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private ComplaintStatus status;

    @Column(name = "response")
    private String response;
}
