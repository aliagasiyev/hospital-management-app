package az.edu.hospitalmanagementproject.model;

import az.edu.hospitalmanagementproject.enums.Gender;
import az.edu.hospitalmanagementproject.enums.Specialization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Doctor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Specialization specialization;
    private Integer yearsOfExperience;
    private String phoneNumber;
    private String email;
    private String department;
    @OneToMany
    private List<Appointment> appointment;
}
