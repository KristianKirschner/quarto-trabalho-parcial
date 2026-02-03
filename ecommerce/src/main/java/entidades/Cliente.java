package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Cliente extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotBlank
    @Size(min = 2, max = 120)
    public String nome;

    @Column(unique = true)
    @NotBlank
    @Email
    public String email;

    public String senha_hash;

    @Size(max = 20)
    public String telefone;

    public LocalDateTime data_criacao;

    @Enumerated(EnumType.STRING)
    public Status status;

    public enum Status {
        ativo, inativo
    }
}
