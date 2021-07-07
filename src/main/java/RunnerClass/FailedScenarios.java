package RunnerClass;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.codehaus.plexus.util.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import BaseUtil.CommonMethod;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		
		features = "@target/rerun.txt", // Cucumber picks the failed scenarios from this file
		glue = { "StepDefinition" }, 
		plugin = { 
				"html:target/cucumber-reports/htmlReport",
				"json:target/cucumber-reports/JsonReport/CucumberTestReport.json", 
				"testng:target/cucumber-reports/xmlReport/CucumberTestReport.xml",
				"rerun:target/rerun.txt"
			 },
	    monochrome = true		
		)

public class FailedScenarios extends AbstractTestNGCucumberTests{

	
	public static CommonMethod commonMethod = new CommonMethod();;
	public static Properties prop;
	
	@BeforeSuite
	public static void loggerProperties() {
		String configFileName = "./src/main/resources/log4j.properties";
		PropertyConfigurator.configure(configFileName);
		prop = commonMethod.getPropValues();
	}
	
	@AfterSuite
	public static void fileDeleted() throws IOException {
		FileUtils.deleteDirectory("./src/main/resources/FeatureFiles/temp/");
	}
}
