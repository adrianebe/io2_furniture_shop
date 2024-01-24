package demo.demo.service.impl;

import demo.demo.entity.AppUser;
import demo.demo.entity.Assortment;
import demo.demo.entity.Order;
import demo.demo.entity.enums.OrderStatus;
import demo.demo.exception.custom.OrderNotFoundException;
import demo.demo.repository.OrderRepo;
import demo.demo.service.AssortmentService;
import demo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static demo.demo.entity.enums.OrderStatus.PENDING;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final AssortmentService assortmentService;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllOrdersByAppUserId(Long appUserId) {
        return orderRepo.findAllByAppUserId(appUserId);
    }

    @Override
    public void createNewOrder(AppUser appUser, String deliveryAddress, List<Assortment> assortments) {

        if (assortments == null || assortments.isEmpty()) {
            throw new IllegalArgumentException("List of assortments cannot be null");
        }

        for (Assortment assortment : assortments) {
            if (!assortmentService.isAssortmentAvailable(assortment)) {
                throw new IllegalArgumentException("Assortment by id" + assortment.getId() + " is not available");
            }
        }

        Order newOrder = new Order();
        newOrder.setAppUser(appUser);
        newOrder.setAssortments(assortments);
        newOrder.setPrice(calculateTotalPrice(assortments));
        newOrder.setDeliveryType(1);
        newOrder.setDeliveryDate(LocalDate.now().plusDays(3));
        newOrder.setOrderStatus(PENDING);
        newOrder.setDeliveryAddress(deliveryAddress);
        newOrder.setOrderDate(LocalDate.now());

        orderRepo.save(newOrder);
    }

    private double calculateTotalPrice(List<Assortment> assortments) {
        return assortments.stream().mapToDouble(Assortment::getPrice).sum();
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order with id: " + orderId + " was not found"));
    }

    @Override
    public double getCountedPriceBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return orderRepo.getCountedPriceBetweenDate(dateFrom, dateTo);
    }

    @Override
    public void updateOrder(Long orderId, LocalDate deliveryDate, OrderStatus orderStatus) {

        Order order = getOrderById(orderId);

        if (!(deliveryDate == null)) {
            order.setDeliveryDate(deliveryDate);
        }

        if (!(orderStatus == null)) {
            order.setOrderStatus(orderStatus);
        }

        orderRepo.save(order);
    }
}
