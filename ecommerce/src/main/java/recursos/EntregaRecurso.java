package recursos;

import java.util.List;

import entidades.Entrega;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("entrega")

public class EntregaRecurso {
    @GET
    public List<Entrega> listar(){
        return Entrega.listAll();
    }

    @POST
    @Transactional
    public void salvar(Entrega entrega) {
        entrega.persist();
    }

}