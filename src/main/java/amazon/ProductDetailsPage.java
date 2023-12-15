package amazon;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductDetailsPage {
	private final WebDriver driver;

    
   
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
    	String mainWindow=driver.getWindowHandle();
    	WebDriver childDriver=switchToChildwindow(driver);
    	System.out.println("the new page title is "+ childDriver.getTitle());
    	String priceDetails= driver.findElement(By.xpath("//div[@id='centerCol']//*[contains(@class,'price-whole')]")).getText();

    	//switch to the parent window
    	driver.switchTo().window(mainWindow);
        return priceDetails;
    }

    public void addToCart() {
    
//       childDriver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
      // String mainWindow=driver.getWindowHandle();
    WebDriver childWindow=switchToChildwindow(driver);
    childWindow.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    System.out.println("the new page title is "+ childWindow.getTitle());
    WebElement cartMsg= childWindow.findElement(By.xpath("//div[@id='attach-added-to-cart-message']//h4[@class='a-alert-heading']"));
    WebDriverWait wait = new WebDriverWait(childWindow, 20);
    wait.until(ExpectedConditions.visibilityOf(cartMsg));
    	
    Assert.assertEquals(cartMsg.getText(), "Added to Cart");
    
    System.out.println("Item added to the cart");
        
    }

    public WebDriver switchToChildwindow(WebDriver driver) {
    	String mainWindow=driver.getWindowHandle();
    	Set<String>s=driver.getWindowHandles();

    	// Now iterate using Iterator
    	Iterator<String> I1= s.iterator();

    	while(I1.hasNext())
    	{

    	String child_window=I1.next();
    	if(!mainWindow.equals(child_window))
    	{
    	driver.switchTo().window(child_window);

    	System.out.println(driver.switchTo().window(child_window).getTitle());

    
    	}

    	}
    	return driver;
    }
}
