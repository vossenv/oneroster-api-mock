Feature: Term Controller Integration Testing

  Scenario: Validate the /terms/:term/classes endpoint

    Given url URL + 'terms/Fall/classes'
    When method GET
    Then status 200
    And match each response == CLASS