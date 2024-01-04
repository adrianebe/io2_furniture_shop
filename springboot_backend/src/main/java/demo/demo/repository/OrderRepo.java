package demo.demo.repository;

import demo.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findAllByAppUserId(Long id);
}
