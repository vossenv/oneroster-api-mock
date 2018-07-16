Feature: Validate the contents of object-by-Id endpoints

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