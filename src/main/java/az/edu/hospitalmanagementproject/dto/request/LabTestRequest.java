package az.edu.hospitalmanagementproject.dto.request;

import az.edu.hospitalmanagementproject.enums.Result;
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
public class LabTestRequest {
    private @NotNull(
            message = "test date cannot be null"
    ) LocalDateTime testDate;
    private @NotBlank(
            message = "result cannot be blank"
    ) Result result;
    private @NotBlank(
            message = "description cannot be blank"
    ) String description;
    private @NotBlank(
            message = "test name cannot be blank"
    ) String testName;
    private @NotNull(
            message = "doctor cannot be null"
    ) Doctor doctor;
    private @NotNull(
            message = "patient cannot be null"
    ) Patient patient;

}
