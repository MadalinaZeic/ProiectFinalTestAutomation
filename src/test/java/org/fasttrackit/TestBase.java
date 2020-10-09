package org.fasttrackit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase {

    protected WebDriver driver = DriverFactory.getDriver();

    public void openHomepage() {
        driver.get(AppConfig.getSiteURL());

        closePopUp();

        System.out.println("Homepage Opened");
    }

    public void closePopUp() {
        WebElement popUpCloseButton;

        try {
            popUpCloseButton = driver.findElement(By.xpath("//button[@class='btn btn-close']"));
            popUpCloseButton.click();
        } catch (Exception e) {
            System.out.println("Homepage pop-up not displayed!");
        }
    }
}
