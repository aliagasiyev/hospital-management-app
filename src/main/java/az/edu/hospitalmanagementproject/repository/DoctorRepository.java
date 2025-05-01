package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.enums.Specialization;
import az.edu.hospitalmanagementproject.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Page<Doctor> findBySpecialization(Specialization var1, Pageable var2);

    Page<Doctor> findByDepartment(String var1, Pageable var2);

    Optional<Doctor> findByFirstNameAndLastName(String var1, String var2);

    void deleteByFirstNameAndLastName(String var1, String var2);

    @Query(value = "select *from doctor order by age", nativeQuery = true)
    Page<Doctor> findAllDoctorsOrderByAge(PageRequest var1);
}

