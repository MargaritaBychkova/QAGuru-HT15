package guru.qa;

import guru.qa.config.APIConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class TestAPI {
    static APIConfig config;

    @BeforeAll
    static void setUp() {
        config = ConfigFactory.create(APIConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseURI();
    }

    @Test
    @DisplayName("Проверка ошибки авторизации")
    void userLoginFailed() {
        String error = "Missing password";

        given()
                .log().uri()
                .log().body()
                .body("{ \"email\": \"" + config.email() + "\" }")
                .contentType(JSON)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is(error));

    }
}



