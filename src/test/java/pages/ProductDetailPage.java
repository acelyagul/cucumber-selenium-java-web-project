
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {
    private WebDriver webDriver;

    public ProductDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[data-test-id='add-to-cart'] i")
    private WebElement addToCartButton;

    @FindBy(css = "div[data-test-id='price-current-price'] span")
    private WebElement productPrice;

    @FindBy(id = "shoppingCart")
    private WebElement goToCartButton;

    public String getProductPrice() {
        String priceText = productPrice.getText().trim().replaceAll("[^0-9,]", "");;
        System.out.println("Product Price: " + priceText);
        return priceText;
    }

    public void addToCart() {
        verifyElementVisible(addToCartButton);
        clickElement(addToCartButton);
    }

    public void goToCart() {
        clickElement(goToCartButton);
    }


}
