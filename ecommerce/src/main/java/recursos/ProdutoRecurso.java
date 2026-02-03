package recursos;

import java.util.List;

import entidades.Produto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Path("produto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProdutoRecurso {
    @GET
    public List<Produto> listar() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void salvar(@Valid Produto produto) {
        produto.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir(@PathParam("id") Integer id) {
        Produto produto = Produto.findById(id);

        if (produto != null) {
            produto.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{id}")
    public void editar(@PathParam("id") Integer id, @Valid Produto produto) {

        Produto existente = Produto.findById(id);
        if (existente == null) {
            return;
        }

        existente.nome = produto.nome;
        existente.descricao = produto.descricao;
        existente.preco = produto.preco;
        existente.estoque = produto.estoque;
        existente.imagem_url = produto.imagem_url;
        existente.data_cadastro = produto.data_cadastro;
        existente.categoria = produto.categoria;
        existente.status = produto.status;
    }
}