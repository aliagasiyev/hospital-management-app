//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.LabTestPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.LabTestRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.LabTestResponse;
import az.edu.turing.hospitalmanagementapp.service.LabTestService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/hospital/laboratory"})
public class LabTestController {
    private final LabTestService labTestService;

    public LabTestController(LabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @PostMapping({"/add-test"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addLabTest(@RequestBody @Valid LabTestRequest labTestRequest) {
        this.labTestService.addLabTest(labTestRequest);
    }

    @PatchMapping({"/update-test-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateLabTestById(@RequestBody @Valid LabTestRequest labTestRequest, @PathVariable Integer id) {
        this.labTestService.updateLabTestById(labTestRequest, id);
    }

    @GetMapping({"/get-all-tests"})
    @ResponseStatus(HttpStatus.OK)
    public LabTestPageResponse getAllLabTests(@RequestParam Integer page, @RequestParam Integer count) {
        return this.labTestService.getAllLabTests(page, count);
    }

    @GetMapping({"/get-tes-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public LabTestResponse getLabTestById(@PathVariable Integer id) {
        return this.labTestService.getLabTestById(id);
    }

    @GetMapping({"get-test-by-doctor-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<LabTestResponse> getLabTestsByDoctorId(@PathVariable("id") Integer doctorId) {
        return this.labTestService.getLabTestsByDoctorId(doctorId);
    }

    @GetMapping({"get-test-by-patient-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<LabTestResponse> getLabTestsByPatientId(@PathVariable Integer id) {
        return this.labTestService.getLabTestsByPatientId(id);
    }

    @GetMapping({"get-test-by-doctor-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    public List<LabTestResponse> getLabTestsByDoctorFirstnameAndLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return this.labTestService.getLabTestsByDoctorFirstnameAndLastname(firstname, lastname);
    }

    @GetMapping({"/get-test-by-patient-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    public List<LabTestResponse> getLabTestsByPatientFirstnameAndLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return this.labTestService.getLabTestsByPatientFirstnameAndLastname(firstname, lastname);
    }

    @DeleteMapping({"/delete-test-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteLabTestByID(@PathVariable Integer id) {
        this.labTestService.deleteLabTestByID(id);
    }
}
