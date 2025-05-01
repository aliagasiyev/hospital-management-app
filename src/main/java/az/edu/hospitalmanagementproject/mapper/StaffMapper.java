package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.StaffRequest;
import az.edu.hospitalmanagementproject.dto.response.StaffResponse;
import az.edu.hospitalmanagementproject.model.Staff;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface StaffMapper {
    Staff toStaffEntity(StaffRequest var1);

    StaffResponse toStaffResponse(Staff var1);
}
