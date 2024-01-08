package demo.demo.service;

import demo.demo.entity.AppUser;
import demo.demo.entity.Assortment;
import demo.demo.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    List<Order> getAllOrdersByAppUserId(Long id);

    void addNewOrder(AppUser appUser, List<Assortment> assortments);

    void deleteOrder(Long id);

    Order getOrderById(Long orderId);
}
