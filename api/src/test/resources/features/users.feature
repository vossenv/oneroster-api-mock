Feature: Basic Karate Testing

  Background:
    * def URL = apiURL

  Scenario: Validate the /users endpoint

    Given url URL + 'users'
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
      role: '#string',
      grades: '#string',
      type: '#string',
      password: '#string'}
    """

  Scenario: Validate the /students endpoint

    Given url URL + 'students'
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

  Scenario: Validate the /teachers endpoint

    Given url URL + 'teachers'
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

  Scenario: Validate the /users/:id endpoint

    Given url URL + '/users/08ff784a-a7ac-4904-83e5-05129bed2cef'
    When method GET
    Then status 200
    And match response ==
    """
    { "userId": "08ff784a-a7ac-4904-83e5-05129bed2cef",
      "sourcedId": "08ff784a-a7ac-4904-83e5-05129bed2cef",
      "status": "active",
      "dateLastModified": "2017-09-27 10:57:52",
      "metadata": "",
      "enabledUser": "TRUE",
      "userIds": "",
      "identifier": "XlVr-7LGr-Pg39",
      "schoolId": "f5897384-9488-466f-b049-1992f7a53f15",
      "givenName": "Claudine",
      "familyName": "Garr",
      "middleName": "Clarita",
      "email": "cgarr@woodland.perficientads.com",
      "username": "cgarr",
      "phone": "188-406-5840",
      "role": "student",
      "grades": "07",
      "type": "LDAP",
      "password": "secret" }
    """

  Scenario: Validate the /students/:id endpoint

    Given url URL + '/students/4c0ed6f8-656b-48c6-a8c8-2eb967146487'
    When method GET
    Then status 200
    And match response ==
    """
    { "userId": "4c0ed6f8-656b-48c6-a8c8-2eb967146487",
      "sourcedId": "4c0ed6f8-656b-48c6-a8c8-2eb967146487",
      "status": "active",
      "dateLastModified": "2017-12-11 03:10:55",
      "metadata": "",
      "enabledUser": "TRUE",
      "userIds": "",
      "identifier": "QyUd-28Rq-XrPu",
      "schoolId": "f9a75f84-130b-419e-bbe6-463585e930e9",
      "givenName": "Nicolas",
      "familyName": "Winspurr",
      "middleName": "Opalina",
      "email": "nwinspurr@spring.perficientads.com",
      "username": "nwinspurr",
      "phone": "814-250-6696",
      "role": "student",
      "grades": "07",
      "type": "LDAP",
      "password": "secret" }
    """

  Scenario: Validate the /teachers/:id endpoint

    Given url URL + '/teachers/f31a4762-0472-4504-8c3a-ec220ee128de'
    When method GET
    Then status 200
    And match response ==
    """
    { "userId": "f31a4762-0472-4504-8c3a-ec220ee128de",
      "sourcedId": "f31a4762-0472-4504-8c3a-ec220ee128de",
      "status": "active",
      "dateLastModified": "2018-04-07 12:49:10",
      "metadata": "",
      "enabledUser": "TRUE",
      "userIds": "",
      "identifier": "43Pf-119r-YcHl",
      "schoolId": "f5897384-9488-466f-b049-1992f7a53f15",
      "givenName": "Gerome",
      "familyName": "MacCart",
      "middleName": "Garrett",
      "email": "gmaccart@woodland.perficientads.com",
      "username": "gmaccart",
      "phone": "717-803-0773",
      "role": "teacher",
      "grades": "UG",
      "type": "LDAP",
      "password": "secret" }
    """

  Scenario: Validate the /users/:id/classes endpoint

    Given url URL + '/users/1226a624-e093-4203-b2a4-a3931ce7cce2/classes'
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

  Scenario: Validate the /students/:id/classes endpoint

    Given url URL + '/students/e041a2f2-3545-4427-b9c1-ec3e3c040cbf/classes'
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

  Scenario: Validate the /teachers/:id/classes endpoint

    Given url URL + '/teachers/a8aad0d4-a2a5-42d4-8eb1-60a176959796/classes'
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