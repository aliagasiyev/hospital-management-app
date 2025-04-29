//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.MedicationPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.MedicationRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.MedicationResponse;
import az.edu.turing.hospitalmanagementapp.service.MedicationService;
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
@RequestMapping({"/hospital/medication"})
public class MedicationController {
    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping({"/add-medication"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addMedication(@RequestBody @Valid MedicationRequest medicationRequest) {
        this.medicationService.addMedication(medicationRequest);
    }

    @PatchMapping({"/update-medication-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateMedicationById(@RequestBody @Valid MedicationRequest medicationRequest, @PathVariable Integer id) {
        this.medicationService.updateMedicationById(medicationRequest, id);
    }

    @GetMapping({"/get-all-medications"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public MedicationPageResponse getAllMedications(@RequestParam Integer page, @RequestParam Integer count) {
        return this.medicationService.getAllMedications(page, count);
    }

    @GetMapping({"/get-medication-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public MedicationResponse getMedicationByID(@PathVariable Integer id) {
        return this.medicationService.getMedicationByID(id);
    }

    @DeleteMapping({"/delete-medication-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteMedicationByID(@PathVariable Integer id) {
        this.medicationService.deleteMedicationByID(id);
    }
}
