package az.edu.hospitalmanagementproject.dto.request;

import az.edu.hospitalmanagementproject.enums.Gender;
import az.edu.hospitalmanagementproject.model.Appointment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class PatientRequest {
    private @NotBlank(
            message = "firstname cannot be blank"
    ) String firstName;
    private @NotBlank(
            message = "lastname cannot be blank"
    ) String lastName;
    private @NotNull(
            message = "gender cannot bo null"
    ) Gender gender;
    private @NotNull(
            message = "age cannot be null"
    ) Integer age;
    private @NotBlank(
            message = "address cannot be blank"
    ) String address;
    private @NotBlank(
            message = "phone number cannot be blank"
    ) String phoneNumber;
    private @NotBlank(
            message = "email cannot be blank"
    ) String email;
    private @NotNull(
            message = "firstname cannot be blank"
    ) LocalDateTime dateOfBirth;
    private @NotNull(
            message = "medical history cannot be null. If patient doesn't have medical history then write empty"
    ) String medicalHistory;
    private List<Appointment> appointment;
}
