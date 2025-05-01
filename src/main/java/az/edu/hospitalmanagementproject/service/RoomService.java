package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.RoomPageResponse;
import az.edu.hospitalmanagementproject.dto.request.RoomRequest;
import az.edu.hospitalmanagementproject.dto.response.RoomResponse;
import az.edu.hospitalmanagementproject.enums.Status;

import java.util.List;

public interface RoomService {

    void addRoom(RoomRequest var1);

    void updateRoomByRoomNumber(RoomRequest var1, Integer var2);

    RoomPageResponse getAllRooms(Integer var1, Integer var2);

    RoomResponse getRoomByRoomNumber(Integer var1);

    List<RoomResponse> getRoomsByDoctorId(Integer var1);

    List<RoomResponse> getRoomsByDoctorFirstnameAndDoctorLastname(String var1, String var2);

    RoomResponse getRoomByPatientId(Integer var1);

    RoomResponse getRoomByPatientFirstnameAndPatientLastname(String var1, String var2);

    void deleteRoomByRoomNumber(Integer var1);

    boolean isAvailable(Status var1);
}
