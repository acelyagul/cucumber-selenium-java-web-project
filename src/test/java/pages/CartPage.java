package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    private WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[class*='product_price']")
    private WebElement productCartPrice;

    @FindBy(css = ".product_name_2Klj3 > a")
    private WebElement verifyCard;

    @FindBy(id = "basket-item-count")
    private WebElement basketItemCount;


    public String getCartPrice() {
        verifyElementVisible(productCartPrice);
        String priceText = productCartPrice.getText().trim().replaceAll("[^0-9,]", "");
        System.out.println("Product Cart Price: " + priceText);
        return priceText;
    }

    public void verifyCartItemCount(int expectedCount) {
        waitForElementToBeClickable(basketItemCount);
        String itemCountText = basketItemCount.getText().trim();
        int actualCount = Integer.parseInt(itemCountText);

        if (actualCount == expectedCount) {
            System.out.println("Doğrulama başarılı: Sepetteki ürün sayısı beklenen değer ile eşleşiyor.");
        } else {
            throw new AssertionError("Hata: Beklenen ürün sayısı " + expectedCount +
                    ", ancak sepette " + actualCount + " ürün var.");
        }
    }


}
