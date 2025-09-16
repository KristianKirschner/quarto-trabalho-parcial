package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Carrinho extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    public Cliente cliente;

    public LocalDateTime data_criacao;

    @Enumerated(EnumType.STRING)
    public Status status;

    public enum Status {
        aberto, finalizado
    }
}
