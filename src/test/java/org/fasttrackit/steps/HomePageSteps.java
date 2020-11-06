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

    private HomePage homePageObj = PageFactory.initElements(driver, HomePage.class);
    private Footer footerObj = PageFactory.initElements(driver, Footer.class);
    private AdvSearchPage advSearchPageObj = PageFactory.initElements(driver, AdvSearchPage.class);

    int nrOfProductsStored;

    String nameResultShownStored;
    String priceResultShownStored;
    String colorResultShownStored;
    String genderResultShownStored;

    @Given("^I open the homepage$")
    public void iOpenTheHomepage() {
        openHomepage();
    }

    @When("^I get the number of products$")
    public void iSearchForProducts() {
        nrOfProductsStored = homePageObj.getHomepageProducts().size();
    }

    @Then("^check for nr of existing products$")
    public void iCheckForAtLeastOneProduct() {
        assertThat("No products exist on the homepage", nrOfProductsStored > 0);
    }

    @And("^I open the Advance Search Page$")
    public void iOpenTheAdvanceSearchPage() {
        footerObj.clickAdvanceSearch();
    }

    @And("^I fill out the name field with \"([^\"]*)\"$")
    public void iFillOutTheNameFieldWith(String name) {
        advSearchPageObj.getNameField().sendKeys(name);

        nameResultShownStored = name;
    }

    @And("^I set the prices from \"([^\"]*)\", to \"([^\"]*)\"$")
    public void iSetThePricesFromTo(String minPrice, String maxPrice) {
        advSearchPageObj.getMinPrice().sendKeys(minPrice);
        advSearchPageObj.getMaxPrice().sendKeys(maxPrice);

        priceResultShownStored = minPrice + " - " + maxPrice;
    }

    @And("^I select the color \"([^\"]*)\"$")
    public void iSelectTheColor(String color) {
        advSearchPageObj.selectItem(advSearchPageObj.getColor()).selectByVisibleText(color);

        colorResultShownStored = color;
    }

    @And("^I select \"([^\"]*)\" as gender$")
    public void iSelectAsGender(String gender) {
        advSearchPageObj.selectItem(advSearchPageObj.getGender()).selectByVisibleText(gender);

        genderResultShownStored = gender;
    }

    @When("^I click the Search button$")
    public void iClickTheSearchButton() {
        advSearchPageObj.clickSearchButton();
    }

    @Then("^a relevant product is displayed$")
    public void aRelevantProductIsDisplayed() {
        String expectedText = "item(s)";
        assertThat("Could not find search results on page.", advSearchPageObj.getProductsFoundMessage().getText(), containsString(expectedText));

        assertThat("No products displayed.", advSearchPageObj.getAdvSearchProductsGrid().size() > 0);
    }

    @And("^relevant information about the product is displayed$")
    public void relevantInformationAboutTheProductIsDisplayed() {
        assertThat("Incorrect name result.", advSearchPageObj.getNameResult().getText(), containsString(nameResultShownStored));
        assertThat("Incorrect price result.", advSearchPageObj.getPriceResult().getText(), containsString(priceResultShownStored));
        assertThat("Incorrect color result.", advSearchPageObj.getColorResult().getText(), containsString(colorResultShownStored));
        assertThat("Incorrect gender result.", advSearchPageObj.getGenderResult().getText(), containsString(genderResultShownStored));
    }

    @Then("^an error message is displayed$")
    public void anErrorMessageIsDisplayed() {
        String errorMsgTex = "Please specify at least one search term.";
        assertThat("No error message is displayed.", advSearchPageObj.getEmptyFormErrorMsg().getText(), containsString(errorMsgTex));
    }

    @And("^I insert a nonexistent product, \"([^\"]*)\"$")
    public void iInsertANonexistentProduct(String productName) {
        advSearchPageObj.getNameField().sendKeys(productName);
    }

    @Then("^a message with no items found should be displayed$")
    public void aMessageWithNoItemsFoundShouldBeDisplayed() {
        String errorMsgText = "No items were found using the following search criteria. Modify your search";
        assertThat("The nonexistent product message does not appear.", advSearchPageObj.getNoItemsFoundMsg().getText(), is(errorMsgText));
    }
}
