package stepdeifinitions;



import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import amazon.FilteredPage;
import amazon.FilteredProductListPage;
import amazon.HomePage;

import amazon.ProductListPage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;

public class ValidateFilter {
	//private  HomePage homePage;
    private  FilteredPage filteredPage;
   //private  ProductListPage productListPage;
    private  FilteredProductListPage filteredProductListPage;

    public  ValidateFilter( ) {
    	DriverManager dm = new DriverManager();
    
    	
    	WebDriver driver = dm.getDriver();
        
     //   this.homePage = new HomePage(driver);
      //  this.productListPage = new ProductListPage(driver);
        this.filteredPage = new FilteredPage(driver);
        this.filteredProductListPage = new FilteredProductListPage(driver);
  
      
    }

    @When("I apply filters for brand {string}")
    public void iApplyFilters(String brand) {
    	filteredPage.applyFilters(brand);
    }

    @Then("I validate the filtered list")
    public void iValidateTheFilteredList() {
        List<WebElement> filteredProductsResults = filteredProductListPage.getFilteredProducts();
        Assert.assertTrue(filteredProductsResults.size() > 0, "No products found after applying filters");
        for(WebElement result: filteredProductsResults) {
        	String resultName=result.findElement(By.xpath(".//h2//span")).getText();
        	if(resultName.contains("Samsung")) {
        		System.out.println(resultName);
        	}
        	else {
				System.out.println("Result name not matching for samsung for result Name: "+resultName);
			}
        }
        
        
    }
}
