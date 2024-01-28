package demo.demo.dto;

import java.time.LocalDate;

public record FinancialReportDatesDto(
        LocalDate dateFrom,
        LocalDate dateTo
) {
}
