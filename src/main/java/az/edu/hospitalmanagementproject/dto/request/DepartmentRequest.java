package az.edu.hospitalmanagementproject.dto.request;

import az.edu.hospitalmanagementproject.model.Doctor;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentRequest {
    private @NotNull(
            message = "department name cannot be blank"
    ) String name;
    private @NotNull(
            message = "doctor cannot be null"
    ) Doctor headOfDepartment;

}
