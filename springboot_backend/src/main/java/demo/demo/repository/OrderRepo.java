package demo.demo.repository;

import demo.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findAllByAppUserId(Long id);

    @Query(value = "SELECT COALESCE(SUM(o.price), 0) FROM Orders o WHERE o.order_date BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
    double getCountedPriceBetweenDate(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);
}
