package recursos;

import java.util.List;

import entidades.Avaliacao;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("avaliacao")

public class AvaliacaoRecurso {
    @GET
    public List<Avaliacao> listar() {
        return Avaliacao.listAll();
    }

    @POST
    @Transactional
    public void salvar(Avaliacao avaliacao) {
        avaliacao.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        Avaliacao avaliacao = Avaliacao.findById(codigo);

        if (avaliacao != null) {
            avaliacao.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{codigo}")
    public void editar(@PathParam("codigo") Integer codigo, Avaliacao avaliacao) {

        Avaliacao existente = Avaliacao.findById(codigo);
        if (existente == null) {
            return;
        }

        existente.cliente = avaliacao.cliente;
        existente.produto = avaliacao.produto;
        existente.nota = avaliacao.nota;
        existente.comentario = avaliacao.comentario;
        existente.data_avaliacao = avaliacao.data_avaliacao;
    }

}