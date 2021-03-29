package com.cimb.glue;

import com.cimb.pages.DealsPage;
import com.cimb.pages.HomePage;
import io.cucumber.java.en.*;

import java.time.Duration;

public class StepDefinition {
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
        DealsPage dealsPageWithTimeout = new DealsPage().get(Duration.ofSeconds(10));
        dealsPageWithTimeout.get().clickCloseButton();

//        new DealsPage().get().clickCloseButton();
//        new DealsPage().get().clickTravelAndFunMenu();
    }

    @Then("I will be able to see its details and other similar deals")
    public void i_will_be_able_to_see_its_details_and_other_similar_deals() {
//        new DealsPage().get().clickTravelAndFunMenu();
    }
}