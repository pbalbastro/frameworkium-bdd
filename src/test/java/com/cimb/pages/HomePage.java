package com.cimb.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class HomePage extends BasePage<HomePage> {

    @Name("Overlay Content Skip Now Button")
    @FindBy(css = "button[class='btn py-4 px-4 text-darkRed hover:underline']")
    private WebElement skipNowButton;

    @Name("Deals Tile")
    @FindBy(css = "div.rowONE  div.hover-tile.h-full.bg-gradient-magentaRed")
    private WebElement dealsTile;

    @Name("Burger Menu")
    @FindBy(css = "div[class='btn-burger-menu cursor-pointer hover:drop-shadow-5']")
    private WebElement burgerMenu;

    @Name("CIMB Deals Menu Link")
    @FindBy(css = "a[href='/en/personal/cimb-deals.html']")
    private WebElement dealsLink;

    @Step("Open home page")
    public static HomePage open() {
        return new HomePage().get("https://www.cimb.com.my/en/personal/home.html");
    }

    @Step("Click Skip Now Button")
    public void clickOverlaySkipButton() {
        wait.until(ExpectedConditions.visibilityOf(skipNowButton));
        skipNowButton.click();
    }

    @Step("Navigate to Deals")
    public void navigateToDeals() {
        burgerMenu.click();
        dealsLink.click();
    }
}