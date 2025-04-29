//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.page.DepartmentPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.DepartmentRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.DepartmentResponse;
import az.edu.turing.hospitalmanagementapp.service.DepartmentService;
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
@RequestMapping({"hospital/department"})
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping({"/add-department"})
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addDepartment(@RequestBody @Valid DepartmentRequest departmentRequest) {
        this.departmentService.addDepartment(departmentRequest);
    }

    @PatchMapping({"/update-department-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void updateDepartmentByID(@RequestBody DepartmentRequest departmentRequest, @PathVariable Integer id) {
        this.departmentService.updateDepartmentByID(departmentRequest, id);
    }

    @GetMapping({"/get-all-departments"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DepartmentPageResponse getAllDepartments(@RequestParam Integer page, @RequestParam Integer count) {
        return this.departmentService.getAllDepartments(page, count);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping({"/get-department-by-id/{id}"})
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public DepartmentResponse getDepartmentByID(@PathVariable Integer id) {
        return this.departmentService.getDepartmentByID(id);
    }

    @DeleteMapping({"/delete-department-by-id/{id}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteDepartmentByID(@PathVariable Integer id) {
        this.departmentService.deleteDepartmentByID(id);
    }
}
