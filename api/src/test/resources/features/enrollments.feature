Feature: Enrollment Controller Integration Testing

  Background:
    * def URL = apiURL

  Scenario: Validate the /enrollments endpoint

    Given url URL + 'enrollments'
    When method GET
    Then status 200
    And match each response ==
    """
    { enrollmentId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      userId: '#string',
      classId: '#string',
      primary: '#string',
      beginDate: '#string',
      endDate: '#string' }
    """

  Scenario: Validate the /enrollments/:id endpoint

    Given url URL + 'enrollments/5d6e0b72-1e15-4cd4-a415-a8e14c61437e'
    When method GET
    Then status 200
    And match response ==
    """
    { "enrollmentId": "5d6e0b72-1e15-4cd4-a415-a8e14c61437e",
      "sourcedId": "5d6e0b72-1e15-4cd4-a415-a8e14c61437e",
      "status": "active",
      "dateLastModified": "2017-10-25 17:24:44",
      "metadata": "",
      "userId": "f3f8660b-46c5-4419-8a0b-d5617b31a48b",
      "classId": "5fbd34b6-ea52-4a4a-b6ae-e43f60139695",
      "primary": "FALSE",
      "beginDate": "2018-09-01 00:00:00",
      "endDate": "2019-01-01 00:00:00" }
    """