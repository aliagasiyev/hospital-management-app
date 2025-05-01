package az.edu.hospitalmanagementproject.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import az.edu.hospitalmanagementproject.dto.page.AppointmentPageResponse;
import az.edu.hospitalmanagementproject.dto.request.AppointmentRequestDto;
import az.edu.hospitalmanagementproject.dto.response.AppointmentResponseDto;
import az.edu.hospitalmanagementproject.exceptions.AppointmentNotFoundException;
import az.edu.hospitalmanagementproject.mapper.AppointmentMapper;
import az.edu.hospitalmanagementproject.model.Appointment;
import az.edu.hospitalmanagementproject.repository.AppointmentRepository;
import az.edu.hospitalmanagementproject.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public void addAppointment(AppointmentRequestDto appointmentRequestDto) {
        this.appointmentRepository.save(this.appointmentMapper.toAppointmentEntity(appointmentRequestDto));
    }

    public AppointmentPageResponse getAllAppointments(Integer page, Integer count) {
        Page<Appointment> appointmentPage = this.appointmentRepository.findAll(PageRequest.of(page, count));
        if (appointmentPage.isEmpty()) {
            throw new AppointmentNotFoundException("Appointment not found");
        } else {
            Stream<Appointment> var10002 = appointmentPage.getContent().stream();
            AppointmentMapper var10003 = this.appointmentMapper;
            var10003.getClass();
            return new AppointmentPageResponse(var10002.map(var10003::toAppointmentResponse).collect(Collectors.toList()), appointmentPage.getTotalPages(), appointmentPage.getTotalElements(), appointmentPage.hasNext());
        }
    }

    public AppointmentResponseDto getAppointmentById(Integer id) {
        Stream<Appointment> var10000 = this.appointmentRepository.findById(id).stream();
        AppointmentMapper var10001 = this.appointmentMapper;
        var10001.getClass();
        return var10000.map(var10001::toAppointmentResponse).findFirst().orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));
    }

    public void deleteAppointmentById(Integer id) {
        if (this.appointmentRepository.findById(id).isEmpty()) {
            throw new AppointmentNotFoundException("Appointment not found");
        } else {
            this.appointmentRepository.deleteById(id);
        }
    }

    public void updateAppointmentById(AppointmentRequestDto appointmentRequestDto, Integer id) {
        Optional<Appointment> existingAppointment = this.appointmentRepository.findById(id);
        if (existingAppointment.isEmpty()) {
            throw new AppointmentNotFoundException("Appointment not found");
        } else {
            existingAppointment.get().setDate(appointmentRequestDto.getDate());
            existingAppointment.get().setDoctor(appointmentRequestDto.getDoctor());
            existingAppointment.get().setReason(appointmentRequestDto.getReason());
            existingAppointment.get().setPatient(appointmentRequestDto.getPatient());
            existingAppointment.get().setStatus(appointmentRequestDto.getStatus());
            this.appointmentRepository.save(existingAppointment.get());
        }
    }
}
