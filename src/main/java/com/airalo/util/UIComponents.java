package com.airalo.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class UIComponents {

    @FindBy(xpath = "//div[@class='sim-detail-operator']//p[contains(text(),'Moshi Moshi')]")
    public WebElement title;

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    public WebElement acceptButton;

    @FindBy(xpath = "//*[@id='wzrk-cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//p[normalize-space()='Japan']")
    public WebElement japanCountry;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='BUY NOW'])[1]")
    public WebElement buyNowButton;

    @FindBy(xpath = "//div[@class='c--sim_item-row sim-item-row light']//p[@class='value sim-item-row-right-value ltr:!tw-ml-auto rtl:!tw-mr-auto overflow-hidden'][normalize-space()='Japan']")
    public WebElement coverage;

    @FindBy(xpath = "//ul[@class='sim-detail-info-list']//p[@class='value sim-item-row-right-value ltr:!tw-ml-auto rtl:!tw-mr-auto overflow-hidden'][normalize-space()='1 GB']")
    public WebElement data;

    @FindBy(xpath = "//ul[@class='sim-detail-info-list']//p[@class='value sim-item-row-right-value ltr:!tw-ml-auto rtl:!tw-mr-auto overflow-hidden'][normalize-space()='7 Days']")
    public WebElement validity;

    @FindBy(xpath = "//ul[@class='sim-detail-info-list']//p[@class='value sim-item-row-right-value ltr:!tw-ml-auto rtl:!tw-mr-auto price overflow-hidden'][contains(text(),'4.50 €')]")
    public WebElement price;

    public UIComponents(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}