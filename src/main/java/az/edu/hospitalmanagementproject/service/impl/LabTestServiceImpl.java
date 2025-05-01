//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.service.impl;

import az.edu.turing.hospitalmanagementapp.dto.page.LabTestPageResponse;
import az.edu.turing.hospitalmanagementapp.dto.request.LabTestRequest;
import az.edu.turing.hospitalmanagementapp.dto.response.LabTestResponse;
import az.edu.turing.hospitalmanagementapp.exception.LabTestNotFoundException;
import az.edu.turing.hospitalmanagementapp.mapper.LabTestMapper;
import az.edu.turing.hospitalmanagementapp.model.LabTest;
import az.edu.turing.hospitalmanagementapp.repository.LabTestRepository;
import az.edu.turing.hospitalmanagementapp.service.LabTestService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LabTestServiceImpl implements LabTestService {
    private final LabTestRepository labTestRepository;
    private final LabTestMapper labTestMapper;

    public LabTestServiceImpl(LabTestRepository labTestRepository, LabTestMapper labTestMapper) {
        this.labTestRepository = labTestRepository;
        this.labTestMapper = labTestMapper;
    }

    public void addLabTest(LabTestRequest labTestRequest) {
        this.labTestRepository.save(this.labTestMapper.toLabTestEntity(labTestRequest));
    }

    public void updateLabTestById(LabTestRequest labTestRequest, Integer id) {
        Optional<LabTest> existingLabTest = this.labTestRepository.findById(id);
        if (existingLabTest.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        } else {
            ((LabTest)existingLabTest.get()).setTestName(labTestRequest.getTestName());
            ((LabTest)existingLabTest.get()).setTestDate(labTestRequest.getTestDate());
            ((LabTest)existingLabTest.get()).setPatient(labTestRequest.getPatient());
            ((LabTest)existingLabTest.get()).setDoctor(labTestRequest.getDoctor());
            ((LabTest)existingLabTest.get()).setResult(labTestRequest.getResult());
            ((LabTest)existingLabTest.get()).setDescription(labTestRequest.getDescription());
            this.labTestRepository.save((LabTest)existingLabTest.get());
        }
    }

    public LabTestPageResponse getAllLabTests(Integer page, Integer count) {
        Page<LabTest> labTestPage = this.labTestRepository.findAll(PageRequest.of(page, count));
        if (labTestPage.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        } else {
            Stream var10002 = labTestPage.getContent().stream();
            LabTestMapper var10003 = this.labTestMapper;
            var10003.getClass();
            return new LabTestPageResponse((List)var10002.map(var10003::toLabTestResponse).collect(Collectors.toList()), (long)labTestPage.getTotalPages(), labTestPage.getTotalElements(), labTestPage.hasNext());
        }
    }

    public LabTestResponse getLabTestById(Integer id) {
        Stream var10000 = this.labTestRepository.findById(id).stream();
        LabTestMapper var10001 = this.labTestMapper;
        var10001.getClass();
        return (LabTestResponse)var10000.map(var10001::toLabTestResponse).findFirst().orElseThrow(() -> new LabTestNotFoundException("Lab test not found"));
    }

    public List<LabTestResponse> getLabTestsByDoctorId(Integer doctorId) {
        List<LabTest> labTests = this.labTestRepository.findByDoctor_Id(doctorId);
        if (labTests.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        } else {
            Stream var10000 = labTests.stream();
            LabTestMapper var10001 = this.labTestMapper;
            var10001.getClass();
            return (List)var10000.map(var10001::toLabTestResponse).collect(Collectors.toList());
        }
    }

    public List<LabTestResponse> getLabTestsByPatientId(Integer id) {
        List<LabTest> labTests = this.labTestRepository.findByPatient_Id(id);
        if (labTests.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        } else {
            Stream var10000 = labTests.stream();
            LabTestMapper var10001 = this.labTestMapper;
            var10001.getClass();
            return (List)var10000.map(var10001::toLabTestResponse).collect(Collectors.toList());
        }
    }

    public List<LabTestResponse> getLabTestsByDoctorFirstnameAndLastname(String firstname, String lastname) {
        List<LabTest> labTests = this.labTestRepository.findByDoctor_FirstNameAndDoctor_LastName(firstname, lastname);
        if (labTests.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        } else {
            Stream var10000 = labTests.stream();
            LabTestMapper var10001 = this.labTestMapper;
            var10001.getClass();
            return (List)var10000.map(var10001::toLabTestResponse).collect(Collectors.toList());
        }
    }

    public List<LabTestResponse> getLabTestsByPatientFirstnameAndLastname(String firstname, String lastname) {
        List<LabTest> labTests = this.labTestRepository.findByPatient_FirstNameAndPatient_LastName(firstname, lastname);
        if (labTests.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        } else {
            Stream var10000 = labTests.stream();
            LabTestMapper var10001 = this.labTestMapper;
            var10001.getClass();
            return (List)var10000.map(var10001::toLabTestResponse).collect(Collectors.toList());
        }
    }

    public void deleteLabTestByID(Integer id) {
        Optional<LabTest> labTest = this.labTestRepository.findById(id);
        if (labTest.isEmpty()) {
            throw new LabTestNotFoundException("Lab test not found");
        } else {
            this.labTestRepository.deleteById(id);
        }
    }
}
