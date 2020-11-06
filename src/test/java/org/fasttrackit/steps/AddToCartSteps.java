package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.*;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToCartSteps extends TestBase {

    private HomePage homePageObj = PageFactory.initElements(driver, HomePage.class);
    private ProductPage productPageObj = PageFactory.initElements(driver, ProductPage.class);
    private ProductResultPage productResultPageObj = PageFactory.initElements(driver, ProductResultPage.class);
    private CheckoutCartPage checkoutCartPageObj = PageFactory.initElements(driver, CheckoutCartPage.class);
    private Header headerObj = PageFactory.initElements(driver, Header.class);

    public String homepageProductNameStored;
    public String homepageProductPriceStored;

    public String productNameStored;
    public String productPriceUnSplitStored;
    public String productPriceSplitStored;

    public String updatedQuantityStored;


    @And("^I store the first product's name$")
    public void iStoreTheFirstProductSName() {
        homepageProductNameStored = homePageObj.getProductText();
    }

    @And("^I store the first product's price$")
    public void iStoreTheFirstProductSPrice() {
        homepageProductPriceStored = homePageObj.getProductPrice();
    }

    @And("^I choose the first product$")
    public void iChooseTheFirstProduct() {
        homePageObj.getAddToCartButton().click();
    }

    @And("^I check that the web page is correct$")
    public void iCheckThatTheWebPageIsCorrect() {
        assertThat("Incorrect web page", driver.getCurrentUrl(), is(checkoutCartPageObj.getPageUrl()));
    }

    @And("^The product name is visible in the product page$")
    public void theProductNameIsVisibleInTheProductPage() {
        assertThat("The product name is different: ", productPageObj.getProductName().getText(), containsString(homepageProductNameStored.toUpperCase()));
    }

    @And("^The product price is visible in the product page$")
    public void theProductPriceIsVisibleInTheProductPage() {
        String[] price = productPageObj.getProductPrice().getText().split("[$]");

        assertThat("The product price is different: ", price[1], is(homepageProductPriceStored.toUpperCase()));
    }

    @When("^I add the product to the cart$")
    public void iAddTheProductToTheCart() {
        productPageObj.getAddToCartButton().click();
    }

    @Then("^The product homepage name is visible in the checkout cart$")
    public void theProductHomepageNameIsVisibleInTheCheckoutCart() {
        assertThat("The product name is incorrect.", checkoutCartPageObj.getProductCartName().getText(), containsString(homepageProductNameStored.toUpperCase()));
    }

    @And("^The price from homepage is the same as the one on the list$")
    public void thePriceFromHomepageIsTheSameAsTheOneOnTheList() {
        assertThat("The product price is incorrect.", checkoutCartPageObj.getProductCartPrice().getText(), containsString(homepageProductPriceStored.toUpperCase()));
    }

    @And("^I choose product number \"([^\"]*)\" and store the name and price$")
    public void iChooseProductNumberAndStoreTheNameAndPrice(String index) {
        try {
            productNameStored = productResultPageObj.getSpecificProductName(driver, index);
            System.out.println("Chosen product name is: " + productNameStored);

            productPriceUnSplitStored = productResultPageObj.getSpecificProductPrice(driver, index);
            System.out.println("Chosen product price is : " + productPriceUnSplitStored);

            productResultPageObj.viewSpecificProductDetails(driver, index);

        } catch (Exception e) {
            System.out.println("Invalid product number!");
        }
    }

    @And("^I choose color \"([^\"]*)\"$")
    public void iChooseColor(String containsText) {
        productPageObj.selectColorFromDropDown(driver, containsText);
    }

    @And("^I choose size \"([^\"]*)\"$")
    public void iChooseSize(String containsText) {
        productPageObj.selectSizeFromDropDown(driver, containsText);
    }

    @Then("^The product result page name is visible in the checkout cart$")
    public void theProductResultPageNameIsVisibleInTheCheckoutCart() {
        assertThat("The product name is incorrect.", checkoutCartPageObj.getProductCartName().getText(), containsString(productNameStored.toUpperCase()));
    }

    @And("^The price from the result page is the same as the one on the list$")
    public void thePriceFromTheResultPageIsTheSameAsTheOneOnTheList() {
        assertThat("The product price is incorrect.", checkoutCartPageObj.getProductCartPrice().getText(), containsString(productPriceUnSplitStored.toUpperCase()));
    }

    @And("^I remove the first product from cart$")
    public void iRemoveTheFirstProductFromCart() {
        checkoutCartPageObj.getFirstRemoveButton().click();
    }

    @And("^I remove the second product from cart$")
    public void iRemoveTheSecondProductFromCart() {
        checkoutCartPageObj.getSecondRemoveButton().click();
    }

    @Then("^the product is removed cart$")
    public void theProductIsRemovedCart() {
        String emptyCartMsg = "SHOPPING CART IS EMPTY";
        assertThat("Product not removed", emptyCartMsg, is(checkoutCartPageObj.getPageTitle().getText()));
    }

    @And("^I click the site logo$")
    public void iClickTheSiteLogo() {
        headerObj.getSiteLogo().click();
    }

    @And("^I click the product page link$")
    public void iClickTheProductPageLink() {
        productPageObj.getProductLink().click();
    }

    @And("^I update the product quantity to \"([^\"]*)\"$")
    public void iUpdateTheProductQuantityTo(String qty) {
        updatedQuantityStored = qty;
        checkoutCartPageObj.updateQtyField(qty);
    }

    @When("^I click the update quantity button$")
    public void iClickTheUpdateQuantityButton() {
        checkoutCartPageObj.getUpdateQtyButton().click();
    }

    @Then("^The total price matches the total price of the products$")
    public void theTotalPriceMatchesTheTotalPriceOfTheProducts() {
        String[] priceSplit = productPriceUnSplitStored.split("[$]");
        productPriceSplitStored = priceSplit[1];

        float totalPrice = Float.parseFloat(priceSplit[1]) * Float.parseFloat(updatedQuantityStored);

        assertThat("Total price does not match.", checkoutCartPageObj.getTotalCartPrice().getText(), containsString(String.valueOf(totalPrice)));
    }
}