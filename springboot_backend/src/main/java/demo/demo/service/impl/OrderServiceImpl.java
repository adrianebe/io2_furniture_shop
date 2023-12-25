package demo.demo.service.impl;

import demo.demo.entity.Assortment;
import demo.demo.entity.Order;
import demo.demo.exception.AssortmentNotFoundException;
import demo.demo.repository.AssortmentRepo;
import demo.demo.repository.OrderRepo;
import demo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final AssortmentRepo assortmentRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllOrdersByAppUserId(Long id) {
        return orderRepo.findAllByAppUserId(id);
    }

    @Override
    public Order addNewOrder(Order order) {
        Assortment assortment = assortmentRepo.findById(order.getAssortment().getId()).orElse(null);

        if (assortment != null) {
            order.setPrice(assortment.getPrice());
        } else {
            throw new AssortmentNotFoundException("Assortment with ID " + order.getAssortment().getId() + " not found");
        }
        return orderRepo.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}
