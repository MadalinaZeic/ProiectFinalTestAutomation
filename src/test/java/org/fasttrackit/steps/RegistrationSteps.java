package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.Header;
import org.fasttrackit.pageObjects.RegistrationPage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationSteps extends TestBase {

    private Header headerObj = PageFactory.initElements(driver, Header.class);
    private RegistrationPage registerObj = PageFactory.initElements(driver, RegistrationPage.class);

    private String firstName = "Ana";
    private String lastName = "Pop";
    private String email = "dom";

    private String generatedFirstNameStored;
    private String generatedLastNameStored;
    private String generatedEmailStored;

    @And("^I go to Account and select Register$")
    public void iGoToAccountAndSelectRegister() {
        headerObj.getAccount().click();
        headerObj.getRegisterSelect().click();
    }

    @And("^I insert a first name$")
    public void iInsertAFirstName() {
        generatedFirstNameStored = fillFormGenerator(firstName, 11);
        registerObj.inputFirstName(generatedFirstNameStored);

    }

    @And("^I insert a last name$")
    public void iInsertALastName() {
        generatedLastNameStored = fillFormGenerator(lastName, 11);
        registerObj.inputLastName(generatedLastNameStored);
    }

    @And("^I insert an email$")
    public void iInsertAnEmail() {
        generatedEmailStored = fillEmailGenerator(email, 15);
        registerObj.inputEmail(generatedEmailStored);
    }

    @And("^I insert a password$")
    public void iInsertAPassword() {
        registerObj.inputPassword(fillFormGenerator("anapass", 10));
    }

    @And("^I insert a password confirmation$")
    public void iInsertAPasswordConfirmation() {
        registerObj.inputPasswordConfirmation(fillFormGenerator("anapass", 10));
    }

    @And("^I click the news letter button$")
    public void iClickTheNewsLetterButton() {
        registerObj.clickNewsLetterCheckBox();
    }

    @When("^I click the register button$")
    public void iClickTheRegisterButton() {
        registerObj.clickRegisterButton();
    }

    @Then("^a confirmation message is displayed$")
    public void aConfirmationMessageIsDisplayed() {
        String expectedMsg = "Thank you for registering with Madison Island.";

        assertThat("Confirmation message not displayed.", registerObj.getRegistrationConfirmationMsg().getText(), is(expectedMsg));
    }

    @And("^the first and last names are displayed$")
    public void theFirstNameIsDisplayed() {
        String expectedMsg = "Hello, " + generatedFirstNameStored + " " + generatedLastNameStored + "!";

        assertThat("First name not displayed.", registerObj.getNamesText().getText(), is(expectedMsg));
    }

    @And("^news letter subscription is confirmed$")
    public void newsLetterSubscriptionIsConfirmed() {
        String expectedMsg = "You are currently subscribed to 'General Subscription'.";

        assertThat("News letter subscription not displayed.", registerObj.getNewsLetterSubscribedMsg().getText(), is(expectedMsg));
    }

    @Then("^mandatory field registration errors are shown$")
    public void mandatoryFieldRegistrationErrorsAreShown() {
        String expectedMsg = "This is a required field.";

        assertThat("Mandatory error not shown for First Name.", registerObj.getMandatoryFirstNameMsg().getText(), is(expectedMsg));
        assertThat("Mandatory error not shown for Last Name.", registerObj.getMandatoryLastNameMsg().getText(), is(expectedMsg));
        assertThat("Mandatory error not shown for Email.", registerObj.getMandatoryEmailMsg().getText(), is(expectedMsg));
        assertThat("Mandatory error not shown for Password.", registerObj.getMandatoryPasswordMsg().getText(), is(expectedMsg));
        assertThat("Mandatory error not shown for Password Confirmation.", registerObj.getMandatoryPasswordConfirmationMsg().getText(), is(expectedMsg));
    }

    @And("^I insert an invalid first name:\"([^\"]*)\"$")
    public void iInsertAnInvalidFirstName(String firstName) {
        registerObj.inputFirstName(firstName);
    }

    @And("^I insert an invalid last name: \"([^\"]*)\"$")
    public void iInsertAnInvalidLastName(String lastName) {
        registerObj.inputLastName(lastName);
    }

    @And("^I insert an invalid email: \"([^\"]*)\"$")
    public void iInsertAnInvalidEmail(String email) {
        registerObj.inputEmail(email);
    }

    @And("^I insert an invalid password: \"([^\"]*)\"$")
    public void iInsertAnInvalidPassword(String password) {
        registerObj.inputPassword(password);
    }

    @And("^I insert an invalid password confirmation: \"([^\"]*)\"$")
    public void iInsertAnInvalidPasswordConfirmation(String passwordConf) {
        registerObj.inputPasswordConfirmation(passwordConf);
    }

    @Then("^email format error message is displayed$")
    public void emailFormatErrorMessageIsDisplayed() {
        String expectedMsg = "Please enter a valid email address. For example johndoe@domain.com.";

        assertThat("Email format error not displayed.", registerObj.getEmailFormatErrorMsg().getText(),is(expectedMsg));
    }

    @And("^password format error message is displayed$")
    public void passwordFormatErrorMessageIsDisplayed() {
        String expectedMsg = "Please enter 6 or more characters. Leading or trailing spaces will be ignored.";

        assertThat("Password format error not displayed.", registerObj.getPasswordFormatErrorMsg().getText(),is(expectedMsg));
    }

    @And("^confirmation error message is displayed$")
    public void confirmationErrorMessageIsDisplayed() {
        String expectedMsg= "Please make sure your passwords match.";

        assertThat("Password confirmation format error not displayed.", registerObj.getPasswordConfirmationFormatErrorMsg().getText(),is(expectedMsg));
    }
}
