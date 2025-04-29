//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.BedPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.BedRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.BedResponse;
import az.edu.turing.hospitalmanagementapp.service.BedService;
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
@RequestMapping({"/hospital/bed"})
public class BedController {
    private final BedService bedService;

    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @PostMapping({"/add-bed"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addBed(@RequestBody BedRequest bedRequest) {
        this.bedService.addBed(bedRequest);
    }

    @PatchMapping({"/update-bed-by-bed-number/{bedNumber}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateBedByBedNumber(@RequestBody BedRequest bedRequest, @PathVariable Integer bedNumber) {
        this.bedService.updateBedByBedNumber(bedRequest, bedNumber);
    }

    @GetMapping({"/get-all-beds"})
    @ResponseStatus(HttpStatus.OK)
    public BedPageResponse getAllBeds(@RequestParam Integer page, @RequestParam Integer count) {
        return this.bedService.getAllBeds(page, count);
    }

    @GetMapping({"/get-all-available-beds"})
    @ResponseStatus(HttpStatus.OK)
    public BedPageResponse getAllAvailableBeds(@RequestParam Integer page, @RequestParam Integer count) {
        return this.bedService.getAllAvailableBeds(page, count);
    }

    @GetMapping({"/get-bed-by-bed-number/{bedNumber}"})
    @ResponseStatus(HttpStatus.OK)
    public BedResponse getBedByBedNumber(@PathVariable Integer bedNumber) {
        return this.bedService.getBedByBedNumber(bedNumber);
    }

    @GetMapping({"/get-bed-by-patient-id/{patientId}"})
    @ResponseStatus(HttpStatus.OK)
    public BedResponse getBedByPatientId(@PathVariable Integer patientId) {
        return this.bedService.getBedByPatientId(patientId);
    }

    @GetMapping({"get-bed-by-patient-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    public BedResponse getBedByPatientFirstnameAndLastname(@RequestParam String firstname, @RequestParam String lastname) {
        return this.bedService.getBedByPatientFirstnameAndLastname(firstname, lastname);
    }

    @PostMapping({"/bed-is-available-or-not/{bedNumber}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean isAvailableOrNot(@PathVariable Integer bedNumber) {
        return this.bedService.isAvailableOrNot(bedNumber);
    }

    @DeleteMapping({"/delete-bed-by-bed-number/{bedNumber}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteBedByBedNumber(@PathVariable Integer bedNumber) {
        this.bedService.deleteBedByBedNumber(bedNumber);
    }
}
