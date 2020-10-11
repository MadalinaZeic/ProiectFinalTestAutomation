package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {

    @FindBy(css = ".col-1 p")
    private WebElement emailConfirmation;

    public String getAccountPageUrl() {
        return "https://demo.cart2quote.com/customer/account/";
    }

    public WebElement getEmailConfirmation() {
        return emailConfirmation;
    }
}
