package scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment3 {
	WebDriver driver;
	
  @Test
  public void fillingPracticeFormName() throws InterruptedException{
	  driver.get("http://toolsqa.com/automation-practice-form/");
	  JavascriptExecutor js7 = (JavascriptExecutor) driver;
	    js7.executeScript("window.scrollBy(0,500)");
/*	  WebElement firstName = driver.findElement(By.name("firstname"));
	  firstName.sendKeys("AMRITHA");
	  String text = firstName.getAttribute("value");
	  System.out.println("First name : "+text);
	  WebElement lastName = driver.findElement(By.id("lastname"));
	  lastName.sendKeys("NANDAKUMAR");
	  String text3 = lastName.getAttribute("value");
	  System.out.println("Last name : "+text3);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,300)");
	  WebElement sex = driver.findElement(By.id("sex-1"));
	  sex.click();
	  JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,100)");
	  WebElement experience = driver.findElement(By.id("exp-0"));
	  experience.click();
	  JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,100)");
	  driver.findElement(By.id("datepicker")).sendKeys("1/1/2019");
	  JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0,100)");
	  WebElement MTCheckbox = driver.findElement(By.id("profession-0"));
	  if(!MTCheckbox.isSelected())
		  MTCheckbox.click();
	  if(MTCheckbox.isSelected())
		  MTCheckbox.click();
	  WebElement ATCheckbox = driver.findElement(By.id("profession-1"));
	  if(!ATCheckbox.isSelected())
		  ATCheckbox.click();
	  JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("window.scrollBy(0,300)");
	  WebElement automationToolCB = driver.findElement(By.id("tool-2"));
	  if(!automationToolCB.isSelected()) 
		  automationToolCB.click();
	  JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    js5.executeScript("window.scrollBy(0,100)");*/
	  Select continents = new Select(driver.findElement(By.id("continents")));
	  Assert.assertEquals(continents.getOptions().size(),7,"size did not match");
	  List <String> expectedContinentsOptions = new ArrayList();
	  List <String> actualContinentsOptions = new ArrayList();
	  expectedContinentsOptions.add("Asia");
	  expectedContinentsOptions.add("Europe");
	  expectedContinentsOptions.add("Africa");
	  expectedContinentsOptions.add("Australia");
	  expectedContinentsOptions.add("South America");
	  expectedContinentsOptions.add("North America");
	  expectedContinentsOptions.add("Antartica");
	  List <WebElement> allOptions = continents.getOptions();
	  for(WebElement oneOption : allOptions) {
		  actualContinentsOptions.add(oneOption.getText());
	  	}
	  continents.selectByIndex(0);
	  WebElement cont = continents.getFirstSelectedOption();
	  System.out.println("Continent 1st selected : " +cont.getText());
	  Assert.assertTrue(cont.getText().equals("Asia"), "not matching");
	  continents.selectByVisibleText("Europe");
	  continents.getFirstSelectedOption();
	  WebElement cont1 = continents.getFirstSelectedOption();
	  System.out.println("Continent last selected : " +cont1.getText());
	  Assert.assertTrue(cont1.getText().equals("Europe"), "not matching");
	  JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("window.scrollBy(0,200)");
	  Select commands = new Select(driver.findElement(By.id("selenium_commands")));
	  Assert.assertTrue(commands.isMultiple());
	  List <String> expectedCommandsOptions = new ArrayList();
	  List <String> actualCommandsOptions = new ArrayList();
	  expectedCommandsOptions.add("Browser Commands");
	  expectedCommandsOptions.add("Navigation Commands");
	  expectedCommandsOptions.add("Switch Commands");
	  expectedCommandsOptions.add("Wait Commands");
	  expectedCommandsOptions.add("WebElement Commands");
	  Assert.assertEquals(commands.getOptions().size(),5,"size did not match");
	  List <WebElement> allCommandOptions = new ArrayList();
	  for(WebElement oneOption1 : allCommandOptions) {
		  actualCommandsOptions.add(oneOption1.getText());
	  }
	  commands.selectByIndex(0);
	  commands.selectByVisibleText("Wait Commands");
	  System.out.println("no:of commands selected :"+commands.getAllSelectedOptions().size());
	  commands.deselectByIndex(0);
	  System.out.println(commands.getAllSelectedOptions().size());
	  commands.deselectAll();
	  System.out.println(commands.getAllSelectedOptions().size());
	  WebElement text1 = driver.findElement(By.xpath("//span[text()='Text1']"));
	  System.out.println("printing Text1 : "+text1.getText());
	  WebElement text2 = driver.findElement(By.id("NextedText"));
	  System.out.println("printing Text2 : "+text2.getText());
	
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
