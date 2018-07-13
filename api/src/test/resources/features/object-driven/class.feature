Feature: Validate endpoints that return Class objects

  Background:
    * def courseId = '7c2fc4b7-d53c-4b37-9ba4-1ba3cf2e0fe4'
    * def schoolId = 'f9a75f84-130b-419e-bbe6-463585e930e9'
    * def term = "Fall"
    * def userId = '1226a624-e093-4203-b2a4-a3931ce7cce2'
    * def studentId = 'e041a2f2-3545-4427-b9c1-ec3e3c040cbf'
    * def teacherId = 'a8aad0d4-a2a5-42d4-8eb1-60a176959796'

  Scenario: /classes responds with a collection of Class objects

    Given url URL + 'classes'
    When method GET
    Then status 200
    And match each response == CLASS

  Scenario: /courses/:id/classes responds with a collection of Class objects

    Given url URL + 'courses/' + courseId + '/classes'
    When method GET
    Then status 200
    And match each response == CLASS

  Scenario: /schools/:id/classes responds with a collection of Class objects

    Given url URL + 'schools/' + schoolId + '/classes'
    When method GET
    Then status 200
    And match each response == CLASS

  Scenario: /terms/:term/classes responds with a collection of Class objects

    Given url URL + 'terms/' + term + '/classes'
    When method GET
    Then status 200
    And match each response == CLASS

  Scenario: /users/:id/classes responds with a collection of Class objects

    Given url URL + '/users/' + userId + '/classes'
    When method GET
    Then status 200
    And match each response == CLASS

  Scenario: /students/:id/classes responds with a collection of Class objects

    Given url URL + '/students/' + studentId + '/classes'
    When method GET
    Then status 200
    And match each response == CLASS

  Scenario: /teachers/:id/classes responds with a collection of Class objects

    Given url URL + '/teachers/' + teacherId + '/classes'
    When method GET
    Then status 200
    And match each response == CLASS