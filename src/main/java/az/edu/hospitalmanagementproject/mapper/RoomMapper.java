package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.RoomRequest;
import az.edu.hospitalmanagementproject.dto.response.RoomResponse;
import az.edu.hospitalmanagementproject.model.Room;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface RoomMapper {
    Room toRoomEntity(RoomRequest var1);

    RoomResponse toRoomResponse(Room var1);
}
