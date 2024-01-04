package demo.demo.service;

import demo.demo.entity.FinancialReport;

import java.util.List;

public interface FinancialReportService {

    List<FinancialReport> getAllFinancialReports();

    FinancialReport getFinancialReportById(Long id);

    FinancialReport addNewFinancialReport(FinancialReport financialReport);

    void deleteFinancialReport(Long id);
}
