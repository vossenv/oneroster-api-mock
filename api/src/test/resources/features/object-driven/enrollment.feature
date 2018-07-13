Feature: Validate endpoints that return Enrollment objects

  Background:
    * def schoolId_1 = 'f9a75f84-130b-419e-bbe6-463585e930e9'
    * def schoolId_2 = 'f5897384-9488-466f-b049-1992f7a53f15'
    * def classId = 'df959645-daae-4f6a-ab0c-8d2ca3e08aaf'

  Scenario: /enrollments responds with a collection of Enrollment objects

    Given url URL + 'enrollments'
    When method GET
    Then status 200
    And match each response == ENROLLMENT

  Scenario: /schools/:id/enrollments responds with a collection of Enrollment objects

    Given url URL + 'schools/' + schoolId_1 + '/enrollments'
    When method GET
    Then status 200
    And match each response == ENROLLMENT

  Scenario: /schools/:id/classes/:id/enrollments responds with a collection of Enrollment objects

    Given url URL + 'schools/' + schoolId_2 + '/classes/' + classId + '/enrollments'
    When method GET
    Then status 200
    And match each response == ENROLLMENT

