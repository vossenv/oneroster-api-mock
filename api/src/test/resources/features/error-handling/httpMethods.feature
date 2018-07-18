Feature: Validate the HTTP Method permissions on each endpoint

  Background:
    * def classId = '5fbd34b6-ea52-4a4a-b6ae-e43f60139695'
    * def courseId = 'f492e547-a9af-4094-8e06-0d9acf9945a0'
    * def enrollmentId = '6d58aac9-bb8a-40e0-8525-3f6474b1b0fa'
    * def schoolId = 'f9a75f84-130b-419e-bbe6-463585e930e9'
    * def studentId = 'd335c489-fcf9-42a6-8cdb-471d9e6bc84a'
    * def teacherId = 'f31a4762-0472-4504-8c3a-ec220ee128de'
    * def userId = '4d423cf3-facf-45e0-aea3-8ee9ff82c47f'
    * table endpoints
      |                               path                             |
      | 'classes'                                                      |
      | 'classes/' + classId                                           |
      | 'classes/' + classId + '/students'                             |
      | 'classes/' + classId + '/teachers'                             |
      | 'courses'                                                      |
      | 'courses/' + courseId                                          |
      | 'courses/' + courseId + '/classes'                             |
      | 'enrollments'                                                  |
      | 'enrollments/' + enrollmentId                                  |
      | 'schools'                                                      |
      | 'schools/' + schoolId                                          |
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
      | 'students/' + studentId                                        |
      | 'students/' + studentId + '/classes'                           |
      | 'teachers'                                                     |
      | 'teachers/' + teacherId                                        |
      | 'teachers/' + teacherId + '/classes'                           |
      | 'users'                                                        |
      | 'users/' + userId                                              |
      | 'users/' + userId + '/classes'                                 |

  Scenario: Validate that disallowed HTTP Methods are not accepted

    * def result = call read('read/disallowed.feature') endpoints
    * def response = $result[*].response
    * match each response contains { status: 'BAD_REQUEST', message: 'The request method is not supported' }

  Scenario: Validate that allowed HTTP Methods are accepted

    * def result = call read('read/allowed.feature') endpoints
    * def response = $result[*].response