package ads4.fatesg.pbbellavisage.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class HorarioCreateDto {
    private Integer id;
    @NotNull
    private Date data;
    @NotNull
    private boolean disponibilidade;
    @NotNull
    private Integer especialista;
    @NotNull
    private Integer tratamento;


    public boolean getDisponibilidade(){
        return this.disponibilidade;
    }
}
