package az.edu.hospitalmanagementproject.dto.page;

import az.edu.hospitalmanagementproject.dto.response.PrescriptionResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionPageResponse {
    private List<PrescriptionResponse> prescriptionList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
