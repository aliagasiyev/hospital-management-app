//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.PrescriptionPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.PrescriptionRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.PrescriptionResponse;
import az.edu.turing.hospitalmanagementapp.service.PrescriptionService;
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
@RequestMapping({"/hospital/prescription"})
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping({"/add-prescription"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addPrescription(@RequestBody PrescriptionRequest prescriptionRequest) {
        this.prescriptionService.addPrescription(prescriptionRequest);
    }

    @PatchMapping({"/update-prescription-by-prescription-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updatePrescriptionByPrescriptionId(@RequestBody PrescriptionRequest prescriptionRequest, @PathVariable Integer id) {
        this.prescriptionService.updatePrescriptionByPrescriptionId(prescriptionRequest, id);
    }

    @GetMapping({"/get-all-prescriptions"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public PrescriptionPageResponse getAllPrescriptions(@RequestParam Integer page, @RequestParam Integer count) {
        return this.prescriptionService.getAllPrescriptions(page, count);
    }

    @GetMapping({"/get-prescription-by-doctor-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<PrescriptionResponse> getPrescriptionByDoctorId(@PathVariable Integer id) {
        return this.prescriptionService.getPrescriptionByDoctorId(id);
    }

    @GetMapping({"/get-prescription-by-patient-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<PrescriptionResponse> getPrescriptionByPatientId(@PathVariable Integer id) {
        return this.prescriptionService.getPrescriptionByPatientId(id);
    }

    @PostMapping({"/validate-prescription/{prescriptionId}"})
    @ResponseStatus
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Boolean validatePrescription(@PathVariable Integer prescriptionId) {
        return this.prescriptionService.validatePrescription(prescriptionId);
    }

    @DeleteMapping({"/delete-prescription-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deletePrescriptionById(@PathVariable Integer id) {
        this.prescriptionService.deletePrescriptionById(id);
    }
}
