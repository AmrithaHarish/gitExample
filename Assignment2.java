package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment2 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void sendMail() {
	    driver.get("http://login.yahoo.com");
		driver.findElement(By.id("login-username")).sendKeys("amritha_harish");
		driver.findElement(By.id("login-signin")).click();
		WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-passwd")));
		password.sendKeys("dhyeya!@#$");
		driver.findElement(By.id("login-signin")).click();
		WebElement mail = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Mail")));
		mail.click();
		driver.findElement(By.xpath("//a[text()='Compose']")).click();
		WebElement to = driver.findElement(By.xpath("//div[@class='typeahead-inputs-container M_0 p_R H_6NIX']/input[@role='combobox']"));
		to.sendKeys("amrithaharish995@gmail.com");
		WebElement subject = driver.findElement(By.xpath("//input[@placeholder='Subject']"));
		subject.sendKeys("Ketan, I have done my assingment (Explicit wait and implemented logout - Amritha");
		WebElement msgBody = driver.findElement(By.xpath("//div[@aria-label='Message body']"));
		msgBody.sendKeys("I feel like its easy to understand every concepts from your training. But for me, it seems a bit difficult when something explaining in hindi. I would be pleased if you conduct the whole class in english only.");
		driver.findElement(By.xpath("//button[@title='Send this email']")).click();
		driver.findElement(By.xpath("//img[@class='_yb_lb7o6']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='_yb_1jjkw _yb_duyhh _yb_16piv']")).click();;
		
  }
  
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-32bit.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,30);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @AfterClass
	  public void afterClass() {
		  //driver.quit();
  }
}
