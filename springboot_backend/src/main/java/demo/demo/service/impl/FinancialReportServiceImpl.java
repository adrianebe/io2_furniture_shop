package demo.demo.service.impl;

import demo.demo.entity.FinancialReport;
import demo.demo.mapper.exception.FinancialReportNotFoundException;
import demo.demo.repository.FinancialReportRepo;
import demo.demo.service.FinancialReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FinancialReportServiceImpl implements FinancialReportService {

    private final FinancialReportRepo financialReportRepo;

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
    public FinancialReport addNewFinancialReport(FinancialReport financialReport) {
        return financialReportRepo.save(financialReport);
    }

    @Override
    public void deleteFinancialReport(Long id) {
        financialReportRepo.deleteById(id);
    }
}
