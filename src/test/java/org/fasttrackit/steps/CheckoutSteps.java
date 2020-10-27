package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.CheckoutCartPage;
import org.fasttrackit.pageObjects.CheckoutPage;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutSteps extends TestBase {
    private CheckoutCartPage checkoutCartPage = PageFactory.initElements(driver, CheckoutCartPage.class);
    private CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);

    @When("^I click the checkout button$")
    public void iClickTheCheckoutButton() {
        checkoutCartPage.getBottomCheckoutButton().click();
    }

    @And("^I fill the checkout form$")
    public void iFillTheCheckoutForm() {
        checkoutPage.clearCheckoutForm();
        checkoutPage.fillCheckoutForm();
    }

    @And("^I choose this shipping address$")
    public void iChooseThisShippingAddress() {
        checkoutPage.getShipToThisAddress().click();
        checkoutPage.getShippingInfoContinueButton().click();
    }

    @And("^I choose flat rate shipping method$")
    public void iChooseFlatRateShippingMethod() {
        checkoutPage.getShippingMethodContinueButton().click();
    }

    @And("^I choose cash on delivery payment method$")
    public void iChooseCashOnDeliveryPaymentMethod() {
        checkoutPage.getCashOnDeliveryPaymentOption().click();
        checkoutPage.getPaymentOptionContinueButton().click();
    }

    @When("^I click page order button$")
    public void iClickPageOrderButton() {
        checkoutPage.getPlaceOrderButton().click();
    }

    @Then("^order confirmation is received$")
    public void orderConfirmationIsReceived() {
        try {
            waitForPageToLoad(10000);
        } catch (InterruptedException e) {
            System.out.println("Page took too much to load!");
        }

        String checkoutSuccessPage = "https://demo.cart2quote.com/checkout/onepage/success/";
        String checkoutSuccessMsg = "YOUR ORDER HAS BEEN RECEIVED.";

        assertThat("Checkout success page nor reached.", driver.getCurrentUrl(), is(checkoutSuccessPage));
        assertThat("Confirmation message not displayed", checkoutPage.getOrderPlacementSuccessMsg().getText(), is(checkoutSuccessMsg));

    }
}
