package PageObjects;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseUtil.BaseClass;
import BaseUtil.CommonMethod;

public class LoginPage extends BaseClass {

	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private static CommonMethod commonMethod = new CommonMethod();

	 private static final ByXPath username = new ByXPath(
	"//input[@name='email']");
	private static final ByXPath password = new ByXPath(
	"//input[@name='password']");
	private static final ByXPath submit = new ByXPath(
	"//input[@type='submit']");

	 public WebElement usernameField() {
	return commonMethod.waitForElement(username);
	}

	 public WebElement passwordField() {
	return commonMethod.waitForElement(password);
	}

	 public WebElement submitButton() {
	return commonMethod.waitForElement(submit);
	}

	}