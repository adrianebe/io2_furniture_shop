package demo.demo.controller;

import demo.demo.dto.ComplaintDto;
import demo.demo.dto.FinancialReportDatesDto;
import demo.demo.dto.OrderUpdateDto;
import demo.demo.entity.Assortment;
import demo.demo.entity.Complaint;
import demo.demo.entity.FinancialReport;
import demo.demo.entity.Order;
import demo.demo.service.AssortmentService;
import demo.demo.service.ComplaintService;
import demo.demo.service.FinancialReportService;
import demo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final AssortmentService assortmentService;
    private final FinancialReportService financialReportService;
    private final ComplaintService complaintService;
    private final OrderService orderService;

    @PostMapping("assortment")
    public ResponseEntity<?> addNewAssortment(@RequestBody Assortment assortment) {
        assortmentService.createNewAssortment(assortment);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("assortment/{assortmentId}")
    public ResponseEntity<?> updateAssortment(@PathVariable Long assortmentId, @RequestBody Assortment assortment) {
        assortmentService.updateAssortment(assortmentId, assortment);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("assortment/{assortmentId}")
    public ResponseEntity<?> deleteAssortmentById(@PathVariable Long assortmentId) {
        assortmentService.deleteAssortment(assortmentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("report")
    public ResponseEntity<List<FinancialReport>> getAllFinancialReports() {
        List<FinancialReport> financialReports = financialReportService.getAllFinancialReports();

        return ResponseEntity.ok(financialReports);
    }

    @GetMapping("report/{reportId}")
    public ResponseEntity<FinancialReport> getOneFinancialReport(@PathVariable Long reportId) {
        FinancialReport financialReport = financialReportService.getFinancialReportById(reportId);

        return ResponseEntity.ok(financialReport);
    }

    @PostMapping("report")
    public ResponseEntity<?> generateFinancialReport(@RequestBody FinancialReportDatesDto financialReportDatesDto) {
        financialReportService.generateNewFinancialReport(
                financialReportDatesDto.dateFrom(),
                financialReportDatesDto.dateTo()
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("report/{reportId}")
    public ResponseEntity<?> deleteFinancialReport(@PathVariable Long reportId) {
        financialReportService.deleteFinancialReport(reportId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("complaint")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();

        return ResponseEntity.ok(complaints);
    }

    @GetMapping("complaint/{complaintId}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long complaintId) {
        Complaint complaint = complaintService.getComplaintById(complaintId);

        return ResponseEntity.ok(complaint);
    }

    @PutMapping("complaint/{complaintId}")
    public ResponseEntity<?> updateComplaint(@PathVariable Long complaintId, @RequestBody ComplaintDto complaintDto) {
        complaintService.updateComplaint(
                complaintId,
                complaintDto.response(),
                complaintDto.status()
        );

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("complaint/{complaintId}")
    public ResponseEntity<?> deleteComplaint(@PathVariable Long complaintId) {
        complaintService.deleteComplaint(complaintId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();

        return ResponseEntity.ok(orders);
    }

    @PutMapping("orders/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable Long orderId, @RequestBody OrderUpdateDto updatedOrder) {
        orderService.updateOrder(
                orderId,
                updatedOrder.deliveryDate(),
                updatedOrder.orderStatus()
        );

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
