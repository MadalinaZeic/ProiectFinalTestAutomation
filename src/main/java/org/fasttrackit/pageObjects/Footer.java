package org.fasttrackit.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer {

    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    private WebElement advanceSearch;

    public void clickAdvanceSearch() {
        advanceSearch.click();
    }
}
