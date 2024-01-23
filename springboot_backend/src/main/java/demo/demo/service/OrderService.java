package demo.demo.service;

import demo.demo.entity.AppUser;
import demo.demo.entity.Assortment;
import demo.demo.entity.Order;
import demo.demo.entity.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    List<Order> getAllOrdersByAppUserId(Long appUserId);

    void createNewOrder(AppUser appUser, String deliveryAddress, List<Assortment> assortments);

    void deleteOrder(Long id);

    Order getOrderById(Long orderId);

    double getCountedPriceBetweenDate(LocalDate dateFrom, LocalDate dateTo);

    void updateOrder(Long orderId, LocalDate deliveryDate, OrderStatus orderStatus);
}
