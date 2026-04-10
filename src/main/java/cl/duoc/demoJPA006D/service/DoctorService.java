package cl.duoc.demoJPA006D.service;

import cl.duoc.demoJPA006D.model.Doctor;
import cl.duoc.demoJPA006D.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public List<Doctor> findAll(){
        return repository.findAll();
    }

    public Doctor findById(int id){
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

    public Doctor update(int id, Doctor doctor) throws Exception {
        boolean exists = repository.existsById(doctor.getId());
        if (!exists){
            throw new Exception("Doctor with id " + doctor.getId() + " not exists");
        }

        return repository.save(doctor);
    }

    public boolean delete(int id){
        boolean exists = repository.existsById(id);
        repository.deleteById(id);
        return exists;
    }

    public List<Doctor> findByName(String name){
        return repository.findByName(name);
    }

    public List<Doctor> findByNameAndLastName(String name, String lastName){
        return repository.findByNameAndLastName(name, lastName);
    }
}
