Feature: Schools Controller Integration Testing

  Background:
    * def URL = apiURL

  Scenario: Validate the /schools endpoint

    Given url URL + 'schools'
    When method GET
    Then status 200
    And match each response ==
    """
    { schoolId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      name: '#string',
      identifier: '#string',
      type: '#string' }
    """

  Scenario: Validate the /schools/:id endpoint

    Given url URL + 'schools/f5897384-9488-466f-b049-1992f7a53f15'
    When method GET
    Then status 200
    And match response ==
    """
    { "schoolId": "f5897384-9488-466f-b049-1992f7a53f15",
      "sourcedId": "f5897384-9488-466f-b049-1992f7a53f15",
      "status": "active",
      "dateLastModified": "2018-05-23 14:52:51",
      "metadata": "",
      "name": "Woodland Elementary School",
      "identifier": "12Fe-4B3v-9uHt",
      "type": "school" }
    """

  Scenario: Validate the /schools/:id/classes endpoint

    Given url URL + 'schools/f9a75f84-130b-419e-bbe6-463585e930e9/classes'
    When method GET
    Then status 200
    And match each response ==
    """
    { classId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      term: '#string',
      classCode: '#string',
      classType: '#string',
      location: '#string',
      courseId: '#string',
      schoolId: '#string',
      periods: '#string' }
    """

  Scenario: Validate the /schools/:id/courses endpoint

    Given url URL + 'schools/f9a75f84-130b-419e-bbe6-463585e930e9/courses'
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

  Scenario: Validate the /schools/:id/classes/:id/enrollments endpoint

    Given url URL + 'schools/f5897384-9488-466f-b049-1992f7a53f15/classes/df959645-daae-4f6a-ab0c-8d2ca3e08aaf/enrollments'
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

  Scenario: Validate the /schools/:id/classes/:id/students endpoint

    Given url URL + 'schools/f9a75f84-130b-419e-bbe6-463585e930e9/classes/d4b88037-6b6d-4ec9-acfb-27e0fb3881f6/students'
    When method GET
    Then status 200
    And match each response ==
    """
    { userId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      enabledUser: '#string',
      userIds: '#string',
      identifier: '#string',
      schoolId: '#string',
      givenName: '#string',
      familyName: '#string',
      middleName: '#string',
      email: '#string',
      username: '#string',
      phone: '#string',
    role: 'student',
      grades: '#string',
      type: '#string',
      password: '#string'}
    """

  Scenario: Validate the /schools/:id/classes/:id/teachers endpoint

    Given url URL + 'schools/f9a75f84-130b-419e-bbe6-463585e930e9/classes/14cb9670-d952-47ff-baa6-fd13d118425b/teachers'
    When method GET
    Then status 200
    And match each response ==
    """
    { userId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      enabledUser: '#string',
      userIds: '#string',
      identifier: '#string',
      schoolId: '#string',
      givenName: '#string',
      familyName: '#string',
      middleName: '#string',
      email: '#string',
      username: '#string',
      phone: '#string',
    role: 'teacher',
      grades: '#string',
      type: '#string',
      password: '#string'}
    """

  Scenario: Validate the /schools/:id/enrollments endpoint

    Given url URL + 'schools/f9a75f84-130b-419e-bbe6-463585e930e9/enrollments'
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

  Scenario: Validate the /schools/:id/students endpoint

    Given url URL + '/schools/f5897384-9488-466f-b049-1992f7a53f15/students'
    When method GET
    Then status 200
    And match each response ==
    """
    { userId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      enabledUser: '#string',
      userIds: '#string',
      identifier: '#string',
      schoolId: '#string',
      givenName: '#string',
      familyName: '#string',
      middleName: '#string',
      email: '#string',
      username: '#string',
      phone: '#string',
    role: 'student',
      grades: '#string',
      type: '#string',
      password: '#string'}
    """

  Scenario: Validate the /schools/:id/teachers endpoint

    Given url URL + 'schools/f9a75f84-130b-419e-bbe6-463585e930e9/teachers'
    When method GET
    Then status 200
    And match each response ==
    """
    { userId: '#string',
      sourcedId: '#string',
      status: '#string',
      dateLastModified: '#string',
      metadata: '#string',
      enabledUser: '#string',
      userIds: '#string',
      identifier: '#string',
      schoolId: '#string',
      givenName: '#string',
      familyName: '#string',
      middleName: '#string',
      email: '#string',
      username: '#string',
      phone: '#string',
    role: 'teacher',
      grades: '#string',
      type: '#string',
      password: '#string'}
    """
