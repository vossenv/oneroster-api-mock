Feature: Courses Controller Integration Testing

  Background:
    * def URL = apiURL

  Scenario: Validate the /courses endpoint

    Given url URL + 'courses'
    When method GET
    Then status 200
    And match each response ==
    """
    { courseId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      grade: '#string',
      title: '#string',
      schoolYear: '#string',
      courseCode: '#string',
      subjects: '#string',
      schoolId: '#string' }
    """

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