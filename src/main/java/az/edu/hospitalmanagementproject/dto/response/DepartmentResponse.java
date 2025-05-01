package az.edu.hospitalmanagementproject.dto.response;

import az.edu.hospitalmanagementproject.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponse {
    private String name;
    private Doctor headOfDepartment;

}
