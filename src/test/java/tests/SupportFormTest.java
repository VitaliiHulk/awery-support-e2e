package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SupportPage;
import pages.ErrorPage;
import utils.BaseTest;

public class SupportFormTest extends BaseTest {

    @Test
    public void shouldSubmitAndVerifyErrorByText() throws InterruptedException {
        SupportPage supportPage = new SupportPage(driver, wait);
        ErrorPage errorPage = new ErrorPage(driver, wait);

        supportPage.open();
        supportPage.fillInquiryInfo();
        supportPage.uploadScreenshot();
        supportPage.fillContactInfo();
        supportPage.fillComputerInfo();

        // VITALII: This is a very bad solution, Thread.sleep, it's unprofessional.
        // But I don't want to trigger a CAPTCHA and then get my IP blocked,
        // and I don't want an HTTP 423 error notification
        Thread.sleep(10000);

        supportPage.submit();

        boolean hasError = errorPage.isErrorVisible();
        Assertions.assertTrue(hasError, "The text 'SOMETHING WENT WRONG' was not found on the page!");

    }
}