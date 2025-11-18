package recursos;

import java.util.List;

import entidades.Administrador;
import entidades.Administrador;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("administrador")

public class AdministradorRecurso {
    @GET
    public List<Administrador> listar() {
        return Administrador.listAll();
    }

    @POST
    @Transactional
    public void salvar(Administrador administrador) {
        administrador.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        Administrador administrador = Administrador.findById(codigo);

        if (administrador != null) {
            administrador.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar(@PathParam("codigo") Integer codigo, Administrador admin) {

        Administrador existente = Administrador.findById(codigo);
        if (existente == null) {
            return;
        }

        existente.nome = admin.nome;
        existente.email = admin.email;
        existente.senha_hash = admin.senha_hash;
        existente.nivel_acesso = admin.nivel_acesso;
    }

}