Feature: User registration

  Scenario: Register a new account
    Given I open the homepage
    And I go to Account and select Register
    And I insert a first name
    And I insert a last name
    And I insert an email
    And I insert a password
    And I insert a password confirmation
    And I click the news letter button
    When I click the register button
    Then a confirmation message is displayed
    And the first and last names are displayed
    And news letter subscription is confirmed

  Scenario: Registration with empty fields
    Given I open the homepage
    And I go to Account and select Register
    When I click the register button
    Then mandatory field registration errors are shown

  Scenario Outline: Registration with invalid data
    Given I open the homepage
    And I go to Account and select Register
    And I insert an invalid first name:"<firstName>"
    And I insert an invalid last name: "<lastName>"
    And I insert an invalid email: "<email>"
    And I insert an invalid password: "<password>"
    And I insert an invalid password confirmation: "<passwordConf>"
    When I click the register button
    Then email format error message is displayed
    And password format error message is displayed
    And confirmation error message is displayed

    Examples:
      | firstName | lastName | email      | password | passwordConf |
      |           |          | test@email | test     | test123      |


