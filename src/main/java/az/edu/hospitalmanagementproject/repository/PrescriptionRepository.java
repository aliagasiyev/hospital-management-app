package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    Optional<Prescription> findByDoctor_Id(Integer var1);

    Optional<Prescription> findByPatient_Id(Integer var1);
}