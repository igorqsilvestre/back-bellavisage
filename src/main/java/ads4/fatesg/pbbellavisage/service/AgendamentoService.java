package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Agendamento;
import ads4.fatesg.pbbellavisage.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class AgendamentoService implements GenericOperations<Agendamento, Integer> {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public Agendamento create(Agendamento entity) {
        return agendamentoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Agendamento read(Integer id) {
        return agendamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Agendamento> readAll() {
        return agendamentoRepository.findAll();
    }

    @Override
    public Agendamento updatePart(Integer id, Agendamento entity) {

        Agendamento agendamentoEncontrado = this.read(id);

        if(agendamentoEncontrado != null){
            entity.setId(agendamentoEncontrado.getId());
            return agendamentoRepository.save(entity);
        }

        return new Agendamento();
    }

    @Override
    public Agendamento updateAll(Integer id, Agendamento entity) {

        Agendamento agendamentoEncontrado = this.read(id);

        if(agendamentoEncontrado != null){

            entity.setId(agendamentoEncontrado.getId());
            return agendamentoRepository.save(entity);
        }

        return new Agendamento();
    }

    @Override
    public void delete(Integer id) {
        agendamentoRepository.deleteById(id);
    }
}
