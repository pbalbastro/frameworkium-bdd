package com.moneylion.pages;

import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class AboutUsPage extends BasePage<AboutUsPage> {

    @Step("Get current url")
    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    @Name("About Us Location Section")
    @FindBy(css = "section.about-us-locations p")
    private WebElement locationsText;

    @Step("Get locations text")
    public String getLocationsText() {
        String text = locationsText.getText();
        return text;
    }
}