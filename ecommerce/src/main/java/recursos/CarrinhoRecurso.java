package recursos;

import java.util.List;

import entidades.Carrinho;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("carrinho")

public class CarrinhoRecurso {
    @GET
    public List<Carrinho> listar(){
        return Carrinho.listAll();
    }

    @POST
    @Transactional
    public void salvar(Carrinho carrinho) {
        carrinho.persist();
    }

}