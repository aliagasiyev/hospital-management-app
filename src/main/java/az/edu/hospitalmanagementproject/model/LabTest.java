package az.edu.hospitalmanagementproject.model;

import az.edu.hospitalmanagementproject.enums.Result;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LabTest {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private LocalDateTime testDate;
    @Enumerated(EnumType.STRING)
    private Result result;
    private String description;
    private String testName;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
}
