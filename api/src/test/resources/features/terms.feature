Feature: Term Controller Integration Testing

  Background:
    * def URL = apiURL

  Scenario: Validate the /terms/:term/classes endpoint

    Given url URL + 'terms/Fall/classes'
    When method GET
    Then status 200
    And match each response ==
    """
    { classId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
    term: 'Fall',
      classCode: '#string',
      classType: '#string',
      location: '#string',
      courseId: '#string',
      schoolId: '#string',
      periods: '#string' }
    """