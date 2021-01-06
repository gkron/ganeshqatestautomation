package runners;

import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests",
		glue= {"stepDefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extent-report.html"},
		tags = {"@sanity"},
		monochrome = true
		
		)
public class TestRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.7.0");
	     Reporter.setSystemInfo("Maven", "3.6.3");
	     Reporter.setSystemInfo("Java Version", "1.8.0_211");
	}

}