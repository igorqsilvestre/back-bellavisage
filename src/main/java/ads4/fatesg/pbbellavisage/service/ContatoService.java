package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Contato;
import ads4.fatesg.pbbellavisage.repository.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ContatoService implements GenericOperations<Contato, Integer> {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public Contato create(Contato entity) {
        return contatoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Contato read(Integer id) {
        return contatoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contato não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contato> readAll() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato updatePart(Integer id, Contato entity) {
        Contato contatoEncontrado = this.read(id);

        if(contatoEncontrado != null){
            entity.setId(contatoEncontrado.getId());
            return contatoRepository.save(entity);
        }

        return new Contato();
    }

    @Override
    public Contato updateAll(Integer id, Contato entity) {
        Contato contatoEncontrado = this.read(id);

        if(contatoEncontrado != null){
            entity.setId(contatoEncontrado.getId());
            return contatoRepository.save(entity);
        }

        return new Contato();
    }

    @Override
    public void delete(Integer id) {
        contatoRepository.deleteById(id);
    }

}
