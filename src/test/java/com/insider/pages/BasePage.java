package com.insider.pages;

import com.insider.utilities.BrowserUtilities;
import com.insider.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(xpath = "//*[@id='wt-cli-accept-all-btn']")
    public WebElement cookieAccept;

    @FindBy(xpath = "//*[@id='navigation']/div[2]/a[1]")
    public WebElement insiderHomePageLogo;

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }


    public void titleAssertion(String titleName){
        String title = Driver.get().getTitle();
        Assert.assertEquals(titleName,title);
    }

    public void elementTextAssertion(WebElement element,String elementName){
        BrowserUtilities.scrollToElement(element);
        String elementText = element.getText().trim();
        Assert.assertEquals(elementName,elementText); //
    }
}
