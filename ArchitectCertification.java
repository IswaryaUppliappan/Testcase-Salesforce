package testcase.salesforce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ArchitectCertification {

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
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		//String windowHandle = driver.getWindowHandle();
				Set<String> windowHandles = driver.getWindowHandles();
				//convert set into list
				List<String> lstname=new ArrayList<String>(windowHandles);
				//move the control into second open window
				driver.switchTo().window(lstname.get(1));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Confirm']")).click();
				Thread.sleep(1000);
				Shadow shadow=new Shadow(driver);
				shadow.setImplicitWait(10);
				shadow.findElementByXPath("//span[contains(text(),'Learning')]").click();
				Thread.sleep(1000);
				WebElement mouseHover = shadow.findElementByXPath("//span[contains(text(),'Learning on Trailhead')]");
				Actions builder =new Actions(driver);
				builder.moveToElement(mouseHover).perform();
				Thread.sleep(1000);
				WebElement drop = shadow.findElementByXPath("//a[contains(text(),'Salesforce Certification')]");
				driver.executeScript("arguments[0].click();",drop);
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(1000);
				String text = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text slds-text-align')]")).getText();
				System.out.println("Summary : " +text);
				Thread.sleep(1000);
				List<WebElement> ele = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
			    for (WebElement webElement : ele) {
					String text1 = webElement.getText();
					System.out.println(" List of Salesforce Architect Certifications: " + text1);
				}
			    driver.findElement(By.linkText("Application Architect")).click();
			    Thread.sleep(1000);
			    List<WebElement> ele1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
			    for (WebElement webElement : ele1) {
					String text2 =webElement.getText();
					System.out.println(" List of Certifications available: " + text2);
				}
			}
		

	}

