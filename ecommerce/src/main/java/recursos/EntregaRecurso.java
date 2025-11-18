package recursos;

import java.util.List;

import entidades.Entrega;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("entrega")

public class EntregaRecurso {
    @GET
    public List<Entrega> listar() {
        return Entrega.listAll();
    }

    @POST
    @Transactional
    public void salvar(Entrega entrega) {
        entrega.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        Entrega entrega = Entrega.findById(codigo);

        if (entrega != null) {
            entrega.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar(@PathParam("codigo") Integer codigo, Entrega entrega) {

        Entrega existente = Entrega.findById(codigo);
        if (existente == null) {
            return;
        }

        existente.pedido = entrega.pedido;
        existente.codigo_rastreamento = entrega.codigo_rastreamento;
        existente.transportadora = entrega.transportadora;
        existente.status_entrega = entrega.status_entrega;
        existente.data_envio = entrega.data_envio;
        existente.data_entrega_prevista = entrega.data_entrega_prevista;
        existente.data_entrega_real = entrega.data_entrega_real;
    }

}