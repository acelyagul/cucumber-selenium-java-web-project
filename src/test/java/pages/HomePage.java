package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageHelper;

public class HomePage extends PageHelper {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;


    public void selectCategory(String mainCategory, String subCategory) {
        try {
            if (acceptCookiesButton.isDisplayed()) {
                clickElement(acceptCookiesButton);
                System.out.println("Cookies accepted.");
            }
        } catch (Exception e) {
            System.out.println("Cookies button not found. Continuing...");
        }

        String dynamicCategoryXPath = "//a[contains(text(),'%s')]";

        WebElement mainCategoryElement = getDynamicElement(dynamicCategoryXPath, mainCategory);
        verifyElementVisible(mainCategoryElement);
        hoverOverElement(mainCategoryElement);

        WebElement subCategoryElement = getDynamicElement(dynamicCategoryXPath, subCategory);
        verifyElementVisible(subCategoryElement);
        clickElement(subCategoryElement);

        System.out.println("Navigated to: " + mainCategory + " -> " + subCategory);
    }
}
