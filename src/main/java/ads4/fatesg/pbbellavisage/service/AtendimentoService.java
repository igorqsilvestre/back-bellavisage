package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Atendimento;
import ads4.fatesg.pbbellavisage.repository.AtendimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class AtendimentoService implements GenericOperations<Atendimento, Integer> {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Override
    public Atendimento create(Atendimento entity) {
        return atendimentoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Atendimento read(Integer id) {
        return atendimentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Especialista não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Atendimento> readAll() {
        return atendimentoRepository.findAll();
    }

    @Override
    public Atendimento updatePart(Integer id, Atendimento entity) {

        Atendimento atendimentoEncontrado = this.read(id);

        if(atendimentoEncontrado != null){
            entity.setId(atendimentoEncontrado.getId());
            return atendimentoRepository.save(entity);
        }

        return new Atendimento();
    }

    @Override
    public Atendimento updateAll(Integer id, Atendimento entity) {

        Atendimento atendimentoEncontrado = this.read(id);

        if(atendimentoEncontrado != null){

            entity.setId(atendimentoEncontrado.getId());
            return atendimentoRepository.save(entity);
        }

        return new Atendimento();
    }

    @Override
    public void delete(Integer id) {
        atendimentoRepository.deleteById(id);
    }
}
