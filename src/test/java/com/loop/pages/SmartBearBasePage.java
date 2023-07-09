package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class SmartBearBasePage {
    public SmartBearBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//a[contains(text(), 'View all orders')]")
    public WebElement viewAllOrders;

    @FindBy(xpath = "//a[contains(text(), 'View all products')]")
    public WebElement viewAllProducts;
    @FindBy(xpath = "//a[contains(text(), 'Order')]")
    public WebElement order;

    @FindBy(id = "ct100_logout")
    public WebElement logout;

    @FindBy(xpath = "//h1[contains(text(),'Web Orders')]")
    public WebElement webOrders;

}