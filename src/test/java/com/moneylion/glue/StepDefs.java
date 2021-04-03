package com.moneylion.glue;

import com.moneylion.pages.AboutUsPage;
import com.moneylion.pages.CreditBuildersLoanPage;
import com.moneylion.pages.HomePage;
import com.moneylion.pages.InvestingPage;
import io.cucumber.java.en.*;

import static com.google.common.truth.Truth.assert_;

public class StepDefs {

    private static final String ABOUT_US_URL = "https://www.moneylion.com/about/";
    private static final String LOCATIONS_TEXT = "Offices located in New York City, San Francisco, Salt Lake City, and Kuala Lumpur.";
    private static final long PORTFOLIO_COUNT = 7;

    @Given("^I am a new customer$")
    public void i_am_a_new_customer() {
    }

    @And("access to the MoneyLion website")
    public void access_to_the_moneylion_website() {
        HomePage.open();
    }

    @When("I hover on “About Us” and click on “About Us” at the top of the webpage")
    public void i_hover_on_about_us_and_click_on_about_us_at_the_top_of_the_webpage() {
        new HomePage().get().clickAboutUsSubmenu();
    }

    @Then("I should redirected to the MoneyLion’s about page")
    public void i_should_redirected_to_the_moneylions_about_page() {

        assert_().withMessage("User is not redirected to About Us Page")
                .that(new AboutUsPage().get().getCurrentUrl())
                .isEqualTo(ABOUT_US_URL);

    }

    @And("I should be able to see “Offices located in New York, San Francisco, Salt Lake City, and Kuala Lumpur” text displayed under “MONEYLION TEAM”")
    public void i_should_be_able_to_see_offices_located_in_new_york_san_francisco_salt_lake_city_and_kuala_lumpur_text_displayed_under_moneylion_team() {

        assert_().withMessage("Office Locations are not displayed")
                .that(new AboutUsPage().get().getLocationsText())
                .isEqualTo(LOCATIONS_TEXT);
    }
    //StepDefs2
    @When("I hover on “Products” and click on “Automated Investing” at the top of the webpage")
    public void i_hover_on_products_and_click_on_automated_investing_at_the_top_of_the_webpage() {
        new HomePage().get().clickAutomatedInvestingSubmenu();
    }

    @And("I scroll to view the personalised portfolio")
    public void i_scroll_to_view_the_personalised_portfolio() throws InterruptedException {
        new InvestingPage().get().scrollToPortolioSection();
    }

    @Then("there should be total of 7 portfolio available on the slider")
    public void there_should_be_total_of_7_portfolio_available_on_the_slider() {

        assert_().withMessage("Incorrect Portfolio Count")
                .that(new InvestingPage().get().getSliderOptionsCount())
                .isEqualTo(PORTFOLIO_COUNT);
    }

    @When("^I select \"([^\"]*)\" portfolio on the slider$")
    public void i_select_something_portfolio_on_the_slider(String option) {
        new InvestingPage().get().selectSliderOption(option);
    }

    @Then("^I should able to see the \"([^\"]*)\" displayed$")
    public void i_should_able_to_see_the_displayed(String portfolioName) {
        assert_().withMessage("Correct Portfolio name is not displayed")
                .that(new InvestingPage().get().getCurrentPortfolioName())
                .isEqualTo(portfolioName);
    }
    //StepDefs3
    @When("I hover on “Products” and click on “Credit Builders Loans” at the top of the webpage")
    public void i_hover_on_products_and_click_on_credit_builders_loans_at_the_top_of_the_webpage() {
        new HomePage().get().clickCreditBuildersLoanSubmenu();
    }

    @And("I scroll to view the “Track Your Credit While You Build” section")
    public void i_scroll_to_view_the_track_your_credit_while_you_build_section() throws InterruptedException {
        new CreditBuildersLoanPage().get().scrollToTrackCreditSection();
    }

    @And("I select “Credit Utilization”")
    public void i_select_credit_utilization() {
        new CreditBuildersLoanPage().get().clickCreditUtilizationMenu();
    }

    @And("^I change the credit utilization percentage to (.*)%$")
    public void i_change_the_credit_utilization_percentage_to_20(int percentage) {
        new CreditBuildersLoanPage().get().moveSlider(percentage);
    }

    @Then("^I should be able to see the grade is now displayed as (.*)$")
    public void i_should_be_able_to_see_the_grade_is_now_displayed_as_b(String grade) {
        assert_().withMessage("Credit Grade displayed is incorrect")
                .that(new CreditBuildersLoanPage().get().getCreditGradeText())
                .isEqualTo(grade);
    }
}