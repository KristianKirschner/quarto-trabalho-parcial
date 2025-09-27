package entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class AdministradorTests {
    @Test
    @Transactional

    public void testSalvaUmAdministrador(){

        Administrador administrador = new Administrador();

        administrador.nome = "Carlos";
        administrador.email = "carlos@gmail.com";
        administrador.senha_hash = "adsid2ji12j31eqoem23";
        administrador.nivel_acesso = Administrador.NivelAcesso.gerente;

        administrador.persist();
        Assertions.assertEquals(6, administrador.id);
    }


}
