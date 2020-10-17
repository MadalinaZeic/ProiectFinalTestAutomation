package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Header {

    @FindBy(css = ".skip-account > .label")
    private WebElement account;

    @FindBy(linkText = "Log In")
    private WebElement logInSelect;

    @FindBy(linkText = "Register")
    private WebElement registerSelect;

    public WebElement getAccount() {
        return account;
    }

    public WebElement getLogIn() {
        return logInSelect;
    }

    public WebElement getRegisterSelect() {
        return registerSelect;
    }
}


