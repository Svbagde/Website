package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).submit();
    }

}
