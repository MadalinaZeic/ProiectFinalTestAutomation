package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageObjects.AccountPage;
import org.fasttrackit.pageObjects.Header;
import org.fasttrackit.pageObjects.LogInPage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogInSteps extends TestBase {

    private Header header = PageFactory.initElements(driver, Header.class);
    private LogInPage logIn = PageFactory.initElements(driver, LogInPage.class);
    private AccountPage accountPage = PageFactory.initElements(driver, AccountPage.class);

    String validEmail;
    String validPassword;

    @And("^I go to Account and select LogIn$")
    public void iGoToAccountAndSelectLogIn() {
        header.getAccount().click();
        header.getLogIn().click();
    }

    @And("^I check that the login page is opened$")
    public void iCheckThatTheLoginPageIsOpened() {
        assertThat("The Log In page is not opened.", driver.getCurrentUrl(), is(logIn.getLogInUrl()));
    }

    @And("^I insert an email: \"([^\"]*)\"$")
    public void iInsertAnExistingEmail(String email) {
        logIn.getLoginEmail().sendKeys(email);

        validEmail = email;
    }

    @And("^I insert an password: \"([^\"]*)\"$")
    public void iInsertAnExistingPassword(String pass) {
        logIn.getLoginPass().sendKeys(pass);

        validPassword = pass;
    }

    @When("^I click the login button$")
    public void iClickTheLoginButton() {
        logIn.getLoginButtonSubmit().click();
    }

    @Then("^the Account Page is opened$")
    public void theAccountPageIsOpened() {
        assertThat("Account Page is not opened", driver.getCurrentUrl(), is(accountPage.getAccountPageUrl()));
    }

    @And("^the chosen email is shown$")
    public void theChosenEmailIsShown() {
        assertThat("Incorrect name result.", accountPage.getEmailConfirmation().getText(), containsString(validEmail));
    }

    @Then("^an invalid email error message is shown$")
    public void anInvalidEmailErrorMessageIsShown() {
        String invalidEmailMsg = "Please enter a valid email address. For example johndoe@domain.com.";

        assertThat("The invalid email message is not displayed.", logIn.getInvalidEmailMsg().getText(), is(invalidEmailMsg));
    }

    @Then("^an invalid password error message is shown$")
    public void anInvalidPasswordErrorMessageIsShown() {
        String invalidPassMsg = "Please enter 6 or more characters. Leading or trailing spaces will be ignored.";

        assertThat("The invalid password message is not displayed.", logIn.getInvalidPasswordMsg().getText(), is(invalidPassMsg));
    }

    @Then("^error messages are shown for the mandatory login fields$")
    public void errorMessagesAreShownForTheMandatoryLoginFields() {
        String errorMsg = "This is a required field.";

        assertThat("The mandatory email error messages are not shown.", logIn.getMandatoryEmailMsg().getText(), is(errorMsg));
        assertThat("The mandatory password error messages are not shown.", logIn.getMandatoryPasswordMsg().getText(), is(errorMsg));
    }
}
