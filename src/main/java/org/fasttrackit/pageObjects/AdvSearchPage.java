package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdvSearchPage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "price")
    private WebElement minPrice;

    @FindBy(id = "price_to")
    private WebElement maxPrice;

    @FindBy(id = "color")
    private WebElement color;

    @FindBy(id = "gender")
    private WebElement gender;

    @FindBy(css = ".buttons-set span > span")
    private WebElement searchButton;

    @FindBy(css = ".advanced-search-amount > strong")
    private WebElement productsFoundMessage;

    @FindBy(xpath = "//div[2]/ul/li")
    private WebElement nameResult;

    @FindBy(xpath = "//div[2]/ul/li[2]")
    private WebElement priceResult;

    @FindBy(xpath = "//ul[2]/li")
    private WebElement colorResult;

    @FindBy(xpath = "//ul[2]/li[2]")
    private WebElement genderResult;

    @FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']")
    private List<WebElement> advSearchProductsGrid;

    @FindBy(xpath = "//li[@class='error-msg']")
    private WebElement emptyFormErrorMsg;

    @FindBy(xpath = "//p[@class='error-msg']")
    private WebElement noItemsFoundMsg;

    public void insertText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public Select selectItem(WebElement element) {
        return new Select(element);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getMinPrice() {
        return minPrice;
    }

    public WebElement getMaxPrice() {
        return maxPrice;
    }

    public WebElement getColor() {
        return color;
    }

    public WebElement getGender() {
        return gender;
    }

    public WebElement getProductsFoundMessage() {
        return productsFoundMessage;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getNameResult() {
        return nameResult;
    }

    public WebElement getPriceResult() {
        return priceResult;
    }

    public WebElement getColorResult() {
        return colorResult;
    }

    public WebElement getGenderResult() {
        return genderResult;
    }

    public List<WebElement> getAdvSearchProductsGrid() {
        return advSearchProductsGrid;
    }

    public WebElement getEmptyFormErrorMsg() {
        return emptyFormErrorMsg;
    }

    public WebElement getNoItemsFoundMsg() {
        return noItemsFoundMsg;
    }
}
