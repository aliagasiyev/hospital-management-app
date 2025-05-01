package az.edu.hospitalmanagementproject.dto.response;

import az.edu.hospitalmanagementproject.enums.Status;
import az.edu.hospitalmanagementproject.model.Doctor;
import az.edu.hospitalmanagementproject.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationResponse {
    private String operationName;
    private String description;
    private LocalDateTime operationDate;
    private Patient patient;
    private Doctor doctor;
    private Status status;
}
