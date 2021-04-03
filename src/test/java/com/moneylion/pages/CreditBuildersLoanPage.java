package com.moneylion.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class CreditBuildersLoanPage extends BasePage<CreditBuildersLoanPage> {

    JavascriptExecutor jse = (JavascriptExecutor)driver;
    Actions action = new Actions(driver);

    @Name("Credit Utilization Menu")
    @FindBy(css = "li[data-graph='utilization']")
    private WebElement creditUtilizationMenu;

    @Name("Credit Utilization Slider Thumb")
    @FindBy(css = "#slider-credit-utilization span")
    private WebElement creditUtilizationsliderThumb;

    @Name("Credit Grade")
    @FindBy(css = "#track-credit-grade-utilization")
    private WebElement creditGrade;

    @Step("Scroll to Track Cred Section")
    public void scrollToTrackCreditSection() throws InterruptedException {
        jse.executeScript("window.scrollBy(0,5100)");
        Thread.sleep(5000);
    }

    @Step("Click Credit Utilization Menu")
    public void clickCreditUtilizationMenu() {
        creditUtilizationMenu.click();
    }

    @Step("Move Slider")
    public void moveSlider(int percentage) {
        percentage -= 310;
        action.dragAndDropBy(creditUtilizationsliderThumb, percentage, 0).perform();
    }

    @Step("Get Credit Grade Text")
    public String getCreditGradeText() {
        return creditGrade.getText();
    }
}