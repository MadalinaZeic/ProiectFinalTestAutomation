package org.fasttrackit.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.AdvSearchPage;
import org.fasttrackit.pageObjects.Footer;
import org.fasttrackit.pageObjects.HomePage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.*;

public class HomePageSteps extends TestBase {

    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private Footer footer = PageFactory.initElements(driver, Footer.class);
    private AdvSearchPage advSearchPage = PageFactory.initElements(driver, AdvSearchPage.class);

    int nrOfProducts;

    @Given("^I open the homepage$")
    public void iOpenTheHomepage() {
        openHomepage();
    }

    @When("^I get the number of products$")
    public void iSearchForProducts() {
        nrOfProducts = homePage.getHomepageProducts().size();
    }

    @Then("^check for nr of existing products$")
    public void iCheckForAtLeastOneProduct() {
        assertThat("No products exist on the homepage", nrOfProducts > 0);
    }

    @And("^I open the Advance Search Page$")
    public void iOpenTheAdvanceSearchPage() {
        footer.clickAdvanceSearch();
    }

    @And("^I fill out the name field with \"([^\"]*)\"$")
    public void iFillOutTheNameFieldWith(String name) {
        advSearchPage.insertText(advSearchPage.getNameField(), name);

    }

    @And("^I set the prices from \"([^\"]*)\", to \"([^\"]*)\"$")
    public void iSetThePricesFromTo(String minPrice, String maxPrice) {
        advSearchPage.insertText(advSearchPage.getMinPrice(), minPrice);
        advSearchPage.insertText(advSearchPage.getMaxPrice(), maxPrice);
    }

    @And("^I select the color \"([^\"]*)\"$")
    public void iSelectTheColor(String color) {
        advSearchPage.selectItem(advSearchPage.getColor()).selectByVisibleText(color);
    }

    @And("^I select \"([^\"]*)\" as gender$")
    public void iSelectAsGender(String gender) {
        advSearchPage.selectItem(advSearchPage.getGender()).selectByVisibleText(gender);
    }

    @When("^I click the Search button$")
    public void iClickTheSearchButton() {
        advSearchPage.clickSearchButton();
    }
}
