Feature: Courses Controller Integration Testing

  Scenario: Validate the /courses endpoint

    Given url URL + 'courses'
    When method GET
    Then status 200
    And match each response == COURSE

  Scenario: Validate the /courses/:id endpoint

    Given url URL + 'courses/65b3b671-7a13-4d0c-9a24-96f429bb6f2e'
    When method GET
    Then status 200
    And match response ==
    """
    { "courseId": "65b3b671-7a13-4d0c-9a24-96f429bb6f2e",
      "sourcedId": "65b3b671-7a13-4d0c-9a24-96f429bb6f2e",
      "status": "active",
      "dateLastModified": "2018-03-30 00:11:26",
      "metadata": "",
      "grade": "8",
      "title": "Algebra III",
      "schoolYear": "2018",
      "courseCode": "Alg-103",
      "subjects": "Algebra III",
      "schoolId": "f9a75f84-130b-419e-bbe6-463585e930e9" }
    """

  Scenario: Validate the /courses/:id/classes endpoint

    Given url URL + 'courses/7c2fc4b7-d53c-4b37-9ba4-1ba3cf2e0fe4/classes'
    When method GET
    Then status 200
    And match each response == CLASS