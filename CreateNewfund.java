package testcase.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateNewfund {

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
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement b = driver.findElement(By.xpath("//p[text()='Service Console']"));
		driver.executeScript("arguments[0].click();", b);
		WebElement a = driver.findElement(By.xpath("//button[@title='Show Navigation Menu']"));
		driver.executeScript("arguments[0].click();", a);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		WebElement c = driver.findElement(By.xpath("//span[text()='Refunds']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", c);  
		driver.executeScript("arguments[0].click();", c); 
		WebElement z = driver.findElement(By.xpath("//div[@title='New']"));
		driver.executeScript("arguments[0].click();", z); 
		WebElement d = driver.findElement(By.xpath("//input[@title='Search Accounts']"));
		driver.executeScript("arguments[0].click();", d); 
		WebElement e = driver.findElement(By.xpath("(//a[@role='option'])[1]"));
		driver.executeScript("arguments[0].click();", e); 
		WebElement f = driver.findElement(By.xpath("(//div[contains(@class,'uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select')])[1]"));
		f.click(); 
		WebElement g = driver.findElement(By.xpath("(//a[text()='Canceled'])[1]"));
		driver.executeScript("arguments[0].click();", g);
		WebElement h = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		driver.executeScript("arguments[0].click();", h); 
		h.sendKeys("50000");
		WebElement i = driver.findElement(By.xpath("(//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel'])[2]"));
		driver.executeScript("arguments[0].click();", i); 
		WebElement j = driver.findElement(By.xpath("(//a[text()='Referenced'])[1]"));
		driver.executeScript("arguments[0].click();", j);
		WebElement k = driver.findElement(By.xpath("(//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel'])[3]"));
		driver.executeScript("arguments[0].click();", k); 
		WebElement l = driver.findElement(By.xpath("(//a[text()='External'])[1]"));
		driver.executeScript("arguments[0].click();", l);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String  expected_Result= "Refund \"R-000000015\" was created.";
        Assert.assertEquals(actual_Result,expected_Result);
	}

}
