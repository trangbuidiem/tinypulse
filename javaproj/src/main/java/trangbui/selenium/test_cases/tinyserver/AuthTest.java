package trangbui.selenium.test_cases.tinyserver;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import trangbui.selenium.common.Log;
import trangbui.selenium.common.MyStringUtils;
import trangbui.selenium.framework.BaseTest;
import trangbui.selenium.page_objects.tinyserver.AuthPage;
import trangbui.selenium.page_objects.tinyserver.DashboardPage;
import trangbui.selenium.page_objects.tinyserver.InvitePage;

public class AuthTest extends BaseTest {
    private AuthPage authPage;
    private DashboardPage dashBoardPage;
    private InvitePage invitePage;

    @BeforeMethod
    public void setup() {
        authPage = new AuthPage(driver);
        dashBoardPage = new DashboardPage(driver);
        invitePage = new InvitePage(driver);
    }

    @Test
    public void doLoginSuccess() throws InterruptedException {
        Log.runStep("Login");
        authPage.launch()
                .setEmail("trangne@gmail.com")
                .clickContinue()
                .setPassword("Tr@123456")
                .clickSignin();
        Log.info(authPage.getTitle());

        dashBoardPage.loaded()
                .clickSettings()
                .clickLnkAddPeople();
        Log.info(dashBoardPage.getTitle());

        invitePage.setFirstName("Tester 01", 0)
                .setLastName("Ms", 0)
                .setEmail(MyStringUtils.randomEmail(5) +"@email.com", 0)
                .clickStartDate(0)
                .clickToday()
                .clickBtnManager(0)
                .ClickManagerEmailItems(0)
                .ClickSegment(0)
                .ClickSelectOption(0)
                .ClickPosition(0);

        invitePage.setFirstName("Tester 02", 1)
                .setLastName("Mr", 1)
                .setEmail(MyStringUtils.randomEmail(8) + "@email.com", 1)
                .clickStartDate(1)
                .clickToday()
                .clickBtnManager(1)
                .ClickManagerEmailItems(0)
                .ClickSegment(1)
                .ClickSelectOption(0)
                .ClickPosition(1)
                .ClickAddPeople();
        invitePage.assertResult();
    }

    @AfterMethod
    public void teardown() {

    }
}

