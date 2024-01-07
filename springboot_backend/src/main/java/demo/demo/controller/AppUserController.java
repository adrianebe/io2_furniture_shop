package demo.demo.controller;

import demo.demo.entity.AppUser;
import demo.demo.service.AppUserService;
import demo.demo.service.AssortmentService;
import demo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;
    private final OrderService orderService;
    private final AssortmentService assortmentService;


    @GetMapping("orders")
    public ResponseEntity<?> getAllAppUserOrders() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser appUser = (AppUser) appUserService.loadUserByUsername(email);

        return ResponseEntity.ok(orderService.getAllOrdersByAppUserId(appUser.getId()));
    }

    @GetMapping("orders/{orderId}")
    public ResponseEntity<?> getSpecificOrderDetails(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    //TODO: make this works
//    @PostMapping("orders")
//    public ResponseEntity<?> createOrder(@RequestBody List<Long> assortmentIds) {
//        String email = SecurityContextHolder.getContext().getAuthentication().getName();
//        AppUser appUser = (AppUser) appUserService.loadUserByUsername(email);
//
//        List<Assortment> assortments = assortmentIds.stream()
//                .map(assortmentService::getAssortmentById)
//                .collect(Collectors.toList());
//
//        Order newOrder = orderService.addNewOrder(appUser, assortments);
//        return ResponseEntity.ok(newOrder);
//    }

    @DeleteMapping("orders/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
