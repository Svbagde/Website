package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListPage {
	
	   private final WebDriver driver;

	    public  ProductListPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void selectProduct(String productName) {
	    	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println("Selected product name is: "+productName);
	    	String xpath= "//*[contains(text(),'"+productName+"')]";
	    	
	     WebElement iphoneBlack=driver.findElement(By.xpath(xpath));
   
			
			  WebDriverWait wait = new WebDriverWait(driver, 10);
			  
			  JavascriptExecutor jse= (JavascriptExecutor) driver;
			  
			  jse.executeScript("arguments[0].scrollIntoView();",iphoneBlack );
			  wait.until(ExpectedConditions.visibilityOf(iphoneBlack));
			 //handling exception 
	     try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        iphoneBlack.click();
     
       
        
	        
	    }
        
}
