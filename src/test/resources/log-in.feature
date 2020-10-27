Feature: LogIn Tests

  Scenario: LogIn with existing credentials
    Given I open the homepage
    And I go to Account and select LogIn
    And I check that the login page is opened
    And I insert an email: "test321@test.com"
    And I insert an password: "123456"
    When  I click the login button
    Then the Account Page is opened
    And the chosen email is shown

  Scenario Outline: Login with invalid credentials
    Given I open the homepage
    And I go to Account and select LogIn
    And I check that the login page is opened
    And I insert an email: "<email>"
    When  I click the login button
    Then an invalid email error message is shown
    When I insert an password: "<password>"
    And I click the login button
    Then an invalid password error message is shown
    Examples:
      | email                    | password |
      | invalid@test             | 123      |
      | invalid@a                | ☺☻«☺♠    |
      | invalid#@test            | 1        |
      | invalidtest123123123@abc | a        |

  Scenario: Login with empty credentials
    Given I open the homepage
    And I go to Account and select LogIn
    And I check that the login page is opened
    When  I click the login button
    Then error messages are shown for the mandatory login fields