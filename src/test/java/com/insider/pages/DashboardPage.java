package com.insider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "(//*[@id='mega-menu-1'])[6]")
    public WebElement moreMenu;

    @FindBy(xpath = "//*[@id='navbarNavDropdown']/ul[1]/li[6]//div[1]/div[3]//a")
    public WebElement careersMenu;

}
