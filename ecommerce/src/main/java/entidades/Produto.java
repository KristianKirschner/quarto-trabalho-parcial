package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Produto extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotBlank
    @Size(min = 3, max = 120)
    public String nome;

    @NotBlank
    @Size(min = 10, max = 2000)
    public String descricao;

    @NotNull
    @PositiveOrZero
    public Double preco;

    @NotNull
    @Min(0)
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
