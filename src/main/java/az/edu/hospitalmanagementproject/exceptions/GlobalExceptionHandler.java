package az.edu.hospitalmanagementproject.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({AppointmentNotFoundException.class})
    public Map<String, String> handleAppointmentNotFoundException(AppointmentNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({DepartmentNotFoundException.class})
    public Map<String, String> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({DoctorNotFoundException.class})
    public Map<String, String> handleDoctorNotFoundException(DoctorNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({MedicationNotFoundException.class})
    public Map<String, String> handleMedicationNotFoundException(MedicationNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({PatientNotFoundException.class})
    public Map<String, String> handlePatientNotFoundException(PatientNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({StaffMemberNotFoundException.class})
    public Map<String, String> handleStaffMemberNotFoundException(StaffMemberNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({IncorrectCredentialsException.class})
    public Map<String, String> handleIncorrectCredentialsException(IncorrectCredentialsException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({PrescriptionNotFoundException.class})
    public Map<String, String> handlePrescriptionNotFoundException(PrescriptionNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    public Map<String, String> handleUsernameNotFoundException(UsernameNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({RoleNotFoundException.class})
    public Map<String, String> handleRoleNotFoundException(RoleNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({RoomNotFoundException.class})
    public Map<String, String> handleRoomNotFoundException(RoomNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({LabTestNotFoundException.class})
    public Map<String, String> handleLabTestNotFoundException(LabTestNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({BedNotFoundException.class})
    public Map<String, String> handleBedNotFoundException(BedNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({NoBedAvailableException.class})
    public Map<String, String> handleNoBedAvailableException(NoBedAvailableException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler({OperationNotFoundException.class})
    public Map<String, String> handleOperationNotFoundException(OperationNotFoundException e) {
        Map<String, String> map = new HashMap();
        map.put("message", e.getMessage());
        return map;
    }
}

