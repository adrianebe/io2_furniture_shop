package demo.demo.controller;

import demo.demo.dto.AssortmentListDto;
import demo.demo.dto.OrderDto;
import demo.demo.entity.AppUser;
import demo.demo.entity.Assortment;
import demo.demo.entity.Order;
import demo.demo.mapper.OrderMapper;
import demo.demo.service.AppUserService;
import demo.demo.service.AssortmentService;
import demo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;
    private final OrderService orderService;
    private final AssortmentService assortmentService;
    private final OrderMapper orderMapper;


    @GetMapping("orders")
    public ResponseEntity<List<OrderDto>> getAllAppUserOrders() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser appUser = (AppUser) appUserService.loadUserByUsername(email);

        return ResponseEntity.ok(orderService.getAllOrdersByAppUserId(appUser.getId())
                .stream()
                .map(orderMapper::mapToDto)
                .toList());
    }

    @GetMapping("orders/{orderId}")
    public ResponseEntity<OrderDto> getSpecificOrderDetails(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.ok(orderMapper.mapToDto(order));
    }


    @PostMapping("orders")
    public ResponseEntity<?> createOrder(@RequestBody AssortmentListDto assortmentIds) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser appUser = (AppUser) appUserService.loadUserByUsername(email);

        List<Assortment> assortments = assortmentIds.assortmentIds().stream()
                .map(assortmentService::getAssortmentById)
                .collect(Collectors.toList());

        orderService.addNewOrder(appUser, assortments);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("orders/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
