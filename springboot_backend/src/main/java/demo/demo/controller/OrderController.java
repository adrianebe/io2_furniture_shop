package demo.demo.controller;

import demo.demo.entity.Order;
import demo.demo.repository.OrderRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderRepo orderRepo;

    public OrderController(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    @GetMapping("get")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    @PostMapping("new")
    public Order newOrder(@RequestBody Order order){
        return orderRepo.save(order);
    }

}
