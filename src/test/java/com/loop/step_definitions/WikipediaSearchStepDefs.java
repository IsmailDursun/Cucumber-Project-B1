package com.loop.step_definitions;

import com.loop.pages.GooglePage;
import com.loop.pages.WikipediaPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static junit.framework.TestCase.assertEquals;
public class WikipediaSearchStepDefs {
    WikipediaPage wikipediaPage = new WikipediaPage();

    @Given("user is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikidepedia"));
    }
    @When("user searches {string} in the wiki search box")
    public void user_searches_in_the_wiki_search_box(String search) {
        wikipediaPage.searchBox.sendKeys(search);
        wikipediaPage.submitButton.click();
    }
    @Then("user should see {string} is in the wiki title")
    public void user_should_see_is_in_the_wiki_title(String title) {
        assertEquals(Driver.getDriver().getTitle(),title);
        BrowserUtils.screenshot();
    }
    @Then("user should see {string} is in the main header")
    public void user_should_see_is_in_the_main_header(String mainheader) {
        assertEquals(wikipediaPage.header.getText(),mainheader);
        BrowserUtils.screenshot();
    }
    @Then("user should see {string} is in the image header")
    public void user_should_see_is_in_the_image_header(String imageHeader) {
        assertEquals(wikipediaPage.imageHeader.getText(),imageHeader);
        BrowserUtils.screenshot();
    }
    @When("user searches for  the {string}")
    public void user_searches_for_the(String search) {
        wikipediaPage.searchBox.sendKeys(search);
        wikipediaPage.submitButton.click();
    }
    @Then("user should see the  {string} in the {string}")
    public void user_should_see_the_in_the(String search, String result) {
        switch (result){
            case "title":
                assertEquals(Driver.getDriver().getTitle(),search+" - Wikipedia");
                break;
            case "header":
                assertEquals(wikipediaPage.header.getText(),search);
                break;
            case "image header":
                assertEquals(wikipediaPage.imageHeader.getText(),search);
                break;


        }
    }

}