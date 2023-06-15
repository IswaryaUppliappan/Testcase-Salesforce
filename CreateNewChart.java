package testcase.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateNewChart {

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
//		WebElement d = driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[1]"));
//		driver.executeScript("arguments[0].click();", d); 
//		WebElement e = driver.findElement(By.xpath("(//span[text()='All'])[1]"));
//		driver.executeScript("arguments[0].click();", e);
		WebElement f = driver.findElement(By.xpath("//button[@title='Show charts']"));
		driver.executeScript("arguments[0].click();", f);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,120)");
			Thread.sleep(2000);
			WebElement g = driver.findElement(By.xpath("//span[text()='Settings']"));
		    driver.executeScript("arguments[0].scrollIntoView(true)", g); 
	        driver.executeScript("arguments[0].click();", g);
	        WebElement h = driver.findElement(By.xpath("//a[@title='New Chart']"));
	        driver.executeScript("arguments[0].click();", h);
	        WebElement i = driver.findElement(By.xpath("//input[@type='text']"));
	        i.sendKeys("NivedhaKrishnan");
	        WebElement p = driver.findElement(By.xpath("(//a[contains(@class,'select')])[2]"));
	        driver.executeScript("arguments[0].click();", p);
	        WebElement j = driver.findElement(By.xpath("(//a[@title='Horizontal Bar Chart'])[2]"));
	        driver.executeScript("arguments[0].click();", j);
	        WebElement q = driver.findElement(By.xpath("(//a[contains(@class,'select')])[3]"));
	        driver.executeScript("arguments[0].click();", q);
	        WebElement k = driver.findElement(By.xpath("//a[@title='Average']"));
	        k.click();
	        WebElement z = driver.findElement(By.xpath("(//a[contains(@class,'select')])[4]"));
	        driver.executeScript("arguments[0].click();", z);
	        WebElement l = driver.findElement(By.xpath("//a[@title='Amount']"));
	        l.click();
	        JavascriptExecutor js2=(JavascriptExecutor)driver;
			js2.executeScript("window.scrollBy(0,120)");
			WebElement m = driver.findElement(By.xpath("//a[text()='Account']"));
		    driver.executeScript("arguments[0].scrollIntoView(true)", m); 
	        driver.executeScript("arguments[0].click();", m);
	        driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	        JavascriptExecutor js3=(JavascriptExecutor)driver;
			js3.executeScript("window.scrollBy(0,120)");
			Thread.sleep(2000);
			WebElement n = driver.findElement(By.xpath("//span[text()='Settings']"));
		    driver.executeScript("arguments[0].scrollIntoView(true)", n); 
	        driver.executeScript("arguments[0].click();", n);
	        WebElement o = driver.findElement(By.xpath("//a[@title='Vertical Bar Chart']"));
	        driver.executeScript("arguments[0].click();", o);
	        
	      
	}

}
