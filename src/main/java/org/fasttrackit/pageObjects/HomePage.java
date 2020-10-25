package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//div[contains(@class, 'productClick')]")
    private List<WebElement> homepageProducts;

    @FindBy(css = ".pt1 .add-to-yes")
    private WebElement addToCartButton;

    @FindBy(css = ".pt1 .product-type")
    private WebElement productText;

    public List<WebElement> getHomepageProducts() {
        return homepageProducts;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public String getProductText() {
        String[] productName = productText.getText().split("[\\n][$]");

        return productName[0];
    }

    public String getProductPrice() {
        String[] productPrice = productText.getText().split("[\\n][$]");

        return productPrice[1];
    }

}