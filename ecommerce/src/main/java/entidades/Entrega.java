package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Entrega extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    public Pedido pedido;

    public String codigo_rastreamento;
    public String transportadora;

    @Enumerated(EnumType.STRING)
    public Status status_entrega;

    public LocalDateTime data_envio;
    public LocalDate data_entrega_prevista;
    public LocalDate data_entrega_real;

    public enum Status {
        pendente, em_transito, entregue
    }
}
