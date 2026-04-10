package cl.duoc.demoJPA006D.service;

import cl.duoc.demoJPA006D.model.Agenda;
import cl.duoc.demoJPA006D.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {
    private final AgendaRepository repository;

    public AgendaService(AgendaRepository repository) {
        this.repository = repository;
    }

    public List<Agenda> findAll(){
        return repository.findAll();
    }
}
