package com.moneylion.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class HomePage extends BasePage<HomePage> {

    @Name("Products Menu")
    @FindBy(css = "#menu-header-menu > li:nth-child(1) > a")
    private WebElement productsMenu;

    @Name("Credit Builders Loan Submenu")
    @FindBy(css = "#menu-header-menu li:nth-child(1) li:nth-child(3) a")
    private WebElement creditBuildersLoanSubmenu;

    @Name("About Us Menu")
    @FindBy(css = "#menu-header-menu > li:nth-child(4) > a")
    private WebElement aboutUsMenu;

    @Name("About Us Submenu")
    @FindBy(css = "#menu-header-menu li:nth-child(4) li:nth-child(1) a")
    private WebElement aboutUsSubmenu;

    @Name("Automated Investing Submenu")
    @FindBy(css = "li:nth-child(1) li:nth-child(4) a")
    private WebElement automatedInvestingSubmenu;

    @Name("MoneyLion Logo")
    @FindBy(css = "img[class='header-logo-light lazyloaded']")
    private WebElement logo;

    @Step("Open home page")
    public static HomePage open() {
        return new HomePage().get("https://www.moneylion.com/");
    }

    @Step("Click About Us Submenu")
    public void clickAboutUsSubmenu() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        aboutUsMenu.click();
        aboutUsSubmenu.click();
    }

    @Step("Click Automated Investing Submenu")
    public void clickAutomatedInvestingSubmenu() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        productsMenu.click();
        automatedInvestingSubmenu.click();
    }

    @Step("Click Credit Builders Loan Submenu")
    public void clickCreditBuildersLoanSubmenu() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        productsMenu.click();
        creditBuildersLoanSubmenu.click();
    }
}