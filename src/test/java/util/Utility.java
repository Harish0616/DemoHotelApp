package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class Utility {
	public static WebDriver driver;
	public static Properties prop;
	public String sheetName;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testCategory,testAuthor;
	
	public void browserLancher(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("edge" )) {
			driver =new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(115));
	}
	public void closeLancher() {
		driver.close();
	}
	
	public void visibilityofElement(WebElement userid) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(userid));
	}
	
	public void sendKeysMethod(WebElement ele, String input) {
		ele.sendKeys(input);
	}
	
	
	
	public static void readFromPropFile(String filename ) throws IOException {
		FileReader file = new FileReader("D:\\Apps and software\\JavaProjects\\DemoHotelAppMiniProject\\src\\test\\resources\\Data\\" + filename + ".properties");
		prop = new Properties();
		prop.load(file);
	}
	
	
		public static String[][] readExcel(String sheetName) throws IOException {
			  // OPEN THE WORKBOOK
		    XSSFWorkbook book = new XSSFWorkbook("D:\\Apps and software\\JavaProjects\\DemoHotelAppMiniProject\\src\\test\\resources\\Data\\DemoHotelTestDatas.xlsx");
		    
		    // Get into the sheets
		    XSSFSheet sheet = book.getSheet(sheetName);
		    
		    // Get number of rows
		    int rowCount = sheet.getLastRowNum();
		    System.out.println("Row count: " + rowCount);
		    
		    // Get the number of columns
		    int columnCount = sheet.getRow(0).getLastCellNum();
		    System.out.println("Column count: " + columnCount);
		    
		    // Create 2D Array
		    String[][] data = new String[rowCount][columnCount];
		    
		    for (int i = 1; i <= rowCount; i++) {
		        XSSFRow row = sheet.getRow(i);
		        
		        // Check if the row is null
		        if (row != null) {
		            // Get the column values
		            for (int j = 0; j < columnCount; j++) {
		                XSSFCell cell = row.getCell(j);
		                
		                // Check if the cell is null
		                if (cell != null) {
		                    // Read and get the value
		                    data[i - 1][j] = cell.getStringCellValue();
		                } else {
		                    // Handle null cell (e.g., assign an empty string)
		                    data[i - 1][j] = ""; // or some default value
		                }
		            }
		        } else {
		            // Handle null row (if necessary)
		            for (int j = 0; j < columnCount; j++) {
		                data[i - 1][j] = ""; // or some default value
		            }
		        }
		    }
		    
		    book.close();
		    return data;
		}
		
		public String screenshot(String name) throws IOException {
			
			
			String path ="D:\\Apps and software\\JavaProjects\\DemoHotelAppMiniProject\\snap"+name+".png";
			
			File dest = new File(path);
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, dest);
			return path;
	         
	        
		}
	}

			


