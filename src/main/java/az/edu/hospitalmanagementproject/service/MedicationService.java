package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.MedicationPageResponse;
import az.edu.hospitalmanagementproject.dto.request.MedicationRequest;
import az.edu.hospitalmanagementproject.dto.response.MedicationResponse;

public interface MedicationService {

    void addMedication(MedicationRequest var1);

    void updateMedicationById(MedicationRequest var1, Integer var2);

    MedicationPageResponse getAllMedications(Integer var1, Integer var2);

    MedicationResponse getMedicationByID(Integer var1);

    void deleteMedicationByID(Integer var1);
}
