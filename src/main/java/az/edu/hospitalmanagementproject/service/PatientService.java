package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.PatientPageResponse;
import az.edu.hospitalmanagementproject.dto.request.PatientRequest;
import az.edu.hospitalmanagementproject.dto.response.PatientResponse;

public interface PatientService {

    void addPatient(PatientRequest var1);

    void updatePatientByID(PatientRequest var1, Integer var2);

    void updatePatientByFirstNameAndLastName(PatientRequest var1, String var2, String var3);

    PatientPageResponse getAllPatients(Integer var1, Integer var2);

    PatientResponse getPatientByID(Integer var1);

    PatientResponse getPatientByFirstNameAndLastName(String var1, String var2);

    void deletePatientByID(Integer var1);

    void deletePatientByFirstNameAndLastName(String var1, String var2);
}
