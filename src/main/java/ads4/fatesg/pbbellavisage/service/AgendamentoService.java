package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.dto.AgendamentoCreateDto;
import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Agendamento;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import ads4.fatesg.pbbellavisage.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
        return agendamentoRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Agendamento> readAll() {
        return agendamentoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Agendamento> readAllAgendamentosByPacienteIdAndStatus(Integer pacienteId, Agendamento.StatusAgendamento status) {
        return agendamentoRepository.findByPacienteIdAndStatus(pacienteId, status);
    }

    @Transactional(readOnly = true)
    public List<Agendamento> readAllAgendamentosByPacienteIdStatusAndDate(Integer pacienteId, Agendamento.StatusAgendamento status, Date data) {
        return agendamentoRepository.findByPacienteIdAndStatusAndHorarioData(pacienteId, status, data);
    }

    @Transactional(readOnly = true)
    public List<Agendamento> readAllByNomeTratamentoStartingWithAndStatus(String nome, Agendamento.StatusAgendamento status) {
        return agendamentoRepository.findByTratamentoNomeStartingWithIgnoreCaseAndStatus(nome, status);
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
