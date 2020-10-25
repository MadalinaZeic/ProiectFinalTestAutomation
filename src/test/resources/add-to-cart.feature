Feature: Add To Cart Tests

  Scenario: Add to cart the first product on the homepage
    Given I open the homepage
    And I store the first product's name
    And I store the first product's price
    When I choose the first product
    Then The product name is visible in the product page
    And The product price is visible in the product page
    When I add the product to the cart
    And I check that the web page is correct
    Then The product homepage name is visible in the checkout cart
    And The price from homepage is the same as the one on the list

  Scenario: Search for a product and add it to the cart
    Given I open the homepage
    And I search for "shirt"
    And relevant products are found
    And I choose product number "4" and store the name and price
    And I choose color "Indigo"
    And I choose size "L"
    When I add the product to the cart
    Then The product result page name is visible in the checkout cart
    And The price from the result page is the same as the one on the list

  Scenario: Add product to cart and remove it from cart
    Given I open the homepage
    And I search for "shirt"
    And relevant products are found
    And I choose product number "1" and store the name and price
    And I choose color "White"
    And I choose size "L"
    When I add the product to the cart
    And I remove the first product from cart
    Then the product is removed cart

  Scenario: Add products to cart and remove them from cart
    Given I open the homepage
    And I search for "shirt"
    And I choose product number "3" and store the name and price
    And I choose color "Charcoal"
    And I choose size "S"
    And I add the product to the cart
    And I click the site logo
    And I search for "book"
    And I choose product number "2" and store the name and price
    And I click the product page link
    And I add the product to the cart
    When I remove the second product from cart
    And I remove the first product from cart
    Then the product is removed cart
