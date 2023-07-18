package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

;


public class BrowserUtils {

    /**
     * validate if driver switched to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * implements assertion
     * note: usually we do not do validation in test method, this is for practicing purposes
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
        assertEquals(expectedTitle,driver.getTitle());
    }

    /*
     @param nameOfthePage from loop practice page
     once you on the page call it
     */
    public static void loopLinkClick(String nameOfthePage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfthePage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Moves the mouse to given element
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        new Actions(Driver.getDriver()).moveToElement(element).perform();
    }

    /**
     * Scrolls down to an element using JavaScript
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    /**
     * Clicks on an element using JavaScript
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        scrollToElement(element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**

     Performs double click action on an element
     @param element
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();}

    /**
     * waits for providing element to be visible
     * @param element
     * @param timeToWaitSec
     * return element
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
     */
    public static void waitForInVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
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

    /**
     * @param elements
     * @return list of webelementsTexts
     */
    public static List<String> getElementsText(List<WebElement> elements){
        List <String> elementsText = new ArrayList<>();
        for (WebElement each:elements) {
            elementsText.add(each.getText());
        }
        return elementsText;
    }
    public static List<String> getElementsTextWithStream (List<WebElement> elements){
        return elements.stream()
                .map(x->x.getText())
                .collect(Collectors.toList());
    }

    public static List<String> getElementsTextWithStream2 (List<WebElement> elements){
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    /**
     *method performs a screenshot anytime we need
     */
    public static void screenshot(){
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        myScenario.attach(screenshot, "image/png", myScenario.getName());
    }
    public static Scenario myScenario;
    public static void takeScreenshot(){
        try {
            //scenario coming from cucumber - JVM
            // before it was scenario.write
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
            //before it was scenario.embed
            //Since I updated fo version 2.0.4 cucumber is not able to embed screenshots
        } catch (WebDriverException wbd){
            wbd.getMessage();
        } catch (ClassCastException cce){
            cce.getMessage();
        }
    }
}