package com.airalo.ui;

import com.airalo.commons.URL;
import com.airalo.util.Driver;
import com.airalo.util.UIComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver(new ChromeDriver());
        try {
            WebDriver webDriver = driver.getDriver();

            webDriver.get(URL.BASE_UI);

            UIComponents uiComponents = new UIComponents(webDriver);

            // Handling cache window
            uiComponents.acceptButton.click();
            uiComponents.cancelButton.click();

            // Selecting country
            uiComponents.japanCountry.click();
            uiComponents.buyNowButton.click();

            assert "Moshi Moshi".equals(uiComponents.title.getText());
            //Approach 1, taking all the details in a list of webelements
            List<WebElement> details = driver.findElements(By.xpath("//ul[@class='sim-detail-info-list']"));
            assert "Japan".equals(details.get(1).getText());
            assert "1 GB".equals(details.get(3).getText());
            assert "7 days".equals(details.get(5).getText());
            assert "4.50".startsWith(details.get(7).getText());

            // Approach2, considering all webelements individually and comparing 
            assert "Japan".equals(uiComponents.coverage.getText());
            assert "1 GB".equals(uiComponents.data.getText());
            assert "7 days".equals(uiComponents.validity.getText());
            assert "4.50".startsWith(uiComponents.price.getText());
        } catch (Exception exception) {
            assert false;
        } finally {
            driver.cleanUp();
        }
    }
}
