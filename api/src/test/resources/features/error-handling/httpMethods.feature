Feature: Validate the HTTP Method permissions on each endpoint

  Background:
    * table endpoints
      | path       |
      | 'users'    |
      | 'students' |

  Scenario: Validate that disallowed HTTP Methods are not accepted

    * def result = call read('read/disallowed.feature') endpoints
    * def response = $result[*].response
    * match each response contains { status: 'BAD_REQUEST', message: 'The request method is not supported' }

  Scenario: Validate that allowed HTTP Methods are accepted

    * def result = call read('read/allowed.feature') endpoints
    * def response = $result[*].response