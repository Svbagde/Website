package stepdeifinitions;

import java.util.concurrent.TimeUnit;

import org.joda.time.Seconds;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import amazon.HomePage;
import amazon.ProductDetailsPage;
import amazon.ProductListPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;

public class AmazonSteps {
    private HomePage homePage;
    private ProductListPage productListPage;
    private ProductDetailsPage productDetailsPage;
     String productPrice;
   // private RegistrationPage registrationPage;
     

    public AmazonSteps ()
    
    {
		/*
		 * this.homePage = homePage; this.productListPage = productListPage;
		 * this.productDetailsPage = productDetailsPage; this.registrationPage =
		 * registrationPage;
		 */
       
        
    }
     //@BeforeTest
    @Given("I am on the Amazon homepage")
    public void iAmOnTheAmazonHomepage() {
    	DriverManager dm = new DriverManager();
    	dm.initializeDriver();
    	
    	WebDriver driver = dm.getDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");
       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.homePage = new HomePage(driver);
        this.productListPage = new ProductListPage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
       
    }
//@Test (priority =1)
    @When("I search for {string}")
    public void iSearchFor(String productName) {
        homePage.searchForProduct(productName);
    }
//@Test (priority =2)
    @When("I select {string} from the list")
    public void iSelectFromTheList(String productName) {
        productListPage.selectProduct(productName);
        productPrice = productDetailsPage.getPrice();
        System.out.println("the selected product price is  "+ productPrice);
        
    }

    @When("I go to the product details page")
    public void iGoToTheProductDetailsPage() {
        
    }

   
//@AfterTest
    @Then("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productDetailsPage.addToCart();
    }

   

   

 

    


}
