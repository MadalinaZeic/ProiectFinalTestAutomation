package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCartPage {

    public String getPageUrl() {
        return "https://demo.cart2quote.com/checkout/cart/";
    }

    @FindBy(css = ".product-name:nth-child(2) > a")
    private WebElement productCartName;

    @FindBy(css = ".product-cart-price .price")
    private WebElement productCartPrice;

    @FindBy(className = "page-title")
    private WebElement pageTitle;

    @FindBy(xpath = "//tr[contains(@class,'first')]//td[@class='a-center product-cart-remove last']//a[@title='Remove Item']")
    private WebElement firstRemoveButton;

    @FindBy(css = ".last.even .a-center a")
    private WebElement secondRemoveButton;

    @FindBy(css = ".product-cart-actions > .input-text")
    private WebElement quantityField;

    @FindBy(css = ".product-cart-actions > .button")
    private WebElement updateQtyButton;

    @FindBy(css = "tr:nth-child(1) strong > .price")
    private WebElement totalCartPrice;

    @FindBy(css = ".top span > span")
    private WebElement topCheckoutButton;

    @FindBy(css = ".method-checkout-cart-methods-onepage-bottom span > span")
    private WebElement bottomCheckoutButton;

    public void updateQtyField(String updQty) {
        quantityField.clear();
        quantityField.sendKeys(updQty);
    }

    public WebElement getProductCartName() {
        return productCartName;
    }

    public WebElement getProductCartPrice() {
        return productCartPrice;
    }

    public WebElement getFirstRemoveButton() {
        return firstRemoveButton;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getSecondRemoveButton() {
        return secondRemoveButton;
    }

    public WebElement getQuantityField() {
        return quantityField;
    }

    public WebElement getUpdateQtyButton() {
        return updateQtyButton;
    }

    public WebElement getTotalCartPrice() {
        return totalCartPrice;
    }

    public WebElement getTopCheckoutButton() {
        return topCheckoutButton;
    }

    public WebElement getBottomCheckoutButton() {
        return bottomCheckoutButton;
    }
}
