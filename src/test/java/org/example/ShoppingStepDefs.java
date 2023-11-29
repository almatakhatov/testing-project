package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShoppingStepDefs extends AbstractStepDefs {

    @Given("the {string} is added to the cart")
    public void somethingIsAddedToTheCart(String item) {
        homePage.addItemToCart(item);
    }

    @Then("the {string} is shown")
    public void theYourShoppingCartIsEmptyIsShown(String text) { assertEquals(text, homePage.getEmptyCartMessage()); }

   @And("the sum {string} is shown")
   public void theSumIsShown(String amount) { assertEquals(amount, homePage.getSubtotal()); }

   @And("the message {string} is shown")
   public void theSuccessMessageIsShown(String message) { assertEquals(message, homePage.getSuccessMessage()); }
}