package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Produto extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String nome;
    public String descricao;
    public Double preco;
    public Integer estoque;
    public String imagem_url;

    public LocalDateTime data_cadastro;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    public Categoria categoria;

    @Enumerated(EnumType.STRING)
    public Status status;

    public enum Status {
        ativo, inativo
    }
}
