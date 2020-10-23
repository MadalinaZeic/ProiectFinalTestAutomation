package org.fasttrackit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public String fillFormGenerator(String input, int endIndex) {

        String suffixGenerator = input + System.nanoTime();

        return suffixGenerator.substring(0, endIndex);
    }

    public String fillEmailGenerator(String input, int endIndex) {
        String suffixGenerator = input + System.nanoTime();
        return suffixGenerator.substring(0, endIndex) + "@cocox.com";
    }

    public List<String> checkListForText(List<String> list, String text) {
        List<String> newList = new ArrayList<>();

        for (String element : list) {
            if (element.contains(text)) {
                newList.add(element);
            }
        }
        return newList;
    }
}