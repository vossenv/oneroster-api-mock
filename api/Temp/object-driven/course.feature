Feature: Validate endpoints that return Course objects

  Background:
    * def schoolId = 'f9a75f84-130b-419e-bbe6-463585e930e9'

  Scenario: /courses responds with a collection of Course objects

    Given url URL + 'courses'
    When method GET
    Then status 200
    And match each response == COURSE

  Scenario: /schools/:id/courses responds with a collection of Course objects

    Given url URL + 'schools/' + schoolId + '/courses'
    When method GET
    Then status 200
    And match each response == COURSE
