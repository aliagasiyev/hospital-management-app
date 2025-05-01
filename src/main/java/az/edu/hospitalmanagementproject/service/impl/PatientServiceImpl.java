package az.edu.hospitalmanagementproject.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import az.edu.hospitalmanagementproject.dto.page.PatientPageResponse;
import az.edu.hospitalmanagementproject.dto.request.PatientRequest;
import az.edu.hospitalmanagementproject.dto.response.PatientResponse;
import az.edu.hospitalmanagementproject.exceptions.PatientNotFoundException;
import az.edu.hospitalmanagementproject.mapper.PatientMapper;
import az.edu.hospitalmanagementproject.model.Patient;
import az.edu.hospitalmanagementproject.repository.PatientRepository;
import az.edu.hospitalmanagementproject.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public void addPatient(PatientRequest patientRequest) {
        this.patientRepository.save(this.patientMapper.toPatientEntity(patientRequest));
    }

    public void updatePatientByID(PatientRequest patientRequest, Integer id) {
        Optional<Patient> existingPatient = this.patientRepository.findById(id);
        if (existingPatient.isEmpty()) {
            throw new PatientNotFoundException("Patient not found");
        } else {
            ((Patient)existingPatient.get()).setFirstName(patientRequest.getFirstName());
            ((Patient)existingPatient.get()).setLastName(patientRequest.getLastName());
            ((Patient)existingPatient.get()).setGender(patientRequest.getGender());
            ((Patient)existingPatient.get()).setAddress(patientRequest.getAddress());
            ((Patient)existingPatient.get()).setDateOfBirth(patientRequest.getDateOfBirth());
            ((Patient)existingPatient.get()).setAge(patientRequest.getAge());
            ((Patient)existingPatient.get()).setPhoneNumber(patientRequest.getPhoneNumber());
            ((Patient)existingPatient.get()).setEmail(patientRequest.getEmail());
            this.patientRepository.save((Patient)existingPatient.get());
        }
    }

    public void updatePatientByFirstNameAndLastName(PatientRequest patientRequest, String firstName, String lastName) {
        Optional<Patient> existingPatient = this.patientRepository.findByFirstNameAndLastName(firstName, lastName);
        if (existingPatient.isEmpty()) {
            throw new PatientNotFoundException("Patient not found");
        } else {
            ((Patient)existingPatient.get()).setFirstName(patientRequest.getFirstName());
            ((Patient)existingPatient.get()).setLastName(patientRequest.getLastName());
            ((Patient)existingPatient.get()).setGender(patientRequest.getGender());
            ((Patient)existingPatient.get()).setAddress(patientRequest.getAddress());
            ((Patient)existingPatient.get()).setDateOfBirth(patientRequest.getDateOfBirth());
            ((Patient)existingPatient.get()).setAge(patientRequest.getAge());
            ((Patient)existingPatient.get()).setPhoneNumber(patientRequest.getPhoneNumber());
            ((Patient)existingPatient.get()).setEmail(patientRequest.getEmail());
            this.patientRepository.save((Patient)existingPatient.get());
        }
    }

    public PatientPageResponse getAllPatients(Integer page, Integer count) {
        Page<Patient> patientPage = this.patientRepository.findAll(PageRequest.of(page, count));
        if (patientPage.isEmpty()) {
            throw new PatientNotFoundException("Patient not found");
        } else {
            Stream var10002 = patientPage.getContent().stream();
            PatientMapper var10003 = this.patientMapper;
            var10003.getClass();
            return new PatientPageResponse((List)var10002.map(var10003::toPatientResponse).collect(Collectors.toList()), (long)patientPage.getTotalPages(), patientPage.getTotalElements(), patientPage.hasNext());
        }
    }

    public PatientResponse getPatientByID(Integer id) {
        Stream var10000 = this.patientRepository.findById(id).stream();
        PatientMapper var10001 = this.patientMapper;
        var10001.getClass();
        return (PatientResponse)var10000.map(var10001::toPatientResponse).findFirst().orElseThrow(() -> new PatientNotFoundException("Patient not found"));
    }

    public PatientResponse getPatientByFirstNameAndLastName(String firstName, String lastName) {
        Stream var10000 = this.patientRepository.findByFirstNameAndLastName(firstName, lastName).stream();
        PatientMapper var10001 = this.patientMapper;
        var10001.getClass();
        return (PatientResponse)var10000.map(var10001::toPatientResponse).findFirst().orElseThrow(() -> new PatientNotFoundException("Patient not found"));
    }

    public void deletePatientByID(Integer id) {
        if (this.patientRepository.findById(id).isEmpty()) {
            throw new PatientNotFoundException("Patient not found");
        } else {
            this.patientRepository.deleteById(id);
        }
    }

    public void deletePatientByFirstNameAndLastName(String firstName, String lastName) {
        if (this.patientRepository.findByFirstNameAndLastName(firstName, lastName).isEmpty()) {
            throw new PatientNotFoundException("Patient not found");
        } else {
            this.patientRepository.deleteByFirstNameAndLastName(firstName, lastName);
        }
    }
}
