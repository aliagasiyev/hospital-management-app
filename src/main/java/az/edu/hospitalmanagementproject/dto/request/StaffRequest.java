package az.edu.hospitalmanagementproject.dto.request;

import az.edu.hospitalmanagementproject.enums.Gender;
import az.edu.hospitalmanagementproject.enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffRequest {
    private @NotBlank(
            message = "firstname cannot be blank"
    ) String firstName;
    private @NotBlank(
            message = "lastname cannot be blank"
    ) String lastName;
    private @NotNull(
            message = "role cannot be null"
    ) RoleEnum roleEnum;
    private @NotBlank(
            message = "email cannot be blank"
    ) String email;
    private @NotBlank(
            message = "phone number cannot be blank"
    ) String phoneNumber;
    private @NotBlank(
            message = "department cannot be blank"
    ) String department;
    private @NotNull(
            message = "age cannot be null"
    ) Integer age;
    private @NotBlank(
            message = "gender cannot be blank"
    ) Gender gender;

}
