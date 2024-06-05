package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Telefone;
import ads4.fatesg.pbbellavisage.repository.TelefoneRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class TelefoneService implements GenericOperations<Telefone, Integer> {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    public Telefone create(Telefone entity) {
        return telefoneRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Telefone read(Integer id) {
        return telefoneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Telefone não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Telefone> readAll() {
        return telefoneRepository.findAll();
    }

    @Override
    public Telefone updatePart(Integer id, Telefone entity) {
        Telefone telefoneEncontrado = this.read(id);

        if(telefoneEncontrado != null){
            entity.setId(telefoneEncontrado.getId());
            return telefoneRepository.save(entity);
        }

        return new Telefone();
    }

    @Override
    public Telefone updateAll(Integer id, Telefone entity) {
        Telefone telefoneEncontrado = this.read(id);

        if(telefoneEncontrado != null){
            entity.setId(telefoneEncontrado.getId());
            return telefoneRepository.save(entity);
        }

        return new Telefone();
    }

    @Override
    public void delete(Integer id) {
        telefoneRepository.deleteById(id);
    }

}
