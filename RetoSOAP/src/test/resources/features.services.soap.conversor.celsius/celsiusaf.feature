Feature: Operación conversión - Celsius a Fahrenheit
  Como usuario de un conversor
  necesito validar que la funcionalidad de Celsius a Fahrenheit trabaje adecuadamente
  para poder tener seguridad en las operaciones de temperatura.

  @positive
  Scenario: Convertir celsius positive
    Given que el usuario del conversor ha definido como 35
    When el usuario del conversor ejecuta la conversion
    Then el ususario debería obtener el resultado 95

  @negativo
  Scenario: Convertir celsius negativo
    Given que el usuario del conversor ha definido como -35
    When el usuario del conversor ejecuta la conversion
    Then el ususario debería obtener el resultado -31