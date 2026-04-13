package cl.duoc.demoJPA006D.service;

import cl.duoc.demoJPA006D.dto.PatientDto;
import cl.duoc.demoJPA006D.model.Patient;

import java.util.List;

public interface PatientService {
    List<PatientDto> findAll();
    PatientDto findById(Long id);
    PatientDto create(PatientDto patient);
    PatientDto update(PatientDto patient);
    boolean delete(Long id);
}
