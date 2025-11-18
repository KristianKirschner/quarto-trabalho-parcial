package recursos;

import java.util.List;

import entidades.Pagamento;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("pagamento")

public class PagamentoRecurso {
    @GET
    public List<Pagamento> listar() {
        return Pagamento.listAll();
    }

    @POST
    @Transactional
    public void salvar(Pagamento pagamento) {
        pagamento.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluir(@PathParam("id") Integer id) {
        Pagamento pagamento = Pagamento.findById(id);

        if (pagamento != null) {
            pagamento.delete();
        }
    }

    @PUT
    @Transactional
    @Path("{id}")
    public void editar(@PathParam("id") Integer id, Pagamento pagamento) {

        Pagamento existente = Pagamento.findById(id);
        if (existente == null) {
            return;
        }

        existente.pedido = pagamento.pedido;
        existente.forma_pagamento = pagamento.forma_pagamento;
        existente.status_pagamento = pagamento.status_pagamento;
        existente.valor = pagamento.valor;
        existente.data_pagamento = pagamento.data_pagamento;
    }
}