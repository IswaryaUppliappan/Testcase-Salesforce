package testcase.salesforce;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class VerifyGoogleplaystore {

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
		driver.findElement(By.xpath("(//span[text()='Get Started'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstname=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstname.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(1000);
		WebElement mouseHover = driver.findElement(By.xpath("//p[text()='Product']"));
		Actions builder =new Actions(driver);
		builder.moveToElement(mouseHover);
		driver.executeScript("arguments[0].click();",mouseHover);
		WebElement e = driver.findElement(By.xpath("//h5[text()='Virtual Private Cloud']"));
		driver.executeScript("arguments[0].click();",e);
		WebElement f = driver.findElement(By.xpath("//h2[text()='How Quip VPC works']"));
		builder.scrollToElement(f);
	    WebElement scroll = driver.findElement(By.xpath("(//img[@alt='Quip VPC IT controls and user experience diagram'])[1]"));
	    driver.executeScript("arguments[0].scrollIntoView(true)", scroll);   
	    File source = driver.getScreenshotAs(OutputType.FILE);
	    File dest = new File("./screenshot/snap2.png");
	    FileUtils.copyFile(source, dest);
		}

}
