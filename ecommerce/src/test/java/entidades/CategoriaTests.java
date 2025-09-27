package entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class CategoriaTests {
    @Test
    @Transactional

    public void testSalvaUmaCategoria(){

Categoria categoria = new Categoria(); 
categoria.nome = "Eletrônicos"; 
categoria.descricao = "Categoria de produtos eletrônicos"; 
categoria.persist(); 
Assertions.assertEquals(6, categoria.id);


}
}