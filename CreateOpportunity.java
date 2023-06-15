package testcase.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateOpportunity {

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
		WebElement b = driver.findElement(By.xpath("//p[text()='Content']"));
		driver.executeScript("arguments[0].click();", b);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		WebElement c = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", c);  
		driver.executeScript("arguments[0].click();", c); 
		driver.findElement(By.xpath("//a[@title='New']")).click();
		WebElement f = driver.findElement(By.xpath("//input[@name='Name']"));
		f.sendKeys("SRM Steel");
		WebElement g = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[3]"));
		driver.executeScript("arguments[0].click();", g);
		driver.findElement(By.xpath("//span[@title='New Customer']")).click();
		WebElement h = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[4]"));
		driver.executeScript("arguments[0].click();", h);
		driver.findElement(By.xpath("//span[@title='Partner Referral']")).click();
		WebElement i = driver.findElement(By.xpath("//input[@name='Amount']"));
		i.sendKeys("75000");
		WebElement j = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		j.sendKeys("7/20/2023");
		WebElement k = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[2]"));
		driver.executeScript("arguments[0].click();", k);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		WebElement l = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[5]"));
		driver.executeScript("arguments[0].click();", l);
		driver.findElement(By.xpath("//span[@title='Bootcamp']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String  expected_Result= "Opportunity \"SRM Steel\" was created.";
        Assert.assertEquals(actual_Result,expected_Result);
		
	}

}
