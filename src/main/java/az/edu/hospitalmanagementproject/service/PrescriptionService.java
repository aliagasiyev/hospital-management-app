package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.PrescriptionPageResponse;
import az.edu.hospitalmanagementproject.dto.request.PrescriptionRequest;
import az.edu.hospitalmanagementproject.dto.response.PrescriptionResponse;

import java.util.List;

public interface PrescriptionService {

    void addPrescription(PrescriptionRequest var1);

    void updatePrescriptionByPrescriptionId(PrescriptionRequest var1, Integer var2);

    PrescriptionPageResponse getAllPrescriptions(Integer var1, Integer var2);

    List<PrescriptionResponse> getPrescriptionByDoctorId(Integer var1);

    List<PrescriptionResponse> getPrescriptionByPatientId(Integer var1);

    Boolean validatePrescription(Integer var1);

    void deletePrescriptionById(Integer var1);
}
