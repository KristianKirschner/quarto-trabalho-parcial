package recursos;

import java.util.List;

import entidades.Categoria;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("categoria")

public class CategoriaRecurso {
    @GET
    public List<Categoria> listar(){
        return Categoria.listAll();
    }

    @POST
    @Transactional
    public void salvar(Categoria categoria) {
        categoria.persist();
    }

}