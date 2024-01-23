package demo.demo.exception.custom;

public class AssortmentNotFoundException extends RuntimeException {
    public AssortmentNotFoundException(String message) {
        super(message);
    }
}
