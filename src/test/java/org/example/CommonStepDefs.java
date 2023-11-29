package org.example;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonStepDefs extends AbstractStepDefs{
    @Given("the home page is opened")
    public void theHomePageOpened() {homePage.openPage();}

    @Then("user redirected to {string}")
    public void RedirectToPage(String url){
        assertEquals( url , homePage.getPageUrl());
    }

    @Given("the {string} is filled with {string}")
    public void thePasswordIsFilledWithPassword(String field, String text) { homePage.fillOutField(field, text); }

    @When("the {string} is clicked")
    public void theButtonIsClicked(String button) { homePage.clickButton(button); }

    @AfterAll
    public static void cleanup(){homePage.closePage();}

}