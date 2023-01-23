package attornatus.person.controller;

import attornatus.person.controller.dto.PersonDTO;
import attornatus.person.model.Address;
import attornatus.person.model.Person;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


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

    @Test
    void whenCreateCheckIsCreated() {

        var personDTO = new PersonDTO();
        personDTO.setName("Jinbe");
        personDTO.setBirthDate("01/01/2000");
        personDTO.setAddress(new Address("rua test", "37500000", "City of evil"));

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(personDTO)
                .post("/person")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract().response().body().prettyPrint();
    }
}