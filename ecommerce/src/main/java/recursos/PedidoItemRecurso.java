package recursos;

import java.util.List;

import entidades.PedidoItem;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("pedidoitem")

public class PedidoItemRecurso {
    @GET
    public List<PedidoItem> listar(){
        return PedidoItem.listAll();
    }

    @POST
    @Transactional
    public void salvar(PedidoItem pedidoItem) {
        pedidoItem.persist();
    }

}