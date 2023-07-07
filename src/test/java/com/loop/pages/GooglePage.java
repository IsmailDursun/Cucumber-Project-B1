package com.loop.pages;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    @FindBy(id = "APjFqb")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='gbqfbb']/preceding-sibling::input")
    public WebElement searhcButton;

    @FindBy(xpath="//a[@class='FLP8od']")
    public WebElement capitalCity;





    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}