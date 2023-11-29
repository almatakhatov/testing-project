package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Map;

public class HomePage {
    private static final String PAGE_URL = "https://demowebshop.tricentis.com/";

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span")
    WebElement outputMessage1;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/ul/li")
    WebElement outputMessage2;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div[2]/div[2]/div")
    WebElement emptyCartMessage;

    public static final Map<String, By> navigationButtons = Map.ofEntries(
            Map.entry("LoginLink", By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")),
            Map.entry("LoginButton", By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")),
            Map.entry("JeweleryLink", By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")),
            Map.entry("CartLink", By.xpath("//*[@id=\"topcartlink\"]/a")),
            Map.entry("UpdateCartButton", By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]")),
            Map.entry("Logout", By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")),
            Map.entry("Checkbox", By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[1]/input"))
    );

    private static final Map<String, By> itemButtons = Map.of(
            "Diamond Heart", By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[3]/div[2]/input")
    );


    public static final Map<String, By> textFields = Map.of(
            "email", By.id("Email"),
            "password", By.id("Password"),
            "ItemQtyField", By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[5]/input")
    );

    public HomePage(WebDriver driver) { this.driver = driver; }

    public void closePage() { driver.quit(); }

    public void openPage(){
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public String getOutputMessage1(){
        return outputMessage1.getText();
    }

    public String getOutputMessage2(){
        return outputMessage2.getText();
    }
    public String getEmptyCartMessage() { return emptyCartMessage.getText(); }
    public String getPageUrl(){return driver.getCurrentUrl();}

    public void clickButton(String button){driver.findElement(navigationButtons.get(button)).click();}

    public void fillOutField(String field, String text) { driver.findElement(textFields.get(field)).sendKeys(text); }

    public void addItemToCart(String item) {
        driver.findElement(itemButtons.get(item)).click();
    }
}
