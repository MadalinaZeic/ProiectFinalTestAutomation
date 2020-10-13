package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {

    public String getLogInUrl() {
        return "https://demo.cart2quote.com/customer/account/login/";
    }

    @FindBy(css = "h1")
    private WebElement loginPageTitle;

    @FindBy(id = "email")
    private WebElement loginEmail;

    @FindBy(id = "pass")
    private WebElement loginPass;

    @FindBy(id = "send2")
    private WebElement loginButtonSubmit;

    @FindBy(id = "advice-validate-email-email")
    private WebElement invalidEmailMsg;

    @FindBy(id = "advice-validate-password-pass")
    private WebElement invalidPasswordMsg;

    @FindBy(id = "advice-required-entry-email")
    private WebElement mandatoryEmailMsg;

    @FindBy(id = "advice-required-entry-pass")
    private WebElement mandatoryPasswordMsg;

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

    public WebElement getInvalidEmailMsg() {
        return invalidEmailMsg;
    }

    public WebElement getInvalidPasswordMsg() {
        return invalidPasswordMsg;
    }

    public WebElement getMandatoryEmailMsg() {
        return mandatoryEmailMsg;
    }

    public WebElement getMandatoryPasswordMsg() {
        return mandatoryPasswordMsg;
    }
}