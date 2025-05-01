//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.service.impl;

import az.edu.turing.hospitalmanagementapp.dto.page.RoomPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.RoomRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.RoomResponse;
import az.edu.turing.hospitalmanagementapp.enums.Status;
import az.edu.turing.hospitalmanagementapp.exception.RoomNotFoundException;
import az.edu.turing.hospitalmanagementapp.mapper.RoomMapper;
import az.edu.turing.hospitalmanagementapp.model.Room;
import az.edu.turing.hospitalmanagementapp.repository.RoomRepository;
import az.edu.turing.hospitalmanagementapp.service.RoomService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public void addRoom(RoomRequest roomRequest) {
        this.roomRepository.save(this.roomMapper.toRoomEntity(roomRequest));
    }

    public void updateRoomByRoomNumber(RoomRequest roomRequest, Integer roomNumber) {
        Optional<Room> existingRoom = this.roomRepository.findById(roomNumber);
        if (existingRoom.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        } else {
            ((Room)existingRoom.get()).setRoomStatus(roomRequest.getRoomStatus());
            ((Room)existingRoom.get()).setDoctor(roomRequest.getDoctor());
            ((Room)existingRoom.get()).setPatient(roomRequest.getPatient());
            this.roomRepository.save((Room)existingRoom.get());
        }
    }

    public RoomPageResponse getAllRooms(Integer page, Integer count) {
        Page<Room> roomPage = this.roomRepository.findAll(PageRequest.of(page, count));
        if (roomPage.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        } else {
            Stream var10002 = roomPage.getContent().stream();
            RoomMapper var10003 = this.roomMapper;
            var10003.getClass();
            return new RoomPageResponse((List)var10002.map(var10003::toRoomResponse).collect(Collectors.toList()), (long)roomPage.getTotalPages(), roomPage.getTotalElements(), roomPage.hasNext());
        }
    }

    public RoomResponse getRoomByRoomNumber(Integer roomNumber) {
        Stream var10000 = this.roomRepository.findById(roomNumber).stream();
        RoomMapper var10001 = this.roomMapper;
        var10001.getClass();
        return (RoomResponse)var10000.map(var10001::toRoomResponse).findFirst().orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

    public List<RoomResponse> getRoomsByDoctorId(Integer doctorId) {
        List<Room> roomList = this.roomRepository.findByDoctor_Id(doctorId);
        if (roomList.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        } else {
            Stream var10000 = roomList.stream();
            RoomMapper var10001 = this.roomMapper;
            var10001.getClass();
            return (List)var10000.map(var10001::toRoomResponse).collect(Collectors.toList());
        }
    }

    public List<RoomResponse> getRoomsByDoctorFirstnameAndDoctorLastname(String firstname, String lastname) {
        List<Room> roomList = this.roomRepository.findByDoctor_FirstNameAndDoctor_LastName(firstname, lastname);
        if (roomList.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        } else {
            Stream var10000 = roomList.stream();
            RoomMapper var10001 = this.roomMapper;
            var10001.getClass();
            return (List)var10000.map(var10001::toRoomResponse).collect(Collectors.toList());
        }
    }

    public RoomResponse getRoomByPatientId(Integer patientId) {
        Stream var10000 = this.roomRepository.findByPatient_Id(patientId).stream();
        RoomMapper var10001 = this.roomMapper;
        var10001.getClass();
        return (RoomResponse)var10000.map(var10001::toRoomResponse).findFirst().orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

    public RoomResponse getRoomByPatientFirstnameAndPatientLastname(String firstname, String lastname) {
        Stream var10000 = this.roomRepository.findByPatient_FirstNameAndPatient_LastName(firstname, lastname).stream();
        RoomMapper var10001 = this.roomMapper;
        var10001.getClass();
        return (RoomResponse)var10000.map(var10001::toRoomResponse).findFirst().orElseThrow(() -> new RoomNotFoundException("Room not found"));
    }

    public void deleteRoomByRoomNumber(Integer roomNumber) {
        Optional<Room> room = this.roomRepository.findById(roomNumber);
        if (room.isEmpty()) {
            throw new RoomNotFoundException("Room not found");
        } else {
            this.roomRepository.deleteById(roomNumber);
        }
    }

    public boolean isAvailable(Status status) {
        switch (status) {
            case AVAILABLE -> {
                return true;
            }
            case OCCUPIED -> {
                return false;
            }
            default -> {
                return false;
            }
        }
    }
}
