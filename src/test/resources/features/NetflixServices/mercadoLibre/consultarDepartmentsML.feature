@MercadoLibre
Feature: Consultar la lista de departments de Mercado Libre
  Scenario: Obtener lista de departamentos
    Given estoy en la página de Mercado Libre
    When consulto la lista de departamentos
    Then valido que la respuesta es 200
    Then se me mostrará los datos que contiene en la consola
