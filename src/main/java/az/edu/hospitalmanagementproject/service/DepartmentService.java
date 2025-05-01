package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.DepartmentPageResponse;
import az.edu.hospitalmanagementproject.dto.request.DepartmentRequest;
import az.edu.hospitalmanagementproject.dto.response.DepartmentResponse;

public interface DepartmentService  {

    void addDepartment(DepartmentRequest var1);

    void updateDepartmentByID(DepartmentRequest var1, Integer var2);

    DepartmentPageResponse getAllDepartments(Integer var1, Integer var2);

    DepartmentResponse getDepartmentByID(Integer var1);

    void deleteDepartmentByID(Integer var1);
}
