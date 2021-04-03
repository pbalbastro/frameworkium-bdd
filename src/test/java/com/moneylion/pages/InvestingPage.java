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
import java.util.concurrent.TimeUnit;

public class InvestingPage extends BasePage<InvestingPage> {

    JavascriptExecutor jse = (JavascriptExecutor)driver;

    @Name("Portfolio Slider Dots")
    @FindBy(css = "span[class*='slider-step']")
    private List<WebElement> portfolioSliderDot;

    @Name("Portfolio Slider Option 1")
    @FindBy(css = "span[class='slider-step-dot']")
    private WebElement firstSliderOption;

    @Name("Portfolio Slider Option 2")
        @FindBy(css = "span[class='slider-step-dot slider-step-dot__2']")
    private WebElement secondSliderOption;

    @Name("Portfolio Slider Option 3")
    @FindBy(css = "span[class='slider-step-dot slider-step-dot__3']")
    private WebElement thirdSliderOption;

    @Name("Portfolio Slider Option 4")
    @FindBy(css = "span[class='slider-step-dot slider-step-dot__4']")
    private WebElement fourthSliderOption;

    @Name("Portfolio Slider Option 5")
    @FindBy(css = "span[class='slider-step-dot slider-step-dot__5']")
    private WebElement fifthSliderOption;

    @Name("Portfolio Slider Option 6")
    @FindBy(css = "span[class='slider-step-dot slider-step-dot__6']")
    private WebElement sixthSliderOption;

    @Name("Portfolio Slider Option 7")
    @FindBy(css = "span[class='slider-step-dot slider-step-dot__7']")
    private WebElement seventhSliderOption;

    @Name("Current Portfolio Name")
    @FindBy(css = "div.slider-bubble-human.is-active.lazyloaded div.slider-bubble-explainer-heading.lazyloaded div p")
    private WebElement currentPortfolioName;

    @Visible
    @Name("Slider")
    @FindBy(css = "div[id='slider']")
    private WebElement slider;

    @Step("Scroll to Portfolio Seciton")
    public void scrollToPortolioSection() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("window.scrollBy(0,2000)");
    }

    @Step("Get total portfolios in the slider")
    public long getSliderOptionsCount() {
        return portfolioSliderDot.stream().count();
    }

    @Step("Select Slider Option")
    public void selectSliderOption(String options) throws InterruptedException {
        Actions action = new Actions(driver);

        switch (options) {
            case "first":
//                Thread.sleep(500);
                action.dragAndDropBy(slider,-300 , 0).perform();
//                wait.until(ExpectedConditions.visibilityOf(slider));
//                action.dragAndDropBy(slider, 0, 0).perform();

//                wait.until(ExpectedConditions.elementToBeClickable(slider));
//                slider.click();
//                for (int i = 0; i < 4; i++) {
//                    action.sendKeys(Keys.ARROW_LEFT).build().perform();
//                }
            case "second":
//                secondSliderOption.click();
//                jse.executeScript("arguments[0].click();", secondSliderOption);
            case "third":

            case "fourth":

            case "fifth":

            case "sixth":

            case "seventh":

            default:

        }
//        if (options == "first") {
//            Thread.sleep(5000);
//                action.dragAndDropBy(slider,-300 , 0).perform();
//
//        } else if (options == "two") {
//            System.out.println("test");
//        }
    }
    @Step("Get Current Portfolio Name")
    public String getCurrentPortfolioName () {
        return currentPortfolioName.getText();
    }
}