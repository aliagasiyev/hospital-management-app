package az.edu.hospitalmanagementproject.dto.request;

import az.edu.hospitalmanagementproject.enums.Gender;
import az.edu.hospitalmanagementproject.enums.Specialization;
import az.edu.hospitalmanagementproject.model.Appointment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorRequest {
    private @NotBlank(
            message = "name cannot be blank"
    ) String firstName;
    private @NotBlank(
            message = "surname cannot be blank"
    ) String lastName;
    private @NotBlank(
            message = "specialization cannot be blank"
    ) Specialization specialization;
    private @NotNull(
            message = "experience cannot be null"
    ) Integer yearsOfExperience;
    private @NotBlank(
            message = "phone number cannot be blank"
    ) String phoneNumber;
    private @NotBlank(
            message = "email cannot be blank"
    ) String email;
    private @NotBlank(
            message = "department cannot be blank"
    ) String department;
    private @NotNull(
            message = "age cannot be null"
    ) Integer age;
    private @NotNull(
            message = "gender cannot be null"
    ) Gender gender;
    private List<Appointment> appointment;

}
