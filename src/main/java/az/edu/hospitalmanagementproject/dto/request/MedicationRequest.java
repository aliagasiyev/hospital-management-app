package az.edu.hospitalmanagementproject.dto.request;

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
public class MedicationRequest {

    private @NotBlank(
            message = "medication name cannot be blank"
    ) String name;
    private @NotBlank(
            message = "manufacturer name cannot be blank"
    ) String manufacturer;
    private @NotNull(
            message = "expiry date cannot be blank"
    ) LocalDateTime expiryDate;

}
