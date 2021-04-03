Feature: MoneyLion Assessment

#  @MoneyLion
  Scenario: Able to acess MoneyLion about page successfully
    Given I am a new customer
    And access to the MoneyLion website
    When I hover on “About Us” and click on “About Us” at the top of the webpage
    Then I should redirected to the MoneyLion’s about page
    And I should be able to see “Offices located in New York, San Francisco, Salt Lake City, and Kuala Lumpur” text displayed under “MONEYLION TEAM”

  @MoneyLion
  Scenario: Able to verify the portfolio types
    Given I am a new customer
    And access to the MoneyLion website
    When I hover on “Products” and click on “Automated Investing” at the top of the webpage
    And I scroll to view the personalised portfolio
    Then there should be total of 7 portfolio available on the slider
    When I select "first" portfolio on the slider
    Then I should able to see the "Steady Income Portfolio" displayed

#  Scenario 3: Able to verify grade for Credit Utilization
#    Given I am a new customer
#    And access to the MoneyLion website
#    When I hover on “Products” and click on “Credit Builders Loans” at the top of the webpage
#    And I scroll to view the “Track Your Credit While You Build” section
#    And I select “Credit Utilization”
#    And I change the credit utilization percentage to 20%
#    Then I should be able to see the grade is now displayed as B