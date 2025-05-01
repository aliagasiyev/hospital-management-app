package az.edu.hospitalmanagementproject.exceptions;

public class NoBedAvailableException extends RuntimeException {
    public NoBedAvailableException(String message) {
        super(message);
    }
}
