package demo.demo.exception;

public class FinancialReportNotFoundException extends RuntimeException {
    public FinancialReportNotFoundException(String message) {
        super(message);
    }
}
