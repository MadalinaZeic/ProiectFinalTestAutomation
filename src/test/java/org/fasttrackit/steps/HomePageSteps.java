package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.AdvSearchPage;
import org.fasttrackit.pageObjects.Footer;
import org.fasttrackit.pageObjects.HomePage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageSteps extends TestBase {

    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private Footer footer = PageFactory.initElements(driver, Footer.class);
    private AdvSearchPage advSearchPage = PageFactory.initElements(driver, AdvSearchPage.class);

    int nrOfProducts;

    String nameResultShown;
    String priceResultShown;
    String colorResultShown;
    String genderResultShown;

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
        advSearchPage.getNameField().sendKeys(name);

        nameResultShown = name;
    }

    @And("^I set the prices from \"([^\"]*)\", to \"([^\"]*)\"$")
    public void iSetThePricesFromTo(String minPrice, String maxPrice) {
        advSearchPage.getMinPrice().sendKeys(minPrice);
        advSearchPage.getMaxPrice().sendKeys(maxPrice);

        priceResultShown = minPrice + " - " + maxPrice;
    }

    @And("^I select the color \"([^\"]*)\"$")
    public void iSelectTheColor(String color) {
        advSearchPage.selectItem(advSearchPage.getColor()).selectByVisibleText(color);

        colorResultShown = color;
    }

    @And("^I select \"([^\"]*)\" as gender$")
    public void iSelectAsGender(String gender) {
        advSearchPage.selectItem(advSearchPage.getGender()).selectByVisibleText(gender);

        genderResultShown = gender;
    }

    @When("^I click the Search button$")
    public void iClickTheSearchButton() {
        advSearchPage.clickSearchButton();
    }

    @Then("^a relevant product is displayed$")
    public void aRelevantProductIsDisplayed() {
        String expectedText = "item(s)";
        assertThat("Could not find search results on page.", advSearchPage.getProductsFoundMessage().getText(), containsString(expectedText));

        assertThat("No products displayed.", advSearchPage.getAdvSearchProductsGrid().size() > 0);
    }

    @And("^relevant information about the product is displayed$")
    public void relevantInformationAboutTheProductIsDisplayed() {
        assertThat("Incorrect name result.", advSearchPage.getNameResult().getText(), containsString(nameResultShown));
        assertThat("Incorrect price result.", advSearchPage.getPriceResult().getText(), containsString(priceResultShown));
        assertThat("Incorrect color result.", advSearchPage.getColorResult().getText(), containsString(colorResultShown));
        assertThat("Incorrect gender result.", advSearchPage.getGenderResult().getText(), containsString(genderResultShown));
    }

    @Then("^an error message is displayed$")
    public void anErrorMessageIsDisplayed() {
        String errorMsgTex = "Please specify at least one search term.";
        assertThat("No error message is displayed.", advSearchPage.getEmptyFormErrorMsg().getText(), containsString(errorMsgTex));
    }

    @And("^I insert a nonexistent product, \"([^\"]*)\"$")
    public void iInsertANonexistentProduct(String productName) {
        advSearchPage.getNameField().sendKeys(productName);
    }

    @Then("^a message with no items found should be displayed$")
    public void aMessageWithNoItemsFoundShouldBeDisplayed() {
        String errorMsgText = "No items were found using the following search criteria. Modify your search";
        assertThat("The nonexistent product message does not appear.", advSearchPage.getNoItemsFoundMsg().getText(), is(errorMsgText));
    }
}
