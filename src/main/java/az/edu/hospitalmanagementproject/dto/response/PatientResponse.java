package az.edu.hospitalmanagementproject.dto.response;

import az.edu.hospitalmanagementproject.enums.Gender;
import az.edu.hospitalmanagementproject.model.Appointment;
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
public class PatientResponse {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String email;
    private String medicalHistory;
    private LocalDateTime dateOfBirth;
    private List<Appointment> appointment;
}
