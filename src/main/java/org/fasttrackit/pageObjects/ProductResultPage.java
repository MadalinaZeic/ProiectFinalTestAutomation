package org.fasttrackit.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductResultPage {

    @FindBy(className = "page-title")
    private WebElement productResultPageTitle;

    @FindBy(className = "note-msg")
    private WebElement productResultPageTitleMsg;

    @FindBy(xpath = "//ul[contains(@class,'products-grid')]")
    private List<WebElement> productsGridResults;

    @FindBy(css = ".product-name > a")
    private List<WebElement> productGridNameContainer;

    @FindBy(xpath = "//span[contains(@id,'product-price')]")
    private List<WebElement> productGridPriceContainer;

    public WebElement getProductResultPageTitle() {
        return productResultPageTitle;
    }

    public WebElement getProductResultPageTitleMsg() {
        return productResultPageTitleMsg;
    }

    public List<WebElement> getProductsGridResults() {
        return productsGridResults;
    }

    public List<WebElement> getProductGridNameContainer() {
        return productGridNameContainer;
    }

    public List<WebElement> getProductGridPriceContainer() {
        return productGridPriceContainer;
    }

    public List<String> getProductResultsNames() {
        List<String> names = new ArrayList<>();

        for (WebElement nameContainers : productGridNameContainer) {
            String name = nameContainers.getText();
            names.add(name);
        }
        return names;
    }

    public void viewSpecificProductDetails(WebDriver driver, String index) {
        driver.findElement(By.cssSelector(".item:nth-child(" + index + ") .button")).click();
    }

    public String getSpecificProductName(WebDriver driver, String index) {
        return driver.findElement(By.cssSelector(".item:nth-child(" + index + ") > .product-info > .product-name > a")).getText();
    }

    public String getSpecificProductPrice(WebDriver driver, String index) {
        int ConvertedIndex = Integer.parseInt(index) - 1;
        return productGridPriceContainer.get(ConvertedIndex).getText();
    }
}
