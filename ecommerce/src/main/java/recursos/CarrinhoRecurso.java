package recursos;

import java.util.List;

import entidades.Carrinho;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("carrinho")

public class CarrinhoRecurso {
    @GET
    public List<Carrinho> listar() {
        return Carrinho.listAll();
    }

    @POST
    @Transactional
    public void salvar(Carrinho carrinho) {
        carrinho.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        Carrinho carrinho = Carrinho.findById(codigo);

        if (carrinho != null) {
            carrinho.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar(@PathParam("codigo") Integer codigo, Carrinho carrinho) {

        Carrinho existente = Carrinho.findById(codigo);
        if (existente == null) {
            return;
        }

        existente.cliente = carrinho.cliente;
        existente.data_criacao = carrinho.data_criacao;
        existente.status = carrinho.status;
    }

}