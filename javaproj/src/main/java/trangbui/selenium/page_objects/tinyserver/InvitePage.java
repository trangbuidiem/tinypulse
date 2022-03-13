package trangbui.selenium.page_objects.tinyserver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trangbui.selenium.common.Log;
import trangbui.selenium.framework.BasePage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.AssertJUnit.assertTrue;

public class InvitePage extends BasePage {
    public InvitePage(WebDriver driver) {
        super(driver);
    }
    // Page Objects
    By btnAddPeople = By.className("cucumber-send-invite-button");
    By txtFirstNames = By.xpath("//input[@field='firstName']");
    By txtLastNames = By.xpath("//input[@field='lastName']");
    By txtEmails = By.xpath("//input[@field='email']");
    By txtStartDates = By.xpath("//input[@field='startDate']");
    LocalDateTime current = LocalDateTime.now();
    String today = current.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    By btnToday = By.xpath("//div[@data-value='" + today +"']");
    By btnManagers = By.xpath("//td[@data-cucumber='manager']");
    By btnManagerEmailItems = By.className("select-email-item");
    By btnSegments = By.xpath("//table[1]//tbody/tr[*]/td[6]/div");
    By btnSelectOptions = By.className("Select-option");
    By btnPositions = By.xpath("//table[1]//tbody/tr[*]/td[7]/div");
    By lblSuccess = By.className("green");
    // By btnSegment = By.xpath("//input[@name='segment']/..");



    // Page Method
    public InvitePage setFirstName(String value, Integer index) {
        writeText(txtFirstNames, value,index);
        return this;
    }

    public InvitePage setLastName(String value, Integer index) {
        writeText(txtLastNames, value,index);
        return this;
    }

    public InvitePage setEmail(String value, Integer index) {
        writeText(txtEmails, value,index);
        return this;
    }

    public InvitePage clickStartDate(Integer index) {
        click(txtStartDates, index);
        waitForElementToAppear(btnToday);
        return this;
    }

    public InvitePage clickToday() {
        click(btnToday);
        return this;
    }

    public InvitePage clickBtnManager(Integer index) {
        click(btnManagers, index);
        waitForElementToAppear(btnManagerEmailItems);
        return this;
    }

    public InvitePage ClickManagerEmailItems(Integer index) {
        click(btnManagerEmailItems, index);
        return this;
    }

    public InvitePage ClickSegment(Integer index) {
        click(btnSegments, index);
        waitForElementToAppear(btnSelectOptions);
        return this;
    }

    public InvitePage ClickPosition(Integer index) {
        click(btnPositions, 0);
        return this;
    }

    public InvitePage ClickSelectOption(Integer index) {
        click(btnSelectOptions, 0);
        return this;
    }

    public InvitePage ClickAddPeople() {
        click(btnAddPeople);
        return this;
    }
    public void assertResult()
    {
        Log.info(lblSuccess.toString());
        this.assertTrue(lblSuccess, "Congratulations");
    }
}
