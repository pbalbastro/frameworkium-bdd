Feature: CIMB Assessment

#  @CIMBTest
  Scenario: Explore Deals under Travel & Fun
    Given I am on CIMB Page
    When I select CIMB Deals
    And I would like to explore more for PTT Outdoor under Travel and Fun
    Then I will be able to see its details and other similar deals

  @CIMBTest
  Scenario: Calculate Property Loan Repayment
    Given I am on CIMB Page
    And I navigate to Tools page from menu
    When I access to Property Loan Repayment Calculator from menu
    And I have inputted all necessary values
    Then I will be able to see the Effective Interest Rate, Total Interest Payable and Total Amount Payable
    And I will be able to see the loan repayment table with total loan tenure that I have entered
    And different interest rates for different year based on my input
