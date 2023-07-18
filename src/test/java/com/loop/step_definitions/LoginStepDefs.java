package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.Keys.ENTER;

public class LoginStepDefs{
    Scenario scenario;
    LoginPage loginPage = new LoginPage();
    String Login;
    String password;


    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }


    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        BrowserUtils.waitForVisibility(loginPage.homeButton, 10);
        loginPage.homeButton.isDisplayed();
        BrowserUtils.takeScreenshot();
    }

    @When("user enters username for employee")
    public void userEntersUsernameForEmployee() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
    }

    @When("user enters password for employee")
    public void userEntersPasswordForEmployee() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for employee")
    public void userShouldSeeTheHomePageForEmployee() {
        BrowserUtils.waitForVisibility(loginPage.homeButton, 10);
        loginPage.homeButton.isDisplayed();
    }

    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
    }

    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        BrowserUtils.waitForVisibility(loginPage.homeButton, 10);
        loginPage.homeButton.isDisplayed();
    }

    @When("user enters username for admin")
    public void user_enters_username_for_admin() {

        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
    }

    @When("user enters password for admin")
    public void user_enters_password_for_admin() {

        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for admin")
    public void user_should_see_the_home_page_for_admin() {
        BrowserUtils.waitForVisibility(loginPage.homeButton, 10);
        loginPage.homeButton.isDisplayed();

    }

    @When("user enters credentials")
    public void user_enters_credentials(Map<String, String> credentials){
//        loginPage.usernameInput.sendKeys(credentials.get("username"));
//        loginPage.passwordInput.sendKeys(credentials.get("password"));
//        Thread.sleep(3000);
//        loginPage.loginButton.click();
//        Thread.sleep(3000);

        loginPage.loginDocuport(credentials.get("username"), credentials.get("password"));
    }

    String login = "";
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        this.login = username;
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password + ENTER);

    }

    @Then("validate left navigation bar")
    public void validate_left_navigation_bar(List<Map<String, String>> users) {

        for (Map<String, String> each : users) {
            switch (login) {
                case "b1g3_client@gmail.com":
                    assert each.get("Client") == null || each.get("Client").equals(loginPage.getleftBar(each.get("Client")));
                    break;
                case "b1g3_supervisor@gmail.com":
                    assert each.get("Supervisor") == null || each.get("Supervisor").equals(loginPage.getleftBar(each.get("Supervisor")));
                    assertTrue(each.get("Supervisor") == null || each.get("Supervisor").equals(loginPage.getleftBar(each.get("Supervisor"))));

                    break;
                case "b1g3_advisor@gmail.com":
                    assert each.get("Advisor").equals(loginPage.getleftBar(each.get("Advisor")));
                    break;
                case "b1g3_employee@gmail.com":
                    assert each.get("Employee") == null || each.get("Employee").equals(loginPage.getleftBar(each.get("Employee")));
                    break;

            }
        }
    }

    @When("the user clicks CLIENTS button")
    public void the_user_clicks_clients_button() {
        loginPage.clientButton.click();
    }

    @When("they click “Create new client” button and choose PERSONAL,")
    public void they_click_create_new_client_button_and_choose_personal() {
        loginPage.createNewClient.click();
        loginPage.personalButton.click();

    }

    @When("the user sees client creation pop up window.")
    public void the_user_sees_client_creation_pop_up_window() {

    }

    @When("the user filled all the information about new client")
    public void the_user_filled_all_the_information_about_new_client(List<Map<String, String>> list) {
        for (Map<String, String> each : list) {

            BrowserUtils.justWait(2);
            loginPage.firstName.sendKeys(each.get("firstName"));
            loginPage.lastName.sendKeys(each.get("lastName"));
            loginPage.checkBox.click();
            loginPage.email.sendKeys(each.get("email"));
            BrowserUtils.justWait(1);
            loginPage.advisorDropdown.click();
            loginPage.batch1Group3.click();
            loginPage.phoneNumber.sendKeys(each.get("phoneNumber"));
            loginPage.passwordInput.sendKeys(each.get("password"));
            loginPage.confirmPassword.sendKeys(each.get("password"));
            this.login = each.get("email");
            this.password = each.get("password");
            loginPage.saveButton.click();
        }
    }

    @When("they click SAVE button")
    public void they_click_save_button() {
    }

    @When("the user sees Confirmation text - “<CLIENT FULL NAME> been created successfully”")
    public void the_user_sees_confirmation_text_client_full_name_been_created_successfully() {
        BrowserUtils.waitForVisibility(loginPage.firstSuccessMessage, 5);
        assert loginPage.firstSuccessMessage.isDisplayed();
    }

    @When("the user is redirected to “EDIT CLIENT” page.")
    public void the_user_is_redirected_to_edit_client_page() {
        BrowserUtils.justWait(2);
    }

    @When("the user filled out all fields")
    public void the_user_filled_out_all_fields() {
        loginPage.serviceButton.click();
        loginPage.consultancyButton.click();
        loginPage.secondTimeAdvisor.click();
        loginPage.batch1Group3.click();
        new Actions(Driver.getDriver()).scrollToElement(loginPage.saveButtonEnd);
        BrowserUtils.justWait(2);
        loginPage.saveButtonEnd.click();
    }

    @When("the user sees Confirmation “ <CLIENT FULL NAME> has been updated successfully”")
    public void the_user_sees_confirmation_client_full_name_has_been_updated_successfully() {
        BrowserUtils.waitForVisibility(loginPage.successMessage, 5);
        loginPage.successMessage.isDisplayed();
        System.out.println(loginPage.successMessage);
    }

    @When("the user LOG OUT of the APP")
    public void the_user_log_out_of_the_app() {
        BrowserUtils.justWait(1);
        loginPage.bGButton.click();
        loginPage.logOut.click();
    }

    @When("they LOG IN as a new client which was created")
    public void they_log_in_as_a_new_client_which_was_created() {
        loginPage.usernameInput.sendKeys(login);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("the user should see the home page")
    public void the_user_should_see_the_home_page() {
        loginPage.homeButton1.isDisplayed();
    }

    @When("user clicks on Received docs")
    public void user_clicks_on_received_docs() {
        loginPage.receivedDocsButton.click();
    }

    @When("user sees buttons on the page1")
    public void user_sees_buttons_on_the_page1(List<String> items) {
        items.forEach(p ->
        {
            assertEquals(p, Driver.getDriver().getTitle());
        });
//        for (String each:items) {
//            System.out.println(each);
//            switch (each) {
//                case "Search":
//                    assert loginPage.searchButtonInreceivedDocs.getText().equals("Search");
//                    break;
//                case "Download":
//                    assert loginPage.downloadButtonInreceivedDocs.getText().equals("Download");
//                    break;
//                case "Received docs":
//                    assert loginPage.ReceivedDocsText.getText().equals("Received docs");
//                    break;
//            }
//    }
}
    @When("user clicks on my uploads")
    public void user_clicks_on_my_uploads() {

    }
    @Then("user sees buttons on the page")
    public void user_sees_buttons_on_the_page(List<String> items) {
        items.forEach(p ->
        {
            assertEquals(p, Driver.getDriver().getTitle());
        });
    }

}
