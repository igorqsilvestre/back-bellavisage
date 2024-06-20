package ads4.fatesg.pbbellavisage.model;

import java.math.BigDecimal;

public class ReportBar {
    private String data;
    private BigDecimal valor;

    public ReportBar(String data, BigDecimal valor) {
        this.data = data;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
