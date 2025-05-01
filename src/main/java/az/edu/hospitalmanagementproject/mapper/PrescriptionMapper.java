package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.PrescriptionRequest;
import az.edu.hospitalmanagementproject.dto.response.PrescriptionResponse;
import az.edu.hospitalmanagementproject.model.Prescription;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface PrescriptionMapper {
    Prescription toPrescriptionEntity(PrescriptionRequest var1);

    PrescriptionResponse toPrescriptionResponse(Prescription var1);
}

