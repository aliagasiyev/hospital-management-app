package az.edu.hospitalmanagementproject.model;

import az.edu.hospitalmanagementproject.enums.Gender;
import az.edu.hospitalmanagementproject.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;
    private String email;
    private String phoneNumber;
    private String department;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
