package az.edu.hospitalmanagementproject.model;

import az.edu.hospitalmanagementproject.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    private String reason;
}
