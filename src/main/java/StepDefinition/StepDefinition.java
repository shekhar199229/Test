package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BaseUtil.CommonMethod;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class StepDefinition extends CommonMethod {

	public LoginPage loginToPage;
	public HomePage homepage;

	public StepDefinition() {
		Setup();
		loginToPage = new LoginPage(driver);
		homepage = new HomePage(driver);
	}
 
    
    @Given("^Open Browser and navigate to Login page$")
    public void openApplication() throws Throwable {
    driver.get(prop.getProperty("url"));
    driver.manage().window().maximize();
    waitPageLoad();
    logger.info("Application opened in given Browser");
    }

     @When("^valid username and password is entered$")
    public void enterUserNmPwd() throws Throwable {
    clearAndSendKeysToElement(highlightElement(loginToPage.usernameField()), prop.getProperty("username"));
    clearAndSendKeysToElement(highlightElement(loginToPage.passwordField()), prop.getProperty("password") );
    logger.info("login successfully");
    }

     @And("login button clicked")
    public void submit_button_clicked() throws IOException, InterruptedException {
    	 
    	 Thread.sleep(5000);
    click(highlightElement(loginToPage.submitButton()));
    logger.info("Search button clicked");
    }

    @Then("^user should able login successfully$")
    public void selectFlightPage() throws InterruptedException, IOException {
    waitPageLoad();
    String pageTitle = driver.getTitle();
    Assert.assertEquals(pageTitle, "Delta Platform");
    logger.info("Page title matched");
    }
 
    
  //  @Timesheet
    
    @Then("^User click on Timesheet icon$")
    public void user_click_on_timesheet_icon() throws Throwable {
    	click(highlightElement(homepage.timesheetfield()));
        logger.info("Timesheet button clicked");
    }
    
    @Then("^verify current month and year$")
    public void verify_current_month_and_year() throws Throwable {
  
    	String str= homepage.currentmonthandyear().getText();
    	System.out.println(str);
        
    }

    @And("^Click on LogHours Button$")
    public void Click_on_LogHours_Button() throws Throwable {
    
        WebElement ele = homepage.LogHoursButton();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
        logger.info("LogHours button clicked");
    }
    
    @Then("^Select project$")
    public void select_project() throws Throwable {
    	click(highlightElement(homepage.selectproject()));
    	Thread.sleep(2000);
    	click(highlightElement(homepage.selectproject1()));
        logger.info("project field clicked");
        
       
    }

    @And("^enter hours$")
    public void enter_hours() throws Throwable {
    	clearAndSendKeysToElement(highlightElement(homepage.enterhours()),prop.getProperty("loghours"));
    }
    
    @Then("^Click on Save button$")
    public void click_on_save_button() throws Throwable {
   	
    	homepage.saveButton().click();
    }

    
    


}