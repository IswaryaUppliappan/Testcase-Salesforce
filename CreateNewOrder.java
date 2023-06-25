package testcase.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateNewOrder {

	public static void main(String[] args) {
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
		WebElement b = driver.findElement(By.xpath("//p[text()='Orders']"));
		driver.executeScript("arguments[0].click();", b);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement c = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[3]"));
		driver.executeScript("arguments[0].click();", c);
		WebElement g = driver.findElement(By.xpath("//span[@title='Testleaf Software']"));
		driver.executeScript("arguments[0].click();", g);
		WebElement d = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[1]"));
		driver.executeScript("arguments[0].click();", d);
		WebElement i = driver.findElement(By.xpath("//span[@title='00000214']"));
		driver.executeScript("arguments[0].click();", i);
		WebElement e = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[4]"));
		driver.executeScript("arguments[0].click();", e);
		WebElement j = driver.findElement(By.xpath("(//span[text()='Draft'])[1]"));
		driver.executeScript("arguments[0].click();", j);
		WebElement f = driver.findElement(By.xpath("//input[@name='EffectiveDate']"));
		driver.executeScript("arguments[0].click();", f);
		f.sendKeys("7/10/2023");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String  expected_Result= "Order \"00000102\" was created.";
        Assert.assertEquals(actual_Result,expected_Result);
	
	}

}
