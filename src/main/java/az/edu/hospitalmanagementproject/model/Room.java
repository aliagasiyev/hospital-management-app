package az.edu.hospitalmanagementproject.model;

import az.edu.hospitalmanagementproject.enums.Status;
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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomNumber;
    @Enumerated(EnumType.STRING)
    private Status roomStatus;
    @OneToMany
    private List<Patient> patient;
    @ManyToOne
    private Doctor doctor;
}
