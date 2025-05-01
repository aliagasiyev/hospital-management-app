package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.LabTestPageResponse;
import az.edu.hospitalmanagementproject.dto.request.LabTestRequest;
import az.edu.hospitalmanagementproject.dto.response.LabTestResponse;

import java.util.List;

public interface LabTestService {

    void addLabTest(LabTestRequest var1);

    void updateLabTestById(LabTestRequest var1, Integer var2);

    LabTestPageResponse getAllLabTests(Integer var1, Integer var2);

    LabTestResponse getLabTestById(Integer var1);

    List<LabTestResponse> getLabTestsByDoctorId(Integer var1);

    List<LabTestResponse> getLabTestsByPatientId(Integer var1);

    List<LabTestResponse> getLabTestsByDoctorFirstnameAndLastname(String var1, String var2);

    List<LabTestResponse> getLabTestsByPatientFirstnameAndLastname(String var1, String var2);

    void deleteLabTestByID(Integer var1);
}
