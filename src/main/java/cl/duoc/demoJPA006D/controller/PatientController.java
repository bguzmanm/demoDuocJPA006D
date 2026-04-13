package cl.duoc.demoJPA006D.controller;

import cl.duoc.demoJPA006D.dto.PatientDto;
import cl.duoc.demoJPA006D.model.Doctor;
import cl.duoc.demoJPA006D.model.Patient;
import cl.duoc.demoJPA006D.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService service;
    public PatientController(PatientService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }
}
