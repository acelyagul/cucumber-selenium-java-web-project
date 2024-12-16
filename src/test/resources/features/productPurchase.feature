Feature: Hepsiburada Product Purchase

  Background:
    Given user on the homepage

  @smoke
  Scenario: User adds the most expensive Apple tablet to the cart and verifies the price
    Then verify that "home page" is visible successfully
    When the user navigates to "Elektronik" category and selects "Tablet" subcategory
    And the user applies the filters:
      | Brand       | Apple    |
      | Screen Size | 13,2 inç |
    And the user selects the most expensive product
    And the user adds the product to the cart
    Then the user verifies the product is added to the cart with the correct price
