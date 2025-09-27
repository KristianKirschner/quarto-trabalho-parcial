package entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

@QuarkusTest
public class ProdutoTests {
    @Test
    @Transactional

    public void testSalvaUmProduto(){

        Produto produto = new Produto();

        produto.nome = "Agua sanitária 2L";
        produto.descricao = "Produto para limpeza";
        produto.preco = 10.0;
        produto.estoque = 5;
        produto.imagem_url = "www.enderecoimagem.com";
        produto.categoria = Categoria.findById(1);
        produto.status = Produto.Status.ativo;


        produto.persist();

        Assertions.assertEquals(6, produto.id);
    }


}
