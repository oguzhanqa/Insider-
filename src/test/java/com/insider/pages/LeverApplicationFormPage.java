package com.insider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeverApplicationFormPage extends BasePage {

    @FindBy(xpath = "//form")
    public WebElement applyForm;
}
