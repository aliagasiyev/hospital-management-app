package az.edu.hospitalmanagementproject.exceptions;

public class StaffMemberNotFoundException extends RuntimeException {
    public StaffMemberNotFoundException(String message) {
        super(message);
    }
}
