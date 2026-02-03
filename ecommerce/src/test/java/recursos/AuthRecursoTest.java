package recursos;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class AuthRecursoTest {

    @Test
    public void loginOkRetornaToken() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"carlos.silva@email.com\",\"password\":\"senha_hash_123\"}")
        .when()
                .post("/auth/login")
        .then()
                .statusCode(200)
                .body("token", startsWith("demo-"))
                .body("tokenType", equalTo("Bearer"))
                .body("userEmail", equalTo("carlos.silva@email.com"))
                .body("userId", notNullValue());
    }

    @Test
    public void loginInvalidoRetorna401() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"carlos.silva@email.com\",\"password\":\"errada\"}")
        .when()
                .post("/auth/login")
        .then()
                .statusCode(401)
                .body("message", containsString("inválidas"));
    }
}
