package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class CarrinhoItem extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    public Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    public Produto produto;

    public Integer quantidade;
    public Double preco_unitario;
}
