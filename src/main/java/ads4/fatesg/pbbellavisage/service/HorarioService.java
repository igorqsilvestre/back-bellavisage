package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Horario;
import ads4.fatesg.pbbellavisage.repository.HorarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class HorarioService implements GenericOperations<Horario, Integer> {

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public Horario create(Horario entity) {
        return horarioRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Horario read(Integer id) {
        return horarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Horário não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Horario> readAll() {
        return horarioRepository.findAll();
    }


    @Override
    public Horario updatePart(Integer id, Horario entity) {
        Horario horarioEncontrado = this.read(id);

        if(horarioEncontrado != null){
            entity.setId(horarioEncontrado.getId());
            return horarioRepository.save(entity);
        }

        return new Horario();
    }

    @Override
    public Horario updateAll(Integer id, Horario entity) {
        Horario horarioEncontrado = this.read(id);

        if(horarioEncontrado != null){
            entity.setId(horarioEncontrado.getId());
            return horarioRepository.save(entity);
        }

        return new Horario();
    }

    @Override
    public void delete(Integer id) {
        horarioRepository.deleteById(id);
    }
}
