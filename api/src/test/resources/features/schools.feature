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