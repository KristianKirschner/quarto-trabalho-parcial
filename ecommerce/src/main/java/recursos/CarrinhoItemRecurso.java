package recursos;

import java.util.List;

import entidades.CarrinhoItem;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("carrinhoitem")

public class CarrinhoItemRecurso {
    @GET
    public List<CarrinhoItem> listar() {
        return CarrinhoItem.listAll();
    }

    @POST
    @Transactional
    public void salvar(CarrinhoItem carrinhoItem) {
        carrinhoItem.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        CarrinhoItem item = CarrinhoItem.findById(codigo);

        if (item != null) {
            item.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar(@PathParam("codigo") Integer codigo, CarrinhoItem item) {

        CarrinhoItem existente = CarrinhoItem.findById(codigo);
        if (existente == null) {
            return;
        }

        existente.carrinho = item.carrinho;
        existente.produto = item.produto;
        existente.quantidade = item.quantidade;
        existente.preco_unitario = item.preco_unitario;
    }

}