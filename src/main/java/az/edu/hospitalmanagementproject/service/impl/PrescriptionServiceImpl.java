//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.service.impl;

import az.edu.turing.hospitalmanagementapp.dto.page.PrescriptionPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.PrescriptionRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.PrescriptionResponse;
import az.edu.turing.hospitalmanagementapp.exception.PrescriptionNotFoundException;
import az.edu.turing.hospitalmanagementapp.mapper.PrescriptionMapper;
import az.edu.turing.hospitalmanagementapp.model.Prescription;
import az.edu.turing.hospitalmanagementapp.repository.PrescriptionRepository;
import az.edu.turing.hospitalmanagementapp.service.PrescriptionService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository, PrescriptionMapper prescriptionMapper) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionMapper = prescriptionMapper;
    }

    public void addPrescription(PrescriptionRequest prescriptionRequest) {
        this.prescriptionRepository.save(this.prescriptionMapper.toPrescriptionEntity(prescriptionRequest));
    }

    public void updatePrescriptionByPrescriptionId(PrescriptionRequest prescriptionRequest, Integer id) {
        Optional<Prescription> existingPrescription = this.prescriptionRepository.findById(id);
        if (existingPrescription.isEmpty()) {
            throw new PrescriptionNotFoundException("Prescription not found");
        } else {
            ((Prescription)existingPrescription.get()).setDoctor(prescriptionRequest.getDoctor());
            ((Prescription)existingPrescription.get()).setInstructions(prescriptionRequest.getInstructions());
            ((Prescription)existingPrescription.get()).setPatient(prescriptionRequest.getPatient());
            ((Prescription)existingPrescription.get()).setLocalDateTime(prescriptionRequest.getLocalDateTime());
            ((Prescription)existingPrescription.get()).setMedication(prescriptionRequest.getMedication());
            ((Prescription)existingPrescription.get()).setValid(prescriptionRequest.isValid());
            this.prescriptionRepository.save((Prescription)existingPrescription.get());
        }
    }

    public PrescriptionPageResponse getAllPrescriptions(Integer page, Integer count) {
        Page<Prescription> prescriptionPage = this.prescriptionRepository.findAll(PageRequest.of(page, count));
        if (prescriptionPage.isEmpty()) {
            throw new PrescriptionNotFoundException("Prescription not found");
        } else {
            Stream var10002 = prescriptionPage.getContent().stream();
            PrescriptionMapper var10003 = this.prescriptionMapper;
            var10003.getClass();
            return new PrescriptionPageResponse((List)var10002.map(var10003::toPrescriptionResponse).collect(Collectors.toList()), (long)prescriptionPage.getTotalPages(), prescriptionPage.getTotalElements(), prescriptionPage.hasNext());
        }
    }

    public List<PrescriptionResponse> getPrescriptionByDoctorId(Integer id) {
        Stream var10000 = this.prescriptionRepository.findByDoctor_Id(id).stream();
        PrescriptionMapper var10001 = this.prescriptionMapper;
        var10001.getClass();
        return (List)var10000.map(var10001::toPrescriptionResponse).collect(Collectors.toList());
    }

    public List<PrescriptionResponse> getPrescriptionByPatientId(Integer id) {
        Stream var10000 = this.prescriptionRepository.findByPatient_Id(id).stream();
        PrescriptionMapper var10001 = this.prescriptionMapper;
        var10001.getClass();
        return (List)var10000.map(var10001::toPrescriptionResponse).collect(Collectors.toList());
    }

    public Boolean validatePrescription(Integer prescriptionId) {
        Optional<Prescription> isValid = this.prescriptionRepository.findById(prescriptionId);
        if (isValid.isEmpty()) {
            throw new PrescriptionNotFoundException("Prescription not found");
        } else {
            return ((Prescription)isValid.get()).isValid();
        }
    }

    public void deletePrescriptionById(Integer id) {
        if (this.prescriptionRepository.findById(id).isEmpty()) {
            throw new PrescriptionNotFoundException("Prescription not found");
        } else {
            this.prescriptionRepository.deleteById(id);
        }
    }
}
