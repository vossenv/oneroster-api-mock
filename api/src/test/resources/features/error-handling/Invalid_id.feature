Feature: API Error Handling Integration Testing

  Scenario: Validate /users/:invalid_id behavior

    Given url URL + 'users/' + INVALID_ID
    When method GET
    Then status 404
    And match response == ERROR

  Scenario: Validate /students/:invalid_id behavior

    Given url URL + 'students/' + INVALID_ID
    When method GET
    Then status 404
    And match response == ERROR

  Scenario: Validate /teachers/:invalid_id behavior

    Given url URL + 'teachers/' + INVALID_ID
    When method GET
    Then status 404
    And match response == ERROR

  Scenario: Validate /users/:invalid_id behavior

    Given url URL + 'users/' + INVALID_ID + 'classes'
    When method GET
    Then status 404
    And match response == ERROR

  Scenario: Validate students/:{invalid id}/classes behavior

    Given url URL + 'students/' + INVALID_ID + '/classes'
    When method GET
    Then status 404
    And match response == ERROR

  Scenario: Validate teachers/:id/classes behavior when id is invalid

    Given url URL + 'teachers/' + INVALID_ID + '/classes'
    When method GET
    Then status 404
    And match response == ERROR
