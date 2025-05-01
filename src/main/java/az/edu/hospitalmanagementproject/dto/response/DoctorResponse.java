package az.edu.hospitalmanagementproject.dto.response;

import az.edu.hospitalmanagementproject.enums.Gender;
import az.edu.hospitalmanagementproject.enums.Specialization;
import az.edu.hospitalmanagementproject.model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DoctorResponse {
    private String firstName;
    private String lastName;
    private Specialization specialization;
    private Integer yearsOfExperience;
    private String phoneNumber;
    private String email;
    private String department;
    private Integer age;
    private Gender gender;
    private List<Appointment> appointment;

}
