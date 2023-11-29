package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormsStepDefs extends AbstractStepDefs {

    @When("the user fills and submits the form with email {string}")
    public void fillAndSubmitFormWithEmail(String email) {
        homePage.fillAndSubmitFormWithEmail(email);
    }

    @When("the user fills and submits the form with wrong email {string}")
    public void fillAndSubmitFormWithWrongEmail(String message) {homePage.fillAndSubmitFormWithWrongEmail(message);
    }
}
