package com.cimb.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class ToolsPage extends BasePage<ToolsPage> {

    @Visible
    @Name("Tools Page Header")
    @FindBy(css = "h1[class='mb-3 uppercase fsize-72-48']")
    private WebElement toolsPageHeader;

}
