package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By errorTextXpath = By.xpath("//*[contains(text(), 'SOMETHING WENT')]");

    public ErrorPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isErrorVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorTextXpath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}