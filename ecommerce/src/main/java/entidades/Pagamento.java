package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pagamento extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    public Pedido pedido;

    @Enumerated(EnumType.STRING)
    public FormaPagamento forma_pagamento;

    @Enumerated(EnumType.STRING)
    public Status status_pagamento;

    public Double valor;

    public LocalDateTime data_pagamento;

    public enum FormaPagamento {
        cartao, boleto, pix
    }

    public enum Status {
        pendente, aprovado, recusado
    }
}
