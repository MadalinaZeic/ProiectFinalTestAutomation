package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    @FindBy(id = "billing:street1")
    private WebElement addressField;

    @FindBy(id = "billing:city")
    private WebElement cityField;

    @FindBy(id = "billing:region_id")
    private WebElement regionField;

    @FindBy(id = "billing:postcode")
    private WebElement postCodeField;

    @FindBy(id = "billing:country_id")
    private WebElement countryField;

    @FindBy(id = "billing:telephone")
    private WebElement telephoneField;

    @FindBy(css = ".form-list:nth-child(2) > .control:nth-child(3) > label")
    private WebElement shipToThisAddress;

    @FindBy(css = "#billing-buttons-container span > span")
    private WebElement shippingInfoContinueButton;

    @FindBy(css = "dd:nth-child(4) .price")
    private WebElement shippingFlatRageMethod;

    @FindBy(css = "#shipping-method-buttons-container span > span")
    private WebElement shippingMethodContinueButton;

    @FindBy(css = "#dt_method_cashondelivery > label")
    private WebElement cashOnDeliveryPaymentOption;

    @FindBy(css = "#payment-buttons-container span > span")
    private WebElement paymentOptionContinueButton;

    @FindBy(css = ".btn-checkout > span > span")
    private WebElement placeOrderButton;

    @FindBy(css = "h1")
    private WebElement orderPlacementSuccessMsg;

    @FindBy(id = "advice-required-entry-billing:street1")
    private WebElement addressFieldValidation;

    @FindBy(id = "advice-validate-select-billing:region_id")
    private WebElement regionFieldValidation;

    public void fillCheckoutForm() {
        Select dropDownRegion = new Select(regionField);
        Select dropDownCountry = new Select(countryField);

        addressField.sendKeys("Home123");
        cityField.sendKeys("Cluj-Napoca");
        dropDownRegion.selectByVisibleText("Alabama");
        postCodeField.sendKeys("400400");
        dropDownCountry.selectByVisibleText("United States");
        telephoneField.sendKeys("052695124");
    }

    public void clearCheckoutForm() {
        addressField.clear();
        cityField.clear();
        postCodeField.clear();
        telephoneField.clear();
    }

    public WebElement getAddressFieldValidation() {
        return addressFieldValidation;
    }

    public WebElement getRegionFieldValidation() {
        return regionFieldValidation;
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getShipToThisAddress() {
        return shipToThisAddress;
    }

    public WebElement getShippingInfoContinueButton() {
        return shippingInfoContinueButton;
    }

    public WebElement getShippingFlatRageMethod() {
        return shippingFlatRageMethod;
    }

    public WebElement getShippingMethodContinueButton() {
        return shippingMethodContinueButton;
    }

    public WebElement getCashOnDeliveryPaymentOption() {
        return cashOnDeliveryPaymentOption;
    }

    public WebElement getPaymentOptionContinueButton() {
        return paymentOptionContinueButton;
    }

    public WebElement getPlaceOrderButton() {
        return placeOrderButton;
    }

    public WebElement getAddressField() {
        return addressField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getRegionField() {
        return regionField;
    }

    public WebElement getPostCodeField() {
        return postCodeField;
    }

    public WebElement getTelephoneField() {
        return telephoneField;
    }

    public WebElement getOrderPlacementSuccessMsg() {
        return orderPlacementSuccessMsg;
    }
}
