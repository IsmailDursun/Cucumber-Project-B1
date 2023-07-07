package com.loop.step_definitions;

import com.loop.pages.GooglePage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import javax.swing.*;
import java.util.List;
import java.util.Map;


public class GoogleSearchStepDefs {

    GooglePage googlePage = new GooglePage();

    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
    }
    @When("user types loop academy in the google search box and click enter")
    public void user_types_loop_academy_in_the_google_search_box_and_click_enter() throws InterruptedException {
        googlePage.searchBox.sendKeys("Loop Academy");
        googlePage.searhcButton.click();
    }
    @Then("User should see Loop Academy - Google search is in the google title")
    public void user_should_see_loop_academy_google_search_is_in_the_google_title() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Loop Academy"));
    }

    @When("user types {string} in the google search box and click enter")
    public void user_types_in_the_google_search_box_and_click_enter(String input) {
        googlePage.searchBox.sendKeys(input);
        googlePage.searhcButton.click();
    }
    @Then("User should see {string} search is in the google title")
    public void user_should_see_search_is_in_the_google_title(String input) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(input));
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
        Thread.sleep(3000);
    }
    @Then("user should see the {string} in the result")
    public void user_should_see_the_in_the_result(String capital) {
        Assert.assertEquals(googlePage.capitalCity.getText(), capital);
    }
}
