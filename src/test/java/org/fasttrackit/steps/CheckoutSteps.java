package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.CheckoutCartPage;
import org.fasttrackit.pageObjects.CheckoutPage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutSteps extends TestBase {
    private CheckoutCartPage checkoutCartPageObj = PageFactory.initElements(driver, CheckoutCartPage.class);
    private CheckoutPage checkoutPageObj = PageFactory.initElements(driver, CheckoutPage.class);

    @When("^I click the checkout button$")
    public void iClickTheCheckoutButton() {
        checkoutCartPageObj.getBottomCheckoutButton().click();
    }

    @And("^I fill the checkout form$")
    public void iFillTheCheckoutForm() {
        checkoutPageObj.clearCheckoutForm();
        checkoutPageObj.fillCheckoutForm();
    }

    @And("^I choose this shipping address$")
    public void iChooseThisShippingAddress() {
        checkoutPageObj.getShipToThisAddress().click();
        checkoutPageObj.getShippingInfoContinueButton().click();

        try {
            waitForPageToLoad(5000);
        } catch (InterruptedException e) {
            System.out.println("Page took too much to load!");
        }
    }

    @And("^I choose flat rate shipping method$")
    public void iChooseFlatRateShippingMethod() {
        checkoutPageObj.getShippingMethodContinueButton().click();
        try {
            waitForPageToLoad(5000);
        } catch (InterruptedException e) {
            System.out.println("Page took too much to load!");
        }
    }

    @And("^I choose cash on delivery payment method$")
    public void iChooseCashOnDeliveryPaymentMethod() {
        checkoutPageObj.getCashOnDeliveryPaymentOption().click();
        checkoutPageObj.getPaymentOptionContinueButton().click();

        try {
            waitForPageToLoad(5000);
        } catch (InterruptedException e) {
            System.out.println("Page took too much to load!");
        }
    }

    @When("^I click page order button$")
    public void iClickPageOrderButton() {
        checkoutPageObj.getPlaceOrderButton().click();
    }

    @Then("^order confirmation is received$")
    public void orderConfirmationIsReceived() {
        try {
            waitForPageToLoad(5000);
        } catch (InterruptedException e) {
            System.out.println("Page took too much to load!");
        }

        String checkoutSuccessPage = "https://demo.cart2quote.com/checkout/onepage/success/";
        String checkoutSuccessMsg = "YOUR ORDER HAS BEEN RECEIVED.";

        assertThat("Checkout success page nor reached.", driver.getCurrentUrl(), is(checkoutSuccessPage));
        assertThat("Confirmation message not displayed", checkoutPageObj.getOrderPlacementSuccessMsg().getText(), is(checkoutSuccessMsg));

    }

    @When("^I clear the checkout form$")
    public void iClearTheCheckoutForm() {
        checkoutPageObj.clearCheckoutForm();
    }

    @Then("^error messages are shown for the mandatory checkout fields$")
    public void errorMessagesAreShownForTheMandatoryCheckoutFields() {
        String requiredFieldErrorMsg = "This is a required field.";
        String pleaseSelectOptionErrorMsg = "Please select an option.";

        assertThat("Mandatory field not highlighted.",requiredFieldErrorMsg,is(checkoutPageObj.getAddressFieldValidation().getText()));
        assertThat("Mandatory field not highlighted.",pleaseSelectOptionErrorMsg,is(checkoutPageObj.getRegionFieldValidation().getText()));
    }
}
