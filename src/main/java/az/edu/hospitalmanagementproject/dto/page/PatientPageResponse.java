package az.edu.hospitalmanagementproject.dto.page;

import az.edu.hospitalmanagementproject.dto.response.PatientResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientPageResponse {
    private List<PatientResponse> patientList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
