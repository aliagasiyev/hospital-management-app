package az.edu.hospitalmanagementproject.dto.page;

import az.edu.hospitalmanagementproject.dto.response.LabTestResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabTestPageResponse {
    private List<LabTestResponse> labTestList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
