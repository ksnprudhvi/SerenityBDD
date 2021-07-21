
Feature: Search Country

  Scenario: Search Country with proper ISO Code
    When I send a GET request with parameter "/alpha/co"
    And Status Code is 200

  Scenario: Search Country with improper ISO Code
    When I send a GET request with parameter "/alpha/co0"
    And Status Code is 404

  Scenario: Search Country with proper Currency Code
    When I send a GET request with parameter "/currency/cop"
    And Status Code is 200

  Scenario: Search Country with improper Currency Code
    When I send a GET request with parameter "/currency/co"
    And Status Code is 400

  Scenario: Search Country with proper Calling Code
    When I send a GET request with parameter "/callingcode/372"
    And Status Code is 200

  Scenario: Search Country with improper Calling Code
    When I send a GET request with parameter "/callingcode/333"
    And Status Code is 404
