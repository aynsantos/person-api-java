package attornatus.person.controller;

import attornatus.person.controller.dto.PersonDTO;
import attornatus.person.enums.AddressType;
import attornatus.person.model.Address;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllCheckResult() {
        RestAssured.given()
                .when()
                .get("/person")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().response().body().prettyPrint();

    }

}