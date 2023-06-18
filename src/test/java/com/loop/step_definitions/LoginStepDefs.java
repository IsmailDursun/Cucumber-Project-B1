package com.loop.step_definitions;

import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;

import java.util.concurrent.TimeUnit;

public class LoginStepDefs {
    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user enters username for client")
    public void user_enters_username_for_client() {

    }
    @When("user  enters password for client")
    public void user_enters_password_for_client() {

    }
    @When("user click login buton")
    public void user_click_login_buton() {

    }
    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {

    }


    @When("user enters username for employee")
    public void userEntersUsernameForEmployee() {
        
    }

    @And("user  enters password for employee")
    public void userEntersPasswordForEmployee() {
        
    }

    @Then("user should see the home page for employee")
    public void userShouldSeeTheHomePageForEmployee() {
    }





}
