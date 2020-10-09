package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
}
