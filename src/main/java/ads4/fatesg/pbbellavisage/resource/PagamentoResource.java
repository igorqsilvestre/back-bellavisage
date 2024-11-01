package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.dto.AgendamentoCreateDto;
import ads4.fatesg.pbbellavisage.dto.PagamentoCreateDto;
import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.*;
import ads4.fatesg.pbbellavisage.service.AgendamentoService;
import ads4.fatesg.pbbellavisage.service.PagamentoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/pagamento")
public class PagamentoResource implements GenericOperations<Pagamento, Integer> {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private AgendamentoService agendamentoService;


    @GetMapping(
            value = "/faturamento/mensal",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public BigDecimal obterFaturamentoMensal(@RequestParam Long tratamentoId, @RequestParam int mes, @RequestParam int ano) {
        return pagamentoService.obterFaturamentoMensal(tratamentoId, mes, ano);
    }

    @Override
    public Pagamento create(@Valid @RequestBody Pagamento entity) {
        return pagamentoService.create(entity);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Pagamento createPagamentoComDto(@Valid @RequestBody PagamentoCreateDto entity) {
        System.out.println(entity);
        Pagamento pagamento = converteDtoEmPagamento(entity);
        return pagamentoService.create(pagamento);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Pagamento read(@PathVariable  Integer id) {
        return pagamentoService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Pagamento> readAll() {
        return pagamentoService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Pagamento updatePart(@PathVariable  Integer id, @Valid @RequestBody Pagamento entity) {
        return pagamentoService.updatePart(id,entity);
    }

    @Override
    public Pagamento updateAll(@PathVariable Integer id, @Valid @RequestBody Pagamento entity) {
        return pagamentoService.updateAll(id,entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Pagamento atualizaPagamentoComDto(@PathVariable Integer id, @Valid @RequestBody PagamentoCreateDto entity) {
        Pagamento pagamento = converteDtoEmPagamento(entity);
        return pagamentoService.updateAll(id, pagamento);
    }


    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        pagamentoService.delete(id);
    }

    private Pagamento converteDtoEmPagamento(@RequestBody @Valid PagamentoCreateDto entity) {
        Agendamento agendamento = agendamentoService.read(entity.getAgendamento());
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(entity.getValor());
        pagamento.setFormaDePagamento(entity.getFormaDePagamento());
        pagamento.setDataHorario(entity.getDataHorario());
        pagamento.setStatusPagamento(entity.getStatusPagamento());
        pagamento.setAgendamento(agendamento);
        return pagamento;
    }
}
