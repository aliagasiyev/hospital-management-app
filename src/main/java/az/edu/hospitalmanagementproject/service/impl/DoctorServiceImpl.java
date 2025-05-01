package az.edu.hospitalmanagementproject.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import az.edu.hospitalmanagementproject.dto.request.DoctorRequest;
import az.edu.hospitalmanagementproject.exceptions.DoctorNotFoundException;
import az.edu.hospitalmanagementproject.mapper.DoctorMapper;
import az.edu.hospitalmanagementproject.model.Doctor;
import az.edu.hospitalmanagementproject.repository.DoctorRepository;
import az.edu.hospitalmanagementproject.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public void addDoctor(DoctorRequest doctorRequest) {
        this.doctorRepository.save(this.doctorMapper.toDoctorEntity(doctorRequest));
    }

    public void updateDoctorByID(DoctorRequest doctorRequest, Integer id) {
        Optional<Doctor> existingDoctor = this.doctorRepository.findById(id);
        if (existingDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        } else {
            ((Doctor)existingDoctor.get()).setEmail(doctorRequest.getEmail());
            ((Doctor)existingDoctor.get()).setFirstName(doctorRequest.getFirstName());
            ((Doctor)existingDoctor.get()).setLastName(doctorRequest.getLastName());
            ((Doctor)existingDoctor.get()).setSpecialization(doctorRequest.getSpecialization());
            ((Doctor)existingDoctor.get()).setDepartment(doctorRequest.getDepartment());
            ((Doctor)existingDoctor.get()).setPhoneNumber(doctorRequest.getPhoneNumber());
            ((Doctor)existingDoctor.get()).setYearsOfExperience(doctorRequest.getYearsOfExperience());
            this.doctorRepository.save((Doctor)existingDoctor.get());
        }
    }

    public void updateDoctorByFirstNameAndLastName(DoctorRequest doctorRequest, String firstName, String lastName) {
        Optional<Doctor> existingDoctor = this.doctorRepository.findByFirstNameAndLastName(firstName, lastName);
        if (existingDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        } else {
            ((Doctor)existingDoctor.get()).setEmail(doctorRequest.getEmail());
            ((Doctor)existingDoctor.get()).setFirstName(doctorRequest.getFirstName());
            ((Doctor)existingDoctor.get()).setLastName(doctorRequest.getLastName());
            ((Doctor)existingDoctor.get()).setSpecialization(doctorRequest.getSpecialization());
            ((Doctor)existingDoctor.get()).setDepartment(doctorRequest.getDepartment());
            ((Doctor)existingDoctor.get()).setPhoneNumber(doctorRequest.getPhoneNumber());
            ((Doctor)existingDoctor.get()).setYearsOfExperience(doctorRequest.getYearsOfExperience());
            this.doctorRepository.save((Doctor)existingDoctor.get());
        }
    }

    public DoctorPageResponse getAllDoctors(Integer page, Integer count) {
        Page<Doctor> doctorPage = this.doctorRepository.findAll(PageRequest.of(page, count));
        if (doctorPage.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        } else {
            Stream var10002 = doctorPage.getContent().stream();
            DoctorMapper var10003 = this.doctorMapper;
            var10003.getClass();
            return new DoctorPageResponse((List)var10002.map(var10003::toDoctorResponse).collect(Collectors.toList()), (long)doctorPage.getTotalPages(), doctorPage.getTotalElements(), doctorPage.hasNext());
        }
    }

    public DoctorPageResponse getDoctorsBySpecialization(Specialization specialization, Integer page, Integer count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Doctor> doctorPage = this.doctorRepository.findBySpecialization(specialization, pageable);
        if (doctorPage.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        } else {
            Stream var10002 = doctorPage.getContent().stream();
            DoctorMapper var10003 = this.doctorMapper;
            var10003.getClass();
            return new DoctorPageResponse((List)var10002.map(var10003::toDoctorResponse).collect(Collectors.toList()), (long)doctorPage.getTotalPages(), doctorPage.getTotalElements(), doctorPage.hasNext());
        }
    }

    public DoctorPageResponse getDoctorsByDepartment(String department, Integer page, Integer count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Doctor> doctorPage = this.doctorRepository.findByDepartment(department, pageable);
        if (doctorPage.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        } else {
            Stream var10002 = doctorPage.getContent().stream();
            DoctorMapper var10003 = this.doctorMapper;
            var10003.getClass();
            return new DoctorPageResponse((List)var10002.map(var10003::toDoctorResponse).collect(Collectors.toList()), (long)doctorPage.getTotalPages(), doctorPage.getTotalElements(), doctorPage.hasNext());
        }
    }

    public DoctorPageResponse getAllDoctorsOrderByAge(Integer page, Integer count) {
        Page<Doctor> doctorPage = this.doctorRepository.findAllDoctorsOrderByAge(PageRequest.of(page, count));
        if (doctorPage.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        } else {
            Stream var10002 = doctorPage.getContent().stream();
            DoctorMapper var10003 = this.doctorMapper;
            var10003.getClass();
            return new DoctorPageResponse((List)var10002.map(var10003::toDoctorResponse).collect(Collectors.toList()), (long)doctorPage.getTotalPages(), doctorPage.getTotalElements(), doctorPage.hasNext());
        }
    }

    public DoctorResponse getDoctorByID(Integer id) {
        Stream var10000 = this.doctorRepository.findById(id).stream();
        DoctorMapper var10001 = this.doctorMapper;
        var10001.getClass();
        return (DoctorResponse)var10000.map(var10001::toDoctorResponse).findFirst().orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));
    }

    public DoctorResponse getDoctorByFirstNameAndLastName(String firstName, String lastName) {
        Stream var10000 = this.doctorRepository.findByFirstNameAndLastName(firstName, lastName).stream();
        DoctorMapper var10001 = this.doctorMapper;
        var10001.getClass();
        return (DoctorResponse)var10000.map(var10001::toDoctorResponse).findFirst().orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));
    }

    public void deleteDoctorByID(Integer id) {
        if (this.doctorRepository.findById(id).isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        } else {
            this.doctorRepository.deleteById(id);
        }
    }

    public void deleteDoctorByFirstNameAndLastName(String firstName, String lastName) {
        if (this.doctorRepository.findByFirstNameAndLastName(firstName, lastName).isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        } else {
            this.doctorRepository.deleteByFirstNameAndLastName(firstName, lastName);
        }
    }
}
