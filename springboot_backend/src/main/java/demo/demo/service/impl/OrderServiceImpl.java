package demo.demo.service.impl;

import demo.demo.entity.AppUser;
import demo.demo.entity.Assortment;
import demo.demo.entity.Order;
import demo.demo.exception.OrderNotFoundException;
import demo.demo.repository.OrderRepo;
import demo.demo.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllOrdersByAppUserId(Long id) {
        return orderRepo.findAllByAppUserId(id);
    }

    @Override
    public void addNewOrder(AppUser appUser, List<Assortment> assortments) {
        Order newOrder = new Order();
        newOrder.setAppUser(appUser);
        newOrder.setAssortments(assortments);
        newOrder.setPrice(calculateTotalPrice(assortments));
        newOrder.setDeliveryType(1);
        newOrder.setDeliveryDate(LocalDate.now().plusDays(3));

        orderRepo.save(newOrder);
    }

    private double calculateTotalPrice(List<Assortment> assortments) {
        return assortments.stream().mapToDouble(Assortment::getPrice).sum();
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order with id: " + orderId + " was not found"));
    }
}
