Feature: Get debug message

  Scenario: Debug only

    Given url URL + 'schools'
    When method GET
    Then status 200

