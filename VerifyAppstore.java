package testcase.salesforce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.sukgu.Shadow;

public class VerifyAppstore {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("(//span[text()='Get Started'])[1]")).click();
		driver.findElement(By.xpath("//h2[text()='Einstein Bots Trails']")).click();
		Set<String> windowHandles = driver.getWindowHandles();	
		List<String> lstname=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstname.get(1));
		Shadow shadow=new Shadow(driver);	
		WebElement f = shadow.findElementByXPath("//span[text()='More']");
		Actions builder =new Actions(driver);
		builder.moveToElement(f);
		driver.executeScript("arguments[0].click();",f);
		shadow.setImplicitWait(10);
		WebElement g = shadow.findElementByXPath("//span[text()='Trail Tracker']");
		driver.executeScript("arguments[0].click();",g);
		Set<String> windowHandles1 = driver.getWindowHandles();	
		List<String> lstname1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(lstname1.get(2));
		WebElement i = shadow.findElementByXPath("//input[@name='bar-input']");		
		i.sendKeys("SalesforceA Connected Apps Administration");
		i.sendKeys(Keys.ENTER);
		WebElement h = shadow.findElementByXPath("//a[text()='SalesforceA Connected Apps Administration']");
		driver.executeScript("arguments[0].click();",h);
		String actual_Result = shadow.findElementByXPath("//h1[text()='SalesforceA Connected Apps Administration']").getText();
		String expected_Result="SalesforceA Connected Apps Administration";
		Assert.assertEquals(actual_Result,expected_Result);
		String actual_Result1 = shadow.findElementByXPath("//button[@class='button button--primary']").getText();
		String expected_Result1="Get It Now";
		Assert.assertEquals(actual_Result1,expected_Result1);


}}
