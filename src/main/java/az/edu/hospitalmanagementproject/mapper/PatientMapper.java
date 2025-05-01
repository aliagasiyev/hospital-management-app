package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.PatientRequest;
import az.edu.hospitalmanagementproject.dto.response.PatientResponse;
import az.edu.hospitalmanagementproject.model.Patient;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface PatientMapper {
    Patient toPatientEntity(PatientRequest var1);

    PatientResponse toPatientResponse(Patient var1);
}

