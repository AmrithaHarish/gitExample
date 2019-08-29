package scripts;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment4 {
	WebDriver driver;
	
  @Test
  public void mobileCompare() {
	  driver.get("https://www.gsmarena.com/");
	  driver.findElement(By.linkText("APPLE")).click();
	  driver.findElement(By.linkText("COMPARE")).click();
	  WebElement ipad_12 = driver.findElement(By.xpath("//a[@href='apple_ipad_pro_12_9_(2018)-9387.php']//span"));
	  if(!ipad_12.isSelected())
	  ipad_12.click();
	  WebElement watch_Series=  driver.findElement(By.xpath("//a[@href='apple_watch_series_4-9321.php']//span"));
	  //WebElement watch_Series = driver.findElement(By.xpath("//a[@href='apple_watch_series_4-9321.php']//span"));
	  System.out.println("1st item selected : "+ipad_12.getText());
	  if(!watch_Series.isSelected())
	  watch_Series.click();
	  driver.findElement(By.linkText("COMPARE")).click();
	  watch_Series=  driver.findElement(By.xpath("//a[@href='apple_watch_series_4-9321.php']//span"));
	  System.out.println("2nd item selected : "+watch_Series.getText());
  }
  
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-32bit.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
  }
  
  @AfterClass
	  public void afterClass() {
		 // driver.quit();
  }
}
