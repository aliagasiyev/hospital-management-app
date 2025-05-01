package az.edu.hospitalmanagementproject.mapper;

import az.edu.hospitalmanagementproject.dto.request.AppointmentRequestDto;
import az.edu.hospitalmanagementproject.dto.response.AppointmentResponseDto;
import az.edu.hospitalmanagementproject.model.Appointment;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface AppointmentMapper {
    AppointmentResponseDto toAppointmentResponse(Appointment var1);

    Appointment toAppointmentEntity(AppointmentRequestDto var1);

}