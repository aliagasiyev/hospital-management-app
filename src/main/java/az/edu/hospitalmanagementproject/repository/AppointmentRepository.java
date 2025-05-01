package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
