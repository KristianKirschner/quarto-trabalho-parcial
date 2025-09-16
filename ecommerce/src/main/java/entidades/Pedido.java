package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pedido extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    public Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    public Endereco enderecoEntrega;

    public LocalDateTime data_pedido;
    public Double valor_total;

    @Enumerated(EnumType.STRING)
    public Status status_pedido;

    public enum Status {
        pendente, pago, enviado, entregue, cancelado
    }
}
