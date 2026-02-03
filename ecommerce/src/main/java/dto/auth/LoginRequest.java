package dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO de login (fake) só para demonstrar fluxo de autenticação em API.
 * Não implementa segurança real.
 */
public class LoginRequest {
    @NotBlank
    @Email
    public String email;

    @NotBlank
    public String password;
}
