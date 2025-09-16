package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class Categoria extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String nome;

    public String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    public Categoria categoriaPai;
}
