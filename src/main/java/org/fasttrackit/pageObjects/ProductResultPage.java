package org.fasttrackit.pageObjects;

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

    @FindBy(css = ".products-grid .price")
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
}
