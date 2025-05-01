package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.DepartmentRequest;
import az.edu.hospitalmanagementproject.dto.response.DepartmentResponse;
import az.edu.hospitalmanagementproject.model.Department;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface DepartmentMapper {
    Department toDepartmentEntity(DepartmentRequest var1);

    DepartmentResponse toDepartmentResponse(Department var1);
}
