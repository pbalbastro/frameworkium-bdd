package com.cimb.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.concurrent.TimeUnit;

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
    @FindBy(css = "button.col-12:nth-child(1)")
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

    @Step("Click Modal Close Button")
    public void clickCloseButton() {
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("LOTCCFrame_1617076401983");
        wait.until(ExpectedConditions.elementToBeClickable(selectCountryCloseButton));
        selectCountryCloseButton.click();
    }

    @Name("Loading Spinner")
    @FindBy(css = "div[id='loading-spinner-text']")
    private WebElement spinner;

    @Step("Click Modal Block")
    public void clickModalBlock() {
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        modalBlock.sendKeys(Keys.ESCAPE);
    }

    @Name("Modal block - MY")
    @FindBy(css = "ngb-modal-window[class='modal fade show d-block']")
    private WebElement modalMy;

    @Step("Click Overlay Close Button - MY")
    public void closeModalMy() {
        wait.until(ExpectedConditions.visibilityOf(modalMy));
        modalMy.sendKeys(Keys.ESCAPE);
//        overlayCloseButton.click();
    }
}