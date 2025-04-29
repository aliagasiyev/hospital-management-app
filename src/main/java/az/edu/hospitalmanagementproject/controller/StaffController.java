//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.StaffPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.StaffRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.StaffResponse;
import az.edu.turing.hospitalmanagementapp.enums.RoleEnum;
import az.edu.turing.hospitalmanagementapp.service.StaffService;
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
@RequestMapping({"/hospital/staff"})
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping({"/add-staff-member"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addStaffMember(@RequestBody @Valid StaffRequest staffRequest) {
        this.staffService.addStaffMember(staffRequest);
    }

    @PatchMapping({"/update-staff-member-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateStaffMemberByID(@RequestBody @Valid StaffRequest staffRequest, @PathVariable Integer id) {
        this.staffService.updateStaffMemberByID(staffRequest, id);
    }

    @PatchMapping({"/update-staff-member-by-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateStaffMemberByFirstNameAndLastName(@RequestBody @Valid StaffRequest staffRequest, @RequestParam String firstName, @RequestParam String lastName) {
        this.staffService.updateStaffMemberByFirstNameAndLastName(staffRequest, firstName, lastName);
    }

    @GetMapping({"/get-all-staff-members"})
    @ResponseStatus(HttpStatus.OK)
    public StaffPageResponse getAllStaffMembers(@RequestParam Integer page, @RequestParam Integer count) {
        return this.staffService.getAllStaffMembers(page, count);
    }

    @GetMapping({"/get-staff-members-by-role"})
    @ResponseStatus(HttpStatus.OK)
    public StaffPageResponse getStaffMembersByRole(@RequestParam RoleEnum roleEnum, @RequestParam Integer page, @RequestParam Integer count) {
        return this.staffService.getStaffMembersByRole(roleEnum, page, count);
    }

    @GetMapping({"/get-staff-member-by-id/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public StaffResponse getStaffMemberByID(@PathVariable Integer id) {
        return this.staffService.getStaffMemberByID(id);
    }

    @GetMapping({"/get-staff-member-by-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.OK)
    public StaffResponse getStaffMemberByFirstNamAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return this.staffService.getStaffMemberByFirstNamAndLastName(firstName, lastName);
    }

    @DeleteMapping({"/delete-staff-member-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteStaffMemberByID(@PathVariable Integer id) {
        this.staffService.deleteStaffMemberByID(id);
    }

    @DeleteMapping({"/delete-staff-member-by-firstname-and-lastname"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteStaffMemberByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        this.staffService.deleteStaffMemberByFirstNameAndLastName(firstName, lastName);
    }
}
