package entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class PedidoItemTests {
    @Test
    @Transactional

    public void testSalvaUmPedidoItem(){

        PedidoItem pedidoItem = new PedidoItem();

        Pedido pedido = Pedido.findById(2);
        Produto produto = Produto.findById(3);

        pedidoItem.pedido = pedido;
        pedidoItem.preco_unitario = 10.0;
        pedidoItem.produto = produto;
        pedidoItem.quantidade = 10;

        pedidoItem.persist();

        Assertions.assertEquals(6, pedidoItem.id);
    }


}
