package trangbui.selenium.page_objects.tinyserver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trangbui.selenium.framework.BasePage;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Page Objects
    By lnkSettings = By.xpath("//li[@data-name='settings']");
    By lnkAddPeople = By.xpath("//li[@data-name='settings_users_invite']");
    By btnAddPeople = By.className("cucumber-send-invite-button");
    By btnEngage = By.xpath("//li[@data-name='dashboards_engage']");

    // Page Method
    public DashboardPage loaded() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementToAppear(btnEngage);
        waitForElementToAppear(lnkSettings);
        return this;
    }

    public DashboardPage clickSettings() {
        click(lnkSettings);
        waitForElementToAppear(lnkAddPeople);
        return this;
    }

    public DashboardPage clickLnkAddPeople() {
        try {
            click(lnkAddPeople);
        } catch (Exception e) {
            this.clickSettings();
            click(lnkAddPeople);
        }
        waitForElementToAppear(btnAddPeople);
        return this;
    }
}
