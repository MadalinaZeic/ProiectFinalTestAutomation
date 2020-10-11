Feature: LogIn Tests

  Scenario: LogIn with existing credentials
    Given I open the homepage
    And I go to Account and select LogIn
    And I check that the login page is opened
    And I insert an existing email: "AnaPop203061086@cocox.com"
    And I insert an existing password: "anapass203"
    When  I click the login button
    Then the Account Page is opened
    And the chosen email is shown

