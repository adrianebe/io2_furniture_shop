package demo.demo.controller;

import demo.demo.entity.Order;
import demo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("get")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("get/{appUserId}")
    public List<Order> getAllOrdersByAppUserId(@PathVariable Long appUserId) {
        return orderService.getAllOrdersByAppUserId(appUserId);
    }


    @DeleteMapping("delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

}
