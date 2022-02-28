package com.insider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualityAssurancePage extends BasePage {

    @FindBy(xpath = "//*[@id='page-head']//a")
    public WebElement seeAllQAJobs;

}
