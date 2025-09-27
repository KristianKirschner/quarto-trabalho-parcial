package entidades;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class PedidoTests {
    @Test
    @Transactional

    public void testSalvaUmPedido(){
        Cliente cliente = Cliente.findById(1);
        Endereco endereco = Endereco.findById(1); 

        Pedido pedido = new Pedido(); 
        pedido.cliente = cliente; 
        pedido.enderecoEntrega = endereco; 
        pedido.data_pedido = LocalDateTime.now(); 
        pedido.valor_total = 299.90; 
        pedido.status_pedido = Pedido.Status.pendente; 
        pedido.persist(); 
        Assertions.assertEquals(6, pedido.id);

    }


}
