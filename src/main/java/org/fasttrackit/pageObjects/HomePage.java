package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//div[contains(@class, 'productClick')]")
    private List<WebElement> homepageProducts;

    public List<WebElement> getHomepageProducts() {
        return homepageProducts;
    }
}
