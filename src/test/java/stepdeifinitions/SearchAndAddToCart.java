package stepdeifinitions;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import amazon.HomePage;
import amazon.ProductDetailsPage;
import amazon.ProductListPage;

import io.cucumber.java.en.*;
import utils.DriverManager;

public class SearchAndAddToCart {
	public class SearchAndAddToCartSteps {
	    private HomePage homePage;
	    private ProductDetailsPage productDetailsPage;
	    private String productPrice;
	    private ProductListPage productListPage;

	    public SearchAndAddToCartSteps() {
	    	DriverManager dm = new DriverManager();
	    	WebDriver driver = dm.getDriver();
	        this.homePage = new HomePage(driver);
	     
	        this.productDetailsPage = new ProductDetailsPage(driver);
	        this.productListPage = new ProductListPage(driver);
	        
	    }

	  

	    @When("I search for {string}")
	    public void iSearchFor(String productName) {
	        homePage.searchForProduct(productName);
	    }

	    @When("I select {string} product from the list")
	    public void iSelectAProductFromTheList(String productName) {
	     productListPage.selectProduct(productName);
	       
	    }

	  

	    @Then("I Select {productName} from the list, and print the Product Price")
	    public void i_select_from_the_list_and_print_the_product_price(String productName) {
	    	productListPage.selectProduct(productName);
	        productPrice = productDetailsPage.getPrice();
	        System.out.println("the selected product price is  "+ productPrice);
	     
	        productDetailsPage.addToCart();
	    }

	 
	 
}
}
