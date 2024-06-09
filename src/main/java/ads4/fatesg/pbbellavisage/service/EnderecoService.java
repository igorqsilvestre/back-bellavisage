package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Endereco;
import ads4.fatesg.pbbellavisage.repository.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class EnderecoService implements GenericOperations<Endereco, Integer> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco create(Endereco entity) {
        return enderecoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Endereco read(Integer id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Endereco> readAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco updatePart(Integer id, Endereco entity) {
        Endereco enderecoEncontrado = this.read(id);

        if(enderecoEncontrado != null){
            entity.setId(enderecoEncontrado.getId());
            return enderecoRepository.save(entity);
        }

        return new Endereco();
    }

    @Override
    public Endereco updateAll(Integer id, Endereco entity) {
        Endereco enderecoEncontrado = this.read(id);

        if(enderecoEncontrado != null){
            entity.setId(enderecoEncontrado.getId());
            return enderecoRepository.save(entity);
        }

        return new Endereco();
    }

    @Override
    public void delete(Integer id) {
        enderecoRepository.deleteById(id);
    }

}
