package com.insider.stepdefinitions;

import com.insider.pages.*;
import com.insider.utilities.BrowserUtilities;
import com.insider.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class taskStepDefinition {

    DashboardPage dashboardPage = new DashboardPage();
    CareersPage careersPage = new CareersPage();
    BasePage basePage = new BasePage();
    QualityAssurancePage qa = new QualityAssurancePage();
    OpenPositionsPage positionsPage = new OpenPositionsPage();

    LeverApplicationJobPage leverApplicationJobPage = new LeverApplicationJobPage();


    @Given("User comes to the Insider home page")
    public void user_comes_to_the_Insider_home_page() {
        basePage.insiderHomePageLogo.isDisplayed();
        basePage.cookieAccept.click();
    }

    @Then("Selects the {string} on navigation bar")
    public void selects_the_on_navigation_bar(String string) {
        WebElement more = Driver.get().findElement(By.xpath("//span[.='" + string + "']"));
        more.click();
    }

    @Then("Navigates to {string}")
    public void navigates_to(String string) {
        WebElement careers = Driver.get().findElement(By.xpath("//h5[.='" + string + "']"));
        careers.click();
        basePage.titleAssertion("Careers - Insider");
        BrowserUtilities.waitForPresenceOfElement(By.xpath("//*[@id='career-our-location']//h3"), 5);
    }

    @Then("User checks the career page blocks")
    public void user_checks_the_career_page_blocks(List<String> blocks) {
        careersPage.verifyBlocks(blocks);
    }

    @Then("User opens teams blocks")
    public void user_opens_teams_blocks() {
        BrowserUtilities.clickWithJS(careersPage.seeAllTeams);
    }

    @Then("Verifies the all teams")
    public void verifies_the_all_teams(List<String> teams) {
        careersPage.verifiesAllTeams(teams);
    }

    @Then("Verifies all locations")
    public void verifies_all_locations(List<String> locations) {
        careersPage.verifiesAllLocations(locations);
    }

    @Given("user goes to Careers Page")
    public void user_goes_to_Careers_Page() {
        basePage.cookieAccept.click();
        dashboardPage.moreMenu.click();
        dashboardPage.careersMenu.click();
        BrowserUtilities.waitForPresenceOfElement(By.xpath("//*[@id='career-our-location']//h3"), 5);
    }

    @Then("User opens {string} as one of the career page block")
    public void user_opens_as_one_of_the_career_page_block(String string) {
        WebElement seeAllTeamsButton = Driver.get().findElement(By.xpath("//*[.='" + string + "']"));
        seeAllTeamsButton.click();
        BrowserUtilities.waitForClickablility(careersPage.QualityAssurance, 5);
    }

    @Then("Selects the {string} one of the team")
    public void selects_the_one_of_the_team(String string) {
        WebElement qualityAssuranceButton = Driver.get().findElement(By.xpath("//h3[.='" + string + "']"));
        qualityAssuranceButton.click();

    }

    @Then("User goes to see qa all position")
    public void user_goes_to_see_qa_all_position() {
        qa.seeAllQAJobs.click();
        basePage.titleAssertion("Open Positions - Insider");
    }

    @Then("User selects {string}, {string} in order to see presence of job list")
    public void user_selects_in_order_to_see_presence_of_job_list(String location, String department) {
        BrowserUtilities.selectDropdownElementByText(positionsPage.locationFilter, location);
        BrowserUtilities.verifySelectedDropdownElement(positionsPage.departmentFilter, department);
    }

    @Then("User verify {string}, {string} and apply button of the jobs")
    public void user_verify_and_apply_button_of_the_jobs(String location, String department) {
        positionsPage.verifyLocationFilteredJobs(location);
        positionsPage.verifyDepartmentFilteredJobs(department);
        positionsPage.verifyApplyButtonFilteredJobs("Apply Now");
    }

    @Then("User verify the following position keywords of the jobs")
    public void user_verify_the_following_position_keywords_of_the_jobs(List<String> positionTitle) {
        positionsPage.verifyThePositionContent(positionTitle);

    }

    @Then("User applies and verifies the Lever Application Form Page for each job")
    public void user_applies_and_verifies_the_Lever_Application_Form_Page_for_each_job() {
        positionsPage.applyForJobs();
    }
}
