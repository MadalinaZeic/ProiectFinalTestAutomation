Feature: Checkout tests

  Scenario: Add product to cart and checkout with existing user
    Given I open the homepage
    And I go to Account and select LogIn
    And I check that the login page is opened
    And I insert an email: "test321@test.com"
    And I insert an password: "123456"
    And I click the login button
    And I search for "shirt"
    And I choose product number "4" and store the name and price
    And I choose color "Indigo"
    And I choose size "L"
    And I add the product to the cart
    And I click the checkout button
    And I choose this shipping address
    And I choose flat rate shipping method
    And I choose cash on delivery payment method
    When I click page order button
    Then order confirmation is received

  Scenario: Add product to cart and don't fill the checkout form
    Given I open the homepage
    And I go to Account and select LogIn
    And I check that the login page is opened
    And I insert an email: "test4@test.com"
    And I insert an password: "123456"
    And I click the login button
    And I search for "shirt"
    And I choose product number "4" and store the name and price
    And I choose color "Indigo"
    And I choose size "L"
    And I add the product to the cart
    And I click the checkout button
    When I clear the checkout form
    And I choose this shipping address
    Then error messages are shown for the mandatory checkout fields
