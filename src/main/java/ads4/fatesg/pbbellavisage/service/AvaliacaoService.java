package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Avaliacao;
import ads4.fatesg.pbbellavisage.repository.AvaliacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class AvaliacaoService implements GenericOperations<Avaliacao, Integer> {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Override
    public Avaliacao create(Avaliacao entity) {
        return avaliacaoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Avaliacao read(Integer id) {
        return avaliacaoRepository.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Avaliacao> readAll() {
        return avaliacaoRepository.findAll();
    }

    @Override
    public Avaliacao updatePart(Integer id, Avaliacao entity) {

        Avaliacao avaliacaoEncontrada = this.read(id);

        if(avaliacaoEncontrada != null){
            entity.setId(avaliacaoEncontrada.getId());
            return avaliacaoRepository.save(entity);
        }

        return new Avaliacao();
    }

    @Override
    public Avaliacao updateAll(Integer id, Avaliacao entity) {

        Avaliacao avaliacaoEncontrada = this.read(id);

        if(avaliacaoEncontrada != null){

            entity.setId(avaliacaoEncontrada.getId());
            return avaliacaoRepository.save(entity);
        }

        return new Avaliacao();
    }

    @Override
    public void delete(Integer id) {
        avaliacaoRepository.deleteById(id);
    }
}
