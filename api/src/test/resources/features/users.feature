Feature: Basic Karate Testing

  Background:
    * def URL = 'http://www.google.com'

  Scenario: Check if Google exists

    Given url URL
    When method GET
    Then status 200
    Dummy Text