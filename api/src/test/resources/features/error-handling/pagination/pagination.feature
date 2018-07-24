@ignore
Feature: Test for pagination related responses

  Background:
    * def size = 5


  Scenario: Test basic requests

    Given url URL + path + '?limit=' + size
    When method GET
    Then status 200
    * assert response.length <= size
    * def sid = response[1].sourcedId

    Given url URL + path + '?offset=1&limit=' + size
    When method GET
    Then status 200
    * assert response.length <= size
    * match response[0].sourcedId == sid


  Scenario: Test exception handling for invalid parameters

    Given url URL + path + '?limit=xxx&offset=yyy'
    When method GET
    Then status 400
    * match response.errorMessageList[0] contains 'Error parsing limit'
    * match response.errorMessageList[1] contains 'Error parsing offset'

    Given url URL + path + '?limit=-1&offset=-1'
    When method GET
    Then status 400
    * match response.errorMessageList[0] contains 'Valid range exceeded for limit'
    * match response.errorMessageList[1] contains 'Valid range exceeded for offset'

    Given url URL + path + '?limit=0&offset=21474836470'
    When method GET
    Then status 400
    * match response.errorMessageList[0] contains 'Valid range exceeded for limit'
    * match response.errorMessageList[1] contains 'Error parsing offset'

    Given url URL + path + '?limit=1001'
    When method GET
    Then status 400
    * match response.errorMessageList[0] contains 'Valid range exceeded for limit'