Feature: Homepage Tests

  Scenario: Check for the existence of products on homepage
    Given I open the homepage
    When I get the number of products
    Then check for nr of existing products

  Scenario: Search products with advance search
    Given I open the homepage
    And I open the Advance Search Page
    And I fill out the name field with "Glass"
    And I set the prices from "0", to "1000"
    And I select the color "Black"
    And I select "Male" as gender
    When I click the Search button