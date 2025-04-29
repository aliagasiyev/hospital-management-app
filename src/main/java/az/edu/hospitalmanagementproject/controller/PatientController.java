//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.PatientPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.PatientRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.PatientResponse;
import az.edu.turing.hospitalmanagementapp.service.PatientService;
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
@RequestMapping({"/hospital/patient"})
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping({"/add-patient"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addPatient(@RequestBody @Valid PatientRequest patientRequest) {
        this.patientService.addPatient(patientRequest);
    }

    @PatchMapping({"/update-patient-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updatePatientByID(@RequestBody @Valid PatientRequest patientRequest, @PathVariable Integer id) {
        this.patientService.updatePatientByID(patientRequest, id);
    }

    @PatchMapping({"/update-patient-by-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updatePatientByFirstNameAndLastName(@RequestBody @Valid PatientRequest patientRequest, @RequestParam String firstName, @RequestParam String lastName) {
        this.patientService.updatePatientByFirstNameAndLastName(patientRequest, firstName, lastName);
    }

    @GetMapping({"/get-all-patients"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PatientPageResponse getAllPatients(@RequestParam Integer page, @RequestParam Integer count) {
        return this.patientService.getAllPatients(page, count);
    }

    @GetMapping({"get-patient-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PatientResponse getPatientByID(@PathVariable Integer id) {
        return this.patientService.getPatientByID(id);
    }

    @GetMapping({"/get-patient-by-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PatientResponse getPatientByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return this.patientService.getPatientByFirstNameAndLastName(firstName, lastName);
    }

    @DeleteMapping({"/delete-patient-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deletePatientByID(@PathVariable Integer id) {
        this.patientService.deletePatientByID(id);
    }

    @DeleteMapping({"/delete-patient-by-id"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deletePatientByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        this.patientService.deletePatientByFirstNameAndLastName(firstName, lastName);
    }
}
