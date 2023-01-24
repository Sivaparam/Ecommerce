Feature: Automate ECommerce Purchase

  Scenario: Customer purchase item thru search
    Given user is on home page of eCommerce site
    When user searches for product in search bar
    And user selects the nth item from search results
    And user adds the item to cart
    And user clicks on checkout
    And user provides payment options
    Then purchase confirmation page is displayed
