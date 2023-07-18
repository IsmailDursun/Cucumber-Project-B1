package com.loop.step_definitions;

import com.loop.pages.GooglePage;
import com.loop.utilities.*;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.util.*;

public class GoogleSearchStepDefs {
    GooglePage googlePage = new GooglePage();
    private static final Logger LOG = LogManager.getLogger();

    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));  //this will run from conf.properties
//        Driver.getDriver().get(System.getenv("url")); // this will read from Jenkins
//        Driver.getDriver().get(System.getProperty("url"));  //this will also read from Jenkins
        LOG.info("User is on Google page");
    }

    @When("user types loop academy in the google search box and click enter")
    public void user_types_loop_academy_in_the_google_search_box_and_click_enter() throws InterruptedException {
        googlePage.searchBox.sendKeys("Loop Academy"+Keys.ENTER);
        LOG.info("User types input to Google page");
    }

    @Then("User should see Loop Academy - Google Search is in the google title")
    public void user_should_see_loop_academy_google_search_is_in_the_google_title() {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Loop Academy - Google Search", actualTitle);
        LOG.info("User sees the results");
    }

    @When("user types {string} in the google search box and click enter")
    public void user_types_in_the_google_search_box_and_click_enter(String input) {
        googlePage.searchBox.sendKeys(input + Keys.ENTER);
//        googlePage.searchBox.sendKeys(System.getProperty("fromJenkins")+Keys.ENTER); //This will read from Jenkins config

    }
    @Then("User should see {string} in the google title")
    public void user_should_see_in_the_google_title(String title) {
        Assert.assertEquals("Expected does not match actual",title,Driver.getDriver().getTitle());
    }

    @Then("user search the following items")
    public void user_search_the_following_items(List <Map<String, String>>items) {

        for (Map<String, String> item : items) {
            System.out.println(item.get("items"));
            googlePage.searchBox.clear();
            googlePage.searchBox.sendKeys(item.get("items") + Keys.ENTER);
        }
    }

//    public void user_search_the_following_items(List <String> items) {
//        items.forEach(p -> {googlePage.searchBox.clear();
//                            googlePage.searchBox.sendKeys(p + Keys.ENTER);
//                            Assert.assertTrue(Driver.getDriver().getTitle().contains(p));
//                            });
//    }

    @When("users search for the {string}")
    public void users_search_for_the(String country) throws InterruptedException {
        googlePage.searchBox.sendKeys("What is the capital of " + country + Keys.ENTER);
        LOG.info("User searches for "+country);
        Thread.sleep(3000);
    }
    @Then("user should see the {string} in the result")
    public void user_should_see_the_in_the_result(String capital) {
        Assert.assertEquals(googlePage.capitalCity.getText(), capital);
        LOG.info("User should see the "+capital);
    }
}
