package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BedRepository extends JpaRepository<Bed, Integer> {
    Optional<Bed> findByPatient_Id(Integer var1);

    Optional<Bed> findByPatient_FirstNameAndPatient_LastName(String var1, String var2);
}
