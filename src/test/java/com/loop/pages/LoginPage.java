package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class LoginPage {
    @FindBy(xpath = "//label[.='Username or email']/following-sibling::input")
    public WebElement usernameInput;

    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//div[@class='v-list-item__title']")
    public List<WebElement> leftNavigationBar;

    @FindBy(xpath = "//label[.='First name']/following-sibling::input")
    public WebElement firstName;

    @FindBy(xpath = "//label[.='Last name']/following-sibling::input")
    public WebElement lastName;

    @FindBy(xpath = "//label[.='Email address']/following-sibling::input")
    public WebElement email;

    @FindBy(xpath = "//label[.='Phone number']/following-sibling::input")
    public WebElement phoneNumber;

    @FindBy(xpath = "//label[.='Confirm password']/following-sibling::input")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[.='Clients']/..")
    public WebElement clientButton;

    @FindBy(xpath = "(//span[.='Create new client'])[2]")
    public WebElement createNewClient;

    @FindBy(xpath = "//span[.='Personal']")
    public WebElement personalButton;

    @FindBy(xpath = "//label[.='Create new user']")
    public  WebElement checkBox;

    @FindBy(xpath = "//label[.='Advisor']/..")
    public WebElement advisorDropdown;

    @FindBy(xpath = "(//div[.='Batch1 Group3'])[2]")
    public WebElement batch1Group3;

    @FindBy(xpath = "//span[.='Ali Veli has been created successfully']")
    public  WebElement firstSuccessMessage;

    @FindBy(xpath = "//label[.='Services']/following-sibling::div")
    public WebElement serviceButton;

    @FindBy(xpath = "(//div[.='Consultancy']/../../div)[4]")
    public WebElement consultancyButton;

    @FindBy(xpath = "//label[.='Advisor']/..")
    public WebElement secondTimeAdvisor;

    @FindBy(xpath = "//span[.='Ali Veli has been updated successfully']")
    public WebElement successMessage;

    @FindBy(xpath = "(//span[.='Batch1 Group3'])[1]")
    public WebElement bGButton;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOut;

    @FindBy(xpath = "//span[.=' Save ']")
    public WebElement saveButtonEnd;


    @FindBy(xpath = "//span[.='Home']")
    public WebElement homeButton1;

    @FindBy(xpath = "//span[.='Received docs']")
    public WebElement receivedDocsButton;

    @FindBy(xpath = "//i/following-sibling::span[.='Search']")
    public WebElement searchButtonInreceivedDocs;

    @FindBy(xpath = "//i/following-sibling::span[.='Download']")
    public WebElement downloadButtonInreceivedDocs;

    @FindBy(xpath = "//h1[.='Received docs']")
    public WebElement ReceivedDocsText;




    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    public void loginDocuport(String username, String password) {
        BrowserUtils.waitForVisibility(usernameInput, 5);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        BrowserUtils.waitForClickable(loginButton, 5);
        BrowserUtils.clickWithJS(loginButton);
    }

    public String getleftBar(String leftBar) {
        return Driver.getDriver().findElement(By.xpath("//span[.='" + leftBar + "']")).getText();
    }

}