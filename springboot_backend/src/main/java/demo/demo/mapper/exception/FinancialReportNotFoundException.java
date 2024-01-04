package demo.demo.mapper.exception;

public class FinancialReportNotFoundException extends RuntimeException {
    public FinancialReportNotFoundException(String message) {
        super(message);
    }
}
