package demo.demo.controller;

import demo.demo.dto.ComplaintDto;
import demo.demo.dto.FinancialReportDatesDto;
import demo.demo.entity.Assortment;
import demo.demo.entity.FinancialReport;
import demo.demo.service.AssortmentService;
import demo.demo.service.ComplaintService;
import demo.demo.service.FinancialReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final AssortmentService assortmentService;
    private final FinancialReportService financialReportService;
    private final ComplaintService complaintService;

    @PostMapping("assortment")
    public ResponseEntity<?> addNewAssortment(@RequestBody Assortment assortment) {
        assortmentService.addNewAssortment(assortment);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("assortment/{assortmentId}")
    public ResponseEntity<?> updateAssortment(@PathVariable Long assortmentId, @RequestBody Assortment assortment) {
        Assortment updatedAssortment = assortmentService.updateAssortment(assortmentId, assortment);

        return ResponseEntity.ok(updatedAssortment);
    }

    @DeleteMapping("assortment/{assortmentId}")
    public ResponseEntity<?> deleteAssortmentById(@PathVariable Long assortmentId) {
        assortmentService.deleteAssortment(assortmentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("report")
    public ResponseEntity<List<FinancialReport>> getAllFinancialReports() {
        return ResponseEntity.ok(financialReportService.getAllFinancialReports());
    }

    @GetMapping("report/{reportId}")
    public ResponseEntity<FinancialReport> getOneFinancialReport(@PathVariable Long reportId) {
        return ResponseEntity.ok(financialReportService.getFinancialReportById(reportId));
    }

    @PostMapping("report")
    public ResponseEntity<?> generateFinancialReport(@RequestBody FinancialReportDatesDto financialReportDatesDto) {
        financialReportService
                .generateNewFinancialReport(
                        financialReportDatesDto.dateFrom(),
                        financialReportDatesDto.dateTo());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("report/{reportId}")
    public ResponseEntity<?> deleteFinancialReport(@PathVariable Long reportId) {
        financialReportService.deleteFinancialReport(reportId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("complaint/{complaintId}")
    public ResponseEntity<?> updateComplaint(@PathVariable Long complaintId, @RequestBody ComplaintDto complaintDto) {
        complaintService.updateComplaint(complaintId,
                complaintDto.description(),
                complaintDto.status());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("complaint/{complaintId}")
    public ResponseEntity<?> deleteComplaint(@PathVariable Long complaintId) {
        complaintService.deleteComplaint(complaintId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
