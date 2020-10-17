package org.fasttrackit.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.Header;
import org.fasttrackit.pageObjects.RegistrationPage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class RegistrationSteps extends TestBase {

    private Header header = PageFactory.initElements(driver, Header.class);
    private RegistrationPage register = PageFactory.initElements(driver, RegistrationPage.class);

    private String firstName = "Ana";
    private String lastName = "Pop";
    private String email = "dom";

    private String generatedFirstName;
    private String generatedLastName;
    private String generatedEmail;

    @And("^I go to Account and select Register$")
    public void iGoToAccountAndSelectRegister() {
        header.getAccount().click();
        header.getRegisterSelect().click();
    }

    @And("^I insert a first name$")
    public void iInsertAFirstName() {
        generatedFirstName = fillFormGenerator(firstName, 11);
        register.inputFirstName(generatedFirstName);

    }

    @And("^I insert a last name$")
    public void iInsertALastName() {
        generatedLastName = fillFormGenerator(lastName, 11);
        register.inputLastName(generatedLastName);
    }

    @And("^I insert an email$")
    public void iInsertAnEmail() {
        generatedEmail = fillEmailGenerator(email, 15);
        register.inputEmail(generatedEmail);
    }

    @And("^I insert a password$")
    public void iInsertAPassword() {
        register.inputPassword(fillFormGenerator("anapass", 10));
    }

    @And("^I insert a password confirmation$")
    public void iInsertAPasswordConfirmation() {
        register.inputPasswordConfirmation(fillFormGenerator("anapass", 10));
    }

    @And("^I click the news letter button$")
    public void iClickTheNewsLetterButton() {
        register.clickNewsLetterCheckBox();
    }

    @When("^I click the register button$")
    public void iClickTheRegisterButton() {
        register.clickRegisterButton();
    }

    @Then("^a confirmation message is displayed$")
    public void aConfirmationMessageIsDisplayed() {
        String expectedMsg = "Thank you for registering with Madison Island.";

        assertThat("Confirmation message not displayed.", register.getRegistrationConfirmationMsg().getText(), is(expectedMsg));
    }

    @And("^the first and last names are displayed$")
    public void theFirstNameIsDisplayed() {
        String expectedMsg = "Hello, " + generatedFirstName + " " + generatedLastName + "!";

        assertThat("First name not displayed.", register.getNamesText().getText(), is(expectedMsg));
    }

    @And("^news letter subscription is confirmed$")
    public void newsLetterSubscriptionIsConfirmed() {
        String expectedMsg = "You are currently subscribed to 'General Subscription'.";

        assertThat("News letter subscription not displayed.", register.getNewsLetterSubscribedMsg().getText(), is(expectedMsg));
    }

    @Then("^mandatory field registration errors are shown$")
    public void mandatoryFieldRegistrationErrorsAreShown() {
        String expectedMsg = "This is a required field.";

        assertThat("Mandatory error not shown for First Name.", register.getMandatoryFirstNameMsg().getText(), is(expectedMsg));
        assertThat("Mandatory error not shown for Last Name.", register.getMandatoryLastNameMsg().getText(), is(expectedMsg));
        assertThat("Mandatory error not shown for Email.", register.getMandatoryEmailMsg().getText(), is(expectedMsg));
        assertThat("Mandatory error not shown for Password.", register.getMandatoryPasswordMsg().getText(), is(expectedMsg));
        assertThat("Mandatory error not shown for Password Confirmation.", register.getMandatoryPasswordConfirmationMsg().getText(), is(expectedMsg));
    }

    @And("^I insert an invalid first name:\"([^\"]*)\"$")
    public void iInsertAnInvalidFirstName(String firstName) {
        register.inputFirstName(firstName);
    }

    @And("^I insert an invalid last name: \"([^\"]*)\"$")
    public void iInsertAnInvalidLastName(String lastName) {
        register.inputLastName(lastName);
    }

    @And("^I insert an invalid email: \"([^\"]*)\"$")
    public void iInsertAnInvalidEmail(String email) {
        register.inputEmail(email);
    }

    @And("^I insert an invalid password: \"([^\"]*)\"$")
    public void iInsertAnInvalidPassword(String password) {
        register.inputPassword(password);
    }

    @And("^I insert an invalid password confirmation: \"([^\"]*)\"$")
    public void iInsertAnInvalidPasswordConfirmation(String passwordConf) {
        register.inputPasswordConfirmation(passwordConf);
    }

    @Then("^email format error message is displayed$")
    public void emailFormatErrorMessageIsDisplayed() {
        String expectedMsg = "Please enter a valid email address. For example johndoe@domain.com.";

        assertThat("Email format error not displayed.",register.getEmailFormatErrorMsg().getText(),is(expectedMsg));
    }

    @And("^password format error message is displayed$")
    public void passwordFormatErrorMessageIsDisplayed() {
        String expectedMsg = "Please enter 6 or more characters. Leading or trailing spaces will be ignored.";

        assertThat("Password format error not displayed.",register.getPasswordFormatErrorMsg().getText(),is(expectedMsg));
    }

    @And("^confirmation error message is displayed$")
    public void confirmationErrorMessageIsDisplayed() {
        String expectedMsg= "Please make sure your passwords match.";

        assertThat("Password confirmation format error not displayed.",register.getPasswordConfirmationFormatErrorMsg().getText(),is(expectedMsg));
    }
}
