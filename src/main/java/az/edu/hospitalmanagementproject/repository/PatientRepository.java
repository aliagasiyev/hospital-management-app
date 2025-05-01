package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByFirstNameAndLastName(String var1, String var2);

    void deleteByFirstNameAndLastName(String var1, String var2);
}
