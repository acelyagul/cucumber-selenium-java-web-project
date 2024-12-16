package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CategoryPage;
import java.util.Map;


public class CategorySteps {


    private WebDriver webDriver;
    CategoryPage categoryPage;

    public CategorySteps() {
        this.webDriver = Hooks.getDriver();
        this.categoryPage = new CategoryPage(webDriver);
    }


    @When("the user applies the filters:")
    public void the_user_applies_the_filters(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> filters = dataTable.asMap(String.class, String.class);

        categoryPage.applyFilter(filters.get("Brand"));
        categoryPage.applyFilter(filters.get("Screen Size"));
    }

    @When("the user selects the most expensive product")
    public void the_user_selects_the_most_expensive_product() {
        categoryPage.selectMostExpensiveProduct();
    }

}
