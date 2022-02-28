package com.insider.pages;

import com.insider.utilities.BrowserUtilities;
import com.insider.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OpenPositionsPage extends BasePage {

    @FindBy(xpath = "//select[@id='filter-by-location']")
    public WebElement locationFilter;

    @FindBy(xpath = "//select[@id='filter-by-department']")
    public WebElement departmentFilter;

    @FindBy(xpath = "//*[@id='jobs-list']//p")
    public List<WebElement> allPositionsNames;

    @FindBy(xpath = "//*[@id='jobs-list']//span")
    public List<WebElement> allJobsDepartment;

    @FindBy(css = "[id='jobs-list'] div[class*='location']")
    public List<WebElement> allJobsLocation;

    @FindBy(xpath = "//*[.='Apply Now']")
    public List<WebElement> allApplyButtons;


    LeverApplicationJobPage leverApplicationJobPage = new LeverApplicationJobPage();


    public void applyForJobs() {

        String origin = Driver.get().getWindowHandle();
        for (int i = 0; i < 4; i++) {
            Driver.get().switchTo().window(origin);
            BrowserUtilities.hover(allApplyButtons.get(i));
            allApplyButtons.get(i).click();
            BrowserUtilities.switchToWindow(allPositionsNames.get(i).getText(), Driver.get());
            leverApplicationJobPage.isOpening();
            leverApplicationJobPage.applyForThisJobButton.click();
            Assert.assertTrue(Driver.get().getCurrentUrl().contains("lever"));
            Driver.get().close();
        }
    }

    public void verifyJobsContent(String element, List<String> keywords) {
        int contentCount = 0;
        for (String keyword : keywords) {
            if (element.contains(keyword)) {
                contentCount++;
            }
        }
        Assert.assertTrue(contentCount > 0);
    }

    public void verifyThePositionContent(List<String> keywords) {
        List<String> positions = BrowserUtilities.getElementsText(allPositionsNames);
        for (String position : positions) {
            verifyJobsContent(position, keywords);
        }
    }

    public void verifyLocationFilteredJobs(String location) {
        for (WebElement element : allJobsLocation) {
            BrowserUtilities.scrollToElement(element);
            element.getText().equals(location);
        }
    }

    public void verifyDepartmentFilteredJobs(String department) {
        for (WebElement element : allJobsDepartment) {
            BrowserUtilities.scrollToElement(element);
            element.getText().equals(department);
        }
    }

    public void verifyApplyButtonFilteredJobs(String apply_now) {
        for (WebElement element : allApplyButtons) {
            BrowserUtilities.hover(element);
            element.getText().equals(apply_now);
        }
    }

}
