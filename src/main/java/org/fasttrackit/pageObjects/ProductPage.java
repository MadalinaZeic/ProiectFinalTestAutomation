package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    @FindBy(className = "add-to-cart-buttons")
    private WebElement addToCartButton;

    @FindBy(css = ".h1")
    private WebElement productName;

    @FindBy(xpath = "//span[contains(@id,'product-price')]")
    private WebElement productPrice;

    @FindBy(id = "attribute92")
    private WebElement colorDropDown;

    @FindBy(id = "attribute180")
    private WebElement SizeDropDown;

    @FindBy(id = "links_21")
    private WebElement productPageLink;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getProductLink() {
        return productPageLink;
    }

    public void selectColorFromDropDown(WebDriver driver, String containsText) {
        Select colorDrp = new Select(colorDropDown);
        colorDrp.selectByVisibleText(containsText);
    }

    public void selectSizeFromDropDown(WebDriver driver, String containsText) {
        Select colorDrp = new Select(SizeDropDown);
        colorDrp.selectByVisibleText(containsText);
    }
}
