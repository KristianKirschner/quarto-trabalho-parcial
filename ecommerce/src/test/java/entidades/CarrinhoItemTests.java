package entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class CarrinhoItemTests {
    @Test
    @Transactional

    public void testSalvaUmCarrinhoItem(){

        CarrinhoItem carrinhoItem = new CarrinhoItem();

        carrinhoItem.carrinho = Carrinho.findById(1);
        carrinhoItem.produto = Produto.findById(1);
        carrinhoItem.quantidade = 1;
        carrinhoItem.preco_unitario = 10.99;


        carrinhoItem.persist();
        Assertions.assertEquals(6, carrinhoItem.id);
    }


}
