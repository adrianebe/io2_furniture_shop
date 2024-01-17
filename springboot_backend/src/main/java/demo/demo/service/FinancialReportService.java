package demo.demo.service;

import demo.demo.entity.FinancialReport;

import java.time.LocalDate;
import java.util.List;

public interface FinancialReportService {

    List<FinancialReport> getAllFinancialReports();

    FinancialReport getFinancialReportById(Long id);

    void generateNewFinancialReport(LocalDate dateFrom, LocalDate dateTo);

    void deleteFinancialReport(Long id);
}
