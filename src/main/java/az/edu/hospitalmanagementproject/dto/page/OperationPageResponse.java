package az.edu.hospitalmanagementproject.dto.page;

import az.edu.hospitalmanagementproject.dto.response.OperationResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationPageResponse {
    private List<OperationResponse> departmentList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
