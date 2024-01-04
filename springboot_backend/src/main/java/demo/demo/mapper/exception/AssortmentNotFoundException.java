package demo.demo.mapper.exception;

public class AssortmentNotFoundException extends RuntimeException {
    public AssortmentNotFoundException(String message) {
        super(message);
    }
}
