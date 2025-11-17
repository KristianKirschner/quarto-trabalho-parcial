package recursos;

import java.util.List;

import entidades.Administrador;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("administrador")

public class AdministradorRecurso {
    @GET
    public List<Administrador> listar(){
        return Administrador.listAll();
    }


    @POST
    @Transactional
    public void salvar(Administrador administrador) {
        administrador.persist();
    }

}