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

    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
    private ProductResultPage productResultPage = PageFactory.initElements(driver, ProductResultPage.class);
    private CheckoutCartPage checkoutCartPage = PageFactory.initElements(driver, CheckoutCartPage.class);
    private Header header = PageFactory.initElements(driver, Header.class);

    public String homepageProductName;
    public String homepageProductPrice;

    public String productName;
    public String productPrice;


    @And("^I store the first product's name$")
    public void iStoreTheFirstProductSName() {
        homepageProductName = homePage.getProductText();
    }

    @And("^I store the first product's price$")
    public void iStoreTheFirstProductSPrice() {
        homepageProductPrice = homePage.getProductPrice();
    }

    @And("^I choose the first product$")
    public void iChooseTheFirstProduct() {
        homePage.getAddToCartButton().click();
    }

    @And("^I check that the web page is correct$")
    public void iCheckThatTheWebPageIsCorrect() {
        assertThat("Incorrect web page", driver.getCurrentUrl(), is(checkoutCartPage.getPageUrl()));
    }

    @And("^The product name is visible in the product page$")
    public void theProductNameIsVisibleInTheProductPage() {
        assertThat("The product name is different: ", productPage.getProductName().getText(), containsString(homepageProductName.toUpperCase()));
    }

    @And("^The product price is visible in the product page$")
    public void theProductPriceIsVisibleInTheProductPage() {
        assertThat("The product price is different: ", productPage.getProductPrice().getText(), containsString(homepageProductPrice.toUpperCase()));
    }

    @When("^I add the product to the cart$")
    public void iAddTheProductToTheCart() {
        productPage.getAddToCartButton().click();
    }

    @Then("^The product homepage name is visible in the checkout cart$")
    public void theProductHomepageNameIsVisibleInTheCheckoutCart() {
        assertThat("The product name is incorrect.", checkoutCartPage.getProductCartName().getText(), containsString(homepageProductName.toUpperCase()));
    }

    @And("^The price from homepage is the same as the one on the list$")
    public void thePriceFromHomepageIsTheSameAsTheOneOnTheList() {
        assertThat("The product price is incorrect.", checkoutCartPage.getProductCartPrice().getText(), containsString(homepageProductPrice.toUpperCase()));
    }

    @And("^I choose product number \"([^\"]*)\" and store the name and price$")
    public void iChooseProductNumberAndStoreTheNameAndPrice(String index) {
        try {
            productName = productResultPage.getSpecificProductName(driver, index);
            System.out.println("Chosen product name is: " + productName);

            productPrice = productResultPage.getSpecificProductPrice(driver, index);
            System.out.println("Chosen product price is : " + productPrice);

            productResultPage.viewSpecificProductDetails(driver, index);

        } catch (Exception e) {
            System.out.println("Invalid product number!");
        }
    }

    @And("^I choose color \"([^\"]*)\"$")
    public void iChooseColor(String containsText) {
        productPage.selectColorFromDropDown(driver, containsText);
    }

    @And("^I choose size \"([^\"]*)\"$")
    public void iChooseSize(String containsText) {
        productPage.selectSizeFromDropDown(driver, containsText);
    }

    @Then("^The product result page name is visible in the checkout cart$")
    public void theProductResultPageNameIsVisibleInTheCheckoutCart() {
        assertThat("The product name is incorrect.", checkoutCartPage.getProductCartName().getText(), containsString(productName.toUpperCase()));
    }

    @And("^The price from the result page is the same as the one on the list$")
    public void thePriceFromTheResultPageIsTheSameAsTheOneOnTheList() {
        assertThat("The product price is incorrect.", checkoutCartPage.getProductCartPrice().getText(), containsString(productPrice.toUpperCase()));
    }

    @And("^I remove the first product from cart$")
    public void iRemoveTheFirstProductFromCart() {
        checkoutCartPage.getFirstRemoveButton().click();
    }

    @And("^I remove the second product from cart$")
    public void iRemoveTheSecondProductFromCart() {
        checkoutCartPage.getSecondRemoveButton().click();
    }

    @Then("^the product is removed cart$")
    public void theProductIsRemovedCart() {
        String emptyCartMsg = "SHOPPING CART IS EMPTY";
        assertThat("Product not removed", emptyCartMsg, is(checkoutCartPage.getPageTitle().getText()));
    }

    @And("^I click the site logo$")
    public void iClickTheSiteLogo() {
        header.getSiteLogo().click();
    }

    @And("^I click the product page link$")
    public void iClickTheProductPageLink() {
        productPage.getProductLink().click();
    }
}