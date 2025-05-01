package az.edu.hospitalmanagementproject.repository;

import az.edu.hospitalmanagementproject.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByDoctor_Id(Integer var1);

    Optional<Room> findByPatient_Id(Integer var1);

    List<Room> findByDoctor_FirstNameAndDoctor_LastName(String var1, String var2);

    Optional<Room> findByPatient_FirstNameAndPatient_LastName(String var1, String var2);
}

