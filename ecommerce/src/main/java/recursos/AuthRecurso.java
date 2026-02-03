package recursos;

import dto.auth.LoginRequest;
import dto.auth.LoginResponse;
import entidades.Cliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.UUID;

/**
 * Endpoint de autenticação FAKE.
 *
 * Objetivo: demonstrar como seria um fluxo de login em uma API REST.
 * Não implementa segurança real (sem hash, sem JWT real, sem sessões).
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthRecurso {

    @POST
    @Path("/login")
    @Transactional
    @Operation(summary = "Login (fake)", description = "Valida email/senha e retorna um token fictício.")
    @APIResponse(responseCode = "200", description = "Login OK",
            content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    @APIResponse(responseCode = "401", description = "Credenciais inválidas")
    public Response login(
            @RequestBody(required = true, content = @Content(schema = @Schema(implementation = LoginRequest.class)))
            @Valid LoginRequest req
    ) {
        Cliente cliente = Cliente.find("email", req.email).firstResult();
        if (cliente == null || cliente.senha_hash == null || !cliente.senha_hash.equals(req.password)) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new SimpleMessage("Credenciais inválidas"))
                    .build();
        }

        // Token fake (não é JWT real). Serve apenas como demonstração.
        String token = "demo-" + UUID.randomUUID();
        LoginResponse resp = new LoginResponse(token, cliente.id, cliente.nome, cliente.email);
        return Response.ok(resp).build();
    }

    public static class SimpleMessage {
        public String message;

        public SimpleMessage() {}

        public SimpleMessage(String message) {
            this.message = message;
        }
    }
}
