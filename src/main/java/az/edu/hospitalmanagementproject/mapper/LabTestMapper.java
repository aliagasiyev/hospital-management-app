package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.LabTestRequest;
import az.edu.hospitalmanagementproject.dto.response.LabTestResponse;
import az.edu.hospitalmanagementproject.model.LabTest;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface LabTestMapper {
    LabTest toLabTestEntity(LabTestRequest var1);

    LabTestResponse toLabTestResponse(LabTest var1);
}
