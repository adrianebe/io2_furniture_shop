package demo.demo.controller;

import demo.demo.entity.FinancialReport;
import demo.demo.service.FinancialReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/finances")
public class FinancialReportController {

    private final FinancialReportService financialReportService;

    @GetMapping("get")
    public List<FinancialReport> getAllBoards() {
        return financialReportService.getAllFinancialReports();
    }

    @PostMapping("add")
    public FinancialReport addNewBoard(@RequestBody FinancialReport financialReport) {
        return financialReportService.addNewFinancialReport(financialReport);
    }

    @DeleteMapping("delete/{financialReportId}")
    public void deleteBoard(@PathVariable Long financialReport) {
        financialReportService.deleteFinancialReport(financialReport);
    }
}
