Feature: API Error Handling Integration Testing

  Scenario: Validate error response for unsupported request type

    Given url URL + 'users'
    When method POST
    Then status 200


