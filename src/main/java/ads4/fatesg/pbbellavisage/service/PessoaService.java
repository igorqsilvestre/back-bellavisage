package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Pessoa;
import ads4.fatesg.pbbellavisage.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class PessoaService implements GenericOperations<Pessoa, Integer> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa create(Pessoa entity) {
        return pessoaRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Pessoa read(Integer id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pessoa> readAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa updatePart(Integer id, Pessoa entity) {

        Pessoa pessoaEncontrada = this.read(id);

        if(pessoaEncontrada != null){
            entity.setId(pessoaEncontrada.getId());
            return pessoaRepository.save(entity);
        }

        return new Pessoa();
    }

    @Override
    public Pessoa updateAll(Integer id, Pessoa entity) {

        Pessoa pessoaEncontrada = this.read(id);

        if(pessoaEncontrada != null){

            entity.setId(pessoaEncontrada.getId());
            return pessoaRepository.save(entity);
        }

        return new Pessoa();
    }

    @Override
    public void delete(Integer id) {
        pessoaRepository.deleteById(id);
    }
}
