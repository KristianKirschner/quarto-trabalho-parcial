package entidades;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class ClienteTests {
    @Test
    @Transactional

    public void testSalvaUmaCliente(){

Cliente cliente = new Cliente(); 
cliente.nome = "João Silva"; 
cliente.email = "joao.silva@example.com"; 
cliente.senha_hash = "hash123"; cliente.telefone = "11999999999"; 
cliente.data_criacao = LocalDateTime.now(); 
cliente.status = Cliente.Status.ativo; 
cliente.persist(); 
Assertions.assertEquals(6, cliente.id);

}
}