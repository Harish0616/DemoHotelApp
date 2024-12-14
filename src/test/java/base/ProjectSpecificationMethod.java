package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;
import util.Utility;


public class ProjectSpecificationMethod extends Utility {

	@BeforeSuite
	public void reportInitilization() {
		String path ="D:\\Apps and software\\JavaProjects\\DemoHotelAppMiniProject\\reports\\DemoHotelAppReport";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("DemoHotelApp Report");
		
		//to capture test data
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void launchLoadUrl(String url, String browser) {
		browserLancher(browser, url);
	}
	
	@DataProvider(name="excelRead")
	public String[][] excelRead() throws IOException  {
		
	       return readExcel(sheetName);
	}
	
	@AfterMethod
	public void closeLauncher() {
		closeLancher();
	}

}
