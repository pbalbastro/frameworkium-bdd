package com.moneylion.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

public class InvestingPage extends BasePage<InvestingPage> {

    JavascriptExecutor jse = (JavascriptExecutor)driver;
    Actions action = new Actions(driver);

    @Name("Portfolio Slider Dots")
    @FindBy(css = "span[class*='slider-step']")
    private List<WebElement> portfolioSliderDot;

    @Name("Current Portfolio Name")
    @FindBy(css = "div.slider-bubble-human.is-active.lazyloaded div.slider-bubble-explainer-heading.lazyloaded div p")
    private WebElement currentPortfolioName;

    @Visible
    @Name("Slider")
    @FindBy(css = "#slider span")
    private WebElement slider;

    @Step("Scroll to Portfolio Seciton")
    public void scrollToPortolioSection() throws InterruptedException {
        jse.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(5000);
    }

    @Step("Get total portfolios in the slider")
    public long getSliderOptionsCount() {
        return portfolioSliderDot.stream().count();
    }

    @Step("Select Slider Option")
    public void selectSliderOption(String options) {
        switch (options) {
            case "first":
                action.dragAndDropBy(slider, -300, 0).perform();
                break;
            case "second":
                action.dragAndDropBy(slider, -200, 0).perform();
                break;
            case "third":
                action.dragAndDropBy(slider, -100, 0).perform();
                break;
            case "fourth":
                action.dragAndDropBy(slider, -50, 0).perform();
                break;
            case "fifth":
                action.dragAndDropBy(slider, 0, 0).perform();
                break;
            case "sixth":
                action.dragAndDropBy(slider, 50, 0).perform();
                break;
            case "seventh":
                action.dragAndDropBy(slider, 100, 0).perform();
                break;
        }
    }
    @Step("Get Current Portfolio Name")
    public String getCurrentPortfolioName () {
        return currentPortfolioName.getText();
    }
}