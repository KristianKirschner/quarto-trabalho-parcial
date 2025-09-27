package entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class EnderecoTests {
    @Test
    @Transactional

    public void testSalvaUmaEndereco(){
Cliente cliente = Cliente.findById(1); 
   Endereco endereco = new Endereco(); 
   endereco.cliente = cliente; 
   endereco.logradouro = "Rua das Flores"; 
   endereco.numero = "123"; 
   endereco.complemento = "Apto 45"; 
   endereco.bairro = "Centro"; 
   endereco.cidade = "Ourinhos"; 
   endereco.estado = "SP"; 
   endereco.cep = "19900-000"; 
   endereco.tipo = Endereco.Tipo.residencial; 
   endereco.persist(); 
   Assertions.assertEquals(6, endereco.id);
}
}