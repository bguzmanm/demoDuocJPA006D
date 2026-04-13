package cl.duoc.demoJPA006D.repository;

import cl.duoc.demoJPA006D.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
