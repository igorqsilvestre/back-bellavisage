package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Procedimento;
import ads4.fatesg.pbbellavisage.repository.ProcedimentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class ProcedimentoService implements GenericOperations<Procedimento, Integer> {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    @Override
    public Procedimento create(Procedimento entity) {
        return procedimentoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Procedimento read(Integer id) {
        return procedimentoRepository.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Procedimento> readAll() {
        return procedimentoRepository.findAll();
    }

    @Override
    public Procedimento updatePart(Integer id, Procedimento entity) {

        Procedimento procedimentoEncontrado = this.read(id);

        if(procedimentoEncontrado != null){
            entity.setId(procedimentoEncontrado.getId());
            return procedimentoRepository.save(entity);
        }

        return new Procedimento();
    }

    @Override
    public Procedimento updateAll(Integer id, Procedimento entity) {

        Procedimento procedimentoEncontrado = this.read(id);

        if(procedimentoEncontrado != null){

            entity.setId(procedimentoEncontrado.getId());
            return procedimentoRepository.save(entity);
        }

        return new Procedimento();
    }

    @Override
    public void delete(Integer id) {
        procedimentoRepository.deleteById(id);
    }
}
