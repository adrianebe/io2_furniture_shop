package demo.demo.service.impl;

import demo.demo.entity.FinancialReport;
import demo.demo.exception.custom.FinancialReportNotFoundException;
import demo.demo.repository.FinancialReportRepo;
import demo.demo.service.FinancialReportService;
import demo.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialReportServiceImpl implements FinancialReportService {

    private final FinancialReportRepo financialReportRepo;
    private final OrderService orderService;

    @Override
    public List<FinancialReport> getAllFinancialReports() {
        return financialReportRepo.findAll();
    }

    @Override
    public FinancialReport getFinancialReportById(Long id) {
        return financialReportRepo.findById(id)
                .orElseThrow(() -> new FinancialReportNotFoundException("Financial report by id: " + id + "was not found!"));

    }

    @Override
    public void generateNewFinancialReport(LocalDate dateFrom, LocalDate dateTo) {
        FinancialReport financialReport = new FinancialReport();
        financialReport.setDateFrom(dateFrom);
        financialReport.setDateTo(dateTo);
        financialReport.setType("Income");
        financialReport.setMoneyEarned(orderService.getCountedPriceBetweenDate(dateFrom, dateTo));

        financialReportRepo.save(financialReport);
    }

    @Override
    public void deleteFinancialReport(Long id) {
        financialReportRepo.deleteById(id);
    }
}
