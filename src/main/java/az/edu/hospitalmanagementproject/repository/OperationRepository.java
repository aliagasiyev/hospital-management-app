package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {
    List<Operation> findByPatient_FirstNameAndPatient_LastName(String var1, String var2);

    List<Operation> findByDoctor_FirstNameAndDoctor_LastName(String var1, String var2);

    List<Operation> findByPatient_Id(Integer var1);

    List<Operation> findByDoctor_Id(Integer var1);
}

