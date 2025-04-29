//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.OperationPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.OperationRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.OperationResponse;
import az.edu.turing.hospitalmanagementapp.enums.Status;
import az.edu.turing.hospitalmanagementapp.service.OperationService;
import jakarta.validation.Valid;
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
@RequestMapping({"/hospital/operation"})
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping({"/add-operation"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addOperation(@RequestBody @Valid OperationRequest operationRequest) {
        this.operationService.addOperation(operationRequest);
    }

    @PatchMapping({"/update-operation-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateOperationById(@RequestBody @Valid OperationRequest operationRequest, @PathVariable Integer id) {
        this.operationService.updateOperationById(operationRequest, id);
    }

    @GetMapping({"/get-all-operations"})
    @ResponseStatus(HttpStatus.OK)
    public OperationPageResponse getAllOperations(@RequestParam Integer page, @RequestParam Integer count) {
        return this.operationService.getAllOperations(page, count);
    }

    @GetMapping({"/get-operation-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public OperationResponse getOperationByID(@PathVariable Integer id) {
        return this.operationService.getOperationByID(id);
    }

    @GetMapping({"/get-operation-by-doctor-id/{doctorId}"})
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResponse> getOperationByDoctorId(@PathVariable Integer doctorId) {
        return this.operationService.getOperationByDoctorId(doctorId);
    }

    @GetMapping({"/get-operation-by-doctor-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResponse> getOperationByDoctorFirstnameAndLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return this.operationService.getOperationByDoctorFirstnameAndLastname(firstname, lastname);
    }

    @GetMapping({"/get-operation-by-patient-id/{patientId}"})
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResponse> getOperationByPatientId(@PathVariable Integer patientId) {
        return this.operationService.getOperationByPatientId(patientId);
    }

    @GetMapping({"/get-operation-by-patient-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    public List<OperationResponse> getOperationByPatientFirstnameAndLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return this.operationService.getOperationByPatientFirstnameAndLastname(firstname, lastname);
    }

    @DeleteMapping({"/delete-operation-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteOperationById(@PathVariable Integer id) {
        this.operationService.deleteOperationById(id);
    }

    @GetMapping({"/get-status-of-operation-by-id/{id}"})
    public Status getStatusOfOperationById(@PathVariable Integer id) {
        return this.operationService.getStatusOfOperationById(id);
    }
}
