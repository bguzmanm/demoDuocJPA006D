package cl.duoc.demoJPA006D.config;

import cl.duoc.demoJPA006D.model.Doctor;
import cl.duoc.demoJPA006D.model.Patient;
import cl.duoc.demoJPA006D.model.Product;
import cl.duoc.demoJPA006D.repository.DoctorRepository;
import cl.duoc.demoJPA006D.repository.PatientRepository;
import cl.duoc.demoJPA006D.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (doctorRepository.count() == 0) {
            log.info(">>> DataInitializer: Tabla Doctor vacía detectada, insertando datos de prueba...");

            // Aquí puedes agregar código para insertar doctores y pacientes de prueba.
            doctorRepository.save(new Doctor(null, "Juan", "Perez", "juan.perez@doctor.cl", "5555"));
            doctorRepository.save(new Doctor(null, "Maritza", "Mitrovic", "maritza.mitrovic@doctor.cl", "6666"));
        }

        if (patientRepository.count() == 0) {
            log.info(">>> DataInitializer: Tabla Paciente vacía detectada, insertando datos de prueba...");

            patientRepository.save(new Patient(null, "Maria", "Gonzalez", "4444"));
            patientRepository.save(new Patient(null, "Marcelo", "Robles", "33333"));

        }

        if (productRepository.count() == 0) {
            log.info(">>> DataInitializer: Tabla Productos vacía detectada, insertando datos de prueba...");

            productRepository.save(new Product(null, "Producto 1", "Descripción Producto 1", 100d, 20d));
            productRepository.save(new Product(null, "Producto 2", "Descripción Producto 2", 120d, 10d));
        }
    }
}
