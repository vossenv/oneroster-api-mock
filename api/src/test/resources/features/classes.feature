#Feature: Classes
#
#  Background:
#    * def URL = 'HTTP://WWW.REPLACEME.COM'
#
#  Scenario: Validate the classes/:id endpoint
#
#    Given url URL + '/classes/1'
#    When method GET
#    Then status 200
#    And match response['class'] contains
#    """
#    { classId : 1,
#      sourcedId : '5fbd34b6-ea52-4a4a-b6ae-e43f60139695',
#      status: 'active',
#      dateLastModified: '2018-03-14 12:55:52',
#      metadata: '#ignore',
#      term: 'Fall',
#      classCode: 'Algebra I - Fall',
#      classType: 'scheduled',
#      location: '305',
#      courseId: '7c2fc4b7-d53c-4b37-9ba4-1ba3cf2e0fe4',
#      schoolId: 'f9a75f84-130b-419e-bbe6-463585e930e9',
#      periods: '1'
#    }
#    """