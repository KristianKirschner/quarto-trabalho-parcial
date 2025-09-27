package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class EntregaTests {
    @Test
    @Transactional

    public void testSalvaUmaEndereco(){
Pedido pedido = Pedido.findById(1); 
Entrega entrega = new Entrega(); 
entrega.pedido = pedido; 
entrega.codigo_rastreamento = "BR123456789"; 
entrega.transportadora = "Correios"; 
entrega.status_entrega = Entrega.Status.pendente; 
entrega.data_envio = LocalDateTime.now(); 
entrega.data_entrega_prevista = LocalDate.now().plusDays(7); 
entrega.data_entrega_real = null; entrega.persist(); 
Assertions.assertEquals(6, entrega.id);
}
}