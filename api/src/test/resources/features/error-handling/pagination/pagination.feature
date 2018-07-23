Feature: Test for pagination related responses

  Scenario: Test /users page stuff

    Given url URL + 'users?limit=2'
    When method GET
    Then status 200
    And match response == '#[2]'
    * def sid = response[1].sourcedId

    Given url URL + 'users?limit=5&offset=1'
    When method GET
    Then status 200
    And match response[0].sourcedId == sid

    Given url URL + 'users?limit=xxx&offset=yyy'
    When method GET
    Then status 400
    And match response.errorMessageList[0] contains 'Error parsing limit'
    And match response.errorMessageList[1] contains 'Error parsing offset'

    Given url URL + 'users?limit=-1&offset=-1'
    When method GET
    Then status 400
    And match response.errorMessageList[0] contains 'Valid range exceeded for limit'
    And match response.errorMessageList[1] contains 'Valid range exceeded for offset'

    Given url URL + 'users?limit=0&offset=21474836470'
    When method GET
    Then status 400
    And match response.errorMessageList[0] contains 'Valid range exceeded for limit'
    And match response.errorMessageList[1] contains 'Error parsing offset'

    Given url URL + 'users?limit=1001'
    When method GET
    Then status 400
    And match response.errorMessageList[0] contains 'Valid range exceeded for limit'