package az.edu.hospitalmanagementproject.model;


import az.edu.hospitalmanagementproject.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = " operation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String operationName;
    private String description;
    private LocalDateTime operationDate;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @Enumerated(EnumType.STRING)
    private Status status;

}
