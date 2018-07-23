@ignore
Feature: Repeatable Scenarios for testing disallowed HTTP Methods

  Scenario: POST is not allowed

    Given url URL + path
    And request {"ThisCannot":"BeEmpty"}
    When method POST
    Then status 400

  Scenario: PUT is not allowed

    Given url URL + path
    And request {"ThisCannot":"BeEmpty"}
    When method PUT
    Then status 400

  Scenario: PATCH is not allowed

    Given url URL + path
    And request {"ThisCannot":"BeEmpty"}
    When method PATCH
    Then status 400

  Scenario: DELETE is not allowed

    Given url URL + path
    And request {"ThisCannot":"BeEmpty"}
    When method DELETE
    Then status 400
    



