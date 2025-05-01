package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.MedicationRequest;
import az.edu.hospitalmanagementproject.dto.response.MedicationResponse;
import az.edu.hospitalmanagementproject.model.Medication;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MedicationMapper {
    Medication toMedicationEntity(MedicationRequest var1);

    MedicationResponse toMedicationResponse(Medication var1);
}
