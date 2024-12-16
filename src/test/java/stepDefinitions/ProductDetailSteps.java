package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;


import pages.ProductDetailPage;


public class ProductDetailSteps {


    private WebDriver webDriver;
    ProductDetailPage productDetailPage;

    public ProductDetailSteps() {
        this.webDriver = Hooks.getDriver();
        this.productDetailPage = new ProductDetailPage(webDriver);
    }


    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        productDetailPage.addToCart();
    }
}
