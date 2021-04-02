Feature: MoneyLion Assessment

  @MoneyLion
  Scenario: Able to acess MoneyLion about page successfully
    Given I am a new customer
    And access to the MoneyLion website
    When I hover on “About Us” and click on “About Us” at the top of the webpage
    Then I should redirected to the MoneyLion’s about page
    And I should be able to see “Offices located in New York, San Francisco, Salt Lake City, and Kuala Lumpur” text displayed under “MONEYLION TEAM”