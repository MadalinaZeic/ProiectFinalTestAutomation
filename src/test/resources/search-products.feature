Feature: Search for products

  Scenario: Empty search
    Given I open the homepage
    When I click search when the field is empty
    Then search field validation fails

  Scenario: Search with no results
    Given I open the homepage
    When I search for "test123"
    Then no results message is shown

  Scenario: Search for a product
    Given I open the homepage
    When I search for "glass"
    Then relevant products are found
