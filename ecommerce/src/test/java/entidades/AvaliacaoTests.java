package entidades;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class AvaliacaoTests {
    @Test
    @Transactional

    public void testSalvaUmaAvaliacao(){

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.cliente = Cliente.findById(1);
        avaliacao.produto = Produto.findById(1);
        avaliacao.nota = 10;
        avaliacao.comentario = "Muito bom!";
        avaliacao.data_avaliacao = LocalDateTime.of(2025, 2, 3, 5, 40);

        avaliacao.persist();
        Assertions.assertEquals(6, avaliacao.id);
    }


}
