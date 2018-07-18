@ignore
Feature: Repeatable Scenarios for testing allowed HTTP Methods

  Scenario: GET is allowed

    Given url URL + path
    When method GET
    Then status 200

  Scenario: OPTIONS is allowed

    Given url URL + path
    When method OPTIONS
    And request {"ThisCannot":"BeEmpty"}
    Then status 200

  Scenario: HEAD is allowed

    Given url URL + path
    And request {"ThisCannot":"BeEmpty"}
    When method HEAD
    Then status 200