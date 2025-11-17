package recursos;

import java.util.List;

import entidades.CarrinhoItem;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("carrinhoitem")

public class CarrinhoItemRecurso {
    @GET
    public List<CarrinhoItem> listar(){
        return CarrinhoItem.listAll();
    }

    @POST
    @Transactional
    public void salvar(CarrinhoItem carrinhoItem) {
        carrinhoItem.persist();
    }

}