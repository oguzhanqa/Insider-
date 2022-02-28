package com.insider.pages;

import com.insider.utilities.BrowserUtilities;
import com.insider.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersPage extends BasePage {

    @FindBy(xpath = "//*[@id='career-our-location']//h3")
    public WebElement locations;

    @FindBy(xpath = "//*[.='Life at Insider']")
    public WebElement lifeAtInsider;

    @FindBy(xpath = "//*[.='See all teams']")
    public WebElement seeAllTeams;

    @FindBy(xpath = "//h3[.='Quality Assurance']")
    public WebElement QualityAssurance;

    @FindBy(xpath = "//section[@id='career-find-our-calling']//a/h3")
    public List<WebElement> allActualTeams;

    @FindBy(xpath = "(//section[@id='career-our-location']//div/a)[2]")
    public WebElement moveToRightIconOfLocation;



    public void verifyBlocks(List<String> blocks) {
        WebElement element = null;
        for (String block : blocks) {
            if(block.equalsIgnoreCase("See all teams")){
                element = seeAllTeams;
            }else if(block.equalsIgnoreCase("Life at Insider")){
                element = lifeAtInsider;
            }else if(block.equalsIgnoreCase("Our Locations")){
                element = locations;
            }
            elementTextAssertion(element,block);
        }
    }

    public void verifiesAllTeams(List<String> expectedTeamNames){
        BrowserUtilities.waitFor(2);
        for(int i = 0; i < expectedTeamNames.size(); i++){
            BrowserUtilities.scrollToElement(allActualTeams.get(i));
            Assert.assertTrue(BrowserUtilities.getElementsText(allActualTeams).get(i).contains(expectedTeamNames.get(i)));
        }
    }

    public void verifiesAllLocations(List<String> expectedLocationNames){
        BrowserUtilities.scrollToElement(locations);
        List<WebElement> allLocations = Driver.get().findElements(By.xpath("//div[@id='location-slider']//div/p"));
        for (int i = 0; i < expectedLocationNames.size(); i++) {
            if(!allLocations.get(i).isDisplayed()){
                moveUntilLocationElementIsDisplayed(allLocations.get(i));
            }
            Assert.assertEquals(expectedLocationNames.get(i),allLocations.get(i).getAttribute("innerHTML"));
        }
    }

    public void moveUntilLocationElementIsDisplayed(WebElement element){
        while (!element.isDisplayed()){
            BrowserUtilities.waitFor(1);
            BrowserUtilities.waitForClickablility(moveToRightIconOfLocation,5);
            moveToRightIconOfLocation.click();
            BrowserUtilities.waitForVisibility(element,5);
        }
    }
}
