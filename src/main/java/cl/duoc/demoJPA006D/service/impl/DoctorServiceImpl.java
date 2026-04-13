package cl.duoc.demoJPA006D.service.impl;

import cl.duoc.demoJPA006D.model.Doctor;
import cl.duoc.demoJPA006D.repository.DoctorRepository;
import cl.duoc.demoJPA006D.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    public List<Doctor> findAll(){
        return repository.findAll();
    }

    public Doctor findById(Long id){
        return repository
                .findById(id)
                .orElse(null);
    }

    public Doctor create(Doctor doctor){
        /*boolean exists = repository.existsById(doctor.getId());
        System.out.println("existe:" + exists);
        if (exists){
            throw new Exception("Doctor with id " + doctor.getId() + " already exists");
        }*/

        return repository.save(doctor);
    }

    public Doctor update(Long id, Doctor doctor) throws Exception {
        boolean exists = repository.existsById(id);
        if (!exists){
            throw new Exception("Doctor with id " + id + " not exists");
        }
        doctor.setId(id);
        return repository.save(doctor);
    }

    public boolean delete(Long id){
        boolean exists = repository.existsById(id);
        if (exists) {
            repository.deleteById(id);
        }
        return exists;
    }

    public List<Doctor> findByName(String name){
        return repository.findByName(name);
    }

    public List<Doctor> findByNameAndLastName(String name, String lastName){
        return repository.findByNameAndLastName(name, lastName);
    }
}
