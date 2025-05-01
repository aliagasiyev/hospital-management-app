//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.service.impl;

import az.edu.turing.hospitalmanagementapp.dto.page.MedicationPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.MedicationRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.MedicationResponse;
import az.edu.turing.hospitalmanagementapp.exception.MedicationNotFoundException;
import az.edu.turing.hospitalmanagementapp.mapper.MedicationMapper;
import az.edu.turing.hospitalmanagementapp.model.Medication;
import az.edu.turing.hospitalmanagementapp.repository.MedicationRepository;
import az.edu.turing.hospitalmanagementapp.service.MedicationService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;
    private final MedicationMapper medicationMapper;

    public MedicationServiceImpl(MedicationRepository medicationRepository, MedicationMapper medicationMapper) {
        this.medicationRepository = medicationRepository;
        this.medicationMapper = medicationMapper;
    }

    public void addMedication(MedicationRequest medicationRequest) {
        this.medicationRepository.save(this.medicationMapper.toMedicationEntity(medicationRequest));
    }

    public void updateMedicationById(MedicationRequest medicationRequest, Integer id) {
        Optional<Medication> existingMedication = this.medicationRepository.findById(id);
        if (existingMedication.isEmpty()) {
            throw new MedicationNotFoundException("Medication not found");
        } else {
            ((Medication)existingMedication.get()).setName(medicationRequest.getName());
            ((Medication)existingMedication.get()).setManufacturer(medicationRequest.getManufacturer());
            ((Medication)existingMedication.get()).setExpiryDate(medicationRequest.getExpiryDate());
            this.medicationRepository.save((Medication)existingMedication.get());
        }
    }

    public MedicationPageResponse getAllMedications(Integer page, Integer count) {
        Page<Medication> medicationPage = this.medicationRepository.findAll(PageRequest.of(page, count));
        if (medicationPage.isEmpty()) {
            throw new MedicationNotFoundException("Medication not found");
        } else {
            Stream var10002 = medicationPage.getContent().stream();
            MedicationMapper var10003 = this.medicationMapper;
            var10003.getClass();
            return new MedicationPageResponse((List)var10002.map(var10003::toMedicationResponse).collect(Collectors.toList()), (long)medicationPage.getTotalPages(), medicationPage.getTotalElements(), medicationPage.hasNext());
        }
    }

    public MedicationResponse getMedicationByID(Integer id) {
        Stream var10000 = this.medicationRepository.findById(id).stream();
        MedicationMapper var10001 = this.medicationMapper;
        var10001.getClass();
        return (MedicationResponse)var10000.map(var10001::toMedicationResponse).findFirst().orElseThrow(() -> new MedicationNotFoundException("Medication not found"));
    }

    public void deleteMedicationByID(Integer id) {
        if (this.medicationRepository.findById(id).isEmpty()) {
            throw new MedicationNotFoundException("Medication not found");
        } else {
            this.medicationRepository.deleteById(id);
        }
    }
}
