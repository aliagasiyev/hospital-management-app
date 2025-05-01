package az.edu.hospitalmanagementproject.model;

import az.edu.hospitalmanagementproject.enums.Status;
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
public class Bed {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer bedNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Room room;
    @OneToOne
    private Patient patient;
}
