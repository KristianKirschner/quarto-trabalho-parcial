package entidades;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entidades.Carrinho.Status;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class CarrinhoTests {
    @Test
    @Transactional

    public void testSalvaUmCarrinho(){

        Carrinho carrinho = new Carrinho();
        carrinho.cliente = Cliente.findById(1);
        carrinho.data_criacao = LocalDateTime.now();
        carrinho.status = Status.valueOf("aberto");
        

        carrinho.persist();
        Assertions.assertEquals(6, carrinho.id);
    }


}
