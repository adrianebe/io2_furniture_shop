package demo.demo.service;

import demo.demo.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    List<Order> getAllOrdersByAppUserId(Long id);

    Order addNewOrder(Order order);

    void deleteOrder(Long id);
}
