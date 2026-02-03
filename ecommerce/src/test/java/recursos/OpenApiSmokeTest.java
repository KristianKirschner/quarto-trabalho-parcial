package recursos;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class OpenApiSmokeTest {

    @Test
    public void openApiEndpointExiste() {
        given()
        .when()
                .get("/q/openapi")
        .then()
                .statusCode(200)
                .body(containsString("Ecommerce API"));
    }
}
