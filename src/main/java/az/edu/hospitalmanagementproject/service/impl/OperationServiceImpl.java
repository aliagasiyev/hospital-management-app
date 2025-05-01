//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.service.impl;

import az.edu.turing.hospitalmanagementapp.dto.page.OperationPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.OperationRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.OperationResponse;
import az.edu.turing.hospitalmanagementapp.enums.Status;
import az.edu.turing.hospitalmanagementapp.exception.OperationNotFoundException;
import az.edu.turing.hospitalmanagementapp.mapper.OperationMapper;
import az.edu.turing.hospitalmanagementapp.model.Operation;
import az.edu.turing.hospitalmanagementapp.repository.OperationRepository;
import az.edu.turing.hospitalmanagementapp.service.OperationService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;
    private final OperationMapper operationMapper;

    public OperationServiceImpl(OperationRepository operationRepository, OperationMapper operationMapper) {
        this.operationRepository = operationRepository;
        this.operationMapper = operationMapper;
    }

    public void addOperation(OperationRequest operationRequest) {
        this.operationRepository.save(this.operationMapper.toOperationEntity(operationRequest));
    }

    public void updateOperationById(OperationRequest operationRequest, Integer id) {
        Optional<Operation> existingOperation = this.operationRepository.findById(id);
        if (existingOperation.isEmpty()) {
            throw new OperationNotFoundException("Operation not found");
        } else {
            ((Operation)existingOperation.get()).setOperationName(operationRequest.getOperationName());
            ((Operation)existingOperation.get()).setDescription(operationRequest.getDescription());
            ((Operation)existingOperation.get()).setDoctor(operationRequest.getDoctor());
            ((Operation)existingOperation.get()).setPatient(operationRequest.getPatient());
            ((Operation)existingOperation.get()).setStatus(operationRequest.getStatus());
            ((Operation)existingOperation.get()).setOperationDate(operationRequest.getOperationDate());
            this.operationRepository.save((Operation)existingOperation.get());
        }
    }

    public OperationPageResponse getAllOperations(Integer page, Integer count) {
        Page<Operation> operationPage = this.operationRepository.findAll(PageRequest.of(page, count));
        if (operationPage.isEmpty()) {
            throw new OperationNotFoundException("Operation not found");
        } else {
            Stream var10002 = operationPage.getContent().stream();
            OperationMapper var10003 = this.operationMapper;
            var10003.getClass();
            return new OperationPageResponse((List)var10002.map(var10003::toOperationResponse).collect(Collectors.toList()), (long)operationPage.getTotalPages(), operationPage.getTotalElements(), operationPage.hasNext());
        }
    }

    public OperationResponse getOperationByID(Integer id) {
        Stream var10000 = this.operationRepository.findById(id).stream();
        OperationMapper var10001 = this.operationMapper;
        var10001.getClass();
        return (OperationResponse)var10000.map(var10001::toOperationResponse).findFirst().orElseThrow(() -> new OperationNotFoundException("Operation not found"));
    }

    public List<OperationResponse> getOperationByDoctorId(Integer doctorId) {
        Stream var10000 = this.operationRepository.findByDoctor_Id(doctorId).stream();
        OperationMapper var10001 = this.operationMapper;
        var10001.getClass();
        return (List)var10000.map(var10001::toOperationResponse).collect(Collectors.toList());
    }

    public List<OperationResponse> getOperationByDoctorFirstnameAndLastname(String firstname, String lastname) {
        Stream var10000 = this.operationRepository.findByDoctor_FirstNameAndDoctor_LastName(firstname, lastname).stream();
        OperationMapper var10001 = this.operationMapper;
        var10001.getClass();
        return (List)var10000.map(var10001::toOperationResponse).collect(Collectors.toList());
    }

    public List<OperationResponse> getOperationByPatientId(Integer patientId) {
        Stream var10000 = this.operationRepository.findByPatient_Id(patientId).stream();
        OperationMapper var10001 = this.operationMapper;
        var10001.getClass();
        return (List)var10000.map(var10001::toOperationResponse).collect(Collectors.toList());
    }

    public List<OperationResponse> getOperationByPatientFirstnameAndLastname(String firstname, String lastname) {
        Stream var10000 = this.operationRepository.findByPatient_FirstNameAndPatient_LastName(firstname, lastname).stream();
        OperationMapper var10001 = this.operationMapper;
        var10001.getClass();
        return (List)var10000.map(var10001::toOperationResponse).collect(Collectors.toList());
    }

    public void deleteOperationById(Integer id) {
        Optional<Operation> operation = this.operationRepository.findById(id);
        if (operation.isEmpty()) {
            throw new OperationNotFoundException("Operation not found");
        } else {
            this.operationRepository.deleteById(id);
        }
    }

    public Status getStatusOfOperationById(Integer id) {
        Optional<Operation> operation = this.operationRepository.findById(id);
        if (operation.isEmpty()) {
            throw new OperationNotFoundException("Operation not found");
        } else {
            return ((Operation)operation.get()).getStatus();
        }
    }
}
