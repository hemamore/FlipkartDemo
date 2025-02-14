package com.tshirt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;





public class MenTshirts {
	RemoteWebDriver driver;
	@BeforeClass
	public void setup() throws Exception{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com");
	}
	public void tearDown() throws Exception{
		driver.quit();
	}
	@Test
	public void verifyProductListWhencolorIsApplied() throws InterruptedException {
		Actions  act = new Actions(driver);
		WebElement women = driver.findElement(By.xpath("//a[@data-group=\"women\"]"));
		act.moveToElement(women).perform();
		driver.findElement( By.xpath("//div[@class=\"desktop-backdropStyle\"]/descendant::a[contains(@href , 'women') and contains(text(),'Dresses')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//ul[@class=\"brand-list\"]/li[1]")).click();
		    Thread.sleep(3000);
	    driver.findElement(By.xpath("//li[@class=\"colour-listItem\"][1]")).click();
	    Thread.sleep(3000);
	    List<WebElement> brandColors=driver.findElements(By.xpath("//h4[@class=\"product-brand\"]"));
	    SoftAssert softly= new SoftAssert();
	    int count =0;
	    for(int i = 0;i < brandColors.size(); i++) {
	    	String brandColor = brandColors.get(i).getText();
	    	softly.assertEquals(brandColor,"Black");
	    	count++;
	    }
	    System.out.println(count);
	    softly.assertAll();
	    	
	    	
	    }
	
	

	
	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.Mantra.com");
		driver.findElement(By.xpath(""));
		
	}

}
