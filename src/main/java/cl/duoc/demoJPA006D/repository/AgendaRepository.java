package cl.duoc.demoJPA006D.repository;

import cl.duoc.demoJPA006D.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
