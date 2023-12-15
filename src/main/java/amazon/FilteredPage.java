package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilteredPage {
	private final WebDriver driver;

    public FilteredPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyFilters(String brand) {
    WebElement samsung=	driver.findElement(By.xpath("//*[contains(text(),'Samsung')]/..//div[contains(@class, 'checkbox')]"));
    	WebDriverWait wait = new WebDriverWait(driver, 10);
	     
     JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",samsung );
        wait.until(ExpectedConditions.elementToBeClickable(samsung));   
    	
    	
        samsung.click();
       
    }
}
