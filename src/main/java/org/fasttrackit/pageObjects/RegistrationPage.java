package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "confirmation")
    private WebElement passConfirmation;

    @FindBy(css = "#form-validate > div.buttons-set > button > span > span")
    private WebElement registerButton;

    @FindBy(id = "is_subscribed")
    private WebElement newsLetterCheckBox;

    @FindBy(css = "li:nth-child(1) > span")
    private WebElement registrationConfirmationMsg;

    @FindBy(css = ".hello")
    private WebElement namesText;

    @FindBy(css = ".col-2 p")
    private WebElement newsLetterSubscribedMsg;

    @FindBy(id = "advice-required-entry-firstname")
    private WebElement mandatoryFirstNameMsg;

    @FindBy(id = "advice-required-entry-lastname")
    private WebElement mandatoryLastNameMsg;

    @FindBy(id = "advice-required-entry-email_address")
    private WebElement mandatoryEmailMsg;

    @FindBy(id = "advice-required-entry-password")
    private WebElement mandatoryPasswordMsg;

    @FindBy(id = "advice-required-entry-confirmation")
    private WebElement mandatoryPasswordConfirmationMsg;

    @FindBy(id = "advice-validate-email-email_address")
    private  WebElement emailFormatErrorMsg;

    @FindBy(id = "advice-validate-password-password")
    private  WebElement passwordFormatErrorMsg;

    @FindBy(id = "advice-validate-cpassword-confirmation")
    private  WebElement passwordConfirmationFormatErrorMsg;

    public void inputFirstName(String keyword) {
        firstName.sendKeys(keyword);
    }

    public void inputLastName(String keyword) {
        lastName.sendKeys(keyword);
    }

    public void inputEmail(String keyword) {
        email.sendKeys(keyword);
    }

    public void inputPassword(String keyword) {
        password.sendKeys(keyword);
    }

    public void inputPasswordConfirmation(String keyword) {
        passConfirmation.sendKeys(keyword);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickNewsLetterCheckBox() {
        newsLetterCheckBox.click();
    }


    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPassConfirmation() {
        return passConfirmation;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getNewsLetterCheckBox() {
        return newsLetterCheckBox;
    }

    public WebElement getRegistrationConfirmationMsg() {
        return registrationConfirmationMsg;
    }

    public WebElement getNamesText() {
        return namesText;
    }

    public WebElement getNewsLetterSubscribedMsg() {
        return newsLetterSubscribedMsg;
    }

    public WebElement getMandatoryFirstNameMsg() {
        return mandatoryFirstNameMsg;
    }

    public WebElement getMandatoryLastNameMsg() {
        return mandatoryLastNameMsg;
    }

    public WebElement getMandatoryEmailMsg() {
        return mandatoryEmailMsg;
    }

    public WebElement getMandatoryPasswordMsg() {
        return mandatoryPasswordMsg;
    }

    public WebElement getMandatoryPasswordConfirmationMsg() {
        return mandatoryPasswordConfirmationMsg;
    }

    public WebElement getEmailFormatErrorMsg() {
        return emailFormatErrorMsg;
    }

    public WebElement getPasswordFormatErrorMsg() {
        return passwordFormatErrorMsg;
    }

    public WebElement getPasswordConfirmationFormatErrorMsg() {
        return passwordConfirmationFormatErrorMsg;
    }
}