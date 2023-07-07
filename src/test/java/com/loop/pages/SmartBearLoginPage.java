package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage extends SmartBearBasePage{

    public SmartBearLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='ctl00_MainContent_username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_login_button']")
    public WebElement loginButton;

    public void login (String username,String password){
        BrowserUtils.waitForVisibility(usernameBox, 10);
        usernameBox.clear();
        usernameBox.sendKeys(username);
        passwordBox.clear();
        passwordBox.sendKeys(password);
        BrowserUtils.waitForClickable(loginButton, 10);
        BrowserUtils.clickWithJS(loginButton);
    }
}
