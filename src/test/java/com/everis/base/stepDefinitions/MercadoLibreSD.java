package com.everis.base.stepDefinitions;

import com.everis.base.steps.MercadoLibreSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MercadoLibreSD {
    @Steps
    public MercadoLibreSteps mercadoLibreSteps;

    @Given("estoy en la página de Mercado Libre")
    public void estoy_en_la_página_de_mercado_libre() {
        System.out.println("---------------INICIAMOS LA PRUEBA------------------");
    }

    @When("consulto la lista de departamentos")
    public void consulto_el_método_department() {
        mercadoLibreSteps.listDepartments();
    }

    @Then("valido que la respuesta es {int}")
    public void valido_que_la_respuesta_es(int i) {
        mercadoLibreSteps.validateStatusCode(i);
        System.out.println("El código de respuesta es: " + i + "Todo salió bien");
    }

    @Then("se me mostrará los datos que contiene en la consola")
    public void se_me_mostrará_los_datos_que_contiene_en_la_consola() {
        mercadoLibreSteps.printList();
        System.out.println("----------SE FINALIZÓ LA IMPRESIÓN DE LA LISTA EN CONSOLA-------------");
    }


}
