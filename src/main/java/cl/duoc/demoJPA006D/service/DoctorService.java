package cl.duoc.demoJPA006D.service;

import cl.duoc.demoJPA006D.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAll();
    Doctor findById(Long id);
    Doctor create(Doctor doctor);
    Doctor update(Long id, Doctor doctor) throws Exception;
    boolean delete(Long id);
    List<Doctor> findByName(String name);
    public List<Doctor> findByNameAndLastName(String name, String lastName);
}
