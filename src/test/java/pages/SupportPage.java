package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class SupportPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SupportPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    private final By problemDescription = By.id("pd");
    private final By errorMessage = By.name("support[enquiry][error_message]");
    private final By whenStarted = By.name("support[enquiry][when_it_started]");
    private final By stepsToRecreate = By.name("support[enquiry][steps_to_recreate]");
    private final By uploadFile = By.name("screen");
    private final By email = By.id("email");
    private final By company = By.name("support[contact][company]");
    private final By name = By.name("support[contact][name]");
    private final By phone = By.name("support[contact][phone]");
    private final By contactTime = By.name("support[contact][time]");
    private final By browser = By.id("input-browser");
    private final By flash = By.id("input-flash");
    private final By sendButton = By.cssSelector("button.support-send");

    // Helper method
    private void waitAndSendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    // Actions
    public void open() {
        driver.get("https://awery.aero/support");
        wait.until(ExpectedConditions.presenceOfElementLocated(problemDescription));
    }

    public void fillInquiryInfo() {
        waitAndSendKeys(problemDescription, "Test automation problem description");
        waitAndSendKeys(errorMessage, "Test error message");
        waitAndSendKeys(whenStarted, "Yesterday");
        waitAndSendKeys(stepsToRecreate, "1. Open page\n2. Click button\n3. Error appears");
    }

    public void uploadScreenshot() {
        File file = new File("src/test/resources/test.png");
        if (file.exists()) {
            driver.findElement(uploadFile).sendKeys(file.getAbsolutePath());
        }
    }

    public void fillContactInfo() {
        waitAndSendKeys(email, "test.vitalii@example.com");
        waitAndSendKeys(company, "Test Company");
        waitAndSendKeys(name, "Vitalii best Tester");
        waitAndSendKeys(phone, "+123456789");
        waitAndSendKeys(contactTime, "00:00");
    }

    public void fillComputerInfo() {
        WebElement browserField = wait.until(ExpectedConditions.visibilityOfElementLocated(browser));
        browserField.clear();
        browserField.sendKeys("Chrome");

        WebElement flashField = driver.findElement(flash);
        flashField.clear();
        flashField.sendKeys("0,0,0");
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }
}