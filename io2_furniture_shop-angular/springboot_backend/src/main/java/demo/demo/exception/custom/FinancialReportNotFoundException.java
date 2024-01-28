package demo.demo.exception.custom;

public class FinancialReportNotFoundException extends RuntimeException {
    public FinancialReportNotFoundException(String message) {
        super(message);
    }
}
