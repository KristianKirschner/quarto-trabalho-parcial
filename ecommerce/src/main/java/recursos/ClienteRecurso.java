package recursos;

import java.util.List;

import entidades.Cliente;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("cliente")

public class ClienteRecurso {
    @GET
    public List<Cliente> listar(){
        return Cliente.listAll();
    }

    @POST
    @Transactional
    public void salvar(Cliente cliente) {
        cliente.persist();
    }

}