package trangbui.selenium.page_objects.tinyserver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trangbui.selenium.framework.BasePage;

import static org.testng.AssertJUnit.assertTrue;

public class AuthPage extends BasePage {
    public AuthPage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://staging.tinyserver.info/auth";

    // Page Objects
    //*[@id="root"]/div/div[1]/section/section/div[1]/div/input

    By txtEmail = By.xpath("//input[@data-cucumber='input-login-email']");
    By btnContinue = By.xpath("//*[@data-cucumber='button-continue']");
    By txtPassword = By.xpath("//input[@data-cucumber='input-login-password']");
    By btnSignin = By.xpath("//*[@data-cucumber='button-login']");


    // Page Method
    public AuthPage launch() {
        driver.get(baseURL);
        return this;
    }

    /**
     * Fill email with emailValue
     * @param value
     */
    public AuthPage setEmail(String value) {
        writeText(txtEmail, value);
        waitForElementToAppear(btnContinue);
        return this;
    }

    public String getEmail(String emailValue) {
        return readText(txtEmail);
    }

    public AuthPage setPassword(String value) {
        writeText(txtPassword, value);
        return this;
    }

    public String getPassword() {
        return readText(txtPassword);
    }

    public AuthPage clickContinue() {
        click(btnContinue);
        waitForElementToAppear(txtPassword);
        return this;
    }

    public AuthPage clickSignin() {
        click(btnSignin);
        myWait(2);
        return this;
    }

}
