package recursos;

import java.util.List;

import entidades.Pagamento;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("pagamento")

public class PagamentoRecurso {
    @GET
    public List<Pagamento> listar(){
        return Pagamento.listAll();
    }

    @POST
    @Transactional
    public void salvar(Pagamento pagamento) {
        pagamento.persist();
    }

}