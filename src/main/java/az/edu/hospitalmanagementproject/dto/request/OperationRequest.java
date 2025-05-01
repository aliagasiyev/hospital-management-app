package az.edu.hospitalmanagementproject.dto.request;

import az.edu.hospitalmanagementproject.enums.Status;
import az.edu.hospitalmanagementproject.model.Doctor;
import az.edu.hospitalmanagementproject.model.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationRequest {
    private @NotBlank(
            message = "operation name cannot be blank"
    ) String operationName;
    private @NotBlank(
            message = "description cannot be blank"
    ) String description;
    private @NotNull(
            message = "date cannot be null"
    ) LocalDateTime operationDate;
    private @NotNull(
            message = "patient cannot be null"
    ) Patient patient;
    private @NotNull(
            message = "doctor cannot be null"
    ) Doctor doctor;
    private @NotBlank(
            message = "status cannot be blank"
    ) Status status;

}
