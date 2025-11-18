package recursos;

import java.util.List;

import entidades.Endereco;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("endereco")

public class EnderecoRecurso {
    @GET
    public List<Endereco> listar() {
        return Endereco.listAll();
    }

    @POST
    @Transactional
    public void salvar(Endereco endereco) {
        endereco.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        Endereco endereco = Endereco.findById(codigo);

        if (endereco != null) {
            endereco.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar(@PathParam("codigo") Integer codigo, Endereco endereco) {

        Endereco existente = Endereco.findById(codigo);
        if (existente == null) {
            return;
        }

        existente.cliente = endereco.cliente;
        existente.logradouro = endereco.logradouro;
        existente.numero = endereco.numero;
        existente.complemento = endereco.complemento;
        existente.bairro = endereco.bairro;
        existente.cidade = endereco.cidade;
        existente.estado = endereco.estado;
        existente.cep = endereco.cep;
        existente.tipo = endereco.tipo;
    }

}