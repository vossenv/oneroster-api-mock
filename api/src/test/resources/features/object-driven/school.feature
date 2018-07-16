Feature: Validate endpoints that return School objects

  Scenario: /schools responds with a collection of School objects

    Given url URL + 'schools'
    When method GET
    Then status 200
    And match each response == SCHOOL

