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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequestDto {
    private @NotNull(
            message = "date cannot be null") LocalDateTime date;private @NotNull(
            message = "status cannot be null"
    ) Status status;
    private @NotNull(
            message = "patient cannot be null"
    ) Patient patient;
    private @NotNull(
            message = "doctor cannot be null"
    ) Doctor doctor;
    private @NotBlank(
            message = "reason cannot be blank"
    ) String reason;
}
