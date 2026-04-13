package cl.duoc.demoJPA006D.service.impl;

import cl.duoc.demoJPA006D.dto.PatientDto;
import cl.duoc.demoJPA006D.model.Patient;
import cl.duoc.demoJPA006D.model.mapper.PatientMapper;
import cl.duoc.demoJPA006D.repository.PatientRepository;
import cl.duoc.demoJPA006D.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;
    private final PatientMapper mapper;

    public PatientServiceImpl(PatientRepository repository, PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PatientDto> findAll() {
        return mapper.toPatientDtos(repository.findAll());
    }

    @Override
    public PatientDto findById(int id) {
        return mapper.toPatientDto(repository.findById(id).orElse(null));
    }

    @Override
    public PatientDto create(PatientDto patient) {
        return mapper.toPatientDto(
                repository.save(mapper.toPatient(patient))
        );
    }

    @Override
    public PatientDto update(PatientDto patient) {
        return mapper.toPatientDto(
                repository.save(mapper.toPatient(patient))
        );
    }

    @Override
    public boolean delete(int id) {
        Patient patient = repository.findById(id).orElse(null);
        if (patient != null) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
