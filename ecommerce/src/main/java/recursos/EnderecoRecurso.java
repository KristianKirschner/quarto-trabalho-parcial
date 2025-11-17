package recursos;

import java.util.List;

import entidades.Endereco;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("endereco")

public class EnderecoRecurso {
    @GET
    public List<Endereco> listar(){
        return Endereco.listAll();
    }

    @POST
    @Transactional
    public void salvar(Endereco endereco) {
        endereco.persist();
    }

}