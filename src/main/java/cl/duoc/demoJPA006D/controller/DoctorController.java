package cl.duoc.demoJPA006D.controller;

import cl.duoc.demoJPA006D.model.Doctor;
import cl.duoc.demoJPA006D.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Doctor>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable int id) {
        Doctor doctor = service.findById(id);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<List<Doctor>> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/filter/{name}/{lastName}")
    public ResponseEntity<List<Doctor>> findByNameAndLastName(@PathVariable String name, @PathVariable String lastName){
        return ResponseEntity.ok(service.findByNameAndLastName(name, lastName));
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
        /*try {*/
            Doctor created = service.create(doctor);
            return ResponseEntity.ok(created);
        /*} catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }*/
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable int id, @RequestBody Doctor doctor) {
        try {
            Doctor updated = service.update(id, doctor);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
