

package az.edu.hospitalmanagementproject.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import az.edu.hospitalmanagementproject.dto.page.DepartmentPageResponse;
import az.edu.hospitalmanagementproject.dto.request.DepartmentRequest;
import az.edu.hospitalmanagementproject.dto.response.DepartmentResponse;
import az.edu.hospitalmanagementproject.exceptions.DepartmentNotFoundException;
import az.edu.hospitalmanagementproject.mapper.DepartmentMapper;
import az.edu.hospitalmanagementproject.model.Department;
import az.edu.hospitalmanagementproject.repository.DepartmentRepository;
import az.edu.hospitalmanagementproject.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public void addDepartment(DepartmentRequest departmentRequest) {
        this.departmentRepository.save(this.departmentMapper.toDepartmentEntity(departmentRequest));
    }

    public void updateDepartmentByID(DepartmentRequest departmentRequest, Integer id) {
        Optional<Department> existingDepartment = this.departmentRepository.findById(id);
        if (existingDepartment.isEmpty()) {
            throw new DepartmentNotFoundException("Department not found");
        } else {
            ((Department)existingDepartment.get()).setHeadOfDepartment(departmentRequest.getHeadOfDepartment());
            ((Department)existingDepartment.get()).setName(departmentRequest.getName());
            this.departmentRepository.save((Department)existingDepartment.get());
        }
    }

    public DepartmentPageResponse getAllDepartments(Integer page, Integer count) {
        Page<Department> departmentPage = this.departmentRepository.findAll(PageRequest.of(page, count));
        if (departmentPage.isEmpty()) {
            throw new DepartmentNotFoundException("Department not found");
        } else {
            Stream var10002 = departmentPage.getContent().stream();
            DepartmentMapper var10003 = this.departmentMapper;
            var10003.getClass();
            return new DepartmentPageResponse((List)var10002.map(var10003::toDepartmentResponse).collect(Collectors.toList()), (long)departmentPage.getTotalPages(), departmentPage.getTotalElements(), departmentPage.hasNext());
        }
    }

    public DepartmentResponse getDepartmentByID(Integer id) {
        Stream var10000 = this.departmentRepository.findById(id).stream();
        DepartmentMapper var10001 = this.departmentMapper;
        var10001.getClass();
        return (DepartmentResponse)var10000.map(var10001::toDepartmentResponse).findFirst().orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
    }

    public void deleteDepartmentByID(Integer id) {
        if (this.departmentRepository.findById(id).isEmpty()) {
            throw new DepartmentNotFoundException("Department not found");
        } else {
            this.departmentRepository.deleteById(id);
        }
    }
}
