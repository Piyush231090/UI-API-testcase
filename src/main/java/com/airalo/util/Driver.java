package com.airalo.util;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {
    WebDriver driver;

    public Driver(WebDriver driver) {
        this.driver = driver;
        configure();
    }

    private void configure() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void cleanUp(){
        driver.close();
    }
}
