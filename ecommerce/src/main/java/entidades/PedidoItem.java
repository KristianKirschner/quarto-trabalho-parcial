package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class PedidoItem extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    public Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    public Produto produto;

    public Integer quantidade;
    public Double preco_unitario;
}
