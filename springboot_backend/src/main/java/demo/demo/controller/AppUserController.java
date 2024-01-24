package demo.demo.controller;

import demo.demo.dto.AssortmentListDto;
import demo.demo.dto.OrderDto;
import demo.demo.entity.AppUser;
import demo.demo.entity.Assortment;
import demo.demo.entity.Complaint;
import demo.demo.entity.Order;
import demo.demo.mapper.OrderMapper;
import demo.demo.service.AppUserService;
import demo.demo.service.AssortmentService;
import demo.demo.service.ComplaintService;
import demo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final ComplaintService complaintService;


    @GetMapping("orders")
    public ResponseEntity<List<OrderDto>> getAllAppUserOrders() {
        AppUser currentUser = appUserService.getCurrentUser();

        return ResponseEntity.ok(orderService.getAllOrdersByAppUserId(currentUser.getId())
                .stream()
                .map(orderMapper::mapToDto)
                .toList());
    }

    @GetMapping("orders/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.ok(orderMapper.mapToDto(order));
    }


    @PostMapping("orders")
    public ResponseEntity<?> createOrder(@RequestBody AssortmentListDto assortmentIds) {
        AppUser currentUser = appUserService.getCurrentUser();
        String deliveryAddress = assortmentIds.deliveryAddress();

        List<Assortment> assortments = assortmentIds.assortmentIds().stream()
                .map(assortmentService::getAssortmentById)
                .collect(Collectors.toList());

        orderService.createNewOrder(currentUser, deliveryAddress, assortments);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("orders/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("complaints")
    public ResponseEntity<List<Complaint>> getAllAppUserComplaints() {
        AppUser currentUser = appUserService.getCurrentUser();
        List<Complaint> complaints = complaintService.getAllAppUserComplaints(currentUser.getId());

        return ResponseEntity.ok(complaints);
    }

    @GetMapping("complaints/{complaintId}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long complaintId) {
        Complaint complaint = complaintService.getComplaintById(complaintId);

        return ResponseEntity.ok(complaint);
    }

    @PostMapping("complaints")
    public ResponseEntity<?> addNewComplaint(@RequestBody Complaint complaint) {
        AppUser currentUser = appUserService.getCurrentUser();
        Order order = orderService.getOrderById(complaint.getOrder().getId());

        complaintService.createNewComplaint(currentUser, order, complaint);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("complaints/{complaintId}")
    public ResponseEntity<?> deleteAppUserComplaint(@PathVariable Long complaintId) {
        AppUser currentUser = appUserService.getCurrentUser();

        complaintService.deleteAppUserComplaint(complaintId, currentUser.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
