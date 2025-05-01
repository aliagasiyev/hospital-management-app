package az.edu.hospitalmanagementproject.dto.response;

import az.edu.hospitalmanagementproject.enums.Status;
import az.edu.hospitalmanagementproject.model.Patient;
import az.edu.hospitalmanagementproject.model.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BedResponse {
    private Status status;
    private Room room;
    private Patient patient;
}
