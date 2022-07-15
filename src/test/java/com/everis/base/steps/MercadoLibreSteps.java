package com.everis.base.steps;

import com.everis.base.models.Book;
import com.everis.base.models.Departamento;
import com.everis.base.models.User;
import freemarker.core.ReturnInstruction;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MercadoLibreSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(MercadoLibreSteps.class);
    static private final String BASE_URL = "https://www.mercadolibre.com.pe/menu/";
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    Response response = RestAssured.get(BASE_URL + "departments");

    @Before
    public void init() {

        LOGGER.info(" Inicializa el constructor request ");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        LOGGER.info(" Inicializa el constructor response ");
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Step("obtiene lista de departamentos")
    public void listDepartments() {

        given().
                spec(requestSpec).
                when().
                get("departments").
                then().
                spec(responseSpec).
                and();
        System.out.println("-----------Se ha obtenido la lista de departamentos-------------");
    }

    @Step("imprime la lista en consola")
    public void printList() {

        System.out.println("----------SE ESTA IMPRIMIENDO LA LISTA EN CONSOLA-------------");
        System.out.println("Body ordenado: " + response.getBody().asPrettyString());
    }

    public void validateStatusCode(int i) {
        assertThat(lastResponse().statusCode(), is(i));
    }


}
