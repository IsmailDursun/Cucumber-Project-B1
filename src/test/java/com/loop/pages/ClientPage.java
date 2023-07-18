package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {
    private final String CHOOSEACCOUNT = "//h3[.='Choose account']";
    public ClientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = CHOOSEACCOUNT)
    public WebElement chooseAccountText;
    @FindBy(xpath = "//span[.=' Continue ']")
    public WebElement continueButton;
}
