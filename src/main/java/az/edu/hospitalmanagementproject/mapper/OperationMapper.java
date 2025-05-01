package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.OperationRequest;
import az.edu.hospitalmanagementproject.dto.response.OperationResponse;
import az.edu.hospitalmanagementproject.model.Operation;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface OperationMapper {
    Operation toOperationEntity(OperationRequest var1);

    OperationResponse toOperationResponse(Operation var1);
}
