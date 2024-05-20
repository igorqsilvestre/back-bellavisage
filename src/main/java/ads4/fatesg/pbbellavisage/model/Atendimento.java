package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "atendimento")
public class Atendimento extends BaseModel{

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime data_hora;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "especialista_id", referencedColumnName = "id")
    private Paciente especialista;

//    @OneToMany
//    @JoinColumn(name = "atendimento_id", referencedColumnName = "id")
//    private List<Atendimento> atendimentos = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Paciente paciente;

//    @OneToMany
//    @JoinColumn(name = "especialista_id")
//    private List<Especialista> especialistas = new ArrayList<>();
//
//    @OneToMany
//    @JoinColumn(name = "procedimento_id", referencedColumnName = "id")
//    private List<Procedimento> procedimentos = new ArrayList<>();
//
//    @OneToMany
//    @JoinColumn(name = "avaliacao_id", referencedColumnName = "id")
//    private List<Avaliacao> avaliacoes = new ArrayList<>();

}
