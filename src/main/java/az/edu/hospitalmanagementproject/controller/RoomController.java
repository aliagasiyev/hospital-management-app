//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.RoomPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.RoomRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.RoomResponse;
import az.edu.turing.hospitalmanagementapp.enums.Status;
import az.edu.turing.hospitalmanagementapp.service.RoomService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/hospital/room"})
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping({"/add-room"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addRoom(@RequestBody RoomRequest roomRequest) {
        this.roomService.addRoom(roomRequest);
    }

    @PatchMapping({"/update-room-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateRoomByRoomNumber(@RequestBody RoomRequest roomRequest, @PathVariable("id") Integer roomNumber) {
        this.roomService.updateRoomByRoomNumber(roomRequest, roomNumber);
    }

    @GetMapping({"/get-all-rooms"})
    @ResponseStatus(HttpStatus.OK)
    public RoomPageResponse getAllRooms(@RequestParam Integer page, @RequestParam Integer count) {
        return this.roomService.getAllRooms(page, count);
    }

    @GetMapping({"/get-room-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse getRoomByRoomNumber(@PathVariable("id") Integer roomNumber) {
        return this.roomService.getRoomByRoomNumber(roomNumber);
    }

    @GetMapping({"/get-room-by-doctor-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<RoomResponse> getRoomByDoctorId(@PathVariable("id") Integer doctorId) {
        return this.roomService.getRoomsByDoctorId(doctorId);
    }

    @GetMapping({"/get-room-by-doctor-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    public List<RoomResponse> getRoomByDoctorFirstnameAndDoctorLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return this.roomService.getRoomsByDoctorFirstnameAndDoctorLastname(firstname, lastname);
    }

    @GetMapping({"/get-room-by-patient-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse getRoomByPatientId(@PathVariable("id") Integer patientId) {
        return this.roomService.getRoomByPatientId(patientId);
    }

    @GetMapping({"/get-room-by-patient-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse getRoomByPatientFirstnameAndPatientLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return this.roomService.getRoomByPatientFirstnameAndPatientLastname(firstname, lastname);
    }

    @DeleteMapping({"/delete-room-by-room-number/{number}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteRoomByRoomNumber(@PathVariable("number") Integer rooNumber) {
        this.roomService.deleteRoomByRoomNumber(rooNumber);
    }

    @PostMapping({"/is-available"})
    @ResponseStatus(HttpStatus.OK)
    public boolean isAvailable(Status status) {
        return this.roomService.isAvailable(status);
    }
}
