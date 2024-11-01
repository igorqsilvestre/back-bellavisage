package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Pagamento;
import ads4.fatesg.pbbellavisage.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@Transactional
public class PagamentoService implements GenericOperations<Pagamento, Integer> {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public Pagamento create(Pagamento entity) {
        return pagamentoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public BigDecimal obterFaturamentoMensal(Long tratamentoId, int mes, int ano) {
        BigDecimal faturamento = pagamentoRepository.calcularFaturamentoMensal(tratamentoId, mes, ano);
        return faturamento != null ? faturamento : BigDecimal.ZERO; // Retorna 0 caso não haja faturamento
    }

    @Transactional(readOnly = true)
    @Override
    public Pagamento read(Integer id) {
        return pagamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pagamento> readAll() {
        return pagamentoRepository.findAll();
    }

    @Override
    public Pagamento updatePart(Integer id, Pagamento entity) {
        Pagamento pagamentoEncontrado = this.read(id);

        if(pagamentoEncontrado != null){
            entity.setId(pagamentoEncontrado.getId());
            return pagamentoRepository.save(entity);
        }

        return new Pagamento();
    }

    @Override
    public Pagamento updateAll(Integer id, Pagamento entity) {
        Pagamento pagamentoEncontrado = this.read(id);

        if(pagamentoEncontrado != null){
            entity.setId(pagamentoEncontrado.getId());
            return pagamentoRepository.save(entity);
        }

        return new Pagamento();
    }

    @Override
    public void delete(Integer id) {
        pagamentoRepository.deleteById(id);
    }

}
