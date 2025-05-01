package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.AppointmentPageResponse;
import az.edu.hospitalmanagementproject.dto.request.AppointmentRequestDto;
import az.edu.hospitalmanagementproject.dto.response.AppointmentResponseDto;

public interface AppointmentService {

    void addAppointment(AppointmentRequestDto var1);

    AppointmentPageResponse getAllAppointments(Integer var1, Integer var2);

    AppointmentResponseDto getAppointmentById(Integer var1);

    void deleteAppointmentById(Integer var1);

    void updateAppointmentById(AppointmentRequestDto var1, Integer var2);
}
