package recursos;

import java.util.List;

import entidades.Pedido;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("pedido")

public class PedidoRecurso {
    @GET
    public List<Pedido> listar() {
        return Pedido.listAll();
    }

    @POST
    @Transactional
    public void salvar(Pedido pedido) {
        pedido.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir(@PathParam("id") Integer id) {
        Pedido pedido = Pedido.findById(id);

        if (pedido != null) {
            pedido.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{id}")
    public void editar(@PathParam("id") Integer id, Pedido pedido) {

        Pedido existente = Pedido.findById(id);
        if (existente == null) {
            return;
        }

        existente.cliente = pedido.cliente;
        existente.enderecoEntrega = pedido.enderecoEntrega;
        existente.data_pedido = pedido.data_pedido;
        existente.valor_total = pedido.valor_total;
        existente.status_pedido = pedido.status_pedido;
    }

}