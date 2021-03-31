package com.cimb.glue;

import com.cimb.pages.DealsPage;
import com.cimb.pages.HomePage;
import com.cimb.pages.PropertyLoanRepaymentCalcPage;
import com.cimb.pages.ToolsPage;
import io.cucumber.java.en.*;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assert_;

public class StepDefinition {

    private static final String LOAN_AMOUNT = "50000";
    private static final String LOAN_TENURE = "5";
    private static final String YEAR_ONE_INTEREST = "155";
    private static final String YEAR_TWO_INTEREST = "125";
    private static final String YEAR_THREE_INTEREST = "125";
    private static final String YEAR_FOUR_INTEREST = "125";
    private static final String YEAR_FIVE_INTEREST = "125";

    @Given("I am on CIMB Page")
    public void i_am_on_cimb_page() {
        HomePage.open();
    }

    @When("I select CIMB Deals")
    public void i_select_cimb_deals(){
        new HomePage().get().clickOverlaySkipButton();
        new HomePage().get().navigateToDeals();
    }

    @And("I would like to explore more for PTT Outdoor under Travel and Fun")
    public void i_would_like_to_explore_more_for_ptt_outdoor_under_travel_and_fun() {
        //new DealsPage().get().clickCloseButton(); //can't click. script timeout error
        new DealsPage().get().closeModalMy();
//        new DealsPage().get().selectCountryMalaysia();
//        new DealsPage().get().clickTravelAndFunMenu();
    }

    @Then("I will be able to see its details and other similar deals")
    public void i_will_be_able_to_see_its_details_and_other_similar_deals() {
//        new DealsPage().get().clickTravelAndFunMenu();
    }

    //StepDefs2
    @And("^I navigate to Tools page from menu$")
    public void i_navigate_to_tools_page_from_menu() {
//        new HomePage().get().closeOverlayContent();
        new HomePage().get().navigateToTools();
    }

    @When("^I access to Property Loan Repayment Calculator from menu$")
    public void i_access_to_property_loan_repayment_calculator_from_menu() {
        new ToolsPage().get().clickPropertyLoanRepaymentCalc();
    }

    @And("^I have inputted all necessary values$")
    public void i_have_inputted_all_necessary_values() {
        new PropertyLoanRepaymentCalcPage().get().inputValues(
                LOAN_AMOUNT, LOAN_TENURE,
                YEAR_ONE_INTEREST, YEAR_TWO_INTEREST,
                YEAR_THREE_INTEREST, YEAR_FOUR_INTEREST,
                YEAR_FIVE_INTEREST);
    }

    @Then("^I will be able to see the Effective Interest Rate, Total Interest Payable and Total Amount Payable$")
    public void i_will_be_able_to_see_the_effective_interest_rate_total_interest_payable_and_total_amount_payable() {

        assert_().withMessage("Effective Interest Rate is not displayed")
                .that(new PropertyLoanRepaymentCalcPage().get().isEffectiveInterestRateDisplayed())
                .isTrue();

        assert_().withMessage("Total Interest Payable is not displayed")
                .that(new PropertyLoanRepaymentCalcPage().get().isTotalInterestPayableDisplayed())
                .isTrue();

        assert_().withMessage("Total Amount Payable is not displayed")
                .that(new PropertyLoanRepaymentCalcPage().get().isTotalAmountPayable())
                .isTrue();

    }

    @And("^I will be able to see the loan repayment table with total loan tenure that I have entered$")
    public void i_will_be_able_to_see_the_loan_repayment_table_with_total_loan_tenure_that_i_have_entered() {
        List<String> lastRowYearsColumn = new PropertyLoanRepaymentCalcPage().get()
                .getLastRowYearsColumn();

        assert_().withMessage("Total Loan Tenure is not equal to input")
                .that(lastRowYearsColumn)
                .containsExactly(LOAN_TENURE);
    }

    @And("^different interest rates for different year based on my input$")
    public void different_interest_rates_for_different_year_based_on_my_input() {

        List<String> interestRatesColumn = new PropertyLoanRepaymentCalcPage().get()
                .getInterestRatesColumn();

        List<String> input = Arrays.asList(YEAR_ONE_INTEREST, YEAR_TWO_INTEREST,
                YEAR_THREE_INTEREST, YEAR_FOUR_INTEREST, YEAR_FIVE_INTEREST);

        new PropertyLoanRepaymentCalcPage().get().inputFormatter(input);

        assert_().withMessage("Interest Rates are not displayed correctly")
                .that(interestRatesColumn)
                .isEqualTo(input);
    }
}