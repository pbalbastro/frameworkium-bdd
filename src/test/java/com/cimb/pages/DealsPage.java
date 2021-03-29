package com.cimb.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class DealsPage extends BasePage<DealsPage> {

    @Name("CIMB Deals Logo")
    @FindBy(css = "img[class='alp-cimbd-logo']")
    private WebElement logo;

    @Name("Travel & Fun Menu")
    @FindBy(css = "div[class='alp-cimbd-nav'] a[href='/my/travel%20&%20fun']")
    private WebElement travelAndFunMenu;

    @Name("First Deal under Travel & Fun")
    @FindBy(css = "deal-item:nth-child(1)")
    private WebElement firstDealCard;

    @Name("Country Selection")
    @FindBy(css = "body > ngb-modal-window > div > div > div.alp-cimbd-modal2.modal-body > div > button:nth-child(1)")
    private WebElement malaysia;

    @Name("Modal Close Button")
    @FindBy(css = "button[class='modal-close-button']")
    private WebElement selectCountryCloseButton;

    @Step("Click Travel & Fun Menu")
    public void clickTravelAndFunMenu() {
        travelAndFunMenu.click();
    }

    @Step("Click first Deal Card")
    public void clickFirstDeal() {
        firstDealCard.click();
    }

    @Step("Is logo displayed")
    public boolean isLogoDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        logo.isDisplayed();
        return true;
    }

    @Step("Select Country Malaysia")
    public void selectCountryMalaysia(){
        malaysia.click();
//        countrySelect.stream()
//                .filter(e -> e.getAttribute("innerHTML").contains("Malaysia"))
//                .findFirst()
//                .orElseThrow(()-> new NoSuchElementException("No matching found"))
//                .click();
    }

    @Step("Click Modal Close Button")
    public void clickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(selectCountryCloseButton));
        selectCountryCloseButton.click();
    }
}