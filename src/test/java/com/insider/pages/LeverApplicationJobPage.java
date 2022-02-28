package com.insider.pages;

import com.insider.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeverApplicationJobPage extends BasePage {

    @FindBy(xpath = "(//*[.='Apply for this job'])[2]")
    public WebElement applyForThisJobButton;

    public void isOpening() {
        BrowserUtilities.waitForClickablility(applyForThisJobButton, 5);
    }

}
