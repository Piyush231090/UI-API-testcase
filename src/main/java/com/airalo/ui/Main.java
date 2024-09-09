package com.airalo.ui;

import com.airalo.commons.URL;
import com.airalo.util.Driver;
import com.airalo.util.UIComponents;
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
            assert "Japan".equals(uiComponents.coverage.getText());
            assert "1 GB".equals(uiComponents.data.getText());
            assert "7 days".equals(uiComponents.validity.getText());
            assert "$4.50".equals(uiComponents.price.getText());
        } catch (Exception exception) {
            assert false;
        } finally {
            driver.cleanUp();
        }
    }
}
