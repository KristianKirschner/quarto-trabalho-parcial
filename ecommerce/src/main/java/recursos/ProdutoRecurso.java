package recursos;

import java.util.List;

import entidades.Produto;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("produto")

public class ProdutoRecurso {
    @GET
    public List<Produto> listar(){
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void salvar(Produto produto) {
        produto.persist();
    }

}