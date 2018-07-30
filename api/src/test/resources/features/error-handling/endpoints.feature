Feature: Validate the HTTP Method permissions on each endpoint

  Background:

    * def classId = '5fbd34b6-ea52-4a4a-b6ae-e43f60139695'
    * def courseId = 'f492e547-a9af-4094-8e06-0d9acf9945a0'
    * def enrollmentId = '6d58aac9-bb8a-40e0-8525-3f6474b1b0fa'
    * def schoolId = 'f9a75f84-130b-419e-bbe6-463585e930e9'
    * def studentId = 'd335c489-fcf9-42a6-8cdb-471d9e6bc84a'
    * def teacherId = 'f31a4762-0472-4504-8c3a-ec220ee128de'
    * def userId = '4d423cf3-facf-45e0-aea3-8ee9ff82c47f'

    * table single_endpoints
      |                               path                             |
      | 'classes/' + classId                                           |
      | 'courses/' + courseId                                          |
      | 'enrollments/' + enrollmentId                                  |
      | 'schools/' + schoolId                                          |
      | 'students/' + studentId                                        |
      | 'teachers/' + teacherId                                        |
      | 'users/' + userId                                              |

    * table list_endpoints
      |                               path                             |
      | 'classes'                                                      |
      | 'classes/' + classId + '/students'                             |
      | 'classes/' + classId + '/teachers'                             |
      | 'courses'                                                      |
      | 'courses/' + courseId + '/classes'                             |
      | 'enrollments'                                                  |
      | 'schools'                                                      |
      | 'schools/' + schoolId + '/classes'                             |
      | 'schools/' + schoolId + '/courses'                             |
      | 'schools/' + schoolId + '/enrollments'                         |
      | 'schools/' + schoolId + '/students'                            |
      | 'schools/' + schoolId + '/teachers'                            |
      | 'schools/' + schoolId + '/classes/' + classId + '/enrollments' |
      | 'schools/' + schoolId + '/classes/' + classId + '/students'    |
      | 'schools/' + schoolId + '/classes/' + classId + '/teachers'    |
      | 'terms/' + 'fall' + '/classes'                                 |
      | 'students'                                                     |
      | 'students/' + studentId + '/classes'                           |
      | 'teachers'                                                     |
      | 'teachers/' + teacherId + '/classes'                           |
      | 'users'                                                        |
      | 'users/' + userId + '/classes'                                 |

  Scenario: Validate that disallowed HTTP Methods are not accepted

    * def result = call read('read/http_disallowed.feature') single_endpoints
    * def response = $result[*].response
    * match each response contains { status: 'BAD_REQUEST', message: 'The request method is not supported' }

    * def result = call read('read/http_disallowed.feature') list_endpoints
    * def response = $result[*].response
    * match each response contains { status: 'BAD_REQUEST', message: 'The request method is not supported' }

  Scenario: Validate that allowed HTTP Methods are accepted

    * def result = call read('read/http_allowed.feature') single_endpoints
    * def result = call read('read/http_allowed.feature') list_endpoints

  Scenario: Validate paging requests

    * def result = call read('read/pagination.feature') list_endpoints
