package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.DoctorRequest;
import az.edu.hospitalmanagementproject.dto.response.DoctorResponse;
import az.edu.hospitalmanagementproject.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface DoctorMapper {
    Doctor toDoctorEntity(DoctorRequest var1);

    DoctorResponse toDoctorResponse(Doctor var1);
}
