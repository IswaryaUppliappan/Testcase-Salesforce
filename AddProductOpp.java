package testcase.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddProductOpp {

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
		WebElement d = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		driver.executeScript("arguments[0].click();", d);
		d.sendKeys("SRM Steel");
		d.sendKeys(Keys.ENTER);
		WebElement g = driver.findElement(By.xpath("//a[@title='SRM Steel']"));
		driver.executeScript("arguments[0].click();", g);
		WebElement e = driver.findElement(By.xpath("//a[@title='Show 2 more actions']"));
		driver.executeScript("arguments[0].click();", e);
		WebElement f = driver.findElement(By.xpath("//a[@title='Add Products']"));
		f.click();
		
	}

}
