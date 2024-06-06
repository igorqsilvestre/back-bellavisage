package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Especialista;
import ads4.fatesg.pbbellavisage.repository.EspecialistaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class EspecialistaService implements GenericOperations<Especialista, Integer> {

    @Autowired
    private EspecialistaRepository especialistaRepository;

    @Override
    public Especialista create(Especialista entity) {
        return especialistaRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Especialista read(Integer id) {
        return especialistaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Especialista não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Especialista> readAll() {
        return especialistaRepository.findAll();
    }

    @Override
    public Especialista updatePart(Integer id, Especialista entity) {

        Especialista especialistaEncontrado = this.read(id);

        if(especialistaEncontrado != null){
            entity.getEndereco().setId(especialistaEncontrado.getEndereco().getId());
            entity.setId(especialistaEncontrado.getId());
            return especialistaRepository.save(entity);
        }

        return new Especialista();
    }

    @Override
    public Especialista updateAll(Integer id, Especialista entity) {

        Especialista especialistaEncontrado = this.read(id);

        if(especialistaEncontrado != null){
            entity.getEndereco().setId(especialistaEncontrado.getEndereco().getId());
            entity.setId(especialistaEncontrado.getId());
            return especialistaRepository.save(entity);
        }

        return new Especialista();
    }

    @Override
    public void delete(Integer id) {
        especialistaRepository.deleteById(id);
    }
}
