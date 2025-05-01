package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, Integer> {
    List<LabTest> findByDoctor_Id(Integer var1);

    List<LabTest> findByPatient_Id(Integer var1);

    List<LabTest> findByPatient_FirstNameAndPatient_LastName(String var1, String var2);

    List<LabTest> findByDoctor_FirstNameAndDoctor_LastName(String var1, String var2);
}