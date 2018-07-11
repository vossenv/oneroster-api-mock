Feature: Classes Controller Integration Testing

  Background:
    * def URL = apiURL

  Scenario: Validate the /classes endpoint

    Given url URL + 'classes'
    When method GET
    Then status 200
    And match each response ==
    """
    { classId : '#string',
      sourcedId : '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      term: '#string',
      classCode: '#string',
      classType: '#string',
      location: '#string',
      courseId: '#string',
      schoolId: '#string',
      periods: '#string'
    }
    """