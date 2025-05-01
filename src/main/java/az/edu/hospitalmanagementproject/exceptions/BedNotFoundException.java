package az.edu.hospitalmanagementproject.exceptions;

public class BedNotFoundException extends RuntimeException {
    public BedNotFoundException(String message) {
        super(message);
    }
}
