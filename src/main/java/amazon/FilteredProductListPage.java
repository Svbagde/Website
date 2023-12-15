package amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilteredProductListPage {
	private final WebDriver driver;

    public FilteredProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getFilteredProducts() {
        return driver.findElements(By.xpath("//div[contains(@data-component-type,'s-search-result')]")); 
    }
}
