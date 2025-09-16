package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class Administrador extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String nome;

    @Column(unique = true)
    public String email;

    public String senha_hash;

    @Enumerated(EnumType.STRING)
    public NivelAcesso nivel_acesso;

    public enum NivelAcesso {
        gerente, vendedor, suporte
    }
}
