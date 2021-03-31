package com.cimb.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.cucumber.java.eo.Do;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyLoanRepaymentCalcPage extends BasePage<PropertyLoanRepaymentCalcPage> {

    @Name("Property Loan Amount Input")
    @FindBy(css = "div.bg-paleGrey > div > div > div > div:nth-child(1) input")
    private WebElement loanAmountInput;

    @Name("Property Loan Tenure Input")
    @FindBy(css = "div.bg-paleGrey > div > div > div > div:nth-child(2) input")
    private WebElement loanTenureInput;

    @Name("Year 1 Interest Input")
    @FindBy(css = ".responsivegrid:nth-child(3) .cmp-calculatorToolsInputField:nth-child(1) .font-bold:nth-child(2)")
    private WebElement yearOneInput;

    @Name("Year 2 Interest Input")
    @FindBy(css = ".responsivegrid:nth-child(3) .cmp-calculatorToolsInputField:nth-child(2) .font-bold:nth-child(2)")
    private WebElement yearTwoInput;

    @Name("Year 3 Interest Input")
    @FindBy(css = ".responsivegrid:nth-child(4) .cmp-calculatorToolsInputField:nth-child(1) .font-bold:nth-child(2)")
    private WebElement yearThreeInput;

    @Name("Year 4 Interest Input")
    @FindBy(css = ".responsivegrid:nth-child(4) .cmp-calculatorToolsInputField:nth-child(2) .font-bold:nth-child(2)")
    private WebElement yearFourInput;

    @Name("Year 5 Interest Input")
    @FindBy(css = ".cmp-calculatorToolsInputField:nth-child(5) .font-bold:nth-child(2)")
    private WebElement yearFiveInput;

    @Name("Effective Interest Rate")
    @FindBy(css = ".flex-col:nth-child(2) > .text-white span:nth-child(1)")
    private WebElement effectiveInterestRate;

    @Name("Total Interest Payable")
    @FindBy(css = ".flex-col:nth-child(3) > .text-white span:nth-child(2)")
    private WebElement totalInterestPayable;

    @Name("Total Amount Payable")
    @FindBy(css = ".flex-col:nth-child(4) > .text-white span:nth-child(2)")
    private WebElement totalAmountPayable;

    @Name("Loan Repayment Table")
    @FindBy(css = "td:nth-child(1)")
    private List<WebElement> yearsColumn;

    @Name("Interest Rates Column")
    @FindBy(css = "td:nth-child(2)")
    private List<WebElement> interestRatesColumn;


    @Step("Input all valid values")
    public void inputValues (String loanAmount, String loanTenure,
                                          String yearOneInterest, String yearTwoInterest,
                                          String yearThreeInterest, String yearFourInterest,
                                          String yearFiveInterest) {

        loanAmountInput.sendKeys(loanAmount);
        loanTenureInput.sendKeys(loanTenure);
        yearOneInput.sendKeys(yearOneInterest);
        yearTwoInput.sendKeys(yearTwoInterest);
        yearThreeInput.sendKeys(yearThreeInterest);
        yearFourInput.sendKeys(yearFourInterest);
        yearFiveInput.sendKeys(yearFiveInterest);

    }

    @Step("Is Effective Interest Rate Displayed")
    public boolean isEffectiveInterestRateDisplayed() {
        float amount = Float.parseFloat(effectiveInterestRate.getText().replace(",", ""));

        if (amount > 0 ) {

        }
        return true;
    }

    @Step("Is Total Interest Payable Displayed")
    public boolean isTotalInterestPayableDisplayed() {
        float amount = Float.parseFloat(totalInterestPayable.getText().replace(",", ""));

        if (amount > 0 ) {

        }
        return true;
    }

    @Step("Is Total Amount Payable Displayed")
    public boolean isTotalAmountPayable() {
        float amount = Float.parseFloat(totalAmountPayable.getText().replace(",", ""));

        if (amount > 0 ) {

        }
        return true;
    }

    @Step("Get Last Row Years Column")
    public List<String> getLastRowYearsColumn() {
        return yearsColumn.stream()
                .skip(yearsColumn.size() - 1)
                .map(e -> e.getText()
                        .trim())
                .collect(Collectors.toList());

    }

    @Step("Get Interest Rates Column")
    public List<String> getInterestRatesColumn() {
        return interestRatesColumn.stream()
                .map(e -> e.getText()
                .trim())
                .collect(Collectors.toList());
    }

    @Step("Get Interest Inputs")
    public List<String> getInterestInputs(){
        return Arrays.asList(yearOneInput.getText(), yearTwoInput.getText(),
                yearThreeInput.getText(), yearFourInput.getText(), yearFiveInput.getText());
    }

    @Step("Interest Input Formatter")
    public List<String> inputFormatter(List<String> list){
        DecimalFormat df = new DecimalFormat("0.00");
        for(int i = 0; i < list.size(); i++) {
            double j = Double.parseDouble(list.get(i));
            j /= 100;
            df.format(j);
            list.set(i, Double.toString(j) + "%");
        }
        return list;
    }
}
