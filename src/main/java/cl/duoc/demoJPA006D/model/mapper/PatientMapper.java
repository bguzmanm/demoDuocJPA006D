package cl.duoc.demoJPA006D.model.mapper;

import cl.duoc.demoJPA006D.dto.PatientDto;
import cl.duoc.demoJPA006D.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toPatient(PatientDto patientDto);
    PatientDto toPatientDto(Patient patient);
    List<PatientDto> toPatientList(List<Patient> patients);
}
