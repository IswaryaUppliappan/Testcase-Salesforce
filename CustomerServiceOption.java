package testcase.salesforce;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class CustomerServiceOption {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstname=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstname.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow shadow=new Shadow(driver);
		WebElement c = shadow.findElementByXPath("//span[text()='Products']");
		driver.executeScript("arguments[0].click();",c);
		shadow.setImplicitWait(10);
		WebElement s = shadow.findElementByXPath("//span[text()='Service']");
		Actions builder =new Actions(driver);
		builder.moveToElement(s).perform();
		shadow.setImplicitWait(20);
		WebElement x = shadow.findElementByXPath("//ul[@class='c360-panel-linkedlist__listitems']");
		//builder.scrollToElement(x).perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,120)");
		shadow.setImplicitWait(20);
		driver.executeScript("arguments[0].scrollIntoView(true)", x);   
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/snap.png");
		FileUtils.copyFile(source, dest);
		
	}

}
