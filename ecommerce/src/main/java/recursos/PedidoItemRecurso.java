package recursos;

import java.util.List;

import entidades.PedidoItem;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("pedidoitem")

public class PedidoItemRecurso {
    @GET
    public List<PedidoItem> listar() {
        return PedidoItem.listAll();
    }

    @POST
    @Transactional
    public void salvar(PedidoItem pedidoItem) {
        pedidoItem.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir(@PathParam("id") Integer id) {
        PedidoItem pedidoItem = PedidoItem.findById(id);

        if (pedidoItem != null) {
            pedidoItem.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{id}")
    public void editar(@PathParam("id") Integer id, PedidoItem pedidoItem) {

        PedidoItem existente = PedidoItem.findById(id);
        if (existente == null) {
            return;
        }

        existente.pedido = pedidoItem.pedido;
        existente.produto = pedidoItem.produto;
        existente.quantidade = pedidoItem.quantidade;
        existente.preco_unitario = pedidoItem.preco_unitario;
    }

}