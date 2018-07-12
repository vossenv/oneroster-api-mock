Feature: Classes Controller Integration Testing

  Scenario: Validate the /classes endpoint

    Given url URL + 'classes'
    When method GET
    Then status 200
    And match each response == CLASS

  Scenario: Validate the /classes/:id endpoint

    Given url URL + 'classes/231cc3cb-6e2b-4d3e-a636-37f965f4ae08'
    When method GET
    Then status 200
    And match response ==
    """
    { "classId": "231cc3cb-6e2b-4d3e-a636-37f965f4ae08",
      "sourcedId": "231cc3cb-6e2b-4d3e-a636-37f965f4ae08",
      "status": "active",
      "dateLastModified": "2017-08-14 00:36:18",
      "metadata": "",
      "term": "Spring",
      "classCode": "Geometry I - Spring",
      "classType": "scheduled",
      "location": "112",
      "courseId": "d0877e4f-f074-496b-90a3-a02d3016c970",
      "schoolId": "f9a75f84-130b-419e-bbe6-463585e930e9",
      "periods": "3" }
    """

  Scenario: Validate the /classes/:id/students endpoint

    Given url URL + 'classes/5fbd34b6-ea52-4a4a-b6ae-e43f60139695/students'
    When method GET
    Then status 200
    And match each response == STUDENT

  Scenario: Validate the /classes/:id/teachers endpoint

    Given url URL + 'classes/de02e4fa-9f8e-4f05-86fb-1173a246594c/teachers'
    When method GET
    Then status 200
    And match each response == TEACHER