package org.fasttrackit.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.Header;
import org.fasttrackit.pageObjects.ProductResultPage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchProductsSteps extends TestBase {
    Header header = PageFactory.initElements(driver, Header.class);
    ProductResultPage productResultPage = PageFactory.initElements(driver, ProductResultPage.class);

    String searchedProduct;

    @When("^I click search when the field is empty$")
    public void iClickSearchWhenTheFieldIsEmpty() {
        header.getSearchButton().click();
    }

    @Then("^search field validation fails$")
    public void searchFieldValidationFails() {
        assertThat("Invalid search not notified.", header.getSearchField().getAttribute("class"), containsString("input-text required-entry validation-failed"));
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String product) {
        searchedProduct = product;
        header.searchProduct(product);
    }

    @Then("^no results message is shown$")
    public void noResultsMessageIsShown() {
        String expectedTitleMsg = "SEARCH RESULTS FOR " + "'" + searchedProduct.toUpperCase() + "'";
        String expectedTitleNotificationMsg = "Your search returns no results.";

        assertThat("Page title not displayed.", productResultPage.getProductResultPageTitle().getText(), is(expectedTitleMsg));
        assertThat("No products found message not displayed.", productResultPage.getProductResultPageTitleMsg().getText(), is(expectedTitleNotificationMsg));
    }

    @Then("^relevant products are found$")
    public void relevantProductsAreFound() {
        assertThat("Relevant product not found.", checkListForText(productResultPage.getProductResultsNames(), searchedProduct.toUpperCase()).size() > 0);
    }
}