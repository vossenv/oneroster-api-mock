Feature: Validate endpoints that return User objects

  Background:
    * def classId_1 = '5fbd34b6-ea52-4a4a-b6ae-e43f60139695'
    * def classId_2 = 'd4b88037-6b6d-4ec9-acfb-27e0fb3881f6'
    * def classId_3 = 'de02e4fa-9f8e-4f05-86fb-1173a246594c'
    * def classId_4 = '14cb9670-d952-47ff-baa6-fd13d118425b'
    * def schoolId_1 = 'f9a75f84-130b-419e-bbe6-463585e930e9'
    * def schoolId_2 = 'f5897384-9488-466f-b049-1992f7a53f15'

  Scenario: /users responds with a collection of User objects

    Given url URL + 'users'
    When method GET
    Then status 200
    And match each response == USER

  Scenario: /students responds with a collection of Student objects

    Given url URL + 'students'
    When method GET
    Then status 200
    And match each response == STUDENT

  Scenario: /teachers responds with a collection of Teacher objects

    Given url URL + 'teachers'
    When method GET
    Then status 200
    And match each response == TEACHER

  Scenario: /classes/:id/students responds with a collection of Student objects

    Given url URL + 'classes/' + classId_1 + '/students'
    When method GET
    Then status 200
    And match each response == STUDENT

  Scenario: /schools/:id/classes/:id/students responds with a collection of Student objects

    Given url URL + 'schools/' + schoolId_1 + '/classes/' + classId_2 + '/students'
    When method GET
    Then status 200
    And match each response == STUDENT

  Scenario: /schools/:id/students responds with a collection of Student objects

    Given url URL + '/schools/' + schoolId_2 + '/students'
    When method GET
    Then status 200
    And match each response == STUDENT

  Scenario: /classes/:id/teachers responds with a collection of Teacher objects

    Given url URL + 'classes/' + classId_3 + '/teachers'
    When method GET
    Then status 200
    And match each response == TEACHER

  Scenario: /schools/:id/classes/:id/teachers responds with a collection of Teacher objects

    Given url URL + 'schools/' + schoolId_1 + '/classes/' + classId_4 + '/teachers'
    When method GET
    Then status 200
    And match each response == TEACHER

  Scenario: /schools/:id/teachers responds with a collection of Teacher objects

    Given url URL + 'schools/' + schoolId_2 + '/teachers'
    When method GET
    Then status 200
    And match each response == TEACHER