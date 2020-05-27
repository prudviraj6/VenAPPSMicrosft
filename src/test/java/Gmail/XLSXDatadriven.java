package Gmail;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class XLSXDatadriven {
	
	public WebDriver driver;
	
  @Test
  public void f() throws Exception {
	  
	  FileInputStream fi = new FileInputStream("C:\\Users\\samyuktha\\Desktop\\POIExcelsheet.xlsx");
	  
		XSSFWorkbook workbook = new XSSFWorkbook(fi);

		XSSFSheet s = workbook.getSheetAt(0);

		String username = s.getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.id("identifierId")).sendKeys(username);
		
		Thread.sleep(3000);
		
		 driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		 Thread.sleep(8000);


			
		String password = s.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(password);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span")).click();
		Thread.sleep(10000);
  
  }
  
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\samyuktha\\Desktop\\testing tools\\Testing software\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://gmail.com");
	  Thread.sleep(3000);
  
  }

  
  @AfterTest
  public void afterTest() {
  
  
  }

}
