package com.loop.step_definitions;

import com.loop.pages.ClientPage;
import com.loop.utilities.BrowserUtils;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

public class ClientStepDefs {
    ClientPage clientPage = new ClientPage();
    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();  // soft assertion

    @When("user validates choose account popup is visible")
    public void user_validates_choose_account_popup_is_visible() {
        BrowserUtils.waitForVisibility(clientPage.chooseAccountText, 5);
//        assertTrue(clientPage.chooseAccountText.isDisplayed());
//        assertTrue(clientPage.chooseAccountText.getText().equals("Choose account"));
//        assert (clientPage.chooseAccountText.getText().equals("Choose account"));
        softAssertions.assertThat(clientPage.chooseAccountText.getText()).isEqualTo("Choose account");
        LOG.info("Account text is visible");
    }

    @When("user chooses account from drop down")
    public void user_chooses_account_from_drop_down() {
        // assertTrue(clientPage.continueButton.isDisplayed());
        softAssertions.assertThat(clientPage.continueButton.isDisplayed()).isTrue();
        softAssertions.assertThat(clientPage.continueButton.getText()).isEqualTo("Continue");
        clientPage.continueButton.click();
        softAssertions.assertAll();
    }

}
