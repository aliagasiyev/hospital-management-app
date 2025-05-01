
package az.edu.hospitalmanagementproject.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import az.edu.hospitalmanagementproject.dto.page.BedPageResponse;
import az.edu.hospitalmanagementproject.dto.request.BedRequest;
import az.edu.hospitalmanagementproject.dto.response.BedResponse;
import az.edu.hospitalmanagementproject.enums.Status;
import az.edu.hospitalmanagementproject.exceptions.BedNotFoundException;
import az.edu.hospitalmanagementproject.exceptions.NoBedAvailableException;
import az.edu.hospitalmanagementproject.mapper.BedMapper;
import az.edu.hospitalmanagementproject.model.Bed;
import az.edu.hospitalmanagementproject.repository.BedRepository;
import az.edu.hospitalmanagementproject.service.BedService;
import lombok.Generated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl implements BedService {
    private final BedRepository bedRepository;
    private final BedMapper bedMapper;

    public void addBed(BedRequest bedRequest) {
        this.bedRepository.save(this.bedMapper.toBedEntity(bedRequest));
    }

    public void updateBedByBedNumber(BedRequest bedRequest, Integer bedNumber) {
        Optional<Bed> existingBed = this.bedRepository.findById(bedNumber);
        if (existingBed.isEmpty()) {
            throw new BedNotFoundException("Bed not found");
        } else {
            existingBed.get().setRoom(bedRequest.getRoom());
            existingBed.get().setPatient(bedRequest.getPatient());
            existingBed.get().setStatus(bedRequest.getStatus());
            this.bedRepository.save(existingBed.get());
        }
    }

    public BedPageResponse getAllBeds(Integer page, Integer count) {
        Page<Bed> bedPage = this.bedRepository.findAll(PageRequest.of(page, count));
        if (bedPage.isEmpty()) {
            throw new BedNotFoundException("Bed not found");
        } else {
            Stream<Bed> var10002 = bedPage.getContent().stream();
            BedMapper var10003 = this.bedMapper;
            var10003.getClass();
            return new BedPageResponse(var10002.map(var10003::toBedResponse).collect(Collectors.toList()), (long)bedPage.getTotalPages(), bedPage.getTotalElements(), bedPage.hasNext());
        }
    }

    public BedPageResponse getAllAvailableBeds(Integer page, Integer count) {
        Page<Bed> bedPage = this.bedRepository.findAll(PageRequest.of(page, count));
        List<Bed> availableBeds = bedPage.getContent().stream().filter((bed) -> bed.getStatus() == Status.AVAILABLE).toList();
        if (availableBeds.isEmpty()) {
            throw new NoBedAvailableException("No bed available");
        } else {
            Stream<Bed> var10002 = availableBeds.stream();
            BedMapper var10003 = this.bedMapper;
            var10003.getClass();
            return new BedPageResponse(var10002.map(var10003::toBedResponse).collect(Collectors.toList()), (long)bedPage.getTotalPages(), bedPage.getTotalElements(), bedPage.hasNext());
        }
    }

    public BedResponse getBedByBedNumber(Integer bedNumber) {
        Stream<Bed> var10000 = this.bedRepository.findById(bedNumber).stream();
        BedMapper var10001 = this.bedMapper;
        var10001.getClass();
        return var10000.map(var10001::toBedResponse).findFirst().orElseThrow(() -> new BedNotFoundException("Bed not found"));
    }

    public BedResponse getBedByPatientId(Integer patientId) {
        Stream<Bed> var10000 = this.bedRepository.findByPatient_Id(patientId).stream();
        BedMapper var10001 = this.bedMapper;
        var10001.getClass();
        return var10000.map(var10001::toBedResponse).findFirst().orElseThrow(() -> new BedNotFoundException("Bed not found"));
    }

    public BedResponse getBedByPatientFirstnameAndLastname(String firstname, String lastname) {
        Stream<Bed> var10000 = this.bedRepository.findByPatient_FirstNameAndPatient_LastName(firstname, lastname).stream();
        BedMapper var10001 = this.bedMapper;
        var10001.getClass();
        return var10000.map(var10001::toBedResponse).findFirst().orElseThrow(() -> new BedNotFoundException("Bed not found"));
    }

    public boolean isAvailableOrNot(Integer bedNumber) {
        Optional<Bed> bed = this.bedRepository.findById(bedNumber);
        if (bed.isEmpty()) {
            throw new BedNotFoundException("Bed not found");
        } else {
            return bed.get().getStatus() == Status.AVAILABLE;
        }
    }

    public void deleteBedByBedNumber(Integer bedNumber) {
        Optional<Bed> bed = this.bedRepository.findById(bedNumber);
        if (bed.isEmpty()) {
            throw new BedNotFoundException("Bed not found");
        } else {
            this.bedRepository.deleteById(bedNumber);
        }
    }

    @Generated
    public BedServiceImpl(BedRepository bedRepository, BedMapper bedMapper) {
        this.bedRepository = bedRepository;
        this.bedMapper = bedMapper;
    }
}
