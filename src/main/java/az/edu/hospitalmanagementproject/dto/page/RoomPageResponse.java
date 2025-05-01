package az.edu.hospitalmanagementproject.dto.page;

import az.edu.hospitalmanagementproject.dto.response.RoomResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomPageResponse {
    private List<RoomResponse> roomList;
    private long totalPages;
    private long totalElements;
    private boolean hasNext;
}
