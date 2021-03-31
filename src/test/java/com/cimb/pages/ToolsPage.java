package com.cimb.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.ArrayList;

public class ToolsPage extends BasePage<ToolsPage> {

    @Visible
    @Name("Tools Page Header")
    @FindBy(css = "h1[class='mb-3 uppercase fsize-72-48']")
    private WebElement toolsPageHeader;

    @Name("Property Loan Repayment Tools Menu")
    @FindBy(css = "article.tool-card.bg4")
    private WebElement propertyLoanRepaymentCalculatorMenu;

    @Step("Click Property Loan Repayment Menu")
    public void clickPropertyLoanRepaymentCalc() {
        propertyLoanRepaymentCalculatorMenu.click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
}
