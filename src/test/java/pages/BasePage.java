
package pages;
import config.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;
import utilities.PageHelper;

public class BasePage extends PageHelper {

    public BasePage() {
        PageFactory.initElements(Hooks.getDriver(), this);
    }

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement acceptAllCookies;

    public void acceptAllCookies() {
        clickElement(acceptAllCookies);
    }

    public void HomePage() {
        getUrl(BaseConfig.getInstance().getUrl());
    }


}
