package org.example;

import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefs extends AbstractStepDefs {
    @Then("the {string} and {string} are shown")
    public void errorMessageIsShown(String errorMessage1, String errorMessage2){
        assertEquals(errorMessage1, homePage.getOutputMessage1());
        assertEquals(errorMessage2, homePage.getOutputMessage2());
    }

    @Then("the {string} is visible")
    public void LoginIsVisible(String label) { assertEquals(label, homePage.getLoginLabel());}
}
