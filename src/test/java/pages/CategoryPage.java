package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static stepDefinitions.Hooks.getDriver;

public class CategoryPage extends BasePage {
    private WebDriver webDriver;

    public CategoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    private final String dynamicFilterXPath = "//a[text()='%s']";

    @FindBy(css = ".product-list .product-item:first-child")
    private WebElement firstProduct;

    @FindBy(xpath = "//a[text()='Apple']")
    private WebElement apple;

    @FindBy(css = "div[data-test-id='price-current-price']")
    private List<WebElement> priceElements;

    @FindBy(css = "li[class^='productListContent']")
    private List<WebElement> productContainers;


    public void applyFilter(String filterValue) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

        By dynamicFilterLocator = By.xpath(String.format("//a[text()='%s']", filterValue));

        WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(dynamicFilterLocator));

        scrollToElement(filterElement);
        verifyElementVisible(filterElement);
        clickElement(filterElement);
        getDriver().navigate().refresh();

        By appliedFilterLocator = By.xpath(String.format("//div[contains(@class, 'appliedVerticalFilter') and contains(text(), '%s')]", filterValue));
        wait.until(ExpectedConditions.visibilityOfElementLocated(appliedFilterLocator));

        System.out.println("Filter successfully applied and visible: " + filterValue);
    }


    public void selectMostExpensiveProduct() {
        double maxPrice = 0.0;
        WebElement mostExpensiveProduct = null;

        for (int i = 0; i < priceElements.size(); i++) {
            WebElement priceElement = priceElements.get(i);
            String priceText = priceElement.getText().replace("TL", "").replace(".", "").replace(",", ".").trim();
            double price = Double.parseDouble(priceText);

            if (price > maxPrice) {
                maxPrice = price;
                mostExpensiveProduct = productContainers.get(i+1);
            }
        }

        if (mostExpensiveProduct != null) {
            scrollToElement(mostExpensiveProduct);
            waitForElementToBeClickable(mostExpensiveProduct);
            clickElement(mostExpensiveProduct);
            switchLastTab();

            System.out.println("Clicked on the most expensive product with price: " + maxPrice);
        } else {
            System.out.println("No products found on the page.");
        }

    }

}
