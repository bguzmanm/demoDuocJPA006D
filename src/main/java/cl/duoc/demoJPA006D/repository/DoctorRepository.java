package cl.duoc.demoJPA006D.repository;

import cl.duoc.demoJPA006D.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByName(String name);
    List<Doctor> findByNameAndLastName(String name, String lastName);
}
