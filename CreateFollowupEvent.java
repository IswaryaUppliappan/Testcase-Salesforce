package testcase.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateFollowupEvent {

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
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		WebElement p = driver.findElement(By.xpath("(//span[@class='viewAllLabel'])[3]"));
	    driver.executeScript("arguments[0].click();", p);
	    WebElement c = driver.findElement(By.xpath("//div[@class='test-listviewdisplayswitcher forceListViewManagerDisplaySwitcher']"));
		c.click();
		 driver.findElement(By.xpath("//li[@title='Table']")).click();
		 WebElement b = driver.findElement(By.xpath("(//a[@title='Bootcamp'])[1]"));
	    driver.executeScript("arguments[0].click();", b);
	    WebElement d = driver.findElement(By.xpath("(//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix'])[2]"));
	    driver.executeScript("arguments[0].click();", d);
	    WebElement e = driver.findElement(By.xpath("//a[@title='Create Follow-Up Event']"));
	    driver.executeScript("arguments[0].click();", e);
	    WebElement r = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
	    r.clear();
	    driver.executeScript("arguments[0].click();", r);
	    WebElement f = driver.findElement(By.xpath("//span[@title='Meeting']"));
	    driver.executeScript("arguments[0].click();", f);
	    WebElement o = driver.findElement(By.xpath("//input[@title='Search Contacts']"));
		driver.executeScript("arguments[0].click();", o);
		WebElement g = driver.findElement(By.xpath("//div[@title='Iswarya Uppliappan']"));
		g.click();
		 WebElement h = driver.findElement(By.xpath("(//a[contains(@class,'entityMenuTrigger slds-button slds-button--icon slds-shrink-none slds-m-vertical--xxx-small slds-grid slds-grid_align-center')])[3]"));
		    driver.executeScript("arguments[0].click();", h);
		    JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,-120)");
			Thread.sleep(2000);
			WebElement l = driver.findElement(By.xpath("//span[@title='Products']"));
			driver.executeScript("arguments[0].scrollIntoView(true)", l);  
			driver.executeScript("arguments[0].click();", l); 
			WebElement z = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
			z.clear();
			z.sendKeys("Jun 24, 2023");
			WebElement y = driver.findElement(By.xpath("(//input[@type='text'])[7]"));
			y.clear();
			y.sendKeys("Jul 8, 2023");
			driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
			String expected_Result="Event \"Meeting\" was created.";
			Assert.assertEquals(actual_Result,expected_Result);
	}

}
