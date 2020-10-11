package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {

    private String logInUrl = "https://demo.cart2quote.com/customer/account/login/";

    @FindBy(css = "h1")
    private WebElement loginPageTitle;

    @FindBy (id ="email" )
    private WebElement loginEmail;

    @FindBy(id="pass")
    private WebElement loginPass;


    @FindBy(id="send2")
    private WebElement loginButtonSubmit;

    public WebElement getLoginEmail() {
        return loginEmail;
    }

    public WebElement getLoginPass() {
        return loginPass;
    }

    public WebElement getLoginButtonSubmit() {
        return loginButtonSubmit;
    }

    public WebElement getLoginPageTitle() {
        return loginPageTitle;
    }

    public String getLogInUrl() {
        return logInUrl;
    }
}
