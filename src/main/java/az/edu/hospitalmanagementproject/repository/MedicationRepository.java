package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Integer> {
}
