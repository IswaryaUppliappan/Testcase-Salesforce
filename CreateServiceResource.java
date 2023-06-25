package testcase.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateServiceResource {

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
		WebElement b = driver.findElement(By.xpath("//p[text()='Service Resources']"));
		driver.executeScript("arguments[0].click();", b);
		driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]")).click();
	    WebElement k = driver.findElement(By.xpath("//div[@title='Edit']"));
	    driver.executeScript("arguments[0].click();", k);
	    WebElement a = driver.findElement(By.xpath("//input[@name='Name']"));
	    a.clear();
	    a.sendKeys("Iswarya");
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String  expected_Result= "Service Resource \"Iswarya\" was saved.";
        Assert.assertEquals(actual_Result,expected_Result);

	}

}
