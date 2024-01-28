package demo.demo.repository;

import demo.demo.entity.FinancialReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialReportRepo extends JpaRepository<FinancialReport, Long> {
}
