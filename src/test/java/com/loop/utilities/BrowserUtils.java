package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class BrowserUtils {
    /**
     * validate if driver switched to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Vlad
     * implements assertion
     * note: usually we do not do validation in t\method, this is for practicing purposes
     */
    public static void switchWindowAndValidate(WebDriver driver,String expectedUrl, String expectedTitle){
        expectedUrl = expectedUrl.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();

        Set<String> windowHandles = driver.getWindowHandles();

        for(String each : windowHandles){
            driver.switchTo().window(each);

            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }

       assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

    }

    /**
     * switches to new window by the exact title
     * return to original window if windows with give title not found
     * @param driver
     * @param targetTitle
     * author Vlad
     */
    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);
    }
    public static void validateTitle(WebDriver driver, String expectedTitle){
        assertEquals(driver.getTitle(),expectedTitle);
    }

    /**
     *

     @param nameOfthePage from loop practice page
     once you on the page call it
     @nsh*/
    public static void loopLinkClick(String nameOfthePage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfthePage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
     }

    /**
     * Moves the mouse to given element
     * @param element on which to hover
     * @author Vlad
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to an element using JavaScript
     * @param element
     * @author Vlad
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    /**
     * Clicks on an element using JavaScript
     * @param element
     * @author nsh
     */
    public static void clickWithJS(WebElement element) {
  scrollToElement(element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**

     Performs double click action on an element
     @param element
     @author nsh*/
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();}

    /**
     * waits for providing element to be visible
     * @param element
     * @param timeToWaitSec
     * return element
     * @author Nadir
     */
    public static WebElement waitForVisibility(WebElement element,int timeToWaitSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author nsh
     */
    public static void waitForInVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * method that will wait untill the element becomes clickable
     * @param element
     * @param timeOut
     * @return
     * @auth Vlad
     */
    public static WebElement waitForClickable(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     *method performs a pause
     * @param seconds
     * @throws InterruptedException
     */
    public static void justWait(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }




}
