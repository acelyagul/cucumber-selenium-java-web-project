package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps {


    private WebDriver webDriver;
    HomePage homePage;

    public HomePageSteps() {
        this.webDriver = Hooks.getDriver();
        this.homePage = new HomePage(webDriver);
    }


    @When("the user navigates to {string} category and selects {string} subcategory")
    public void the_user_navigates_to_category_and_selects_subcategory(String mainCategory, String subCategory) {
        homePage.selectCategory(mainCategory, subCategory);
    }


}
