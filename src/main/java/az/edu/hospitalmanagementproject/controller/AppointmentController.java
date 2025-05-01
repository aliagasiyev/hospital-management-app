

import az.edu.hospitalmanagementproject.dto.page.AppointmentPageResponse;
import az.edu.hospitalmanagementproject.dto.request.AppointmentRequestDto;
import az.edu.hospitalmanagementproject.dto.response.AppointmentResponseDto;
import az.edu.hospitalmanagementproject.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
@RequestMapping({"/hospital/appointment"})
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping({"/add-appointment"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) {
        this.appointmentService.addAppointment(appointmentRequestDto);
    }

    @GetMapping({"/get-all-appointments"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public AppointmentPageResponse getAllAppointments(@RequestParam Integer page, @RequestParam Integer count) {
        return this.appointmentService.getAllAppointments(page, count);
    }

    @GetMapping({"/get-appointment-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public AppointmentResponseDto getAppointmentById(@PathVariable Integer id) {
        return this.appointmentService.getAppointmentById(id);
    }

    @DeleteMapping({"/delete-appointment-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteAppointmentById(@PathVariable Integer id) {
        this.appointmentService.deleteAppointmentById(id);
    }

    @PatchMapping({"/update-appointment-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateAppointmentById(@RequestBody @Valid AppointmentRequestDto appointmentRequestDto, @PathVariable Integer id) {
        this.appointmentService.updateAppointmentById(appointmentRequestDto, id);
    }
}
