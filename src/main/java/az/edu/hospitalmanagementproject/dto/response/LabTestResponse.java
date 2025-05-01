package az.edu.hospitalmanagementproject.dto.response;

import az.edu.hospitalmanagementproject.enums.Result;
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
public class LabTestResponse {
    private LocalDateTime testDate;
    private Result result;
    private String description;
    private String testName;
    private Doctor doctor;
    private Patient patient;
}
