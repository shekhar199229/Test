package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

import BaseUtil.BaseClass;
import BaseUtil.CommonMethod;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	private static CommonMethod commonMethod = new CommonMethod();

	 private static final ByXPath timesheet = new ByXPath(
			"//*[@id='navbar_main']/div[2]/a/img");
	private static final ByXPath monthandyear = new ByXPath(
	"//*[@id=\"calendar\"]/div[1]/div[3]/h2");
	
	private static final ByXPath LogHoursButton = new ByXPath(
			"//*[@id=\"navbar_main_wrapper\"]/div[4]/div[7]/div/div[5]/div/table/tbody/tr[2]/td/a");
	
	private static final ByXPath selectproject = new ByXPath(
			"//*[@id=\"project\"]");
	
	private static final ByXPath selectproject1 = new ByXPath("//*[@id='project']/option[2]");  
	
	private static final ByXPath enterhours = new ByXPath(
			"//*[@id=\"02022021\"]"); 
	
	private static final ByXPath saveButton = new ByXPath(
			"//*[@id=\"save\"]"); 
	

	 public WebElement timesheetfield() {
	return commonMethod.waitForElement(timesheet);
	}

	 public WebElement currentmonthandyear() {
	return commonMethod.waitForElement(monthandyear);
	}
	 
	 public WebElement LogHoursButton() {
			return commonMethod.waitForElement(LogHoursButton);
	}
	 public WebElement selectproject() {
			return commonMethod.waitForElement(selectproject);
	}
	 
	 public WebElement selectproject1() {
			return commonMethod.waitForElement(selectproject1);
	}
	 
	 public WebElement enterhours() {
			return commonMethod.waitForElement(enterhours);
			}
	 public WebElement saveButton() {
			return commonMethod.waitForElement(saveButton);
			}
}
