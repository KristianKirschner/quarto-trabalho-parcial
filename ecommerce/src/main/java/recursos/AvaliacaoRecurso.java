package recursos;

import java.util.List;

import entidades.Avaliacao;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("avaliacao")

public class AvaliacaoRecurso {
    @GET
    public List<Avaliacao> listar(){
        return Avaliacao.listAll();
    }


    @POST
    @Transactional
    public void salvar(Avaliacao avaliacao) {
        avaliacao.persist();
    }

}