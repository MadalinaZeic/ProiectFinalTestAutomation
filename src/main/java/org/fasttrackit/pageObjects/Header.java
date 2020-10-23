package org.fasttrackit.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(css = ".skip-account > .label")
    private WebElement account;

    @FindBy(linkText = "Log In")
    private WebElement logInSelect;

    @FindBy(linkText = "Register")
    private WebElement registerSelect;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[1]/button")
    private WebElement searchButton;

    public void searchProduct(String key) {
        searchField.sendKeys(key + Keys.ENTER);
    }

    public WebElement getAccount() {
        return account;
    }

    public WebElement getLogIn() {
        return logInSelect;
    }

    public WebElement getRegisterSelect() {
        return registerSelect;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }
}


