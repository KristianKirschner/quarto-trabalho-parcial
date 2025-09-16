package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cliente extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String nome;

    @Column(unique = true)
    public String email;

    public String senha_hash;

    public String telefone;

    public LocalDateTime data_criacao;

    @Enumerated(EnumType.STRING)
    public Status status;

    public enum Status {
        ativo, inativo
    }
}
