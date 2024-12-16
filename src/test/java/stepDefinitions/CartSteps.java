package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.ProductDetailPage;


public class CartSteps {


    private WebDriver webDriver;
    CartPage cartPage;
    ProductDetailPage productDetailPage;

    public CartSteps() {
        this.webDriver = Hooks.getDriver();
        this.cartPage = new CartPage(webDriver);
        this.productDetailPage = new ProductDetailPage(webDriver);
    }


    @Then("the user verifies the product is added to the cart with the correct price")
    public void the_user_verifies_the_product_is_added_to_the_cart_with_the_correct_price() {
        String productDetailPrice = productDetailPage.getProductPrice();
        productDetailPage.goToCart();
        cartPage.verifyCartItemCount(1);
        String cartPrice = cartPage.getCartPrice();
        Assert.assertEquals(cartPrice, productDetailPrice);
    }
}
