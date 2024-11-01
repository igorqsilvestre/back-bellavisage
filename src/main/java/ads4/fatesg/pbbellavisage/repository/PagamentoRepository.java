package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    @Query("SELECT SUM(p.valor) FROM Pagamento p WHERE p.agendamento.tratamento.id = :tratamentoId AND MONTH(p.dataHorario) = :mes AND YEAR(p.dataHorario) = :ano AND p.statusPagamento = 'Pago'")
    BigDecimal calcularFaturamentoMensal(@Param("tratamentoId") Long tratamentoId, @Param("mes") int mes, @Param("ano") int ano);
}
