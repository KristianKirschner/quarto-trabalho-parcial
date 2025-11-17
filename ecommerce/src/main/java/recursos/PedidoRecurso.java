package recursos;

import java.util.List;

import entidades.Pedido;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("pedido")

public class PedidoRecurso {
    @GET
    public List<Pedido> listar(){
        return Pedido.listAll();
    }

    @POST
    @Transactional
    public void salvar(Pedido pedido) {
        pedido.persist();
    }

}