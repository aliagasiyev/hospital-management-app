package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.enums.RoleEnum;
import az.edu.hospitalmanagementproject.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByFirstNameAndLastName(String var1, String var2);

    Page<Staff> findByRoleEnum(RoleEnum var1, Pageable var2);

    void deleteByFirstNameAndLastName(String var1, String var2);
}