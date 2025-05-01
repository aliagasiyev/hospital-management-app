package az.edu.hospitalmanagementproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime localDateTime;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    @OneToMany
    private List<Medication> medication;
    private String instructions;
    private boolean isValid;
}
