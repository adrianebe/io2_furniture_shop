package demo.demo.exception;

public class AssortmentNotFoundException extends RuntimeException {
    public AssortmentNotFoundException(String message) {
        super(message);
    }
}
