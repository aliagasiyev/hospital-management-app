//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.DoctorPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.DoctorRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.DoctorResponse;
import az.edu.turing.hospitalmanagementapp.enums.Specialization;
import az.edu.turing.hospitalmanagementapp.service.DoctorService;
import jakarta.validation.Valid;
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
@RequestMapping({"/hospital/doctor"})
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping({"/add-doctor"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    private void addDoctor(@RequestBody @Valid DoctorRequest doctorRequest) {
        this.doctorService.addDoctor(doctorRequest);
    }

    @PatchMapping({"/update-doctor-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateDoctorByID(@RequestBody @Valid DoctorRequest doctorRequest, @PathVariable Integer id) {
        this.doctorService.updateDoctorByID(doctorRequest, id);
    }

    @PatchMapping({"/update-doctor-by-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateDoctorByFirstNameAndLastName(@RequestBody @Valid DoctorRequest doctorRequest, @RequestParam String firstName, @RequestParam String lastName) {
        this.doctorService.updateDoctorByFirstNameAndLastName(doctorRequest, firstName, lastName);
    }

    @GetMapping({"/get-all-doctors"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorPageResponse getAllDoctors(@RequestParam Integer page, @RequestParam Integer count) {
        return this.doctorService.getAllDoctors(page, count);
    }

    @GetMapping({"/get-doctors-by-specialization"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorPageResponse getDoctorsBySpecialization(@RequestParam Specialization specialization, @RequestParam Integer page, @RequestParam Integer count) {
        return this.doctorService.getDoctorsBySpecialization(specialization, page, count);
    }

    @GetMapping({"/get-doctors-by-department"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorPageResponse getDoctorsByDepartment(@RequestParam String department, @RequestParam Integer page, @RequestParam Integer count) {
        return this.doctorService.getDoctorsByDepartment(department, page, count);
    }

    @GetMapping({"/get-all-doctors-order-by-age"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorPageResponse getAllDoctorsOrderByID(@RequestParam Integer page, @RequestParam Integer count) {
        return this.doctorService.getAllDoctorsOrderByAge(page, count);
    }

    @GetMapping({"/get-doctor-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorResponse getDoctorByID(@PathVariable Integer id) {
        return this.doctorService.getDoctorByID(id);
    }

    @GetMapping({"/get-doctor-by-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DoctorResponse getDoctorByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return this.doctorService.getDoctorByFirstNameAndLastName(firstName, lastName);
    }

    @DeleteMapping({"/delete-doctor-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteDoctorByID(@PathVariable Integer id) {
        this.doctorService.deleteDoctorByID(id);
    }

    @DeleteMapping({"/delete-doctor-by-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteDoctorByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        this.doctorService.deleteDoctorByFirstNameAndLastName(firstName, lastName);
    }
}
