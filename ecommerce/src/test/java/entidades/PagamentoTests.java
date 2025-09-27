package entidades;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class PagamentoTests {
    @Test
    @Transactional

    public void testSalvaUmPagamentor(){
Pedido pedido = Pedido.findById(1); 
Pagamento pagamento = new Pagamento(); 
pagamento.pedido = pedido; 
pagamento.forma_pagamento = Pagamento.FormaPagamento.pix; 
pagamento.status_pagamento = Pagamento.Status.aprovado; 
pagamento.valor = 150.0; 
pagamento.data_pagamento = LocalDateTime.now(); 
pagamento.persist(); 
Assertions.assertEquals(6, pagamento.id);
}
}