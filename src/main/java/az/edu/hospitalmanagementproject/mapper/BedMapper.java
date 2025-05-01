package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.BedRequest;
import az.edu.hospitalmanagementproject.dto.response.BedResponse;
import az.edu.hospitalmanagementproject.model.Bed;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface BedMapper {
    Bed toBedEntity(BedRequest var1);

    BedResponse toBedResponse(Bed var1);
}
