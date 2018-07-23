Feature: Test for pagination related responses

  Scenario: Test /users page stuff

    Given url URL + 'users?limit=5'
    When method GET
    Then status 200
    And match response == '#[5]'
    * def sid = response[1].sourcedId

    Given url URL + 'users?limit=5&offset=1'
    When method GET
    Then status 200
    And match response == '#[5]'
    And match response[0].sourcedId == sid


#
#    Given url URL + 'users?limit=xxx'
#    When method GET
#    Then status 400