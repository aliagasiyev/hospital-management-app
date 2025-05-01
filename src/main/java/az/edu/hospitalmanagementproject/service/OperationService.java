package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.OperationPageResponse;
import az.edu.hospitalmanagementproject.dto.request.OperationRequest;
import az.edu.hospitalmanagementproject.dto.response.OperationResponse;
import az.edu.hospitalmanagementproject.enums.Status;

import java.util.List;

public interface OperationService {

    void addOperation(OperationRequest var1);

    void updateOperationById(OperationRequest var1, Integer var2);

    OperationPageResponse getAllOperations(Integer var1, Integer var2);

    OperationResponse getOperationByID(Integer var1);

    List<OperationResponse> getOperationByDoctorId(Integer var1);

    List<OperationResponse> getOperationByDoctorFirstnameAndLastname(String var1, String var2);

    List<OperationResponse> getOperationByPatientId(Integer var1);

    List<OperationResponse> getOperationByPatientFirstnameAndLastname(String var1, String var2);

    void deleteOperationById(Integer var1);

    Status getStatusOfOperationById(Integer var1);
}
