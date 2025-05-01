package az.edu.hospitalmanagementproject.service;

import az.edu.hospitalmanagementproject.dto.page.DoctorPageResponse;
import az.edu.hospitalmanagementproject.dto.request.DoctorRequest;
import az.edu.hospitalmanagementproject.dto.response.DoctorResponse;
import az.edu.hospitalmanagementproject.enums.Specialization;

public interface DoctorService {

    void addDoctor(DoctorRequest var1);

    void updateDoctorByID(DoctorRequest var1, Integer var2);

    void updateDoctorByFirstNameAndLastName(DoctorRequest var1, String var2, String var3);

    DoctorPageResponse getAllDoctors(Integer var1, Integer var2);

    DoctorPageResponse getDoctorsBySpecialization(Specialization var1, Integer var2, Integer var3);

    DoctorPageResponse getDoctorsByDepartment(String var1, Integer var2, Integer var3);

    DoctorPageResponse getAllDoctorsOrderByAge(Integer var1, Integer var2);

    DoctorResponse getDoctorByID(Integer var1);

    DoctorResponse getDoctorByFirstNameAndLastName(String var1, String var2);

    void deleteDoctorByID(Integer var1);

    void deleteDoctorByFirstNameAndLastName(String var1, String var2);
}
