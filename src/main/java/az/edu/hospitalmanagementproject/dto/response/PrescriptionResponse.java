package az.edu.hospitalmanagementproject.dto.response;

import az.edu.hospitalmanagementproject.model.Doctor;
import az.edu.hospitalmanagementproject.model.Medication;
import az.edu.hospitalmanagementproject.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionResponse {
    private LocalDateTime localDateTime;
    private Doctor doctor;
    private Patient patient;
    private List<Medication> medication;
    private String instructions;
    private boolean isValid;
}
