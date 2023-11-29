package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/span/span")
    WebElement Subtotal;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")
    WebElement SuccessMessage;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    WebElement LoginLabel;

    @FindBy(xpath = "//*[@id=\"newsletter-result-block\"]")
    WebElement NewspaperSuccess;

    public static final Map<String, By> navigationButtons = Map.ofEntries(
            Map.entry("LoginLink", By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")),
            Map.entry("LoginButton", By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")),
            Map.entry("JeweleryLink", By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")),
            Map.entry("ClothLink", By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]/a")),
            Map.entry("BookLink", By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")),
            Map.entry("CartLink", By.xpath("//*[@id=\"topcartlink\"]/a")),
            Map.entry("UpdateCartButton", By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]")),
            Map.entry("Logout", By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")),
            Map.entry("Checkbox", By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[1]/input")),
            Map.entry("TermsOfUseCheckbox", By.xpath("//*[@id=\"termsofservice\"]")),
            Map.entry("CheckoutButton", By.xpath("//*[@id=\"checkout\"]")),
            Map.entry("BillAddressContinueButton", By.xpath("//*[@id=\"billing-buttons-container\"]/input")),
            Map.entry("ShipAddressContinueButton", By.xpath("//*[@id=\"shipping-buttons-container\"]/input")),
            Map.entry("ShipMethodContinueButton", By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")),
            Map.entry("PayMethodContinueButton", By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")),
            Map.entry("PayInfoContinueButton", By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")),
            Map.entry("ConfirmButton", By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input"))
    );

    private static final Map<String, By> itemButtons = Map.of(
            "Diamond Heart", By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[3]/div[2]/input"),
            "Casual Belt", By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[4]/div/div[2]/div[3]/div[2]/input"),
            "Jeans", By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input"),
            "Handbag", By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[7]/div/div[2]/div[3]/div[2]/input"),
            "Fiction", By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")
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
    public String getSubtotal() { return Subtotal.getText(); }
    public String getSuccessMessage() { return SuccessMessage.getText(); }
    public String getLoginLabel() { return LoginLabel.getText(); }
    public String getNewspaperMessage() { return NewspaperSuccess.getText(); }

    public String getPageUrl(){return driver.getCurrentUrl();}

    public void clickButton(String button){driver.findElement(navigationButtons.get(button)).click();}

    public void fillOutField(String field, String text) { driver.findElement(textFields.get(field)).sendKeys(text); }

    public void addItemToCart(String item) {
        driver.findElement(itemButtons.get(item)).click();
    }

    public void fillAndSubmitFormWithEmail(String email) {
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"newsletter-email\"]"));
        emailInput.sendKeys(email);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"newsletter-subscribe-button\"]"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By successMessageLocator = By.xpath("//*[@id=\"newsletter-result-block\"]");
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));

        String actualMessage = getNewspaperMessage();
        String expectedMessage = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";
    }

    public void fillAndSubmitFormWithWrongEmail(String email) {
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"newsletter-email\"]"));
        emailInput.sendKeys(email);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"newsletter-subscribe-button\"]"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By MessageLocator = By.xpath("//*[@id=\"newsletter-result-block\"]");
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));

        String actualMessage = getNewspaperMessage();
        String expectedMessage = "Enter valid email";
    }
}
