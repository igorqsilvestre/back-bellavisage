package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Especialidade;
import ads4.fatesg.pbbellavisage.repository.EspecialidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class EspecialidadeService implements GenericOperations<Especialidade, Integer> {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Override
    public Especialidade create(Especialidade entity) {
        return especialidadeRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Especialidade read(Integer id) {
        return especialidadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Especialidade não encontrada!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Especialidade> readAll() {
        return especialidadeRepository.findAll();
    }

    @Override
    public Especialidade updatePart(Integer id, Especialidade entity) {

        Especialidade especialidadeEncontrada = this.read(id);

        if(especialidadeEncontrada != null){

            entity.setId(especialidadeEncontrada.getId());
            return especialidadeRepository.save(entity);
        }

        return new Especialidade();
    }

    @Override
    public Especialidade updateAll(Integer id, Especialidade entity) {

        Especialidade especialidadeEncontrada = this.read(id);

        if(especialidadeEncontrada != null){
            entity.setId(especialidadeEncontrada.getId());
            return especialidadeRepository.save(entity);
        }

        return new Especialidade();
    }

    @Override
    public void delete(Integer id) {
        especialidadeRepository.deleteById(id);
    }
}
